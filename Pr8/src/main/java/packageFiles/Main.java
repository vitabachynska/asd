package packageFiles;

import java.util.ArrayList;
import java.util.List;

import static packageFiles.GenericUtils.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        //run1();
        run2();


    }


    private static void run1(){
        List list = new ArrayList();
        list.add("value");
        //list.add(23);

        List<String> list1 = new ArrayList<>();
        list1.add("value");
        //list1.add(23);

        for (Object o: list){
            String s = (String) o;
        }

        //при використанні generic чітко видно тип який має прийматися і
        // невідповідність виявляється на етапі компіляції
    }

    private static void run2(){
        List<String> names = List.of("Anna", "Sophia");
        System.out.println("First: " + firstOrNull(names));

        List<Double> numdersDouble = List.of(12.4, 45.4, 8.0);
        System.out.println("Sum: " + sum(numdersDouble));

        List<Number> numbers = new ArrayList<>();
        addDefaultIds(numbers);
        System.out.println("Numbers with IDs: " + numbers);

    }
}
