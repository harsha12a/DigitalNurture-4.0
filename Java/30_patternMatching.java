class PatternMatching {
    public static void details(Object obj) {
        String res = switch(obj) {
            case String s -> "String: " + s;
            case Integer i -> "Integer: " + i;
            case Double d -> "Double: " + d;
            case null -> "Null object";
            default -> "Unknown type";
        };
        System.out.println(res);
    }
    public static void main(String[] args) {
        details("Hello");
        details(42);
        details(3.14);
        details(null);
    }
}