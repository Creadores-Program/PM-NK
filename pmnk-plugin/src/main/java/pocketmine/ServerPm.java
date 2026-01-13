package pocketmine;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;
import php.runtime.env.Environment;
import php.runtime.Memory;
import php.runtime.memory.ObjectMemory;
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
  private Memory loggerM;
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
    this.loggerM = (Memory) new ObjectMemory(this.logger);
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
  public Memory getLogger(){
    return this.loggerM;
  }
  @Signature
  public static ServerPm getInstance(){
    return instance;
  }
}
