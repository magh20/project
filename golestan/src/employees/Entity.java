package employees;

public class Entity {
    private int id, age;
    private String username, pass, name, job, salary, education,imputation;


    public int getId() {
        return id;
    }

    public Entity setId(int id) {
        this.id = id;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Entity setAge(int age) {
        this.age = age;
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

    public String getJob() {
        return job;
    }

    public Entity setJob(String job) {
        this.job = job;
        return this;
    }

    public String getSalary() {
        return salary;
    }

    public Entity setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public Entity setEducation(String education) {
        this.education = education;
        return this;
    }

    public String getImputation() {
        return imputation;
    }

    public Entity setImputation(String imputation) {
        this.imputation = imputation;
        return this;
    }
}
