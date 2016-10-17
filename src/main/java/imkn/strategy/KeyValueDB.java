package imkn.strategy;


import java.util.List;

public interface KeyValueDB {

    void add(KeyValueStringItem item);

    public void add(KeyValueIntArrayItem item);

    KeyValueStringItem getStringItem(String id);

    KeyValueIntArrayItem getIntArrayItem(String id);

    void removeStringItem(String id);

    void removeIntArrayItem(String id);

    List<KeyValueIntArrayItem> listIntArrayItems();

    List<KeyValueStringItem> listStringItems();

}
