<?php
declare(strict_types=1);

namespace pocketmine;
use pocketmine\Server;

define('pocketmine\_CORE_CONSTANTS_INCLUDED', true);
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
new Server();
