package packageFiles;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public void main(String[] args) {
        //run1();
        //run2();
        run3();

    }

    private void run1() {

        Order validOrder = new Order(1, "wds@email", 1000);
        System.out.println("Коректне замовлення: " + validOrder);
        try {
            Order invalidOrder1 = new Order(-50, "2w@email", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        try {
            Order invalidOrder2 = new Order(30, "email", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        try {
            Order invalidOrder3 = new Order(30, "wsd@email", -100);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private void run2() {

        OrderService orderService = new OrderService();
        Order testOrder = new Order(465, "fd@edfdv", 1000);

        try {
            orderService.checkout(testOrder);
        } catch (OrderProcessingException e) {
            System.err.println("Message: " + e.getMessage());
            System.err.println("Cause: " + e.getCause());
        }


        /*Order testOrder1 = new Order(465, "fdedfdv", 1000);

        try {
            orderService.checkout(testOrder1);
        } catch (OrderProcessingException e) {
            System.err.println("Message: " + e.getMessage());
            System.err.println("Cause: " + e.getCause());
        }*/
    }
    private void run3(){
        try {
            new Order(1, "@email", 100);
        } catch (IllegalArgumentException e) {
            System.err.println("Validation: " + e.getMessage());
        }
    }

}
