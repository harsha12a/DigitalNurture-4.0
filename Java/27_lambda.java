import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Lambda {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Umesh");
        names.add("Ramu");
        names.add("Somu");
        names.add("Prem");

        System.out.println("Before sorting:");
        System.out.println(names);

        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        System.out.println("\nAfter sorting:");
        System.out.println(names);
    }
}