package pocketmine;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;
import php.runtime.env.Environment;
import php.runtime.Memory;
import php.runtime.memory.StringMemory;
import php.runtime.reflection.MethodEntity;
import cn.nukkit.Server;
import pocketmine.utils.MainLoggerPm;
import static php.runtime.annotation.Reflection.*;

@Name("Server")
@Namespace("pocketmine")
public class ServerPm extends BaseObject{
  public static final String BROADCAST_CHANNEL_ADMINISTRATIVE = Server.BROADCAST_CHANNEL_ADMINISTRATIVE;
  public static final String BROADCAST_CHANNEL_USERS = Server.BROADCAST_CHANNEL_USERS;
  private static ServerPm instance;
  private static Server instanceNK;
  private MainLoggerPm logger;
  private Memory serverID;
  public ServerPm(Environment env){
    super(env);
  }
  public ServerPm(Environment env, ClassEntity clazz){
    super(env, clazz);
  }
  @Signature
  public void __construct(Environment env){
    instance = this;
    instanceNK = Server.getInstance();
    this.logger = new MainLoggerPm(env, instanceNK.getLogger(), true);
    try{
      env.invokeMethod(this.logger, "__construct");
      ClassEntity clazzUuidpm = env.fetchClass("pocketmine\\utils\\UUID");
      MethodEntity fromStrUuidpm = clazzUuidpm.findMethod("fromstring");
      this.serverID = fromStrUuidpm.invokeStatic(env, StringMemory.valueOf(instanceNK.getServerUniqueId().toString()));
    }catch(Throwable e){
      e.printStackTrace();
    }
  }
  @Signature
  public String getName(Environment env){
    return env.findConstant("pocketmine\\NAME").toString() + "-" + instanceNK.getName();
  }
  @Signature
  public boolean isRunning(){
    return instanceNK.isRunning();
  }
  @Signature
  public String getPocketMineVersion(Environment env){
    return env.findConstant("pocketmine\\VERSION").toString();
  }
  @Signature
  public String getVersion(){
    return instanceNK.getVersion();
  }
  @Signature
  public String getApiVersion(Environment env){
    return env.findConstant("pocketmine\\BASE_VERSION").toString();
  }
  @Signature
  public String getFilePath(Environment env){
    return env.findConstant("pocketmine\\PATH").toString();
  }
  @Signature
  public String getResourcePath(Environment env){
    return env.findConstant("pocketmine\\RESOURCE_PATH").toString();
  }
  @Signature
  public String getDataPath(){
    return instanceNK.getDataPath();
  }
  @Signature
  public String getPluginPath(){
    return instanceNK.getPluginPath();
  }
  @Signature
  public int getMaxPlayers(){
    return instanceNK.getMaxPlayers();
  }
  @Signature
  public boolean getOnlineMode(){
    return instanceNK.getPropertyBoolean("xbox-auth", true);
  }
  @Signature
  public boolean requiresAuthentication(){
    return this.getOnlineMode();
  }
  @Signature
  public int getPort(){
    return instanceNK.getPort();
  }
  @Signature
  public int getViewDistance(){
    return instanceNK.getViewDistance();
  }
  @Signature
  public int getAllowedViewDistance(int distance){
    return Math.max(2, Math.min(distance, this.getViewDistance()));
  }
  @Signature
  public String getIp(){
    return instanceNK.getIp();
  }
  @Signature
  public Memory getServerUniqueId(){
    return this.serverID;
  }
  @Signature
  public MainLoggerPm getLogger(){
    return this.logger;
  }
  @Signature
  public static ServerPm getInstance(){
    return instance;
  }
}
