class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Barks");
    }
}

class Inheritence {
    public static void main(String[] args) {
        Animal anm = new Animal();
        System.out.print("Animal Sound: ");
        anm.makeSound();

        Dog dog = new Dog();
        System.out.print("Dog Sound: ");
        dog.makeSound();
    }
}
