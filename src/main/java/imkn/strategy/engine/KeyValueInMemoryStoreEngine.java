package imkn.strategy.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class KeyValueInMemoryStoreEngine implements KeyValueStoreEngine {

    private Map<String, byte[]> store = new HashMap<>();

    @Override
    public void add(String id, byte[] data) {
        store.put(id, data);
    }

    @Override
    public byte[] get(String id) {
        return store.get(id);
    }

    @Override
    public void remove(String id) {
        store.remove(id);
    }

    @Override
    public List<String> listIds(String prefix) {
        return new ArrayList<>(store.keySet()).stream()
                .filter(name -> name.startsWith(prefix))
                .collect(Collectors.toList());
    }
}
