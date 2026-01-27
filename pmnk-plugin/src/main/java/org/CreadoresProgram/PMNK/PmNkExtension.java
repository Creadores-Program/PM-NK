package org.CreadoresProgram.PMNK;
import php.runtime.ext.support.Extension;
import php.runtime.env.CompileScope;
import cn.nukkit.Server;
import cn.nukkit.Nukkit;
import cn.nukkit.utils.MainLogger;
import cn.nukkit.utils.TextFormat;
import pocketmine.ServerPm;
import pocketmine.utils.MainLoggerPm;
import pocketmine.math.*;
import pocketmine.utils.*;
import pocketmine.level.*;
public class PmNkExtension extends Extension{
  @Override
  public Status getStatus() {
    return Status.STABLE;
  }
  @Override
  public void onRegister(CompileScope scope) {
    registerClass(scope, ServerPm.class, MainLoggerPm.class, TextFormat.class, Vector3Pm.class, Vector2Pm.class, PositionPm.class, AssumptionFailedErrorPm.class, LocationPm.class);
  }
}
