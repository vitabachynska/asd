package packageFiles;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StepRunner {

    public static void run(Object target) {
        Class<?> clazz = target.getClass();
        List<Method> steps = new ArrayList<>();

        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Step.class)) {

                if (m.getParameterCount() > 0 || !m.getReturnType().equals(void.class)) {
                    throw new StepExecutionException("Метод " + m.getName() + " має бути void і без аргументів!");
                }
                steps.add(m);
            }
        }

        steps.sort(Comparator.comparingInt(m -> m.getAnnotation(Step.class).order()));
        for (Method m : steps) {
            try {
                m.setAccessible(true);
                m.invoke(target);
            } catch (InvocationTargetException e) {
                throw new StepExecutionException("Помилка під час виконання: " + m.getName(), e.getCause());
            } catch (IllegalAccessException e) {
                throw new StepExecutionException("Немає доступу до методу: " + m.getName(), e);
            }
        }
    }
}
