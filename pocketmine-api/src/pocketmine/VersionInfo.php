<?php
declare(strict_types=1);

namespace pocketmine;
use cn\nukkit\Nukkit;
use pocketmine\Server;
use function define;
use const DIRECTORY_SEPARATOR;

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
$git_info = Nukkit::GIT_INFO;
if($git_info != null){
  define('pocketmine\GIT_COMMIT', $git_info->getProperty('git.commit.id.abbrev'));
}else{
  define('pocketmine\GIT_COMMIT', 'null');
}
define('pocketmine\DATA', Nukkit::DATA_PATH);
define('pocketmine\PLUGIN_PATH', Nukkit::PLUGIN_PATH . DIRECTORY_SEPARATOR);
define('pocketmine\START_TIME', Nukkit::START_TIME);
define('pocketmine\RESOURCE_PATH', Nukkit::DATA_PATH . "resource_packs" . DIRECTORY_SEPARATOR);
new Server();
