<?php
namespace pocketmine;
use Server as ServerNK;
use pocketmine\utils\UUID;
use pocketmine\utils\MainLogger;
use function max;
use function min;
use function define;
//$serverNK->getDeclaredField("BROADCAST_CHANNEL_ADMINISTRATIVE")->get(null);
class Server{
  public const BROADCAST_CHANNEL_ADMINISTRATIVE = ServerNK::BROADCAST_CHANNEL_ADMINISTRATIVE;
  public const BROADCAST_CHANNEL_USERS = ServerNK::BROADCAST_CHANNEL_USERS;
  private static $instance = null;
  private static $instanceNK = ServerNK::getInstance();
  private $serverID;
  private $logger;
  public function getName() : string{
		return \pocketmine\NAME . "-" . self::$instanceNK->getName();
  }
  public function isRunning() : bool{
    return self::$instanceNK->isRunning();
  }
  public function getPocketMineVersion() : string{
		return \pocketmine\VERSION;
  }
  public function getVersion() : string{
    return self::$instanceNK->getVersion();
  }
  public function getApiVersion() : string{
		return \pocketmine\BASE_VERSION;
  }
  public function getFilePath() : string{
		return \pocketmine\PATH;
  }
  public function getResourcePath() : string{
		return \pocketmine\RESOURCE_PATH;
  }
  public function getDataPath() : string{
		return self::$instanceNK->getDataPath();
	}
	public function getPluginPath() : string{
		return self::$instanceNK->getPluginPath();
  }
  public function getMaxPlayers() : int{
		return self::$instanceNK->getMaxPlayers();
  }
  public function getOnlineMode() : bool{
		return self::$instanceNK->getPropertyBoolean("xbox-auth", true);
  }
  public function requiresAuthentication() : bool{
		return $this->getOnlineMode();
  }
  public function getPort() : int{
    return self::$instanceNK->getPort();
  }
  public function getViewDistance() : int{
    return self::$instanceNK->getViewDistance();
  }
  public function getAllowedViewDistance(int $distance) : int{
		return max(2, min($distance, $this->getViewDistance()));
  }
  public function getIp() : string{
    return self::$instanceNK->getIp();
  }
  public function getServerUniqueId(){
    return $this->serverID;
  }
  public function getAutoSave() : bool{
	  return self::$instanceNK->getAutoSave();
  }
  public function setAutoSave(bool $value){
    self::$instanceNK->setAutoSave($value);
  }
  public function getLevelType() : string{
    return self::$instanceNK->getLevelType();
  }
  public function getGenerateStructures() : bool{
    if(self::$instanceNK->getPluginManager->getPlugin("WorldGeneratorExtension") != null){
      return true;
    }
    return false;
  }
  public function getGamemode() : int{
    return self::$instanceNK->getGamemode();
  }
  public function getForceGamemode() : bool{
    return self::$instanceNK->getForceGamemode();
  }
  public static function getGamemodeString(int $mode) : string{
    return self::$instanceNK->getGamemodeString($mode);
  }
  public static function getGamemodeName(int $mode) : string{
    $gameName = self::$instanceNK->getGamemodeString($mode, true);
    if($gameName == "UNKNOWN"){
      throw new \InvalidArgumentException("Invalid gamemode $mode");
    }
    return $gameName;
  }
  public static function getGamemodeFromString(string $str) : int{
    return self::$instanceNK->getGamemodeFromString($str);
  }
  public function getDifficulty() : int{
    return self::$instanceNK->getDifficulty();
  }
  public function getLogger(){
    return $this->logger;
  }
  public static function getInstance(){
    return self::$instance;
  }
  public function __construct(){
	  self::$instance = $this;
	  $this->serverID = UUID::fromString(self::$instanceNK->getServerUniqueId()->toString());
	  $this->logger = new MainLogger(self::$instanceNK->getLogger());
  }
}
