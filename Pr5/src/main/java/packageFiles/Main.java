package packageFiles;

public class Main {
    public static void main(String[] args) {
        //run();
        //run2();
        run3();
    }

    static void run() {
        PaymentMethod card = new CardPayment();
        PaymentMethod paypal = new PayPalPayment();

        card.pay(100);
        paypal.pay(300);

        card.payWithFee(100, 10);
        paypal.payWithFee(200, 10);
    }

    static void run2() {
        ReportGenerator report = new DailyReport();
        report.generate();

    }

    static void run3() {
        MultiNotifier notifier = new MultiNotifier();
        notifier.send("Hello world");

    }
}

