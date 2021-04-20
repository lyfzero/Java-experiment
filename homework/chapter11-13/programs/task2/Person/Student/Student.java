import org.graalvm.compiler.lir.amd64.AMD64Binary.ThreeOp;

public class Student extends Person implements Cloneable {
    private int studentId;      // 学生 Id
    private String department;  // 所在院系
    private String classNo;     // 所在班级
    public Student() { // 缺省构造函数

    }
    public Student(String name, 
                    int age, 
                    int studentId, 
                    String department, 
                    String classNo) { // 构造函数
        super(name, age);
        this.studentId = studentId;
        this.department = department;
        this.classNo = classNo;
    }
    public int getStudentId() { // 获取学生 Id
        return this.studentId;
    }
    public void setStudentId(int studentId) { // 设置学生 Id
        this.studentId = studentId;
    }
    public String getDepartment() { // 获取所在院系
        return this.department;
    }
    public void setDepartment(String department) { // 设置所在院系
        this.department = department;
    }
    public String getClassNo() { // 获取所在班级
        return this.classNo;
    }
    public void setClassNo(String classNo) { // 设置所在班级
        this.classNo = classNo;
    }
    @Override
    public String toString() { // 覆盖 toString
        return super.toString() + ", studentId: " + this.studentId + ", department: " + this.department + ", classNo: " + this.classNo;
    }
    @Override
    public boolean equals(Object obj) { // 比较两个 Student 对象的内容是否相等
        if(obj instanceof Student) {
            if(!super.equals(obj)) {
                return false;
            }
            Student o = (Student)obj;
            return this.studentId == o.studentId && this.department == o.department && this.classNo == o.classNo;
        }
        return false;
    }
    @Override
    public Object clone() throws CloneNotSupportedException { // Student 的深拷贝克隆
        Student s = super.clone();
        s.classNo = this.classNo;
        s.department = this.department;
        s.studentId = this.studentId;
        return s;
        
        // throw
    }
}
