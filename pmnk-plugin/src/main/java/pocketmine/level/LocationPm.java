package pocketmine.level;
import java.util.Arrays;
import pocketmine.math.Vector3Pm;
import pocketmine.ServerPm;
import cn.nukkit.level.Location;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;
import php.runtime.Memory;
import php.runtime.memory.StringMemory;
import php.runtime.lang.spl.exception.BadMethodCallException;
import php.runtime.lang.spl.exception.InvalidArgumentException;
import static php.runtime.annotation.Reflection.*;

@Name("Location")
@Namespace("pocketmine\\level")
public class LocationPm extends PositionPm{
    private Location instanceNK:
    public LocationPm(Environment env, Location instanceNK){
        super(env, instanceNK);
        this.instanceNK = instanceNK;
    }
    public LocationPm(Environment env, ClassEntity clazz){
        super(env, clazz);
    }
    @Signature
    public void __construct(Environment env){
        if(this.instanceNK == null){
            this.instanceNK = new Location();
        }
    }
    @Signature
    public void __construct(Environment env, int x){
        this.instanceNK = new Location((double) x);
    }
    @Signature
    public void __construct(Environment env, float x){
        this.instanceNK = new Location((double) x);
    }
    @Signature
    public void __construct(Environment env, int x, int y){
        this.instanceNK = new Location(((double) x), ((double) y));
    }
    @Signature
    public void __construct(Environment env, float x, float y){
        this.instanceNK = new Location(((double) x), ((double) y));
    }
    @Signature
    public void __construct(Environment env, int x, int y, int z){
        this.instanceNK = new Location(((double) x), ((double) y), ((double) z));
    }
    @Signature
    public void __construct(Environment env, float x, float y, float z){
        this.instanceNK = new Location(((double) x), ((double) y), ((double) z));
    }
    @Signature
    public void __construct(Environment env, int x, int y, int z, float yaw){
        this.instanceNK = new Location(((double) x), ((double) y), ((double) z), ((double) yaw));
    }
    @Signature
    public void __construct(Environment env, float x, float y, float z, float yaw){
        this.instanceNK = new Location(((double) x), ((double) y), ((double) z), ((double) yaw));
    }
    @Signature
    public void __construct(Environment env, int x, int y, int z, float yaw, float pitch){
        this.instanceNK = new Location(((double) x), ((double) y), ((double) z), ((double) yaw), ((double) pitch));
    }
    @Signature
    public void __construct(Environment env, float x, float y, float z, float yaw, float pitch){
        this.instanceNK = new Location(((double) x), ((double) y), ((double) z), ((double) yaw), ((double) pitch));
    }
    /*
    @Signature
    public void __construct(Environment env, int x, int y, int z, float yaw, float pitch, LevelPm level){
        this.instanceNK = new Location(((double) x), ((double) y), ((double) z), ((double) yaw), ((double) pitch), level.getNK());
    }
    @Signature
    public void __construct(Environment env, float x, float y, float z, float yaw, float pitch, LevelPm level){
        this.instanceNK = new Location(((double) x), ((double) y), ((double) z), ((double) yaw), ((double) pitch), level.getNK());
    }
    */
    @Signature
    public static LocationPm fromObject(Environment env, Vector3Pm pos){
        LocationPm posn = new LocationPm(env, Location.fromObject(pos.getNK()));
        try{
            env.invokeMethod(posn, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return posn;
    }
    /*
    @Signature
    public static LocationPm fromObject(Environment env, Vector3Pm pos, LevelPm level){
        LocationPm posn = new LocationPm(env, Location.fromObject(pos.getNK(), level.getNK()));
        try{
            env.invokeMethod(posn, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return posn;
    }
    @Signature
    public static LocationPm fromObject(Environment env, Vector3Pm pos, LevelPm level, float yaw){
        LocationPm posn = new LocationPm(env, Location.fromObject(pos.getNK(), level.getNK(), ((double) yaw)));
        try{
            env.invokeMethod(posn, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return posn;
    }
    @Signature
    public static LocationPm fromObject(Environment env, Vector3Pm pos, LevelPm level, float yaw, float pitch){
        LocationPm posn = new LocationPm(env, Location.fromObject(pos.getNK(), level.getNK(), ((double) yaw), ((double) pitch)));
        try{
            env.invokeMethod(posn, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return posn;
    }
    */
    @Signature
    public LocationPm asLocation(Environment env){
        LocationPm posn = new LocationPm(env, this.instanceNK.clone());
        try{
            env.invokeMethod(posn, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return posn;
    }
    @Signature
    public float getYaw(){
        return (float) this.instanceNK.getYaw();
    }
    @Signature
    public float getPitch(){
        return (float) this.instanceNK.getPitch();
    }
    @Signature
    public String __toString(){
        return this.instanceNK.toString();
    }
    @Override
    @Signature
    public boolean equals(Vector3Pm v){
        if(v instanceof LocationPm){
            LocationPm vl = (LocationPm) v;
            return super.equals(v) && this.getYaw() == vl.getYaw() && this.getPitch() == vl.getPitch();
        }
        return super.equals(v);
    }
    @Signature
    public void __set(String name, float val){
        switch(name){
            case "yaw":
                this.instanceNK.yaw = (double) val;
                break;
            case "pitch":
                this.instanceNK.pitch = (double) val;
                break;
            default:
                super.__set(name, val);
        }
    }
    @Signature
    public Memory __get(String name){
        switch(name){
            case "yaw":
                return ServerPm.javaToMemory(this.instanceNK.yaw);
            case "pitch":
                return ServerPm.javaToMemory(this.instanceNK.pitch);
        }
        return super.__get(name);
    }
    @Override
    @Ignore
    public Location getNK(){
        return this.instanceNK;
    }
}