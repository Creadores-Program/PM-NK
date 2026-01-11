package pocketmine;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;
import php.runtime.env.Environment;
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
  public ServerPm(Environment env){
    super(env);
  }
  public ServerPm(Environment env, ClassEntity clazz){
    super(env, clazz);
  }
  @Signature
  public void __construct(){
    instance = this;
    instanceNK = Server.getInstance();
    this.logger = new MainLoggerPm(getEnvironment(), instanceNK.getLogger());
  }
  @Signature
  public String getName(){
    return getEnvironment().findConstant("pocketmine\\NAME").toString() + "-" + instanceNK.getName();
  }
  @Signature
  public boolean isRunning(){
    return instanceNK.isRunning();
  }
  @Signature
  public String getPocketMineVersion(){
    return getEnvironment().findConstant("pocketmine\\VERSION").toString();
  }
  @Signature
  public String getVersion(){
    return instanceNK.getVersion();
  }
  @Signature
  public String getApiVersion(){
    return getEnvironment().findConstant("pocketmine\\BASE_VERSION").toString();
  }
  @Signature
  public String getFilePath(){
    return getEnvironment().findConstant("pocketmine\\PATH").toString();
  }
  @Signature
  public String getResourcePath(){
    return getEnvironment().findConstant("pocketmine\\RESOURCE_PATH").toString();
  }
  @Signature
  public ServerPm getInstance(){
    return instance;
  }
}
