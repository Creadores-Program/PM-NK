<?php
namespace pocketmine {
  const MIN_PHP_VERSION = "7.4.0";
  function critical_error($message){
		echo "[ERROR] $message" . PHP_EOL;
  }
}
