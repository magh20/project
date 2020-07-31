package employees;
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
    public void insert(employees.Entity entity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into employees (id, username, pass, name, age, job, salary, education,imputation) values (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setString(2, entity.getusername());
        preparedStatement.setString(3, entity.getPass());
        preparedStatement.setString(4, entity.getName());
        preparedStatement.setInt(5, entity.getAge());
        preparedStatement.setString(6, entity.getJob());
        preparedStatement.setString(7, entity.getSalary());
        preparedStatement.setString(8, entity.getEducation());
        preparedStatement.setString(9,entity.getImputation());
        preparedStatement.executeUpdate();
    }
    public void updateImputation(Entity entity)throws Exception{
        preparedStatement=connection.prepareStatement("update employees set imputation=?  where username=? and pass=?");
        preparedStatement.setString(1,entity.getImputation());
        preparedStatement.setString(2,entity.getusername());
        preparedStatement.setString(3,entity.getPass());
        preparedStatement.executeUpdate();
    }
    public void update(Entity entity,String Username,String Pass) throws Exception{
        preparedStatement=connection.prepareStatement("update employees set username=?,pass=?,education=? where username=? and pass=?");
        preparedStatement.setString(1,entity.getusername());
        preparedStatement.setString(2,entity.getPass());
        preparedStatement.setString(3,entity.getEducation());
        preparedStatement.setString(4,Username);
        preparedStatement.setString(5,Pass);
        preparedStatement.executeUpdate();
    }
    public List<employees.Entity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from employees");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<employees.Entity> entityList = new ArrayList<>();
        while (resultSet.next()) {
            employees.Entity entity = new Entity();
            entity.setId(resultSet.getInt("id"));
            entity.setusername(resultSet.getString("username"));
            entity.setPass(resultSet.getString("pass"));
            entity.setName(resultSet.getString("name"));
            entity.setAge(resultSet.getInt("age"));
            entity.setJob(resultSet.getString("job"));
            entity.setSalary(resultSet.getString("salary"));
            entity.setEducation(resultSet.getString("education"));
            entityList.add(entity);
            usernames.add(resultSet.getString("username"));
            passes.add(resultSet.getString("pass"));
        }
        return entityList;
    }
    public String showSalary(Entity entity)throws Exception{
        preparedStatement=connection.prepareStatement("select * from employees where username =? and pass =?");
        preparedStatement.setString(1,entity.getusername());
        preparedStatement.setString(2,entity.getPass());
        ResultSet resultSet=preparedStatement.executeQuery();
        String salary = null;
        if(resultSet.next()){
            salary=resultSet.getString("salary");
        }else{
            System.out.println("username or pass is wrong!");
        }return salary;
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