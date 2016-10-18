package imkn.listener;


public class DBLogListener implements Listener {

    @Override
    public void onEvent(Object event) {
        System.out.println("DB_LOG: " + event.toString());
    }

}