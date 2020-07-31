package notices;

public class Entity {
    private int id;
    private String notice;

    public int getId() {
        return id;
    }

    public Entity setId(int id) {
        this.id = id;
        return this;
    }

    public String getNotice() {
        return notice;
    }

    public Entity setNotice(String notice) {
        this.notice = notice;
        return this;
    }
}
