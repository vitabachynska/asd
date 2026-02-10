package packageFiles;

public interface EmailNotifier {
    default void send(String text){
        System.out.println("EmailNotifier " + text);
    }
}
