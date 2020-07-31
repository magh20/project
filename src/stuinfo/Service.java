package stuinfo;
import java.util.List;

public class Service {
    private Service() {}
    private static stuinfo.Service service = new stuinfo.Service();
    public static stuinfo.Service getInstance() {
        return service;
    }
    public void save(stuinfo.Entity entity) throws Exception {
        try (stuinfo.Repository repository = new stuinfo.Repository()) {
            repository.insert(entity);
            repository.commit();
        }
    }
    public void remove(int stuid, int courseid) throws Exception {
        try (stuinfo.Repository repository = new stuinfo.Repository()) {
            repository.delete(stuid, courseid);
            repository.commit();
        }
    }
    public void edit(int stuid,int courseid,String fail)throws Exception{
        try (Repository repository=new Repository()){
            repository.update(stuid,courseid,fail);
            repository.commit();
        }
    }
    public List<stuinfo.Entity> report() throws Exception {
        List<Entity> entities;
        try (stuinfo.Repository repository = new Repository()) {
            entities = repository.select();
        }
        return entities;
    }
    public List<Integer> report(int stuid, int termid) throws Exception {
        List<Integer> entities;
        try (stuinfo.Repository repository = new Repository()) {
            entities = repository.select(stuid, termid);
        }
        return entities;
    }
    public List<stuinfo.Entity> report(int stuid) throws Exception {
        List<stuinfo.Entity> entities;
        try (stuinfo.Repository repository = new Repository()) {
            entities = repository.select(stuid);
        }
        return entities;
    }
}