<?php
declare(strict_types=1);
namespace pocketmine\utils;
use MainLogger as MainLoggerNK;
use Server as ServerNK;
use LogLevel;
class MainLogger{
  private $loggerNK;
  public static $logger;
  private $format;
  public function __construct($loggerNK){
    $this->loggerNK = $loggerNK;
    static::$logger = $this;
    $this->format = TextFormat::AQUA . "[%s] " . TextFormat::RESET . "%s[%s/%s]: %s" . TextFormat::RESET;
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
  public function setLogDebug(bool $logDebug){}
  public function emergency($message){
    $this->loggerNK->emergency($message);
  }
  public function alert($message){
    $this->loggerNK->alert($message);
  }
  public function critical($message){
    $this->loggerNK->critical($message);
  }
  public function error($message){
    $this->loggerNK->error($message);
  }
  public function warning($message){
    $this->loggerNK->warning($message);
  }
  public function notice($message){
    $this->loggerNK->notice($message);
  }
  public function info($message){
    $this->loggerNK->info($message);
  }
  public function debug($message, bool $force = false){
    if(static::$serverNK->getConfig("debug.level", 1) < 3 && !$force){
      return;
    }
    $this->loggerNK->debug($message);
  }
  public function logException(\Throwable $e, $trace = null){
    $this->loggerNK->logException($e);
  }
  public function log($level, $message){
		switch($level){
			case LogLevel::EMERGENCY:
				$this->emergency($message);
				break;
			case LogLevel::ALERT:
				$this->alert($message);
				break;
			case LogLevel::CRITICAL:
				$this->critical($message);
				break;
			case LogLevel::ERROR:
				$this->error($message);
				break;
			case LogLevel::WARNING:
				$this->warning($message);
				break;
			case LogLevel::NOTICE:
				$this->notice($message);
				break;
			case LogLevel::INFO:
				$this->info($message);
				break;
			case LogLevel::DEBUG:
				$this->debug($message);
				break;
		}
	}
  public function shutdown(){}
  public function syncFlushBuffer(){}
  public function run(){}
}
$metodos = get_class_methods(ServerNK::class); 
print_r($metodos);
