package pocketmine.level;
import java.util.Arrays;
import pocketmine.math.Vector3Pm;
import pocketmine.ServerPm;
import cn.nukkit.level.Position;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;
import php.runtime.Memory;
import php.runtime.memory.StringMemory;
import php.runtime.lang.spl.exception.BadMethodCallException;
import static php.runtime.annotation.Reflection.*;
@Name("Position")
@Namespace("pocketmine\\level")
public class PositionPm extends Vector3Pm{
    private Position instanceNK;
    public PositionPm(Environment env, Position instanceNK){
        super(env);
        this.instanceNK = instanceNK;
    }
    public PositionPm(Environment env, ClassEntity clazz){
        super(env, clazz);
    }
    @Signature
    public void __construct(Environment env){
        if(this.instanceNK == null){
            this.instanceNK = new Position();
        }
    }
}
