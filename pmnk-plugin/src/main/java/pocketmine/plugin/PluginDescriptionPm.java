package pocketmine.plugin;
import cn.nukkit.plugin.PluginDescription;
import php.runtime.lang.BaseObject;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;
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
    public void __construct(Environment env, String yamlString){
        this.instanceNK = new PluginDescription(yamlString);
    }
    /*@Signature
    public void __construct(Environment env, Memory yamlString){
        ???
    }*/
}