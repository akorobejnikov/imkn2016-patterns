package imkn.strategy.engine;


import java.io.IOException;
import java.util.List;

public interface KeyValueStoreEngine {

    void add(String id, byte[] data) throws IOException;

    byte[] get(String id) throws IOException;

    void remove(String id) throws IOException;

    List<String> listIds(String prefix) throws IOException;

}
