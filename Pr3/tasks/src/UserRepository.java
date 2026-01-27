import java.util.Optional;
public class UserRepository {
    public Optional<User> findByEmail(String email) {
        if ("test@email.com".equals(email)) {
            return Optional.of(new User(email));
        }
        return Optional.empty();
    }
}
