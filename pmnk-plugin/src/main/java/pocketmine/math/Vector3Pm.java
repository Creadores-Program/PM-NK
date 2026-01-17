package pocketmine.math;
import php.runtime.lang.BaseObject;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;
import php.runtime.Memory;
import php.runtime.memory.StringMemory;
import php.runtime.lang.spl.exception.BadMethodCallException;
import cn.nukkit.math.Vector3;
import pocketmine.ServerPm;
import static php.runtime.annotation.Reflection.*;

@Name("Vector3")
@Namespace("pocketmine\\math")
public class Vector3Pm extends BaseObject{
  private Vector3 instanceNK;
  public Vector3Pm(Environment env, Vector3 instanceNK){
    super(env);
    this.instanceNK = instanceNK;
  }
  public Vector3Pm(Environment env, ClassEntity clazz){
    super(env, clazz);
  }
  @Signature
  public void __construct(Environment env){
    if(this.instanceNK == null){
        BadMethodCallException ex = new BadMethodCallException(env);
        try{
            env.invokeMethod(ex, "__construct", StringMemory.valueOf("He has no arguments!"));
        }catch(Throwable e){
            e.printStackTrace();
        }
        throw ex;
    }
  }
  @Signature
  public void __construct(float x, float y, float z){
    this.instanceNK = new Vector3(((double) x), ((double) y), ((double) z));
  }
  @Signature
  public void __construct(int x, int y, int z){
    this.instanceNK = new Vector3(((double) x), ((double) y), ((double) z));
  }
  @Signature
  public Memory __get(String name){
    switch(name){
      case "x":
        return ServerPm.javaToMemory(this.instanceNK.getX());
      case "y":
        return ServerPm.javaToMemory(this.instanceNK.getY());
      case "z":
        return ServerPm.javaToMemory(this.instanceNK.getZ());
    }
    return Memory.NULL;
  }
  @Signature
  public void __set(String name, int val){
    switch(name){
      case "x":
        this.instanceNK.x = (double) val;
        break;
      case "y":
        this.instanceNK.y = (double) val;
        break;
      case "z":
        this.instanceNK.z = (double) val;
        break;
    }
  }
  @Signature
  public void __set(String name, float val){
    switch(name){
        case "x":
        this.instanceNK.x = (double) val;
        break;
      case "y":
        this.instanceNK.y = (double) val;
        break;
      case "z":
        this.instanceNK.z = (double) val;
        break;
    }
  }
}
