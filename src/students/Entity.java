package students;

public class Entity {
    private int id, termNum, year;
    private String username, pass, name, tuition, payment, field;

    public int getYear() {
        return year;
    }

    public Entity setYear(int year) {
        this.year = year;
        return this;
    }

    public String getField() {
        return field;
    }

    public Entity setField(String field) {
        this.field = field;
        return this;
    }

    public int getId() {
        return id;
    }

    public Entity setId(int id) {
        this.id = id;
        return this;
    }

    public int getTermNum() {
        return termNum;
    }

    public Entity setTermNum(int termNum) {
        this.termNum = termNum;
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

    public String getTuition() {
        return tuition;
    }

    public Entity setTuition(String tuition) {
        this.tuition = tuition;
        return this;
    }

    public String getPayment() {
        return payment;
    }

    public Entity setPayment(String payment) {
        this.payment = payment;
        return this;
    }
}