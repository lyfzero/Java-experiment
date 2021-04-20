public class Course implements Cloneable {
    private String courseName;    // 课程名称
    private List<Person> students;// 选修课程的学生列表，保存在ArrayList里
    private Person teacher;       // 课程的授课老师

    public Course(String courseName, Person teacher) {  // 构造函数
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = new List<Person>();
    }
    public void register(Person s) {  // 选修课程
        // 应该把选修的学生加入到学生列表里。
        // 注意同一个学生只能选修一次，内部的ArrayList里不能出现重复的学生
        if s not in students {
            students.add(s);
        }
    }
    public String getCourseName() { // 获取课程名称
        return this.courseName;
    }
    public List<Person> getStudents() { // 获取课程的学生名单 
        // 这个方法纯粹是为了测试课程对象的深拷贝 实际场景下不应该返回学生名单，破坏了封装性
        return this.students;
    }
    public Person getTeacher() { // 获取课程授课老师
        return this.teacher;
    }
    public void unregister(Person s) { // 取消选修 应该把取消选修的学生从学生名单里删除
        
    }
    public int getNumberOfStudent() { // 获取选修课程的学生总数
        return this.students.length;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {  // Course的深拷贝克隆

    }
    @Override
    public String toString() { // 覆盖toString
        // 描述Course对象信息的字符串(应该包括课程名称、教师的详细信息，每个学生的详细信息，学生总数)

    }
    @Override
    public boolean equals(OBject obj) { // 比较二个Course对象的内容是否相等
        // 注意学生名单内容也要相等（元素个数相等，每个List里的每个对象在另外一个List里都有唯一的内容相等的元素，但次序可以不同）
    }
}
