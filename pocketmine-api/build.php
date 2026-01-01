<?php
echo "Packing PocketMine PM-NK Translator...\n";
$pharFile = "PocketMine-MP.phar";
$phar = new Phar($pharFile);
$phar->setAlias("PocketMine-MP.phar");
$phar->buildFromDirectory(dirname(__FILE__) . '/src');
if(Phar::canCompress(Phar::GZ)){
    $phar->compressFiles(Phar::GZ);
} elseif (Phar::canCompress(Phar::BZ2)){
    $phar->compressFiles(Phar::BZ2);
}
$phar->setStub("<?php __HALT_COMPILER(); ?>");
echo "Done!\n";
?>