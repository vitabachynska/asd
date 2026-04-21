package packageFiles;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassInfoPrinter {

    public static void print() {
        Class<?> clazz = Book.class;
        System.out.println("getName(): " + clazz.getName());
        System.out.println("getSuperclass(): " + clazz.getSuperclass());
        System.out.println("getInterfaces(): " + Arrays.toString(clazz.getInterfaces()));

        System.out.println("\ngetDeclaredFields():");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("  " + f.getName() + " : " + f.getType().getSimpleName());
        }

        System.out.println("getDeclaredMethods():");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("  " + m.getName() + " (повертає " + m.getReturnType().getSimpleName() + ")");
        }
    }
}
