<?php
namespace pocketmine\utils;
use TextFormat as TextFormatNK;
use function is_array;
use function json_encode;
use function json_last_error_msg;
use function mb_scrub;
use function preg_last_error;
use function preg_quote;
use function preg_replace;
use function preg_split;
use function str_repeat;
use function str_replace;
use const JSON_UNESCAPED_SLASHES;
use const PREG_BACKTRACK_LIMIT_ERROR;
use const PREG_BAD_UTF8_ERROR;
use const PREG_BAD_UTF8_OFFSET_ERROR;
use const PREG_INTERNAL_ERROR;
use const PREG_JIT_STACKLIMIT_ERROR;
use const PREG_RECURSION_LIMIT_ERROR;
use const PREG_SPLIT_DELIM_CAPTURE;
use const PREG_SPLIT_NO_EMPTY;
abstract class TextFormat{
    public const ESCAPE = "\xc2\xa7";
	public const EOL = "\n";

	public const BLACK = TextFormat::ESCAPE . "0";
	public const DARK_BLUE = TextFormat::ESCAPE . "1";
	public const DARK_GREEN = TextFormat::ESCAPE . "2";
	public const DARK_AQUA = TextFormat::ESCAPE . "3";
	public const DARK_RED = TextFormat::ESCAPE . "4";
	public const DARK_PURPLE = TextFormat::ESCAPE . "5";
	public const GOLD = TextFormat::ESCAPE . "6";
	public const GRAY = TextFormat::ESCAPE . "7";
	public const DARK_GRAY = TextFormat::ESCAPE . "8";
	public const BLUE = TextFormat::ESCAPE . "9";
	public const GREEN = TextFormat::ESCAPE . "a";
	public const AQUA = TextFormat::ESCAPE . "b";
	public const RED = TextFormat::ESCAPE . "c";
	public const LIGHT_PURPLE = TextFormat::ESCAPE . "d";
	public const YELLOW = TextFormat::ESCAPE . "e";
	public const WHITE = TextFormat::ESCAPE . "f";

	public const OBFUSCATED = TextFormat::ESCAPE . "k";
	public const BOLD = TextFormat::ESCAPE . "l";
	public const STRIKETHROUGH = TextFormat::ESCAPE . "m";
	public const UNDERLINE = TextFormat::ESCAPE . "n";
	public const ITALIC = TextFormat::ESCAPE . "o";
	public const RESET = TextFormat::ESCAPE . "r";
	private static function makePcreError() : \InvalidArgumentException{
		$errorCode = preg_last_error();
		$message = [
			PREG_INTERNAL_ERROR => "Internal error",
			PREG_BACKTRACK_LIMIT_ERROR => "Backtrack limit reached",
			PREG_RECURSION_LIMIT_ERROR => "Recursion limit reached",
			PREG_BAD_UTF8_ERROR => "Malformed UTF-8",
			PREG_BAD_UTF8_OFFSET_ERROR => "Bad UTF-8 offset",
			PREG_JIT_STACKLIMIT_ERROR => "PCRE JIT stack limit reached"
		][$errorCode] ?? "Unknown (code $errorCode)";
		throw new \InvalidArgumentException("PCRE error: $message");
	}
    public static function tokenize(string $string) : array{
        $result = preg_split("/(" . TextFormat::ESCAPE . "[0-9a-fk-or])/u", $string, -1, PREG_SPLIT_NO_EMPTY | PREG_SPLIT_DELIM_CAPTURE);
		if($result === false) throw self::makePcreError();
		return $result;
    }
    public static function clean(string $string, bool $removeFormat = true) : string{
        return TextFormatNK::clean($string, true);
    }
	public static function colorize(string $string, string $placeholder = "&") : string{
		return TextFormatNK::colorize($placeholder, $string);
	}
	/**
	 * Returns an HTML-formatted string with colors/markup
	 *
	 * @param string|string[] $string
	 */
	public static function toHTML($string) : string{
		if(!is_array($string)){
			$string = self::tokenize($string);
		}
		$newString = "";
		$tokens = 0;
		foreach($string as $token){
			switch($token){
				case TextFormat::BOLD:
					$newString .= "<span style=font-weight:bold>";
					++$tokens;
					break;
				case TextFormat::OBFUSCATED:
					//$newString .= "<span style=text-decoration:line-through>";
					//++$tokens;
					break;
				case TextFormat::ITALIC:
					$newString .= "<span style=font-style:italic>";
					++$tokens;
					break;
				case TextFormat::UNDERLINE:
					$newString .= "<span style=text-decoration:underline>";
					++$tokens;
					break;
				case TextFormat::STRIKETHROUGH:
					$newString .= "<span style=text-decoration:line-through>";
					++$tokens;
					break;
				case TextFormat::RESET:
					$newString .= str_repeat("</span>", $tokens);
					$tokens = 0;
					break;

				//Colors
				case TextFormat::BLACK:
					$newString .= "<span style=color:#000>";
					++$tokens;
					break;
				case TextFormat::DARK_BLUE:
					$newString .= "<span style=color:#00A>";
					++$tokens;
					break;
				case TextFormat::DARK_GREEN:
					$newString .= "<span style=color:#0A0>";
					++$tokens;
					break;
				case TextFormat::DARK_AQUA:
					$newString .= "<span style=color:#0AA>";
					++$tokens;
					break;
				case TextFormat::DARK_RED:
					$newString .= "<span style=color:#A00>";
					++$tokens;
					break;
				case TextFormat::DARK_PURPLE:
					$newString .= "<span style=color:#A0A>";
					++$tokens;
					break;
				case TextFormat::GOLD:
					$newString .= "<span style=color:#FA0>";
					++$tokens;
					break;
				case TextFormat::GRAY:
					$newString .= "<span style=color:#AAA>";
					++$tokens;
					break;
				case TextFormat::DARK_GRAY:
					$newString .= "<span style=color:#555>";
					++$tokens;
					break;
				case TextFormat::BLUE:
					$newString .= "<span style=color:#55F>";
					++$tokens;
					break;
				case TextFormat::GREEN:
					$newString .= "<span style=color:#5F5>";
					++$tokens;
					break;
				case TextFormat::AQUA:
					$newString .= "<span style=color:#5FF>";
					++$tokens;
					break;
				case TextFormat::RED:
					$newString .= "<span style=color:#F55>";
					++$tokens;
					break;
				case TextFormat::LIGHT_PURPLE:
					$newString .= "<span style=color:#F5F>";
					++$tokens;
					break;
				case TextFormat::YELLOW:
					$newString .= "<span style=color:#FF5>";
					++$tokens;
					break;
				case TextFormat::WHITE:
					$newString .= "<span style=color:#FFF>";
					++$tokens;
					break;
				default:
					$newString .= $token;
					break;
			}
		}

		$newString .= str_repeat("</span>", $tokens);

		return $newString;
	}
}
