package packageFiles;

public class DailyReport extends ReportGenerator {
    @Override
    protected void collectData() {
        System.out.println("Збір даних");
    }
    @Override
    protected void formatReport() {
        System.out.println("Форматування даних");
    }
}
