package crsinfo;

public class Entity {
    private int crsid, stuid, absence, score;

    public int getCrsid() {
        return crsid;
    }

    public Entity setCrsid(int crsid) {
        this.crsid = crsid;
        return this;
    }

    public int getStuid() {
        return stuid;
    }

    public Entity setStuid(int stuid) {
        this.stuid = stuid;
        return this;
    }

    public int getAbsence() {
        return absence;
    }

    public Entity setAbsence(int absence) {
        this.absence = absence;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Entity setScore(int score) {
        this.score = score;
        return this;
    }
}
