package org.CreadoresProgram.PMNK;
import php.runtime.ext.support.Extension;
import php.runtime.env.CompileScope;
import php.runtime.reflection.ClassEntity;
import cn.nukkit.Server;
import cn.nukkit.Nukkit;
public class NukkitExtension extends Extension{
  @Override
  public Status getStatus() {
    return Status.STABLE;
  }
  @Override
  public void onRegister(CompileScope scope) {
    registerClass(scope, Server.class, Nukkit.class);
  }
  protected void registerClass(CompileScope scope, Class<?>... classes) {
    for (Class<?> clazz : classes) {
      String className = clazz.getName().replace('.', '\\');
      ClassEntity entity = new ClassEntity(scope);
      entity.setName(className);
      entity.setNativeClazz(clazz);
      ClassEntity javaObjectEntity = scope.fetchUserClass(JavaObject.class);
      if (javaObjectEntity != null) {
        entity.setParent(javaObjectEntity);
      } else {
          entity.setParent(scope.fetchUserClass("php\\lang\\JavaObject"));
      }
      scope.addUserClass(entity);
    }
  }
}
