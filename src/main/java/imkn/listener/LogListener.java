package imkn.listener;


public class LogListener implements Listener {

    @Override
    public void onEvent(Event event) {
        System.out.println("LOG: " + event.toString());
    }

}
