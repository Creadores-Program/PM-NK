package pocketmine.utils;
import php.runtime.lang.exception.BaseError;
import php.runtime.env.Environment;
import static php.runtime.annotation.Reflection.*;
@Name("AssumptionFailedError")
@Namespace("pocketmine\\utils")
public class AssumptionFailedErrorPm extends BaseError{
    public AssumptionFailedErrorPm(Environment env) {
        super(env);
    }
}