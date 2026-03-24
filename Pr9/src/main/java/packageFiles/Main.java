package packageFiles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //run1();
        //run2();
        //run3();
        run4();
    }

    private static void run4() {
        UserDto user = new UserDto();
        user.setUsername("Vitalina");
        System.out.println("Користувач: " + user.getUsername());

        Price price = new Price(999.99, "грн");
        System.out.println("Ціна: " + price);


        CheckoutRequest request = CheckoutRequest.builder()
                .id(101)
                .productName("Laptop")
                .quantity(1)
                .build();

        System.out.println("Замовлення: " + request);
    }

    private static void run3() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(3, "2026-03-20"));
        tickets.add(new Ticket(1, "2026-04-15"));
        tickets.add(new Ticket(2, "2026-03-20"));

        tickets.sort(new Comparator<Ticket>() {
            @Override
            public int compare(Ticket t1, Ticket t2) {
                return Integer.compare(t1.priority, t2.priority);
            }
        });
        System.out.println("Після анонімного класу: " + tickets);

        tickets.sort((t1, t2) -> Integer.compare(t1.priority, t2.priority));

        System.out.println("Method Reference:");
        tickets.forEach(System.out::println);

        String sortBy = "copparing";

        if(sortBy.equals("comparing")){
           // tickets.sort(TicketComparators.BY_COMPARING);
        }
        else if (sortBy.equals("priority")) {
            tickets.sort(TicketComparators.BY_PRIORITY);
        } else {
            tickets.sort(TicketComparators.BY_DATE);
        }

        System.out.println("Фінальний результат: " + tickets);
    }

    private static void run2() {
        TicketService service = new TicketService();

        service.buildTicketId("Квиток");
        Runnable action = service.runOnce();
        action.run();
    }

    private static void run1(){
        Car myCar = new Car("Tesla");
        Car.Engine engine = myCar.createEngine(500);
        System.out.println(engine);

        Library myLibrary = new Library("бібліотека");
        Library.Book myBook = myLibrary.new Book("назва книги", "автор");
        System.out.println(myBook.bookLabel());
    }
}
