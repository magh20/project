package crsinfo;
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
    public void insert(crsinfo.Entity entity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into crsinfo (crsid, stuid, absence, score) values (?,?,?,?)");
        preparedStatement.setInt(1, entity.getCrsid());
        preparedStatement.setInt(2, entity.getStuid());
        preparedStatement.setInt(3, entity.getAbsence());
        preparedStatement.setInt(4, entity.getScore());
        preparedStatement.executeUpdate();
    }
    public void delete(int crsid, int stuid) throws Exception {
        preparedStatement = connection.prepareStatement("delete from crsinfo where crsid=? and stuid=?");
        preparedStatement.setInt(1, crsid);
        preparedStatement.setInt(2, stuid);
        preparedStatement.executeUpdate();
    }
    public void update(int stuid,int score,int crsid)throws Exception{
        preparedStatement=connection.prepareStatement("update crsinfo set score=? where stuid=? and crsid=?");
        preparedStatement.setInt(1,score);
        preparedStatement.setInt(2,stuid);
        preparedStatement.setInt(3,crsid);
        preparedStatement.executeUpdate();
    }
    public List<crsinfo.Entity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from crsinfo");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<crsinfo.Entity> entityList = new ArrayList<>();
        while (resultSet.next()) {
            crsinfo.Entity entity = new Entity();
            entity.setCrsid(resultSet.getInt("crsid"));
            entity.setStuid(resultSet.getInt("stuid"));
            entity.setAbsence(resultSet.getInt("absence"));
            entity.setScore(resultSet.getInt("score"));
            entityList.add(entity);
        }
        return entityList;
    }
    public List<Integer> select(int stuid) throws Exception {
        preparedStatement = connection.prepareStatement("select * from crsinfo where stuid=?");
        preparedStatement.setInt(1, stuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> scoreList = new ArrayList<>();
        while (resultSet.next())
            scoreList.add(resultSet.getInt("score"));
        return scoreList;
    }
    public List<Integer> getStuIDs(int crsid) throws Exception {
        preparedStatement = connection.prepareStatement("select * from crsinfo where crsid=?");
        preparedStatement.setInt(1, crsid);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> stuIDs = new ArrayList<>();
        while (resultSet.next())
            stuIDs.add(resultSet.getInt("stuid"));
        return stuIDs;
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