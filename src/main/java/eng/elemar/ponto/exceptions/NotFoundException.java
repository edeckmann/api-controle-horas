package eng.elemar.ponto.exceptions;

import eng.elemar.ponto.utils.MessageUtils;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
    
}
