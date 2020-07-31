package stuinfo;

public class Entity {
    private int stuid, termid, courseid;
    private String fail;

    public int getStuid() {
        return stuid;
    }

    public Entity setStuid(int stuid) {
        this.stuid = stuid;
        return this;
    }

    public int getTermid() {
        return termid;
    }

    public Entity setTermid(int termid) {
        this.termid = termid;
        return this;
    }

    public int getCourseid() {
        return courseid;
    }

    public Entity setCourseid(int courseid) {
        this.courseid = courseid;
        return this;
    }

    public String getFail() {
        return fail;
    }

    public Entity setFail(String fail) {
        this.fail = fail;
        return this;
    }
}