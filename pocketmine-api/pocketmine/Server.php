<?php
namespace pocketmine;
use cn\nukkit\Server as ServerNK;
use pocketmine\utils\UUID;
use function max;
use function min;
class Server{
  public const BROADCAST_CHANNEL_ADMINISTRATIVE = ServerNK::BROADCAST_CHANNEL_ADMINISTRATIVE;
  public const BROADCAST_CHANNEL_USERS = ServerNK::BROADCAST_CHANNEL_USERS;
  private static $instance = null;
  private static $instanceNK = ServerNK::getInstance();
  private $serverID;
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
    //UUID::fromString(self::$instanceNK->getServerUniqueId(), /*$version*/);
    return $this->serverID;
  }
}
