package www.stu.week1.t3_28;

public class Test1 {
    public static void main(String[] args) {
        Animal a1 = new Cat();  // 父类型引用指向子类型对象
        a1.setAge(1);
        a1.setName("小猫");

        // 重写, 子类重写父类方法(非private修饰的方法)
        // 子类重写的方法在虚方法表中覆盖父类被重写的方法
        a1.sleep();

        /*子类中的构造方法默认先访问父类中的无参构造再访问己
          子类继承父类的全部成员变量
                                                      */
        Cat cat1 = new Cat();
        cat1.attainName();

    }
}
