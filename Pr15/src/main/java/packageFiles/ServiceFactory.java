package packageFiles;

import java.lang.reflect.Constructor;

public class ServiceFactory {
    public static PaymentService create(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getDeclaredConstructor();

            Object obj = constructor.newInstance();
            PaymentService service = (PaymentService) obj;
            return service;

        } catch (Exception e) {
            System.err.println("Помилка створення сервісу: " + e.getMessage());
            return null;
        }
    }
}
