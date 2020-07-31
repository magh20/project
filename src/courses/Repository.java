package courses;
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
    public void insert(courses.Entity entity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into courses (termid, crsid, tchid, name, requirements, time, place, salary, survey) values (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, entity.getTermid());
        preparedStatement.setInt(2, entity.getCrsid());
        preparedStatement.setInt(3, entity.getTchid());
        preparedStatement.setString(4, entity.getName());
        preparedStatement.setString(5, entity.getRequirements());
        preparedStatement.setString(6, entity.getTime());
        preparedStatement.setInt(7, entity.getPlace());
        preparedStatement.setString(8, entity.getSalary());
        preparedStatement.setInt(9, entity.getSurvey());
        preparedStatement.executeUpdate();
    }
    public List<courses.Entity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from courses");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<courses.Entity> entityList = new ArrayList<>();
        while (resultSet.next()) {
            courses.Entity entity = new Entity();
            entity.setTermid(resultSet.getInt("termid"));
            entity.setCrsid(resultSet.getInt("crsid"));
            entity.setTchid(resultSet.getInt("tchid"));
            entity.setName(resultSet.getString("name"));
            entity.setRequirements(resultSet.getString("requirements"));
            entity.setTime(resultSet.getString("time"));
            entity.setPlace(resultSet.getInt("place"));
            entity.setSalary(resultSet.getString("salary"));
            entity.setSurvey(resultSet.getInt("survey"));
            entityList.add(entity);
        }
        return entityList;
    }
    public courses.Entity select(int courseid) throws Exception {
        preparedStatement = connection.prepareStatement("select * from courses where crsid=? and termid=98");
        preparedStatement.setInt(1, courseid);
        ResultSet resultSet = preparedStatement.executeQuery();
        courses.Entity entity = new Entity();
        while (resultSet.next()) {
            entity = new Entity();
            entity.setTchid(resultSet.getInt("tchid"));
            entity.setName(resultSet.getString("name"));
            entity.setRequirements(resultSet.getString("requirements"));
            entity.setTime(resultSet.getString("time"));
            entity.setPlace(resultSet.getInt("place"));
        }
        return entity;
    }
    public List<courses.Entity> select(int tchid, int termid) throws Exception {
        preparedStatement = connection.prepareStatement("select * from courses where tchid=? and termid=98");
        preparedStatement.setInt(1, tchid);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<courses.Entity> entityList = new ArrayList<>();
        while (resultSet.next()) {
            courses.Entity entity = new Entity();
            entity.setCrsid(resultSet.getInt("crsid"));
            entity.setName(resultSet.getString("name"));
            entity.setTime(resultSet.getString("time"));
            entity.setPlace(resultSet.getInt("place"));
            entity.setSalary(resultSet.getString("salary"));
            entity.setSurvey(resultSet.getInt("survey"));
            entityList.add(entity);
        }
        return entityList;
    }
    public List<Integer> getCourseIDs(int tchid) throws Exception {
        preparedStatement = connection.prepareStatement("select * from courses where tchid=? and termid=98");
        preparedStatement.setInt(1, tchid);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> courseIDs = new ArrayList<>();
        while (resultSet.next()) {
            courseIDs.add(resultSet.getInt("crsid"));
        }
        return courseIDs;
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