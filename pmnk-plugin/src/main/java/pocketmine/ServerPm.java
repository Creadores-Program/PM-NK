package pocketmine;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;
import php.runtime.env.Environment;
import php.runtime.Memory;
import php.runtime.memory.StringMemory;
import php.runtime.reflection.MethodEntity;
import php.runtime.lang.spl.exception.InvalidArgumentException;
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
      MethodEntity fromStrUuidpm = clazzUuidpm.findMethod("fromString");
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
  public boolean getAutoSave(){
    return instanceNK.getAutoSave();
  }
  @Signature
  public void setAutoSave(boolean value){
    instanceNK.setAutoSave(value);
  }
  @Signature
  public String getLevelType(){
    String leveltype = instanceNK.getLevelType();
    if(leveltype.equals("default")){
      leveltype = leveltype.toUpperCase();
    }
    return leveltype;
  }
  @Signature
  public boolean getGenerateStructures(){
    if(instanceNK.getPluginManager().getPlugin("WorldGeneratorExtension") != null){
      return true;
    }
    return false;
  }
  @Signature
  public int getGamemode(){
    return instanceNK.getGamemode();
  }
  @Signature
  public boolean getForceGamemode(){
    return instanceNK.getForceGamemode();
  }
  @Signature
  public static String getGamemodeString(int mode){
    return Server.getGamemodeString(mode);
  }
  @Signature
  public static String getGamemodeName(Environment env, int mode){
    String gameName = Server.getGamemodeString(mode, true);
    if(gameName.equals("UNKNOWN")){
      InvalidArgumentException ex = new InvalidArgumentException(env);
      try{
        env.invokeMethod(ex, "__construct", StringMemory.valueOf("Invalid gamemode "+mode));
      }catch(Throwable e){
        e.printStackTrace();
      }
      throw ex;
    }
    return gameName;
  }
  @Signature
  public static int getGamemodeFromString(String str){
    return Server.getGamemodeFromString(str);
  }
  @Signature
  public int getDifficulty(){
    return instanceNK.getDifficulty();
  }
  @Signature
  public boolean hasWhitelist(){
    return instanceNK.hasWhitelist();
  }
  @Signature
  public int getSpawnRadius(){
    return instanceNK.getSpawnRadius();
  }
  @Signature
  public boolean getAllowFlight(){
    return instanceNK.getAllowFlight();
  }
  @Signature
  public boolean isHardcore(){
    return instanceNK.isHardcore();
  }
  @Signature
  public int getDefaultGamemode(){
    return instanceNK.getDefaultGamemode();
  }
  @Signature
  public String getMotd(){
    return instanceNK.getMotd();
  }
  @Signature
  public BaseObject getLoader(){
    //no implemented
    return null;
  }
  @Signature
  public MainLoggerPm getLogger(){
    return this.logger;
  }
  /*
  @Signature
  public EntityMetadataStorePm getEntityMetadata(){}
  @Signature
  public PlayerMetadataStorePm getPlayerMetadata(){}
  @Signature
  public LevelMetadataStorePm getLevelMetadata(){}
  @Signature
  public getUpdater(){}
  @Signature
  public PluginManagerPm getPluginManager(){}
  @Signature
  public CraftingManagerPm getCraftingManager(){}
  @Signature
  public ResourcePackManager getResourcePackManager(){}
  @Signature
  public AsyncPoolPm getAsyncPool(){}
  */
  @Signature
  public int getTick(){
    return instanceNK.getTick();
  }
  @Signature
  public float getTicksPerSecond(){
    return instanceNK.getTicksPerSecond();
  }
  @Signature
  public float getTicksPerSecondAverage(){
    return instanceNK.getTicksPerSecondAverage();
  }
  @Signature
  public float getTickUsage(){
    return instanceNK.getTickUsage();
  }
  @Signature
  public float getTickUsageAverage(){
    return instanceNK.getTickUsageAverage();
  }
  @Signature
  public static ServerPm getInstance(){
    return instance;
  }
}
