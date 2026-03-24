package packageFiles;

public class TicketService {
    public void buildTicketId(String base) {
        String suffix = "-1234";

        class IdBuilder {
            String build() {
                return base + suffix;
            }
        }

        IdBuilder builder = new IdBuilder();
        System.out.println("ID квитка: " + builder.build());
    }

    public Runnable runOnce() {
         return new Runnable() {
            public void run() {
                System.out.println("Запустили один раз");
            }
        };
    }
}
