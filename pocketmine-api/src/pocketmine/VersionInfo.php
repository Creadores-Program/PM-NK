<?php
declare(strict_types=1);

namespace pocketmine;
use php\lang\JavaClass;
use pocketmine\Server;
use function define;
use const DIRECTORY_SEPARATOR;

$nukkit = new JavaClass("cn.nukkit.Nukkit");
const _VERSION_INFO_INCLUDED = true;
const BASE_VERSION = "3.23.1";
const NAME = "PM-NK";
const BUILD_CHANNEL = "stable";
const IS_DEVELOPMENT_BUILD = false;
const BUILD_NUMBER = 0;
$version = BASE_VERSION;
if(IS_DEVELOPMENT_BUILD){
  $version .= "+dev";
  if(BUILD_NUMBER > 0){
    $version .= "." . BUILD_NUMBER;
  }
}
define('pocketmine\VERSION', $version);
$git_info = $nukkit->getDeclaredField("GIT_INFO")->get(null);
if($git_info != null){
  define('pocketmine\GIT_COMMIT', $git_info->getProperty('git.commit.id.abbrev'));
}else{
  define('pocketmine\GIT_COMMIT', 'null');
}
define('pocketmine\DATA', $nukkit->getDeclaredField("DATA_PATH")->get(null));
define('pocketmine\PLUGIN_PATH', $nukkit->getDeclaredField("PLUGIN_PATH")->get(null) . DIRECTORY_SEPARATOR);
define('pocketmine\START_TIME', $nukkit->getDeclaredField("START_TIME")->get(null));
define('pocketmine\RESOURCE_PATH', $nukkit->getDeclaredField("DATA_PATH")->get(null) . "resource_packs" . DIRECTORY_SEPARATOR);
new Server();
