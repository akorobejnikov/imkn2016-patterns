package imkn.listener;


public class ObjectCreatedEvent implements Event{

    private final Object object;

    public ObjectCreatedEvent(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "object created: " + object.toString();
    }

}
