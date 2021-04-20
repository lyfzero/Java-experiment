class A{ 
    public void m() { 
      System.out.println("A's m"); 
    } 
    public static void s() { 
      System.out.println("A's s"); 
    } 
  } 
  
  class B extends A{ 
    //覆盖父类实例方法 
    public void m() { 
      System.out.println("B's m"); 
    } 
    // 隐藏父类静态方法 
    public static void s() { 
      System.out.println("B's s"); 
    } 
  }
  
  public class OverrideDemo { 
    public static void main(String[] args) { 
      A o = new B(); // 父类型变量引用子类对象 
      o.m(); // 由于父类实例方法m被子类覆盖，o运行时指向B类对象，由于多态性，执行的是B的m 
      o.s(); //由于s是静态方法，没有多态性，编译器编译时对象o的声明类型是A，所以执行的是A的s 
    } 
  }