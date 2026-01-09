<?php
declare(strict_types=1);
namespace pocketmine {
  const MIN_PHP_VERSION = "7.1.0";
  function critical_error($message){
		echo "[ERROR] $message" . PHP_EOL;
  }
}
