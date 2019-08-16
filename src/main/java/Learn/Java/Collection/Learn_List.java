package Learn.Java.Collection;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Learn_List {

    @Test
    public void learnList() {
        List<String> stringList = Stream.of("Apple", "Cherry", "Banana", "Orange").collect(Collectors.toList());
        System.out.println("List of Element are - " + stringList);
        System.out.println("List of String Size is : " + stringList.size());
        System.out.println("Element at 2 positing : " + stringList.get(2));
        System.out.println("List contains Elment 'Cherry'? : " + stringList.contains("Cherry"));
        stringList.remove(2);
        System.out.println("Second Elment 'Cherry' is Removed : " + stringList);
        stringList.add(2, "PineApple");
        System.out.println("List after adding PineApple at position 2 : " + stringList);
        stringList.sort((Comparator<? super String>) stringList);
        System.out.println("List after Sort : " + stringList);
    }
}
