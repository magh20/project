package teachers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Repository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public static List<String> usernames = new ArrayList<>();
    public static List<String> passes = new ArrayList<>();
    public Repository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "magh", "magh1379");
        connection.setAutoCommit(false);
    }
    public void insert(teachers.Entity entity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into teachers (id, username, pass, name, salary) values (?,?,?,?,?)");
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setString(2, entity.getusername());
        preparedStatement.setString(3, entity.getPass());
        preparedStatement.setString(4, entity.getName());
        preparedStatement.setString(5, entity.getSalary());
        preparedStatement.executeUpdate();
    }
    public List<teachers.Entity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from teachers");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<teachers.Entity> entityList = new ArrayList<>();
        while (resultSet.next()) {
            teachers.Entity entity = new Entity();
            entity.setId(resultSet.getInt("id"));
            entity.setusername(resultSet.getString("username"));
            entity.setPass(resultSet.getString("pass"));
            entity.setName(resultSet.getString("name"));
            entity.setSalary(resultSet.getString("salary"));
            entityList.add(entity);
            usernames.add(resultSet.getString("username"));
            passes.add(resultSet.getString("pass"));
        }
        return entityList;
    }
    public String showSalary(Entity entity)throws Exception{
        preparedStatement=connection.prepareStatement("select * from teachers where username =? and pass =?");
        preparedStatement.setString(1,entity.getusername());
        preparedStatement.setString(2,entity.getPass());
        ResultSet resultSet=preparedStatement.executeQuery();
        String salary = null;
        if(resultSet.next()){
            salary=resultSet.getString("salary");
        }
        return salary;
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