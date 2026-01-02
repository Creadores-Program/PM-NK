<?php
declare(strict_types=1);
namespace pocketmine\utils;
use php\lang\JavaClass;
class MainLogger{
  private $loggerNK;
  public static $logger;
  public static $serverNK;
  private $format = TextFormat::AQUA . "[%s] " . TextFormat::RESET . "%s[%s/%s]: %s" . TextFormat::RESET;
  public function __construct($loggerNK){
    $this->loggerNK = $loggerNK;
    static::$logger = $this;
    //static::$serverNK->getConfig("debug.level", 1);
  }
  public static function getLogger() : MainLogger{
		return static::$logger;
  }
  public static function isRegisteredStatic() : bool{
		return static::$logger !== null;
  }
  public function getFormat() : string{
		return $this->format;
	}
  public function setFormat(string $format) : void{}
}
$serverNK = new JavaClass("cn.nukkit.Server");
MainLogger::$serverNK = $serverNK->getDeclaredMethod("getInstance", [])->invoke(null);
