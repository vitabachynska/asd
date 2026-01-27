public class Main {

    public static void main(String[] args) {
        UserRepository repository = new UserRepository();

        User user1 = repository.findByEmail("test@email.com")
                .orElseThrow(() -> new RuntimeException("User not found"));
        User user2 = repository.findByEmail("unknown@email.com")
                .orElseGet(() -> new User("default@email.com"));

        System.out.println("user1 = "+user1.getEmail());
        System.out.println("user2 = "+user2.getEmail());
    }
}