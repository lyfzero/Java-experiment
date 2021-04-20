public class Person implements Cloneable {
    private String name;  // 姓名
    private int age;      // 年龄
    public Person() { // 缺省构造函数
        name = "";
        age = 0;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() { // 获取姓名
        return this.name;
    }
    public void setName(String name) { // 设置姓名
        this.name = name;
    }
    public int getAge() { // 获取年龄
        return this.age;
    }
    public void setAge(int age) { // 设置姓名
        this.age = age;
    }
    @Override
    public String toString() {  // 覆盖 toString
        return "name: " + this.name + ", age: " + this.age;
    }
    @Override
    public boolean equals(Object obj) { // 比较二个Person对象的内容是否相等
        // 数据成员比较
        if(obj instanceof Person) {
            Person o = (Person)obj;
            return this.age == o.age && this.name == o.name;
        }
        return false;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{ // Person 的深拷贝克隆
        Person p = new Person();
        p.age = this.age;
        // clone name

        return p;
    }
}
