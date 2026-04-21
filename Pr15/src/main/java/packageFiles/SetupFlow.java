package packageFiles;

public class SetupFlow {
    @Step(order = 2)
    private void startServices() {
        System.out.println("Сервіси запущено");
    }

    @Step(order = 1)
    public void initConfig() {
        System.out.println("Конфігурацію завантажено");
    }

    @Step(order = 3)
    private void connectDatabase() {
        System.out.println("Базу даних підключено");

        //throw new RuntimeException("Error");
    }
}
