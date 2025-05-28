class Car {
    String make;
    String model;
    int year;

    void displayDetails() {
        System.out.println("Car Make : " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Car Year : " + year);
        System.out.println("-----------------------");
    }
}

class ClassObject {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.make = "Honda";
        car1.model = "Civic";
        car1.year = 2022;
        System.out.println("Car 1 Details:");
        car1.displayDetails();

        Car car2 = new Car();
        car2.make = "Toyota";
        car2.model = "Camry";
        car2.year = 2021;
        System.out.println("Car 2 Details:");
        car2.displayDetails();
    }
}
