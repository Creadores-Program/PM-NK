package pocketmine.math;
import java.util.Arrays;
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
  public double getX(){
    return this.instanceNK.getX();
  }
  @Signature
  public double getY(){
    return this.instanceNK.getY();
  }
  @Signature
  public double getZ(){
    return this.instanceNK.getZ();
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
  public int getFloorZ(){
    return this.instanceNK.getFloorZ();
  }
  @Signature
  public Vector3Pm add(Environment env, int x, int y, int z){
    Vector3Pm vec = new Vector3Pm(env, this.instanceNK.add(((double) x), ((double) y), ((double) z)));
    try{
        env.invokeMethod(vec, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vec;
  }
  @Signature
  public Vector3Pm add(Environment env, float x, float y, float z){
    Vector3Pm vec = new Vector3Pm(env, this.instanceNK.add(((double) x), ((double) y), ((double) z)));
    try{
        env.invokeMethod(vec, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vec;
  }
  @Signature
  public Vector3Pm addVector(Environment env, Vector3Pm v){
    Vector3Pm vec = new Vector3Pm(env, this.instanceNK.add(v.getNK()));
    try{
        env.invokeMethod(vec, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vec;
  }
  @Signature
  public Vector3Pm subtract(Environment env, int x, int y, int z){
    return this.add(env, -x, -y, -z);
  }
  @Signature
  public Vector3Pm subtract(Environment env, float x, float y, float z){
    return this.add(env, -x, -y, -z);
  }
  @Signature
  public Vector3Pm subtractVector(Environment env, Vector3Pm v){
    Vector3 vnk = v.getNK();
    return this.add(env, -((float) vnk.getX()), -((float) vnk.getY()), -((float) vnk.getZ()));
  }
  @Signature
  public Vector3Pm multiply(Environment env, float number){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.multiply((double) number));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm divide(Environment env, float number){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.divide((double) number));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm ceil(Environment env){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.ceil());
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm floor(Environment env){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.floor());
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm round(Environment env, Memory... args){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.round());
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm abs(Environment env){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.abs());
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm getSide(int side){
    return this.getSide(side, 1);
  }
  @Signature
  public Vector3Pm getSide(int  side, int step){
    //no implemented
    return null;
  }
  @Signature
  public Vector3Pm down(Environment env){
    return this.down(env, 1);
  }
  @Signature
  public Vector3Pm down(Environment env, int step){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.down(step));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm up(Environment env){
    return this.up(env, 1);
  }
  @Signature
  public Vector3Pm up(Environment env, int step){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.up(step));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm north(Environment env){
    return this.north(env, 1);
  }
  @Signature
  public Vector3Pm north(Environment env, int step){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.north(step));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm south(Environment env){
    return this.south(env, 1);
  }
  @Signature
  public Vector3Pm south(Environment env, int step){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.south(step));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm west(Environment env){
    return this.west(env, 1);
  }
  @Signature
  public Vector3Pm west(Environment env, int step){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.west(step));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm east(Environment env){
    return this.east(env, 1);
  }
  @Signature
  public Vector3Pm east(Environment env, int step){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.east(step));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  /*
  @Signature
  public GeneratorPm sides(){
    return this.sides(1);
  }
  @Signature
  public GeneratorPm sides(int step){}
  @Signature
  public Vector3Pm[] sidesArray(){
    return this.sidesArray(false);
  }
  @Signature
  public Vector3Pm[] sidesArray(boolean keys){
    return this.sidesArray(keys, 1);
  }
  @Signature
  public Vector3Pm[] sidesArray(boolean keys, int step){}
  @Signature
  public void sidesAroundAxis(int axis){
    this.sidesAroundAxis(axis, 1);
  }
  @Signature
  public void sidesAroundAxis(int axis, int step){}
  */
  @Signature
  public Vector3Pm asVector3(Environment env){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.clone());
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public float distance(Vector3Pm pos){
    return (float) this.instanceNK.distance(pos.getNK());
  }
  @Signature
  public float distanceSquared(Vector3Pm pos){
    return (float) this.instanceNK.distanceSquared(pos.getNK());
  }
  @Signature
  public float maxPlainDistance(float x){
    return this.maxPlainDistance(x, 0);
  }
  @Signature
  public float maxPlainDistance(float x, float z){
    return (float) this.instanceNK.maxPlainDistance(((double) x), ((double) z));
  }
  @Signature
  public float maxPlainDistance(Vector3Pm x){
    return (float) this.instanceNK.maxPlainDistance(x.getNK());
  }
  @Signature
  public float maxPlainDistance(Vector3Pm x, float z){
    return this.maxPlainDistance(x);
  }
  @Signature
  public float maxPlainDistance(Vector2Pm x){
    return (float) this.instanceNK.maxPlainDistance(x.getNK());
  }
  @Signature
  public float maxPlainDistance(Vector2Pm x, float z){
    return this.maxPlainDistance(x);
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
  public Vector3Pm normalize(Environment env){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.normalize());
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public float dot(Vector3Pm v){
    return (float) this.instanceNK.dot(v.getNK());
  }
  @Signature
  public Vector3Pm cross(Environment env, Vector3Pm v){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.cross(v.getNK()));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public boolean equals(Vector3Pm v){
    return this.instanceNK.equals(v.getNK());
  }
  @Signature
  public Vector3Pm getIntermediateWithXValue(Environment env, Vector3Pm v, float x){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.getIntermediateWithXValue(v.getNK(), ((double) x)));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm getIntermediateWithYValue(Environment env, Vector3Pm v, float y){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.getIntermediateWithYValue(v.getNK(), ((double) y)));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm getIntermediateWithZValue(Environment env, Vector3Pm v, float z){
    Vector3Pm vpm = new Vector3Pm(env, this.instanceNK.getIntermediateWithXValue(v.getNK(), ((double) z)));
    try{
        env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
        e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public String __toString(){
    return this.instanceNK.toString();
  }
  @Signature
  public Vector3Pm withComponents(){
    return this;
  }
  @Signature
  public Vector3Pm withComponents(Environment env, int x){
    Vector3Pm vpm = new Vector3Pm(env, new Vector3(((double) x), this.instanceNK.getY(), this.instanceNK.getZ()));
    try{
      env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
      e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm withComponents(Environment env, float x){
    Vector3Pm vpm = new Vector3Pm(env, new Vector3(((double) x), this.instanceNK.getY(), this.instanceNK.getZ()));
    try{
      env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
      e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm withComponents(Environment env, int x, int y){
    Vector3Pm vpm = new Vector3Pm(env, new Vector3(((double) x), ((double) y), this.instanceNK.getZ()));
    try{
      env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
      e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm withComponents(Environment env, float x, float y){
    Vector3Pm vpm = new Vector3Pm(env, new Vector3(((double) x), ((double) y), this.instanceNK.getZ()));
    try{
      env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
      e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm withComponents(Environment env, int x, int y, int z){
    Vector3Pm vpm = new Vector3Pm(env, new Vector3(((double) x), ((double) y), ((double) z)));
    try{
      env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
      e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm withComponents(Environment env, float x, float y, float z){
    Vector3Pm vpm = new Vector3Pm(env, new Vector3(((double) x), ((double) y), ((double) z)));
    try{
      env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
      e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm maxComponents(Environment env, Vector3Pm vector, Vector3Pm... vectors){
    Vector3 vectorn = vector.getNK();
    Vector3[] vectorsn = Arrays.stream(vectors).map(v -> v.getNK()).toArray(Vector3[]::new);
    double x = vectorn.getX();
    double y = vectorn.getY();
    double z = vectorn.getZ();
    for(Vector3 position : vectorsn){
      x = Math.max(x, position.getX());
      y = Math.max(y, position.getY());
      z = Math.max(z, position.getZ());
    }
    Vector3Pm vpm = new Vector3Pm(env, new Vector3(x, y, z));
    try{
      env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
      e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm minComponents(Environment env, Vector3Pm vector, Vector3Pm... vectors){
    Vector3 vectorn = vector.getNK();
    Vector3[] vectorsn = Arrays.stream(vectors).map(v -> v.getNK()).toArray(Vector3[]::new);
    double x = vectorn.getX();
    double y = vectorn.getY();
    double z = vectorn.getZ();
    for(Vector3 position : vectorsn){
      x = Math.min(x, position.getX());
      y = Math.min(y, position.getY());
      z = Math.min(z, position.getZ());
    }
    Vector3Pm vpm = new Vector3Pm(env, new Vector3(x, y, z));
    try{
      env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
      e.printStackTrace();
    }
    return vpm;
  }
  @Signature
  public Vector3Pm sum(Environment env, Vector3Pm... vector3s){
    Vector3[] vectorsn = Arrays.stream(vector3s).map(v -> v.getNK()).toArray(Vector3[]::new);
    double x = 0;
    double y = 0;
    double z = 0;
    for(Vector3 position : vectorsn){
      x += position.getX();
      y += position.getY();
      z += position.getZ();
    }
    Vector3Pm vpm = new Vector3Pm(env, new Vector3(x, y, z));
    try{
      env.invokeMethod(vpm, "__construct");
    }catch(Throwable e){
      e.printStackTrace();
    }
    return vpm;
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
  @Ignore
  public Vector3 getNK(){
    return this.instanceNK;
  }
}
