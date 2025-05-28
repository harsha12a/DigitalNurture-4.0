class TypeCast {
    public static void main(String[] args) {
        double d = 20;
        int dToi = (int) d; // Explicit type casting from double to int
        System.out.println("Integer value: " + dToi);

        int i = 25;
        double iTod = i; // Implicit type casting from int to double
        System.out.println("Double value: " + iTod);
    }
}
