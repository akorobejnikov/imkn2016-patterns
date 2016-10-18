package imkn.listener;


public class ObjectCreatedEvent {

    private final Object object;

    public ObjectCreatedEvent(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "object created: " + object.toString();
    }

}
