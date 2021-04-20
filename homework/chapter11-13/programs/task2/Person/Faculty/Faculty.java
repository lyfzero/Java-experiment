public class Faculty extends Person implements Cloneable {
    private int facultyId; // 教工 Id
    private String title;  // 职称
    private String email;  // 邮箱
    public Faculty() { // 缺省构造函数

    }
    public Faculty(String name, 
                    int age, 
                    int facultyId, 
                    String title, 
                    String email) { //
        super(name, age);
        this.facultyId = facultyId;
        this.title = title;
        this.email = email;
    }
    public int getFacultyId() { // 获取教工Id
        return getFacultyId();
    }
    public void setFacultyId(int facultyId) { // 设置教工Id
        this.facultyId = facultyId;
    }
    public String getTitle() { // 获取职称
        return this.title;
    }
    public void setTitle(String title) { // 设置教工Id
        this.title = title;
    }
    public String getEmail() { // 获取邮箱
        return this.email;
    }
    public void setEmail(String email) { // 设置邮箱
        this.email = email;
    }
    @Override
    public String toString() { // 覆盖toString
        return super.toString() + ", facultyId: " + this.facultyId + ", title: " + this.title + ", email: " + this.email;
    }
    @Override
    public boolean equals(Object obj) { // 比较二个Faculty对象的内容是否相等
        if(obj instanceof Faculty) {
            if(!super.equals(obj)) {
                return false;
            }
            Faculty o = (Faculty)obj;
            return this.facultyId == o.facultyId && this.title == o.title && this.email == o.email;
        }
        return false;
    }
    @Override
    public Object clone() throws CloneNotSupportedException { // Faculty的深拷贝克隆
        Faculty f = super.clone();
        f.facultyId = this.facultyId;
        f.title = this.title;
        f.email = this.email;
        return f;
    }
}
