package students;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Repository implements
        AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public static List<String> usernames = new ArrayList<>();
    public static List<String> passes = new ArrayList<>();
    public Repository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "magh", "magh1379");
        connection.setAutoCommit(false);
    }
    public void insert(students.Entity entity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into students (id, username, pass, name, tuition, payment, termNum, year, field) values (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setString(2, entity.getusername());
        preparedStatement.setString(3, entity.getPass());
        preparedStatement.setString(4, entity.getName());
        preparedStatement.setString(5, entity.getTuition());
        preparedStatement.setString(6, entity.getPayment());
        preparedStatement.setInt(7, entity.getTermNum());
        preparedStatement.setInt(8, entity.getYear());
        preparedStatement.setString(9, entity.getField());
        preparedStatement.executeUpdate();
    }
    public void update(String tuition, int id) throws Exception {
        preparedStatement = connection.prepareStatement("update students set tuition=? where id=?");
        preparedStatement.setString(1, tuition);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }
    public void update(String tuition, String payment, int id) throws Exception {
        preparedStatement = connection.prepareStatement("update students set tuition=?, payment=? where id=?");
        preparedStatement.setString(1, tuition);
        preparedStatement.setString(2, payment);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
    }
    public List<students.Entity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from students");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<students.Entity> entityList = new ArrayList<>();
        while (resultSet.next()) {
            students.Entity entity = new Entity();
            entity.setId(resultSet.getInt("id"));
            entity.setusername(resultSet.getString("username"));
            entity.setPass(resultSet.getString("pass"));
            entity.setName(resultSet.getString("name"));
            entity.setTuition(resultSet.getString("tuition"));
            entity.setPayment(resultSet.getString("payment"));
            entity.setTermNum(resultSet.getInt("termNum"));
            entity.setYear(resultSet.getInt("year"));
            entity.setField(resultSet.getString("field"));
            entityList.add(entity);
            usernames.add(resultSet.getString("username"));
            passes.add(resultSet.getString("pass"));
        }
        return entityList;
    }
    public students.Entity select(int id) throws Exception {
        preparedStatement = connection.prepareStatement("select * from students where id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        students.Entity entity = new Entity();
        while (resultSet.next()) {
            entity.setYear(resultSet.getInt("year"));
            entity.setField(resultSet.getString("field"));
        }
        return entity;
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