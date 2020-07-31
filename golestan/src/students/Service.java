package students;
import java.util.List;

public class Service {
    private Service() {}
    private static Service service = new Service();
    public static Service getInstance() {
        return service;
    }
    public void save(Entity entity) throws Exception {
        try (Repository repository = new Repository()) {
            repository.insert(entity);
            repository.commit();
        }
    }
    public void edit(String tuition, int id) throws Exception {
        try (Repository repository = new Repository()) {
            repository.update(tuition, id);
            repository.commit();
        }
    }
    public void edit(String tuition, String payment, int id) throws Exception {
        try (Repository repository = new Repository()) {
            repository.update(tuition, payment, id);
            repository.commit();
        }
    }
    public List<Entity> report() throws Exception {
        List<Entity> entities;
        try (Repository repository = new Repository()) {
            entities = repository.select();
        }
        return entities;
    }
    public Entity report(int id) throws Exception {
        Entity entity;
        try (Repository repository = new Repository()) {
            entity = repository.select(id);
        }
        return entity;
    }
}