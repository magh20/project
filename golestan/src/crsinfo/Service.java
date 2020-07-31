package crsinfo;
import java.util.List;

public class Service {
    private Service() {}
    private static crsinfo.Service service = new crsinfo.Service();
    public static crsinfo.Service getInstance() {
        return service;
    }
    public void save(crsinfo.Entity entity) throws Exception {
        try (crsinfo.Repository repository = new crsinfo.Repository()) {
            repository.insert(entity);
            repository.commit();
        }
    }
    public void remove(int crsid, int stuid) throws Exception {
        try (crsinfo.Repository repository = new crsinfo.Repository()) {
            repository.delete(crsid, stuid);
            repository.commit();
        }
    }
    public void edit(int stuid,int score,int crsid)throws Exception{
        try (Repository repository=new Repository()){
            repository.update(stuid,score,crsid);
            repository.commit();
        }
    }
    public List<crsinfo.Entity> report() throws Exception {
        List<Entity> entities;
        try (crsinfo.Repository repository = new Repository()) {
            entities = repository.select();
        }
        return entities;
    }
    public List<Integer> report(int stuid) throws Exception {
        List<Integer> entities;
        try (crsinfo.Repository repository = new Repository()) {
            entities = repository.select(stuid);
        }
        return entities;
    }
    public List<Integer> getStuIDs(int crsid) throws Exception {
        List<Integer> entities;
        try (crsinfo.Repository repository = new Repository()) {
            entities = repository.getStuIDs(crsid);
        }
        return entities;
    }
}