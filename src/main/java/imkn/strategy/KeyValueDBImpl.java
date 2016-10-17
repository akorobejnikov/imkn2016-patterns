package imkn.strategy;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class KeyValueDBImpl implements KeyValueDB {

    private static final String INT_ARRAY_KEY_PREFIX = "int_array_";
    private static final String STRING_KEY_PREFIX = "string_";
    private KeyValueStoreEngine storeEngine;

    public KeyValueDBImpl(KeyValueStoreEngine storeStrategy) {
        this.storeEngine = storeStrategy;
    }

    private String intArrayKey(String id) {
        return INT_ARRAY_KEY_PREFIX + id;
    }

    private String stringKey(String id) {
        return STRING_KEY_PREFIX + id;
    }

    @Override
    public void add(KeyValueStringItem item) {
        try {
            storeEngine.add(stringKey(item.getId()), item.getText().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new KeyValueDBException(e);
        }
    }

    @Override
    public void add(KeyValueIntArrayItem item) {
        int[] values = item.getValue();
        ByteBuffer data = ByteBuffer.allocate(values.length * 4);
        for (int value : values) {
            data.putInt(value);
        }
        try {
            storeEngine.add(intArrayKey(item.getId()), data.array());
        } catch (IOException e) {
            throw new KeyValueDBException(e);
        }
    }

    @Override
    public KeyValueStringItem getStringItem(String id) {
        try {
            byte[] bytes = storeEngine.get(stringKey(id));
            if (bytes == null) {
                return null;
            }
            return new KeyValueStringItem(stringKey(id), new String(bytes, StandardCharsets.UTF_8.name()));
        } catch (IOException e) {
            throw new KeyValueDBException(e);
        }
    }

    @Override
    public KeyValueIntArrayItem getIntArrayItem(String id) {
        try {
            byte[] bytes = storeEngine.get(intArrayKey(id));
            if (bytes == null) {
                return null;
            }
            ByteBuffer buf = ByteBuffer.wrap(bytes);
            int[] values = new int[bytes.length / 4];
            for (int i = 0; i < values.length; i++) {
                values[i] = buf.getInt();
            }
            return new KeyValueIntArrayItem(id, values);
        } catch (IOException e) {
            throw new KeyValueDBException(e);
        }
    }

    @Override
    public void removeStringItem(String id) {
        try {
            storeEngine.remove(stringKey(id));
        } catch (IOException e) {
            throw new KeyValueDBException(e);
        }
    }

    @Override
    public void removeIntArrayItem(String id) {
        try {
            storeEngine.remove(intArrayKey(id));
        } catch (IOException e) {
            throw new KeyValueDBException(e);
        }
    }

    @Override
    public List<KeyValueIntArrayItem> listIntArrayItems() {
        try {
            return storeEngine.listIds(INT_ARRAY_KEY_PREFIX).stream()
                    .map(id -> id.substring(INT_ARRAY_KEY_PREFIX.length()))
                    .map(this::getIntArrayItem)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new KeyValueDBException(e);
        }
    }

    @Override
    public List<KeyValueStringItem> listStringItems() {
        try {
            return storeEngine.listIds(STRING_KEY_PREFIX).stream()
                    .map(id -> id.substring(STRING_KEY_PREFIX.length()))
                    .map(this::getStringItem)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new KeyValueDBException(e);
        }
    }

}