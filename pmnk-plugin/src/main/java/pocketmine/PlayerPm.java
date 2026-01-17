package pocketmine;
import php.runtime.lang.BaseObject;
import php.runtime.env.Environment;
import php.runtime.lang.spl.exception.BadMethodCallException;
import static php.runtime.annotation.Reflection.*;
import cn.nukkit.Player;

@Name("Player")
@Namespace("pocketmine")
public class PlayerPm extends BaseObject{
    private Player instanceNK;
    public PlayerPm(Environment env, Player player){
        super(env);
        this.instanceNK = player;
    }
    public ServerPm(Environment env, ClassEntity clazz){
        super(env, clazz);
    }
    @Signature
    public void __construct(Environment env){
        if(this.instanceNK == null){
            BadMethodCallException ex = new BadMethodCallException(env);
            try{
                env.invokeMethod(ex, "__construct", StringMemory.valueOf("Cannot serialize Server instance"));
            }catch(Throwable e){
                e.printStackTrace();
            }
            throw ex;
        }
    }
}