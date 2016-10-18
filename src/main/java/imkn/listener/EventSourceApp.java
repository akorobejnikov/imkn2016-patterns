package imkn.listener;


public class EventSourceApp {

    public static void main(String[] args) {

        EventBusImpl eventBus = new EventBusImpl();

        Listener logListener = new LogListener();
        Listener dbLogListener = new DBLogListener();
        Listener mailSendListener = new MailSendListener();

        eventBus.subscribe(logListener);
        eventBus.subscribe(dbLogListener);
        eventBus.subscribe(mailSendListener);

        eventBus.publish(new ObjectCreatedEvent("new_object"));

        System.out.println();

        eventBus.unsubscribe(mailSendListener);

        eventBus.publish(new ObjectDeletedEvent("new_object"));
    }

}
