package packageFiles;

public class MultiNotifier implements EmailNotifier, SmsNotifier{
    @Override
    public void send(String text) {
        SmsNotifier.super.send(text);
        EmailNotifier.super.send(text);
    }

}
