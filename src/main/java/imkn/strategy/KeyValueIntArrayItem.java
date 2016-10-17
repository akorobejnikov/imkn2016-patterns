package imkn.strategy;


public class KeyValueIntArrayItem {

    private String id;
    private int[] value;

    public KeyValueIntArrayItem(String id, int[] value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public int[] getValue() {
        return value;
    }
}
