public class Cat {
    double weight;
    String name;
    int age;
    String color;

    public Cat(double weight, String name, int age, String color) {
        this.weight = weight;
        this.name = name;
        this.age = age;
        this.color = color;
    }

    void meow() {
        System.out.println("Meow");
    }
    void pee() {
        weight -= 20;
    }
    void eat() {
        weight += 50;
    }
}
