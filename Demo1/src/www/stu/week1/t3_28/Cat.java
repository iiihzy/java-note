package www.stu.week1.t3_28;

public class Cat extends Animal{

    private String name;
    public void attainName() {
        this.name = "小猫";
        super.setName("小动物");
        System.out.println("子类 " + this.name + " " + "父类 " + super.getName());
    }

    @Override
    public void eat() {
        System.out.println(getName() + "在吃猫粮");
    }
    @Override
    public void sleep() {
        System.out.println(getName() + "在睡觉");
        super.sleep();
    }


}
