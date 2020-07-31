package teachers;

public class Entity {
    private int id;
    private String username, pass, name,salary,lessonName,lessonTime;

    public Entity() {
    }

    public int getId() {
        return id;
    }

    public Entity setId(int id) {
        this.id = id;
        return this;
    }

    public String getusername() {
        return username;
    }

    public Entity setusername(String username) {
        this.username = username;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public Entity setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getName() {
        return name;
    }

    public Entity setName(String name) {
        this.name = name;
        return this;
    }

    public String getSalary() {
        return salary;
    }

    public Entity setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public String getLessonTime() {
        return lessonTime;
    }

    public Entity setLessonTime(String lessonTime) {
        this.lessonTime = lessonTime;
        return this;
    }

    public String getLessonName() {
        return lessonName;
    }

    public Entity setLessonName(String lessonName) {
        this.lessonName = lessonName;
        return this;
    }
}
