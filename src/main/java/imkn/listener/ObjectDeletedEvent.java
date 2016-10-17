package imkn.listener;


public class ObjectDeletedEvent implements Event{

    private final Object object;

    public ObjectDeletedEvent(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "object deleted: " + object.toString();
    }

}