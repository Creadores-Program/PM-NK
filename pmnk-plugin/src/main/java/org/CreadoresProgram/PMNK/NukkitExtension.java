package org.CreadoresProgram.PMNK;
import php.runtime.ext.support.Extension;
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
}
