package packageFiles;

public interface SmsNotifier {
    default void send(String text){
        System.out.println("SmsNotifier " + text);
    }
}
