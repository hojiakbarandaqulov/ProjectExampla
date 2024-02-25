import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       /* Integer numbers[] = {2, 8, 3, 6, 1, 7, 9, 0};

        List<Integer> sortedList = Arrays.asList(numbers).stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);*/
       /* String string[]={"Java","Python","JavaScript","Flutter"};

        List<String> strings=Arrays.asList(string).stream().skip(3).collect(Collectors.toList());
        System.out.println(strings);*/
        String s="ataylab";
         List<String> strings=Arrays.asList(s).stream().filter(value->value.length()>5).collect(Collectors.toList());
        System.out.println(strings);
    }
}