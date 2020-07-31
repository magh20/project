package courses;

public class Entity {
    private int termid, crsid, tchid, place, survey;
    private String name, time, salary, requirements;

    public String getRequirements() {
        return requirements;
    }

    public Entity setRequirements(String requirements) {
        this.requirements = requirements;
        return this;
    }

    public int getTermid() {
        return termid;
    }

    public Entity setTermid(int termid) {
        this.termid = termid;
        return this;
    }

    public int getCrsid() {
        return crsid;
    }

    public Entity setCrsid(int crsid) {
        this.crsid = crsid;
        return this;
    }

    public int getTchid() {
        return tchid;
    }

    public Entity setTchid(int tchid) {
        this.tchid = tchid;
        return this;
    }

    public int getPlace() {
        return place;
    }

    public Entity setPlace(int place) {
        this.place = place;
        return this;
    }

    public int getSurvey() {
        return survey;
    }

    public Entity setSurvey(int survey) {
        this.survey = survey;
        return this;
    }

    public String getName() {
        return name;
    }

    public Entity setName(String name) {
        this.name = name;
        return this;
    }

    public String getTime() {
        return time;
    }

    public Entity setTime(String time) {
        this.time = time;
        return this;
    }

    public String getSalary() {
        return salary;
    }

    public Entity setSalary(String salary) {
        this.salary = salary;
        return this;
    }
}
