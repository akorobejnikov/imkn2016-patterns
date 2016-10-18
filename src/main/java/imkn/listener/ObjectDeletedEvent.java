package imkn.listener;


public class ObjectDeletedEvent {

    private final Object object;

    public ObjectDeletedEvent(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "object deleted: " + object.toString();
    }

}