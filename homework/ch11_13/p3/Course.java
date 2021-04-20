package homework.ch11_13.p3;
import java.util.ArrayList;

public class Course implements Cloneable {
    private String courseName;    // 课程名称
    private ArrayList<Person> students;// 选修课程的学生列表，保存在ArrayList里
    private Person teacher;       // 课程的授课老师

    public Course(String courseName, Person teacher) {  // 构造函数
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = new ArrayList<Person>();
    }
    public void register(Person s) {  // 选修课程
        // 应该把选修的学生加入到学生列表里。
        // 注意同一个学生只能选修一次，内部的ArrayList里不能出现重复的学生
        if(students.indexOf(s) == -1) {
            students.add(s);
        }
    }
    public String getCourseName() { // 获取课程名称
        return this.courseName;
    }
    public ArrayList<Person> getStudents() { // 获取课程的学生名单 
        // 这个方法纯粹是为了测试课程对象的深拷贝 实际场景下不应该返回学生名单，破坏了封装性
        return this.students;
    }
    public Person getTeacher() { // 获取课程授课老师
        return this.teacher;
    }
    public void unregister(Person s) { // 取消选修 应该把取消选修的学生从学生名单里删除
        int index = students.indexOf(s);
        if(index != -1) {
            students.remove(index);
        }
    }
    public int getNumberOfStudent() { // 获取选修课程的学生总数
        return this.students.size();
    }
    @Override
    public Object clone() throws CloneNotSupportedException {  // Course的深拷贝克隆
        Course c = (Course)super.clone();
        c.courseName = this.courseName;
        c.teacher = (Faculty)this.teacher.clone();
        c.students = (ArrayList<Person>)this.students.clone();
        return c;
    }
    @Override
    public String toString() { // 覆盖toString
        // 描述Course对象信息的字符串(应该包括课程名称、教师的详细信息，每个学生的详细信息，学生总数)
        String res =  "Course Name: " + this.courseName.toString() + "\nTeacher Info: " + this.teacher.toString() + "\nStudent List:";
        for(Person s : this.students) {
            res += "\n\t" + s.toString();
        }
        res += "\nTotally: " + this.students.size() + " students.";
        return res;
    }
    @Override
    public boolean equals(Object obj) { // 比较二个Course对象的内容是否相等
        // 注意学生名单内容也要相等（元素个数相等，每个List里的每个对象在另外一个List里都有唯一的内容相等的元素，但次序可以不同）
        // 数据成员比较
        if(obj instanceof Course) {
            Course o = (Course)obj;
            if(this.courseName.equals(o.courseName) && this.teacher.equals(o.teacher)) {
                if(this.students.size() == o.students.size() && this.students.containsAll(o.students)) {
                    return true;
                }
            }
        }
        return false;
    }
}
