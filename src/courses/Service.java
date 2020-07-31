package courses;
import java.util.List;

public class Service {
    private Service() {}
    private static courses.Service service = new courses.Service();
    public static courses.Service getInstance() {
        return service;
    }
    public void save(courses.Entity entity) throws Exception {
        try (courses.Repository repository = new courses.Repository()) {
            repository.insert(entity);
            repository.commit();
        }
    }
    public List<courses.Entity> report() throws Exception {
        List<Entity> entities;
        try (courses.Repository repository = new Repository()) {
            entities = repository.select();
        }
        return entities;
    }
    public courses.Entity report(int courseid) throws Exception {
        courses.Entity entity;
        try (courses.Repository repository = new Repository()) {
            entity = repository.select(courseid);
        }
        return entity;
    }
    public List<courses.Entity> report(int tchid, int termid) throws Exception {
        List<Entity> entities;
        try (courses.Repository repository = new Repository()) {
            entities = repository.select(tchid, termid);
        }
        return entities;
    }
    public List<Integer> getCourseIDs(int tchid) throws Exception {
        List<Integer> entities;
        try (courses.Repository repository = new Repository()) {
            entities = repository.getCourseIDs(tchid);
        }
        return entities;
    }
}