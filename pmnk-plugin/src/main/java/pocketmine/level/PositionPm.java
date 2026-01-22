package pocketmine.level;
import java.util.Arrays;
import pocketmine.math.Vector3Pm;
import pocketmine.utils.AssumptionFailedError;
import pocketmine.ServerPm;
import cn.nukkit.level.Position;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;
import php.runtime.Memory;
import php.runtime.memory.StringMemory;
import php.runtime.lang.spl.exception.BadMethodCallException;
import php.runtime.lang.spl.exception.InvalidArgumentException;
import static php.runtime.annotation.Reflection.*;
@Name("Position")
@Namespace("pocketmine\\level")
public class PositionPm extends Vector3Pm{
    private Position instanceNK;
    private Memory level;
    public PositionPm(Environment env, Position instanceNK){
        super(env, instanceNK);
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
    @Signature
    public void __construct(Environment env, int x){
        this.instanceNK = new Position((double) x);
    }
    @Signature
    public void __construct(Environment env, float x){
        this.instanceNK = new Position((double) x);
    }
    @Signature
    public void __construct(Environment env, int x, int y){
        this.instanceNK = new Position(((double) x), ((double) y));
    }
    @Signature
    public void __construct(Environment env, float x, float y){
        this.instanceNK = new Position(((double) x), ((double) y));
    }
    @Signature
    public void __construct(Environment env, int x, int y, int z){
        this.instanceNK = new Position(((double) x), ((double) y), ((double) z));
    }
    @Signature
    public void __construct(Environment env, float x, float y, float z){
        this.instanceNK = new Position(((double) x), ((double) y), ((double) z));
    }
    /*
    @Signature
    public void __construct(Environment env, int x, int y, int z, LevelPm level){
        this.instanceNK = new Position(((double) x), ((double) y), ((double) z), level.getNK());
    }
    @Signature
    public void __construct(Environment env, float x, float y, float z, LevelPm level){
        this.instanceNK = new Position(((double) x), ((double) y), ((double) z), level.getNK());
    }
    */
    @Signature
    public static PositionPm fromObject(Environment env, Vector3Pm pos){
        PositionPm posn = new PositionPm(env, Position.fromObject(pos.getNK()));
        try{
            env.invokeMethod(posn, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return posn;
    }
    /*
    @Signature
    public static PositionPm fromObject(Environment env, Vector3Pm pos, LevelPm level){
        PositionPm posn = new PositionPm(env, Position.fromObject(pos.getNK(), level.getNK()));
        try{
            env.invokeMethod(posn, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return posn;
    }
    */
    @Signature
    public PositionPm asPosition(){
        PositionPm posn = new PositionPm(env, this.instanceNK.clone());
        try{
            env.invokeMethod(posn, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return posn;
    }
    @Signature
    public Memory getLevel(){
        return this.level;
    }
    @Signature
    public Memory getLevelNonNull(Environment env){
        if(this.level == null){
            AssumptionFailedError er = new AssumptionFailedError(env);
            try{
                env.invokeMethod(er, "__construct", StringMemory.valueOf("Position world is null"));
            }catch(Throwable e){
                e.printStackTrace();
            }
            throw er;
        }
        return this.level;
    }
    @Signature
    public PositionPm setLevel(){
        InvalidArgumentException er = new InvalidArgumentException(env);
        try{
            env.invokeMethod(er, "__construct", StringMemory.valueOf("Position world is null"));
        }catch(Throwable e){
            e.printStackTrace();
        }
        throw er;
    }
    /*
    @Signature
    public PositionPm setLevel(LevelPm level){
        if(level == null){
            return this.setLevel();
        }
        this.instanceNK.level = val.getNK();
        this.level = (Memory) new php.runtime.memory.ObjectMemory(val);
        return this;
    }
    */
    @Signature
    public boolean isValid(){
        return this.instanceNK.isValid();
    }
    @Override
    @Signature
    public PositionPm getSide(int side){
        return this.getSide(side, 1);
    }
    @Override
    @Signature
    public PositionPm getSide(int side, int step){
        if(this.isValid()){
            return null;
        }
        return super.getSide(side, step);
    }
    @Override
    @Signature
    public String __toString(){
        return this.instanceNK.toString();
    }
    @Override
    @Signature
    public boolean equals(Vector3Pm v){
        if(v instanceof PositionPm){
            return super.equals(v) && this.level.equals(v.getLevel());
        }
        return super.equals(v);
    }
    /*
    @Signature
    public void __set(String name, LevelPm val){
        if(name.equals("level")){
            this.instanceNK.level = val.getNK();
            this.level = (Memory) new php.runtime.memory.ObjectMemory(val);
        }
    }
    @Signature
    public Memory __get(String name){
        if(name.equals("level")){
            return this.level;
        }
        return super.__get(name);
    }
    */
    @Override
    @Ignore
    public Position getNK(){
        return this.instanceNK;
    }
}
