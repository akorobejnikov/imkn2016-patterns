package imkn.listener;


import java.util.ArrayList;
import java.util.List;

public class EventBusImpl implements EventBus {

    private List<Listener> listeners = new ArrayList<>();

    @Override
    public void subscribe(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void unsubscribe(Listener listener) {
        listeners.remove(listener);
    }

    @Override
    public void publish(Object event) {
        listeners.forEach(l -> l.onEvent(event));
    }

}
