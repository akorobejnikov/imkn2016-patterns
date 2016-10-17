package imkn.strategy;


public class KeyValueStringItem {

    private final String id;
    private final String text;

    public KeyValueStringItem(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }
}
