package imkn.strategy;


import java.io.IOException;

public class KeyValueDBException extends RuntimeException {

    public KeyValueDBException(IOException e) {
        super(e);
    }

}
