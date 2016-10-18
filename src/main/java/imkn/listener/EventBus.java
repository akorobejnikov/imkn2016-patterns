package imkn.listener;


public interface EventBus {

    void subscribe(Listener listener);

    void unsubscribe(Listener listener);

    void publish(Object event);

}
