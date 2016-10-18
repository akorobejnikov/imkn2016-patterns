package imkn.listener;


public class MailSendListener implements Listener {

    @Override
    public void onEvent(Object event) {
        System.out.println("MAIL_SEND: " + event.toString());
    }

}