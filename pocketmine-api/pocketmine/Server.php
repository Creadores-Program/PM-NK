<?php
namespace pocketmine;
use cn\nukkit\Server as ServerNK;
use Ramsey\Uuid\UuidInterface;
class Server{
  public const BROADCAST_CHANNEL_ADMINISTRATIVE = ServerNK::BROADCAST_CHANNEL_ADMINISTRATIVE;
  public const BROADCAST_CHANNEL_USERS = ServerNK::BROADCAST_CHANNEL_USERS;
  private static $instance = null;
  private static $instanceNK = ServerNK::getInstance();
  public function getName() : string{
		return \pocketmine\NAME . "-" . $this->instanceNK->getName();
  }
  public function isRunning() : bool{
    return $this->instanceNK->isRunning();
  }
  public function getPocketMineVersion() : string{
		return \pocketmine\VERSION;
  }
  public function getVersion() : string{
    return $this->instanceNK->getVersion();
  }
  public function getApiVersion() : string{
		return \pocketmine\BASE_VERSION;
  }
  public function getFilePath() : string{
		return \pocketmine\PATH;
  }
  public function getResourcePath() : string{
    //No defined
		return \pocketmine\RESOURCE_PATH;
  }
  public function getDataPath() : string{
		return $this->instanceNK->getDataPath();
	}
	public function getPluginPath() : string{
		return $this->instanceNK->getPluginPath();
  }
  public function getMaxPlayers() : int{
		return $this->instanceNK->getMaxPlayers();
  }
  public function getOnlineMode() : bool{
    //no defined
		return $this->onlineMode;
  public function requiresAuthentication() : bool{
		return $this->getOnlineMode();
  }
  public function getPort() : int{
    return $this->instanceNK->getPort();
  }
  public function getViewDistance() : int{
    return $this->instanceNK->getViewDistance();
  }
  public function getAllowedViewDistance(int $distance) : int{
		return max(2, min($distance, $this->getViewDistance()));
  }
  public function getIp() : string{
    return $this->instanceNK->getIp();
  }
  public function getServerUniqueId(){
    //UuidInterface needs to be converted
    return $this->instanceNK->getServerUniqueId();
  }
}
