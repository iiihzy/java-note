package www.stu.week1.t3_28;

public class Animal {
    private int age;
    private String name;

    public void eat(){
        System.out.println("动物在吃饭");
    }

    public void sleep(){
        System.out.println("动物在睡觉");
    }
    public Animal() {
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
