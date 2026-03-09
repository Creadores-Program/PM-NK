package pocketmine.plugin;
import cn.nukkit.plugin.PluginDescription;
import php.runtime.lang.BaseObject;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;
import php.runtime.memory.StringMemory;
import php.runtime.lang.spl.exception.BadMethodCallException;
import static php.runtime.annotation.Reflection.*;
@Name("PluginDescription")
@Namespace("pocketmine\\plugin")
public class PluginDescriptionPm extends BaseObject{
    private PluginDescription instanceNK;

    public PluginDescriptionPm(Environment env, PluginDescription description){
        super(env);
        this.instanceNK = description;
    }

    public PluginDescriptionPm(Environment env, ClassEntity clazz){
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

    @Signature
    public void __construct(Environment env, String yamlString){
        this.instanceNK = new PluginDescription(yamlString);
    }
    /*@Signature
    public void __construct(Environment env, Memory yamlString){
        ???
    }*/

    @Ignore
    public PluginDescription getNK(){
        return this.instanceNK;
    }
}