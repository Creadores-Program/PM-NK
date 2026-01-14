package pocketmine.utils;
import php.runtime.lang.BaseObject;
import php.runtime.lang.BaseException;
import php.runtime.reflection.ClassEntity;
import php.runtime.env.Environment;
import cn.nukkit.utils.MainLogger;
import cn.nukkit.Server;
import static php.runtime.annotation.Reflection.*;
@Name("MainLogger")
@Namespace("pocketmine\\utils")
public class MainLoggerPm extends BaseObject{
    @Property
    public static MainLoggerPm logger;
    public static final String EMERGENCY = "emergency";
    public static final String ALERT = "alert";
    public static final String CRITICAL = "critical";
    public static final String ERROR = "error";
    public static final String WARNING = "warning";
    public static final String NOTICE = "notice";
    public static final String INFO = "info";
    public static final String DEBUG = "debug";
    private String format = "";
    private MainLogger loggernk;
    public MainLoggerPm(Environment env, MainLogger loggernk, boolean isMain){
        super(env);
        this.loggernk = loggernk;
        if(isMain){
            logger = this;
        }
    }
    public MainLoggerPm(Environment env, ClassEntity clazz){
        super(env, clazz);
    }
    @Signature
    public void __construct(){
    }
    @Signature
    public boolean isRegisteredStatic(){
        return logger != null;
    }
    @Signature
    public static MainLoggerPm getLogger(){
        return logger;
    }
    @Signature
    public String getFormat(){
        return this.format;
    }
    @Signature
    public void setFormat(String format){}
    @Signature
    public void setLogDebug(boolean logdebug){}
    @Signature
    public void emergency(String message){
        this.loggernk.emergency(message);
    }
    @Signature
    public void alert(String message){
        this.loggernk.alert(message);
    }
    @Signature
    public void critical(String message){
        this.loggernk.critical(message);
    }
    @Signature
    public void error(String message){
        this.loggernk.error(message);
    }
    @Signature
    public void warning(String message){
        this.loggernk.warning(message);
    }
    @Signature
    public void notice(String message){
        this.loggernk.notice(message);
    }
    @Signature
    public void info(String message){
        this.loggernk.info(message);
    }
    @Signature
    public void debug(String message){
        this.debug(message, false);
    }
    @Signature
    public void debug(String message, boolean force){
        this.loggernk.debug(message);
    }
    @Signature
    public void logException(BaseException e){
        this.logException(e, null);
    }
    @Signature
    public void logException(BaseException e, String trace){
        this.loggernk.logException(e);
    }
    @Signature
    public void log(String level, String message){
        switch(level){
            case "emergency":
                this.emergency(message);
                break;
            case "alert":
                this.alert(message);
                break;
            case "critical":
                this.critical(message);
                break;
            case "error":
                this.error(message);
                break;
            case "warning":
                this.warning(message);
                break;
            case "notice":
                this.notice(message);
                break;
            case "info":
                this.info(message);
                break;
            case "debug":
                this.debug(message);
                break;
        }
    }
    @Signature
    public void shutdown(){}
    @Signature
    public void syncFlushBuffer(){}
    @Signature
    public void run(){}
}
