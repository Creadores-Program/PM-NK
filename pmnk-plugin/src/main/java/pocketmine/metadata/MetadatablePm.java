package pocketmine.metadata;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.metadata.Metadatable;
import java.util.List;
import static php.runtime.annotation.Reflection.*;

@Name("Metadatable")
@Namespace("pocketmine\\metadata")
public interface MetadatablePm extends Metadatable{
  @Ignore
  @Override
  default void removeMetadata(String metadataKey, Plugin owningPlugin) throws Exception{}
}
