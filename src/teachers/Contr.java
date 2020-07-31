package teachers;

public class Contr {
    public String username,pass,salary;
    public String showSalary(){
        try {
            salary= Service.getInstance().showSalary(new Entity().setusername(username).setPass(pass));
        } catch (Exception e){
            e.getMessage();
        }
        return salary;
    }
}