package stuinfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Repository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public Repository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "magh", "magh1379");
        connection.setAutoCommit(false);
    }
    public void insert(stuinfo.Entity entity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into stuinfo (stuid, termid, courseid, fail) values (?,?,?,?)");
        preparedStatement.setInt(1, entity.getStuid());
        preparedStatement.setInt(2, entity.getTermid());
        preparedStatement.setInt(3, entity.getCourseid());
        preparedStatement.setString(4, entity.getFail());
        preparedStatement.executeUpdate();
    }
    public void delete(int stuid, int courseid) throws Exception {
        preparedStatement = connection.prepareStatement("delete from stuinfo where stuid=? and termid=? and courseid=?");
        preparedStatement.setInt(1, stuid);
        preparedStatement.setInt(2, 98);
        preparedStatement.setInt(3, courseid);
        preparedStatement.executeUpdate();
    }
    public void update(int stuid,int courseid,String fail)throws Exception{
        preparedStatement=connection.prepareStatement("update stuinfo set fail=? where stuid=? and termid=? and courseid=?");
        preparedStatement.setString(1,fail);
        preparedStatement.setInt(2,stuid);
        preparedStatement.setInt(3,98);
        preparedStatement.setInt(4,courseid);
        preparedStatement.executeUpdate();
    }
    public List<stuinfo.Entity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from stuinfo");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<stuinfo.Entity> entityList = new ArrayList<>();
        while (resultSet.next()) {
            stuinfo.Entity entity = new Entity();
            entity.setStuid(resultSet.getInt("stuid"));
            entity.setTermid(resultSet.getInt("termid"));
            entity.setCourseid(resultSet.getInt("courseid"));
            entity.setFail(resultSet.getString("fail"));
            entityList.add(entity);
        }
        return entityList;
    }
    public List<Integer> select(int stuid, int termid) throws Exception {
        preparedStatement = connection.prepareStatement("select * from stuinfo where stuid=? and termid=?");
        preparedStatement.setInt(1, stuid);
        preparedStatement.setInt(2, termid);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> courseidList = new ArrayList<>();
        while (resultSet.next()) {
            int courseid = resultSet.getInt("courseid");
            courseidList.add(courseid);
        }
        return courseidList;
    }
    public List<stuinfo.Entity> select(int stuid) throws Exception {
        preparedStatement = connection.prepareStatement("select * from stuinfo where stuid=?");
        preparedStatement.setInt(1, stuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<stuinfo.Entity> entityList = new ArrayList<>();
        while (resultSet.next()) {
            stuinfo.Entity entity = new Entity();
            entity.setTermid(resultSet.getInt("termid"));
            entity.setCourseid(resultSet.getInt("courseid"));
            entity.setFail(resultSet.getString("fail"));
            entityList.add(entity);
        }
        return entityList;
    }
    public void commit() throws Exception {
        connection.commit ();
    }
    public void rollback() throws Exception {
        connection.rollback ();
    }
    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}