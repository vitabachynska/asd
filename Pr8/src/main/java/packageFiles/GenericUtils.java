package packageFiles;

import java.util.ArrayList;
import java.util.List;

public class GenericUtils {
    public static <T> T firstOrNull(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public static double sum(List<? extends Number> numbers) {
        double result = 0.0;
        for (Number n : numbers) {
            result += n.doubleValue();
        }
        return result;
    }

    public static void addDefaultIds(List<? super Integer> ids) {
        ids.add(10);
        ids.add(93);
        ids.add(12);
    }
}
