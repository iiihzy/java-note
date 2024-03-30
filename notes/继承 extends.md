### 继承 extends

#### 成员变量: 

- **无论父类成员变量是私有还是非私有的,子类继承父类的全部特征.**

  -  

    ```java
    // 父类 Animal
    public class Animal {
        public int age;
        private String name;
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    }
    
    // 子类 Dog
    public class Dog extends Animal{
        public void set(){
            this.age = 1;
            setName("小狗");
            System.out.println(getName() + '\t' + age);
        }
    }
    // main方法
    public class Test {
        public static void main(String[] args) {
            Dog a1 = new Dog();
            a1.set();
        }
    }
    ```

  - ![image-20240330104205644](https://cdn.jsdelivr.net/gh/iiihzy/liaoliao/liaoliao/202403301042091.png)

- **子类定义的成员变量永远不会覆盖子类所继承父类的特征**

  ```java
  public class Animal {
      private String name;
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  }
  public class Dog extends Animal{
  
      public String name;
      public void set(){
          this.name = "小狗";
          // this.name 相当于 name
          super.setName("小动物");
          System.out.println("Fu: " + super.getName());
          System.out.println("Zi: " + this.name);
      }
  }
  import java.util.Scanner;
  
  public class Test {
      public static void main(String[] args) {
          Dog a1 = new Dog();
          a1.set();
      }
  }
  
  ```
  ![image-20240330102905477](https://cdn.jsdelivr.net/gh/iiihzy/liaoliao/liaoliao/202403301029923.png)

- **子类不包含成员变量时, this, super指向同一个变量**

  ```java
  public class Animal {
      private String name;
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  }
  
  public class Dog extends Animal{
      public void setNames() {
          // this.setName("小狗");
          setName("小狗");
          super.setName("小动物");
          System.out.println("Fu: " + super.getName());
          System.out.println("Zi: " + this.getName());
  
      }
  }
  
  import java.util.Scanner;
  
  public class Test {
      public static void main(String[] args) {
          Dog a1 = new Dog();
          a1.setNames();
      }
  }
  
  ```

  - ![image-20240330101723676](https://cdn.jsdelivr.net/gh/iiihzy/liaoliao/liaoliao/202403301017676.png)

  

#### **构造方法:**

- **<u>所有构造方法,子类都无法继承,但可以借用父类的构造方法,给对象赋初值</u>** 

  -  

    ```java
    // 父类 Animal
    public class Animal {
        private int age;
        private String name;
        public Animal() {
        }
        public Animal(int age, String name) {
            this.age = age;
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
    // 子类 Dog
    public class Dog extends Animal{
        public Dog(){}
        public Dog(int age, String name){
            super(age, name);
        }
    }
    // main 方法
    import java.util.Scanner;
    public class Test {
        public static void main(String[] args) {
            Dog a1 = new Dog(1, "小狗");
            System.out.println(a1);
        }
    }
    ```

  - ![image-20240330110302842](https://cdn.jsdelivr.net/gh/iiihzy/liaoliao/liaoliao/202403301103296.png)

- **<u>子类中所有的构造方法默认先访问父类中的无参构造, 再执行自己</u>** 

  -  

    ```java
     // 父类 Animal
    public class Animal {
        private int age;
        private String name;
    
        public Animal() {
            System.out.println("父类无参构造执行");
        }
    
        public Animal(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    // 子类 Dog
    public class Dog extends Animal{
        public Dog(){
            System.out.println("子类无参构造执行");
        }
        public Dog(int age, String name){
        }
    }
    // main 方法
    public class Test {
        public static void main(String[] args) {
            Dog a1 = new Dog();
            Dog a2 = new Dog(1, "小狗");
        }
    }
    
    // 父类无参构造执行
    // 子类无参构造执行
    // 父类无参构造执行
    ```

  - ![image-20240330113843966](https://cdn.jsdelivr.net/gh/iiihzy/liaoliao/liaoliao/202403301138459.png)

  - ![img](https://cdn.jsdelivr.net/gh/iiihzy/liaoliao/liaoliao/202403301144946.png)

#### 成员方法:

- **非私有的成员方法可以被继承, 私有的成员方法无法被继承** 
- ![image-20240330115959509](https://cdn.jsdelivr.net/gh/iiihzy/liaoliao/liaoliao/202403301159997.png)

##### 重写: 

1. **重写方法的名称、形参列表必须与父类中的一致.**
2. 子类重写父类方法时，**==访问权限子类必须大于等于父类==**
   - **(default < protected < public )**
3. 子类重写父类方法时，**<u>返回值类型子类必须小于等于父类</u>**
   - ![image-20240330122358757](https://cdn.jsdelivr.net/gh/iiihzy/liaoliao/liaoliao/202403301223195.png)
4. 建议:重写的方法尽量和父类保持一致。
5. 私有方法不能被重写。
6. 子类不能重写父类的静态方法，如果重写会报错的。

其中5. 6点可总结为 <u>**==只有被添加到虚方法表中的方法才能被重写==**</u> 