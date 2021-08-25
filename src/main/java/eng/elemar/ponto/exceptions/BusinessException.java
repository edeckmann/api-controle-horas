package eng.elemar.ponto.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message){
        super(message);
    }
}
