package imkn.listener;


import java.util.ArrayList;
import java.util.List;

public class EventBus {

    private List<Listener> listeners = new ArrayList<>();

    void subscribe(Listener listener) {
        listeners.add(listener);
    }

    void unsubscribe(Listener listener) {
        listeners.remove(listener);
    }

    void publish(Event event) {
        listeners.forEach(l -> l.onEvent(event));
    }

}
