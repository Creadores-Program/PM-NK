package pocketmine.math;
import java.util.Arrays;
import php.runtime.lang.BaseObject;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;
import php.runtime.Memory;
import php.runtime.memory.StringMemory;
import php.runtime.lang.spl.exception.BadMethodCallException;
import cn.nukkit.math.Vector2;
import pocketmine.ServerPm;
import static php.runtime.annotation.Reflection.*;

@Name("Vector2")
@Namespace("pocketmine\\math")
public class Vector2Pm extends BaseObject{
    private Vector2 instanceNK;
    public Vector2Pm(Environment env, Vector2 instanceNK){
        super(env);
        this.instanceNK = instanceNK;
    }
    public Vector2Pm(Environment env, ClassEntity clazz){
        super(env, clazz);
    }
    @Signature
    public void __construct(){
        if(this.instanceNK == null){
            this.instanceNK = new Vector2(0, 0);
        }
    }
    @Signature
    public void __construct(int x){
        this.instanceNK = new Vector2(((double) x), 0);
    }
    @Signature
    public void __construct(float x){
        this.instanceNK = new Vector2(((double) x), 0);
    }
    @Signature
    public void __construct(int x, int y){
        this.instanceNK = new Vector2(((double) x), ((double) y));
    }
    @Signature
    public void __construct(float x, float y){
        this.instanceNK = new Vector2(((double) x), ((double) y));
    }
    @Signature
    public float getX(){
        return (float) this.instanceNK.getX();
    }
    @Signature
    public float getY(){
        return (float) this.instanceNK.getY();
    }
    @Signature
    public int getFloorX(){
        return this.instanceNK.getFloorX();
    }
    @Signature
    public int getFloorY(){
        return this.instanceNK.getFloorY();
    }
    @Signature
    public Vector2Pm add(Environment env, int x){
        return this.add(env, x, 0);
    }
    @Signature
    public Vector2Pm add(Environment env, float x){
        return this.add(env, x, 0);
    }
    @Signature
    public Vector2Pm add(Environment env, int x, int y){
        Vector2Pm vec = new Vector2Pm(env, this.instanceNK.add(((double) x), ((double) y)));
        try{
            env.invokeMethod(vec, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return vec;
    }
    @Signature
    public Vector2Pm add(Environment env, float x, float y){
        Vector2Pm vec = new Vector2Pm(env, this.instanceNK.add(((double) x), ((double) y)));
        try{
            env.invokeMethod(vec, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return vec;
    }
    @Signature
    public Vector2Pm add(Environment env, Vector2Pm x){
        Vector2Pm vec = new Vector2Pm(env, this.instanceNK.add(x.getNK()));
        try{
            env.invokeMethod(vec, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return vec;
    }
    @Signature
    public Vector2Pm subtract(Environment env, int x){
        return this.subtract(env, x, 0);
    }
    @Signature
    public Vector2Pm subtract(Environment env, float x){
        return this.subtract(env, x, 0);
    }
    @Signature
    public Vector2Pm subtract(Environment env, int x, int y){
        return this.add(env, -x, -y);
    }
    @Signature
    public Vector2Pm subtract(Environment env, float x, float y){
        return this.add(env, -x, -y);
    }
    @Signature
    public Vector2Pm subtract(Environment env, Vector2Pm x){
        Vector2 vnk = x.getNK();
        return this.add(env, -((float) vnk.getX()), -((float) vnk.getY()));
    }
    @Signature
    public Vector2Pm ceil(Environment env){
        Vector2Pm vpm = new Vector2Pm(env, this.instanceNK.ceil());
        try{
            env.invokeMethod(vpm, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return vpm;
    }
    @Signature
    public Vector2Pm floor(Environment env){
        Vector2Pm vpm = new Vector2Pm(env, this.instanceNK.floor());
        try{
            env.invokeMethod(vpm, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return vpm;
    }
    @Signature
    public Vector2Pm round(Environment env){
        Vector2Pm vpm = new Vector2Pm(env, this.instanceNK.round());
        try{
            env.invokeMethod(vpm, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return vpm;
    }
    @Signature
    public Vector2Pm abs(Environment env){
        Vector2Pm vpm = new Vector2Pm(env, this.instanceNK.abs());
        try{
            env.invokeMethod(vpm, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return vpm;
    }
    @Signature
    public Vector2Pm multiply(Environment env, float number){
        Vector2Pm vpm = new Vector2Pm(env, this.instanceNK.multiply((double) number));
        try{
            env.invokeMethod(vpm, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return vpm;
    }
    @Signature
    public Vector2Pm divide(Environment env, float number){
        Vector2Pm vpm = new Vector2Pm(env, this.instanceNK.divide((double) number));
        try{
            env.invokeMethod(vpm, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return vpm;
    }
    @Signature
    public float distance(float x){
        return (float) this.instanceNK.distance(((double) x));
    }
    @Signature
    public float distance(float x, float y){
        return (float) this.instanceNK.distance(((double) x), ((double) y));
    }
    @Signature
    public float distance(Vector2Pm x){
        return (float) this.instanceNK.distance(x.getNK());
    }
    @Signature
    public float distanceSquared(float x){
        return (float) this.instanceNK.distanceSquared(((double) x));
    }
    @Signature
    public float distanceSquared(float x, float y){
        return (float) this.instanceNK.distanceSquared(((double) x), ((double) y));
    }
    @Signature
    public float length(){
        return (float) this.instanceNK.length();
    }
    @Signature
    public float lengthSquared(){
        return (float) this.instanceNK.lengthSquared();
    }
    @Signature
    public Vector2Pm normalize(Environment env){
        Vector2Pm vpm = new Vector2Pm(env, this.instanceNK.normalize());
        try{
            env.invokeMethod(vpm, "__construct");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return vpm;
    }
    @Signature
    public float dot(Vector2Pm v){
        return (float) this.instanceNK.dot(v.getNK());
    }
    @Signature
    public String __toString(){
        return this.instanceNK.toString();
    }
    @Signature
    public Memory __get(String name){
        switch(name){
            case "x":
                return ServerPm.javaToMemory(this.instanceNK.getX());
            case "y":
                return ServerPm.javaToMemory(this.instanceNK.getY());
        }
        return Memory.NULL;
    }
    @Ignore
    public Vector2 getNK(){
        return this.instanceNK;
    }
}