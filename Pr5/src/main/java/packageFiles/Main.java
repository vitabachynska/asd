package packageFiles;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //run();
        run2();
    }

    static void run() {
        PaymentMethod[] methods = {
                new CardPayment(),
                new PayPalPayment()
        };

        PaymentProcessor processor = new PaymentProcessor();
        int amount = 10;

        for (PaymentMethod method : methods) {
            processor.process(method, amount);
        }
    }

    static void run2() {
        ReportGenerator report = new DailyReport();
        report.generate();

        }
}

