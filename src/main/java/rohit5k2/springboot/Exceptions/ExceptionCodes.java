package rohit5k2.springboot.Exceptions;

public class ExceptionCodes {
    enum Codes{
        Unknown(-1),
        BaseException(100),
        ParameterException(101),
        DBAccessException(102);

        int value;
        Codes(int v) {
            this.value = v;
        }
    }
}
