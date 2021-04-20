package homework.ch11_13.p3;

public class CourseTest {
    public CourseTest() {

    }
    public static void main(String[] args) throws CloneNotSupportedException {
        // 程序入口函数 
        // 在这里实例化教师对象、课程对象。
        // 同时实例化多个学生对象向课程注册。 
        // 需要创建一个Course数组，包含至少二门课程，每门课程至少注册三名学生。
        // 最后打印出每门课程的详细信息。 
        // 同时测试Person、Student、Faculty、Course的深拷贝功能，
        // 深拷贝测试包括： 
        //  克隆出来的对象和源对象内容相等； 
        //  克隆出来的对象和源对象所有引用类型数据成员指向的是不同对象。
        Person teacher = new Faculty("James Gosling", 65, 0000, "Professor", "http://nighthacks.com/jag/bio/index.html");
        Course javaCourse = new Course("Java Language Programming", teacher);
        Person student1 = new Student("aaa", 20, 20170101, "cs", "cs1704");
        Person student2 = new Student("bbb", 20, 20170102, "cs", "cs1705");
        Person student3 = new Student("ccc", 20, 20170103, "cs", "cs1706");
        javaCourse.register(student1);
        javaCourse.register(student2);
        javaCourse.register(student3);
        System.out.println(javaCourse);
        javaCourse.unregister(student3);
        System.out.println(javaCourse);
        // 测试是否为深拷贝
        Course javaCourse2 = (Course)javaCourse.clone();
        System.out.println(javaCourse.equals(javaCourse2)); // 测试对象内容是否相等
        System.out.println(javaCourse.getCourseName() != javaCourse2.getCourseName()); // 测试所有引用类型数据成员是否指向相同对象
        System.out.println(javaCourse.getTeacher() != javaCourse2.getTeacher());
        System.out.println(javaCourse.getStudents() != javaCourse2.getStudents());
        System.out.println(javaCourse2);
    }
}
