import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age) {}

class Record {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 15);
        Person p2 = new Person("Bob", 25);
        System.out.println("People:");
        System.out.println(p1);
        System.out.println(p2);
        
        List<Person> people = List.of(p1, p2);
        List<Person> names = people.stream().filter(p -> p.age() >= 18).collect(Collectors.toList());
        System.out.println("Adults:");
        for (Person p : names) {
            System.out.println(p.name());
        }
    }
}
