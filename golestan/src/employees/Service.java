package employees;
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
    public void edit(Entity entity,String Username,String Pass)throws Exception{
        try (Repository repository=new Repository()){
            repository.update(entity,Username,Pass);
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
    public String showSalary(Entity entity)throws Exception{
        String salary;
        try (Repository repository=new Repository()){
            salary=repository.showSalary(entity);
        }return salary;
    }
    public void saveImputation(Entity entity)throws Exception{
        try (Repository repository=new Repository()){
            repository.updateImputation(entity);
            repository.commit();
        }
    }
}