package eng.elemar.ponto.exceptions;

import lombok.Getter;

@Getter
public class ExceptionResponse {
    private String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }
}
