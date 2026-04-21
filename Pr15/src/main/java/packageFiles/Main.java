package packageFiles;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //run1();
        //run2();
        run3();
    }

    private static void run1() {
        Class<?> clazz = Book.class;
        ClassInfoPrinter.print(clazz);
    }

    private static void run2() {
        PaymentService cardService = ServiceFactory.create("packageFiles.CardPaymentService");
        PaymentService cashService = ServiceFactory.create("packageFiles.CashPaymentService");
        if (cardService != null)
            cardService.pay(7654);
        if (cashService != null)
            cashService.pay(234);
    }
    private static void run3(){
        StepRunner.run(new SetupFlow());
    }
}


