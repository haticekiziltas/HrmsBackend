package kodlamaio.hrmsdemo.core.utilities.validations;


import kodlamaio.hrmsdemo.core.utilities.results.ErrorResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessResult;

public class Validations {
    public static Result run(Result... logics) {
        for (var result : logics) {

            if (!result.isSucces()) {
                return result;
            }

        }
        return null;

    }
}
