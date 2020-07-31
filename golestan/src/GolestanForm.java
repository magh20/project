import employees.Contr;
import notices.Service;
import students.Repository;
import stuinfo.Entity;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

public class GolestanForm {
    public int index, course, id, tuition, payment, tempInt;
    public String tempStr;
    public List<Integer> tempIntList = new ArrayList<>();
    public List<String> tempStrList = new ArrayList<>();
    public List<Entity> tempEntList = new ArrayList<>();
    public List<courses.Entity> tempEntList2 = new ArrayList<>();
    public GolestanForm() {
        initComponents();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void studentButtonMouseClicked(MouseEvent e) {
        mainFrame.setVisible(false);
        usernameField.setText("enter username");
        passField.setText("enter password");
        logFrame.setVisible(true);
    }
    private void enterButtonMouseClicked(MouseEvent e) {
        if (usernameField.getText().equals("") || usernameField.getText().equals("enter username")) {
            logErrorText.setText("Username can't be empty");
            logErrorDialog.setVisible(true);
        }
        else if (passField.getText().equals("") || passField.getText().equals("enter password")) {
            logErrorText.setText("Password can't be empty");
            logErrorDialog.setVisible(true);
        }
        else {
            if (Main.usernames.contains(usernameField.getText()) == false) {
                logErrorText.setText("User doesn't exist");
                logErrorDialog.setVisible(true);
            }
            else {
                index = Main.usernames.indexOf(usernameField.getText());
                String pass = Main.passes.get(index);
                if (passField.getText().equals(pass)) {
                    logFrame.setVisible(false);
                    if (usernameField.getText().contains("e"))
                        employeeFrame.setVisible(true);
                    else if (usernameField.getText().contains("s"))
                        studentFrame.setVisible(true);
                    else
                        teacherFrame.setVisible(true);
                }
                else {
                    logErrorText.setText("Wrong password");
                    logErrorDialog.setVisible(true);
                }
            }
        }
    }
    private void usernameFieldMouseClicked(MouseEvent e) {
        if (usernameField.getText().equals("") || usernameField.getText().equals("enter username"))
            usernameField.setText("");
    }
    private void passFieldMouseClicked(MouseEvent e) {
        if (passField.getText().equals("") || passField.getText().equals("enter password"))
            passField.setText("");
    }
    private void noticeButtonMouseClicked(MouseEvent e) {
        mainFrame.setVisible(false);
        try {
            noticeLbl.setText("<html>" + Service.getInstance().report().get(0).getId()+"\t"+Service.getInstance().report().get(0).getNotice() + "<br/>" + "<br/>" +
                    Service.getInstance().report().get(1).getId()+"\t"+Service.getInstance().report().get(1).getNotice() + "<br/>" +  "<br/>" +
                    Service.getInstance().report().get(2).getId()+"\t"+Service.getInstance().report().get(2).getNotice() + "</html>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        noticeFrame.setVisible(true);
    }
    private void backBtn1MouseClicked(MouseEvent e) {
        studentFrame.setVisible(false);
        mainFrame.setVisible(true);
    }
    private void backBtn2MouseClicked(MouseEvent e) {
        teacherFrame.setVisible(false);
        mainFrame.setVisible(true);
    }
    private void backBtn3MouseClicked(MouseEvent e) {
        employeeFrame.setVisible(false);
        mainFrame.setVisible(true);
    }
    private void backBtn4MouseClicked(MouseEvent e) {
        noticeFrame.setVisible(false);
        mainFrame.setVisible(true);
    }
    private void backBtn5MouseClicked(MouseEvent e) {
        mainFrame.setVisible(false);
        rmvFrm.setVisible(false);
        studentFrame.setVisible(true);
    }
    private void backBtn6MouseClicked(MouseEvent e) {
        mainFrame.setVisible(false);
        addFrm.setVisible(false);
        studentFrame.setVisible(true);
    }
    private void button5MouseClicked(MouseEvent e) {}
    private void removeBtnMouseClicked(MouseEvent e) {}
    private void selectButtonMouseClicked(MouseEvent e) {
        studentFrame.setVisible(false);
        try {
            addLbl.setText("<html>" + courses.Service.getInstance().report().get(8).getCrsid()+" \\ "+courses.Service.getInstance().report().get(8).getTchid()+" \\ "+courses.Service.getInstance().report().get(8).getName()+" \\ "+courses.Service.getInstance().report().get(8).getRequirements()+" \\ "+courses.Service.getInstance().report().get(8).getTime()+" \\ "+courses.Service.getInstance().report().get(8).getPlace() + "<br/>" +
                    courses.Service.getInstance().report().get(9).getCrsid()+" \\ "+courses.Service.getInstance().report().get(9).getTchid()+" \\ "+courses.Service.getInstance().report().get(9).getName()+" \\ "+courses.Service.getInstance().report().get(9).getRequirements()+" \\ "+courses.Service.getInstance().report().get(9).getTime()+" \\ "+courses.Service.getInstance().report().get(9).getPlace() + "<br/>" +
                    courses.Service.getInstance().report().get(10).getCrsid()+" \\ "+courses.Service.getInstance().report().get(10).getTchid()+" \\ "+courses.Service.getInstance().report().get(10).getName()+" \\ "+courses.Service.getInstance().report().get(10).getRequirements()+" \\ "+courses.Service.getInstance().report().get(10).getTime()+" \\ "+courses.Service.getInstance().report().get(10).getPlace() + "<br/>" +
                    courses.Service.getInstance().report().get(11).getCrsid()+" \\ "+courses.Service.getInstance().report().get(11).getTchid()+" \\ "+courses.Service.getInstance().report().get(11).getName()+" \\ "+courses.Service.getInstance().report().get(11).getRequirements()+" \\ "+courses.Service.getInstance().report().get(11).getTime()+" \\ "+courses.Service.getInstance().report().get(11).getPlace() + "</html>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        addFld.setText("");
        addFrm.setVisible(true);
    }
    private void addBtnMouseClicked(MouseEvent e) {
        if (Integer.parseInt(addFld.getText())>4) {
            logErrorText.setText("Wrong Course ID!");
            logErrorDialog.setVisible(true);
        }
        else {
            course = Integer.parseInt(addFld.getText());
            tempStr = Main.usernames.get(index);
            id = Repository.usernames.indexOf(tempStr) + 1;
            try {
                stuinfo.Service.getInstance().save(new Entity().setStuid(id).setTermid(98).setCourseid(course));
                crsinfo.Service.getInstance().save(new crsinfo.Entity().setCrsid(course).setStuid(id));
                tuition = Integer.parseInt(students.Service.getInstance().report().get(id - 1).getTuition());
                switch (course) {
                    case 1:
                    case 2:
                        students.Service.getInstance().edit(String.valueOf(tuition + 500000), id);
                        break;
                    case 3:
                    case 4:
                        students.Service.getInstance().edit(String.valueOf(tuition + 400000), id);
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            dialogLabel.setText("Successful");
            dialog.setVisible(true);
        }
    }
    private void rmvButtonMouseClicked(MouseEvent e) {
        studentFrame.setVisible(false);
        getSelectedCourses();
        rmvFld.setText("");
        rmvFrm.setVisible(true);
    }
    private void rmvBtnMouseClicked(MouseEvent e) {
        course = Integer.parseInt(rmvFld.getText());
        if (tempIntList.contains(course)) {
            tempStr = Main.usernames.get(index);
            id = Repository.usernames.indexOf(tempStr) + 1;
            try {
                stuinfo.Service.getInstance().remove(id, course);
                crsinfo.Service.getInstance().remove(course, id);
                tuition = Integer.parseInt(students.Service.getInstance().report().get(id - 1).getTuition());
                switch (course) {
                    case 1:
                    case 2:
                        students.Service.getInstance().edit(String.valueOf(tuition - 500000), id);
                        break;
                    case 3:
                    case 4:
                        students.Service.getInstance().edit(String.valueOf(tuition - 400000), id);
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            dialogLabel.setText("Successful");
            dialog.setVisible(true);
            getSelectedCourses();
        }
        else {
            logErrorText.setText("Wrong Course ID!");
            logErrorDialog.setVisible(true);
        }
    }
    private void getSelectedCourses() {
        try {
            tempStr = Main.usernames.get(index);
            id = Repository.usernames.indexOf(tempStr)+1;
            tempIntList = stuinfo.Service.getInstance().report(id, 98);
            tempStr = "<html>";
            for (int i : tempIntList) {
                tempStrList.clear();
                tempStrList.add(String.valueOf(i));
                tempStrList.add(String.valueOf(courses.Service.getInstance().report(i).getTchid()));
                tempStrList.add(courses.Service.getInstance().report(i).getName());
                tempStrList.add(courses.Service.getInstance().report(i).getRequirements());
                tempStrList.add(courses.Service.getInstance().report(i).getTime());
                tempStrList.add(String.valueOf(courses.Service.getInstance().report(i).getPlace()));
                for (String s : tempStrList)
                    tempStr += (s+" \\ ");
                tempStr = tempStr.substring(0, tempStr.length()-3);
                tempStr += "<br/>";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tempStr = tempStr.substring(0, tempStr.length()-1);
        tempStr += "</html>";
        rmvLbl.setText(tempStr);
    }
    private void payButtonMouseClicked(MouseEvent e) {
        studentFrame.setVisible(false);
        try {
            tempStr = Main.usernames.get(index);
            id = Repository.usernames.indexOf(tempStr)+1;
            tuition = Integer.parseInt(students.Service.getInstance().report().get(id -1).getTuition());
            payment = Integer.parseInt(students.Service.getInstance().report().get(id - 1).getPayment());
            tempInt = tuition - payment;
            if (tuition==0 || tempInt ==0) {
                tuitionFrm.setVisible(false);
                studentFrame.setVisible(true);
                logErrorText.setText("No payment left!");
                logErrorDialog.setVisible(true);
            }
            else {
                tuitionLbl.setText("Tuition payment left: " + tempInt);
                tuitionFrm.setVisible(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void tuitionBtnMouseClicked(MouseEvent e) {
        tuitionFrm.setVisible(false);
        studentFrame.setVisible(true);
        try {
            payment += tempInt;
            students.Service.getInstance().edit("0", String.valueOf(payment), id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        dialog.setVisible(true);
    }
    private void button6MouseClicked(MouseEvent e) {
        Contr contr=new Contr();
        contr.username=usernameField.getText();
        contr.pass=passField.getText();
        dialog.setVisible(true);
        dialogLabel.setText(contr.showSalary());
    }
    private void button7MouseClicked(MouseEvent e) {
        employeeFrame.setVisible(false);
        hourFld.setText("enter hour");
        dateFld.setText("enter date");
        recordFrm.setVisible(true);
    }
    private void button1MouseClicked(MouseEvent e) {
        try {
            tempInt = employees.Repository.usernames.indexOf(usernameField.getText());
            dialog.setVisible(true);
            dialogLabel.setText("<html>" + "ID\\Username\\Password\\Name\\Age\\Job\\Salary\\Education" + "<br/>" +
                    employees.Service.getInstance().report().get(tempInt).getId()+"\\"+employees.Service.getInstance().report().get(tempInt).getusername()+"\\"+employees.Service.getInstance().report().get(tempInt).getPass()+"\\"+
                    employees.Service.getInstance().report().get(tempInt).getName()+"\\"+employees.Service.getInstance().report().get(tempInt).getAge()+"\\"+employees.Service.getInstance().report().get(tempInt).getJob()+"\\"+
                    employees.Service.getInstance().report().get(tempInt).getSalary()+"\\"+employees.Service.getInstance().report().get(tempInt).getEducation() + "</html>");
        } catch (Exception a1){
            a1.getMessage();
        }
    }
    private void button2MouseClicked(MouseEvent e) {
        employeeFrame.setVisible(false);
        loanFrm.setVisible(true);
    }
    private void button3MouseClicked(MouseEvent e) {
        employeeFrame.setVisible(false);
        registerFld.setText("enter information");
        registerFrm.setVisible(true);
    }
    private void button4MouseClicked(MouseEvent e) {
        employeeFrame.setVisible(false);
        suFld.setText("username");
        spFld.setText("password");
        seFld.setText("education");
        saveFrm.setVisible(true);
    }
    private void hourFldMouseClicked(MouseEvent e) {
        if(hourFld.getText().equals("enter hour")){
            hourFld.setText("");
        }
    }
    private void dateFldMouseClicked(MouseEvent e) {
        if(dateFld.getText().equals("enter date")){
            dateFld.setText("");
        }
    }
    private void recordBtnMouseClicked(MouseEvent e) {
        if(hourFld.getText().equals("") || hourFld.getText().equals("enter hour")){
            logErrorText.setText("the hour can't be empty!");
            logErrorDialog.setVisible(true);
        }
        else if(dateFld.getText().equals("") || dateFld.getText().equals("enter date")){
            logErrorText.setText("the date can't be empty!");
            logErrorDialog.setVisible(true);
        }
        else {
            recordFrm.setVisible(false);
            employeeFrame.setVisible(true);
            dialogLabel.setText("recorded");
            dialog.setVisible(true);
        }
    }
    private void loan1BtnMouseClicked(MouseEvent e) {
        loanFrm.setVisible(false);
        employeeFrame.setVisible(true);
        dialog.setVisible(true);
        dialogLabel.setText("1 million loan demanded");
    }
    private void loan2BtnMouseClicked(MouseEvent e) {
        loanFrm.setVisible(false);
        employeeFrame.setVisible(true);
        dialog.setVisible(true);
        dialogLabel.setText("2 million loan demanded");
    }
    private void registerFldMouseClicked(MouseEvent e) {
        if(registerFld.getText().equals("enter information")){
            registerFld.setText("");
        }
    }
    private void registerBtnMouseClicked(MouseEvent e) {
        if (registerFld.getText().equals("") || registerFld.getText().equals("enter information")) {
            logErrorDialog.setVisible(true);
            logErrorText.setText("can't be empty!");
        } else {
            try {
                employees.Service.getInstance().saveImputation(new employees.Entity().setImputation(registerFld.getText()).setusername(usernameField.getText()).setPass(passField.getText()));
            } catch (Exception a) {
                a.getMessage();
            }
            registerFrm.setVisible(false);
            employeeFrame.setVisible(true);
            dialog.setVisible(true);
            dialogLabel.setText("information saved.");
        }
    }
    private void suFldMouseClicked(MouseEvent e) {
        if(suFld.getText().equals("username")){
            suFld.setText("");
        }
    }
    private void seFldMouseClicked(MouseEvent e) {
        if(seFld.getText().equals("education")){
            seFld.setText("");
        }
    }
    private void spFldMouseClicked(MouseEvent e) {
        if(spFld.getText().equals("password")){
            spFld.setText("");
        }
    }
    private void sdBtnMouseClicked(MouseEvent e) {
        if(suFld.getText().equals("username")||suFld.getText().equals("")){
            logErrorText.setText("username can't be empty!");
            logErrorDialog.setVisible(true);
        }
        else if(seFld.getText().equals("education")||seFld.getText().equals("")){
            logErrorText.setText("education can't be empty!");
            logErrorDialog.setVisible(true);
        }
        else if(spFld.getText().equals("password")||spFld.getText().equals("")){
            logErrorText.setText("password can't be empty!");
            logErrorDialog.setVisible(true);
        }
        else {
            try {
                employees.Service.getInstance().edit(new employees.Entity().setusername(suFld.getText()).setPass(spFld.getText()).setEducation(seFld.getText()),usernameField.getText(),passField.getText());
            }catch (Exception e1){
                e1.getMessage();
            }
            saveFrm.setVisible(false);
            employeeFrame.setVisible(true);
            dialog.setVisible(true);
            dialogLabel.setText("information edited.");
        }
    }
    private void reportBtnMouseClicked(MouseEvent e) {
        reportFrm.setVisible(false);
        studentFrame.setVisible(true);
    }
    private void lessonButtonMouseClicked(MouseEvent e) {
        studentFrame.setVisible(false);
        try {
            tempStr = Main.usernames.get(index);
            id = Repository.usernames.indexOf(tempStr)+1;
            tempEntList = stuinfo.Service.getInstance().report(id);
            tempStr = "<html>";
            for (Entity entity : tempEntList) {
                tempStrList.clear();
                tempStrList.add(String.valueOf(entity.getTermid()));
                tempStrList.add(String.valueOf(entity.getCourseid()));
                tempStrList.add(String.valueOf(courses.Service.getInstance().report().get(entity.getCourseid()-1).getTchid()));
                tempStrList.add(entity.getFail());
                for (String s : tempStrList)
                    tempStr += (s+" \\ ");
                tempStr = tempStr.substring(0, tempStr.length()-3);
                tempStr += "<br/>";
            }
            tempStr = tempStr.substring(0, tempStr.length()-1);
            tempStr += "</html>";
            reportLbl.setText(tempStr);
            reportFrm.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void buttonLessonMouseClicked(MouseEvent e) {
        teacherFrame.setVisible(false);
        try {
            tempStr = Main.usernames.get(index);
            id = teachers.Repository.usernames.indexOf(tempStr)+1;
            tempEntList2 = courses.Service.getInstance().report(id, 0);
            tempStr = "<html>";
            for (courses.Entity entity : tempEntList2) {
                tempStrList.clear();
                tempStrList.add(String.valueOf(entity.getCrsid()));
                tempStrList.add(String.valueOf(entity.getName()));
                tempStrList.add(String.valueOf(entity.getTime()));
                tempStrList.add(String.valueOf(entity.getPlace()));
                tempStrList.add(String.valueOf(entity.getSalary()));
                tempStrList.add(String.valueOf(entity.getSurvey()));
                for (String s : tempStrList)
                    tempStr += (s+" \\ ");
                tempStr = tempStr.substring(0, tempStr.length()-3);
                tempStr += "<br/>";
            }
            tempStr = tempStr.substring(0, tempStr.length()-1);
            tempStr += "</html>";
            tReportLbl.setText(tempStr);
            tReportFrm.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void tchReportBtnMouseClicked(MouseEvent e) {
        tReportFrm.setVisible(false);
        teacherFrame.setVisible(true);
    }
    private void failBtnMouseClicked(MouseEvent e) {
        failFrm.setVisible(false);
        studentFrame.setVisible(true);
    }
    private void unitButtonMouseClicked(MouseEvent e) {
        studentFrame.setVisible(false);
        try {
            tempStr = Main.usernames.get(index);
            id = Repository.usernames.indexOf(tempStr)+1;
            tempEntList = stuinfo.Service.getInstance().report(id);
            tempStr = "<html>";
            for (Entity entity : tempEntList)
                if (entity.getFail().equals("no"))
                    getCourses(entity);
            tempStr = tempStr.substring(0, tempStr.length()-1);
            tempStr += "</html>";
            passLbl.setText(tempStr);
            tempStr = "<html>";
            for (Entity entity : tempEntList)
                if (entity.getFail().equals("yes"))
                    getCourses(entity);
            tempStr = tempStr.substring(0, tempStr.length()-1);
            tempStr += "</html>";
            failLbl.setText(tempStr);
            failFrm.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void getCourses(Entity entity) throws Exception {
        tempStrList.clear();
        tempStrList.add(String.valueOf(entity.getTermid()));
        tempStrList.add(String.valueOf(entity.getCourseid()));
        tempStrList.add(String.valueOf(courses.Service.getInstance().report().get(entity.getCourseid()-1).getTchid()));
        for (String s : tempStrList)
            tempStr += (s+" \\ ");
        tempStr = tempStr.substring(0, tempStr.length()-3);
        tempStr += "<br/>";
    }
    private void scoresBtnMouseClicked(MouseEvent e) {
        scoresFrm.setVisible(false);
        studentFrame.setVisible(true);
    }
    private void scoreButtonMouseClicked(MouseEvent e) {
        studentFrame.setVisible(false);
        try {
            tempStr = Main.usernames.get(index);
            id = Repository.usernames.indexOf(tempStr)-1;
            scoresLbl.setText(crsinfo.Service.getInstance().report().get(id).getCrsid()+" \\ "+crsinfo.Service.getInstance().report().get(id).getScore());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        scoresFrm.setVisible(true);
    }
    private void avgBtnMouseClicked(MouseEvent e) {
        avgFrm.setVisible(false);
        studentFrame.setVisible(true);
    }
    private void averageButtonMouseClicked(MouseEvent e) {
        studentFrame.setVisible(false);
        tempStr = Main.usernames.get(index);
        id = Repository.usernames.indexOf(tempStr)+1;
        try {
            tempIntList = crsinfo.Service.getInstance().report(id);
            tempInt = 0;
            int count = 0;
            for (int i : tempIntList) {
                tempInt += i;
                count++;
            }
            avgLbl.setText("Average: "+(tempInt/count));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        avgFrm.setVisible(true);
    }
    private void cIDFldMouseClicked(MouseEvent e) {
        cIDFld.setText("");
    }
    private void cReportBtnMouseClicked(MouseEvent e) {
        cReportFrm.setVisible(false);
        teacherFrame.setVisible(true);
    }
    private void cIDBtnMouseClicked(MouseEvent e) {
        if (cIDFld.getText().equals("Enter Course ID") || cIDFld.getText().equals("")) {
            logErrorText.setText("Course ID Can't Be Empty!");
            logErrorDialog.setVisible(true);
        }
        else {
            try {
                tempStr = Main.usernames.get(index);
                id = teachers.Repository.usernames.indexOf(tempStr)+1;
                course = Integer.parseInt(cIDFld.getText());
                tempIntList = courses.Service.getInstance().getCourseIDs(id);
                if (tempIntList.contains(course)) {
                    cIDFrm.setVisible(false);
                    tempIntList = crsinfo.Service.getInstance().getStuIDs(course);
                    tempInt = tempIntList.size();
                    tempStr = "<html>";
                    for (int i : tempIntList) {
                        students.Entity entity = students.Service.getInstance().report(i);
                        tempStrList.clear();
                        tempStrList.add(entity.getField());
                        tempStrList.add(String.valueOf(entity.getYear()));
                        for (String s : tempStrList)
                            tempStr += (s+" \\ ");
                        tempStr = tempStr.substring(0, tempStr.length()-3);
                        tempStr += "<br/>";
                    }
                    tempStr = tempStr.substring(0, tempStr.length()-1);
                    tempStr += "</html>";
                    cReportLbl.setText(tempStr);
                    cReportCountLbl.setText("Student Count: "+tempInt);
                    cReportFrm.setVisible(true);
                }
                else {
                    logErrorText.setText("Wrong Course ID!");
                    logErrorDialog.setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private void buttonNumMouseClicked(MouseEvent e) {
        teacherFrame.setVisible(false);
        cIDFld.setText("Enter Course ID");
        cIDFrm.setVisible(true);
    }
    private void idStudentFldMouseClicked(MouseEvent e) {
        if(idStudentFld.getText().equals("enter student id")){
            idStudentFld.setText("");
        }
    }
    private void scoreFldMouseClicked(MouseEvent e) {
        if(scoreFld.getText().equals("enter score")){
            scoreFld.setText("");
        }
    }
    private void courseIdFldMouseClicked(MouseEvent e) {
        if(courseIdFld.getText().equals("enter course id")){
            courseIdFld.setText("");
        }
    }
    private void buttonInsertMouseClicked(MouseEvent e) {
        teacherFrame.setVisible(false);
        idStudentFld.setText("enter student id");
        scoreFld.setText("enter score");
        courseIdFld.setText("enter course id");
        scoreFrm.setVisible(true);
    }
    private void scoreBtnMouseClicked(MouseEvent e) {
        if(idStudentFld.getText().equals("") || idStudentFld.getText().equals("enter student id")){
            dialogLabel.setText("student id can't be empty!");
            dialog.setVisible(true);
        }
        else if(scoreFld.getText().equals("") || scoreFld.getText().equals("enter score")){
            dialogLabel.setText("score can't be empty!");
            dialog.setVisible(true);
        }
        else if(courseIdFld.getText().equals("") || courseIdFld.getText().equals("enter course id")){
            dialogLabel.setText("course id can't be empty!");
            dialog.setVisible(true);
        }
        else {
            id = Integer.parseInt(idStudentFld.getText());
            tempInt = Integer.parseInt(scoreFld.getText());
            course = Integer.parseInt(courseIdFld.getText());
            try {
                crsinfo.Service.getInstance().edit(id,tempInt,course);
                if(tempInt >= 10)
                    stuinfo.Service.getInstance().edit(id,course,"no");
                else
                    stuinfo.Service.getInstance().edit(id,course,"yes");
            } catch (Exception e1){
                e1.getMessage();
            }
            scoreFrm.setVisible(false);
            teacherFrame.setVisible(true);
            dialog.setVisible(true);
            dialogLabel.setText("Successful");
        }
    }
    private void buttonIncomeMouseClicked(MouseEvent e) {
        teachers.Contr contr=new teachers.Contr();
        contr.username=usernameField.getText();
        contr.pass=passField.getText();
        dialogLabel.setText(contr.showSalary());
        dialog.setVisible(true);
    }
    private void buttonRemoveMouseClicked(MouseEvent e) {
        teacherFrame.setVisible(false);
        removeFld.setText("enter student id");
        removeFld2.setText("enter course id");
        removeFrame.setVisible(true);
    }
    private void removeFldMouseClicked(MouseEvent e) {
        if (removeFld.getText().equals("enter student id")) {
            removeFld.setText("");
        }
    }
    private void removeButtonMouseClicked(MouseEvent e) {
        if (removeFld.getText().equals("") || removeFld.getText().equals("enter student id")) {
            logErrorText.setText("student id can't be empty!");
            logErrorDialog.setVisible(true);
        }
        else if (removeFld2.getText().equals("") || removeFld2.getText().equals("enter course id")) {
            logErrorText.setText("course id can't be empty!");
            logErrorDialog.setVisible(true);
        }
        else {
            id = Integer.parseInt(passField.getText());
            try {
                stuinfo.Service.getInstance().remove(Integer.parseInt(removeFld.getText()),Integer.parseInt(removeFld2.getText()));
                crsinfo.Service.getInstance().remove(Integer.parseInt(removeFld2.getText()), Integer.parseInt(removeFld.getText()));
            }catch (Exception e1){
                e1.getMessage();
            }
            removeFrame.setVisible(false);
            teacherFrame.setVisible(true);
            dialog.setVisible(true);
            dialogLabel.setText("Successful");
        }
    }
    private void removeFld2MouseClicked(MouseEvent e) {
        if (removeFld.getText().equals("enter course id")) {
            removeFld.setText("");
        }
    }
    private void buttonEvaluationMouseClicked(MouseEvent e) {
        teacherFrame.setVisible(false);
        srvyFld.setText("Enter Course ID");
        srvyFrm.setVisible(true);
    }
    private void srvyFldMouseClicked(MouseEvent e) {
        if (srvyFld.getText().equals("Enter Course ID"))
            srvyFld.setText("");
    }
    private void surveyBtnMouseClicked(MouseEvent e) {
        surveyFrm.setVisible(false);
        teacherFrame.setVisible(true);
    }
    private void srvyBtnMouseClicked(MouseEvent e) {
        if (srvyFld.getText().equals("") || srvyFld.getText().equals("Enter Course ID")) {
            logErrorText.setText("Course ID Can't Be Empty!");
            logErrorDialog.setVisible(true);
        }
        else {
            id = Integer.parseInt(passField.getText());
            course = Integer.parseInt(srvyFld.getText());
            try {
                if (id==1) {
                    if (course==1) {
                        surveyLbl.setText(String.valueOf(courses.Service.getInstance().report().get(7 + course).getSurvey()));
                        srvyFrm.setVisible(false);
                        surveyFrm.setVisible(true);
                    }
                    else if (course==2) {
                        surveyLbl.setText(String.valueOf(courses.Service.getInstance().report().get(7 + course).getSurvey()));
                        srvyFrm.setVisible(false);
                        surveyFrm.setVisible(true);
                    }
                    else {
                        logErrorText.setText("Course ID Wrong!");
                        logErrorDialog.setVisible(true);
                    }
                }
                else {
                    if (course==3) {
                        surveyLbl.setText(String.valueOf(courses.Service.getInstance().report().get(7 + course).getSurvey()));
                        srvyFrm.setVisible(false);
                        surveyFrm.setVisible(true);
                    }
                    else if (course==4) {
                        surveyLbl.setText(String.valueOf(courses.Service.getInstance().report().get(7 + course).getSurvey()));
                        srvyFrm.setVisible(false);
                        surveyFrm.setVisible(true);
                    }
                    else {
                        logErrorText.setText("Course ID Wrong!");
                        logErrorDialog.setVisible(true);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        mainFrame = new JFrame();
        studentButton = new JButton();
        noticeButton = new JButton();
        studentFrame = new JDialog();
        selectButton = new JButton();
        rmvButton = new JButton();
        payButton = new JButton();
        lessonButton = new JButton();
        unitButton = new JButton();
        scoreButton = new JButton();
        averageButton = new JButton();
        backBtn1 = new JButton();
        teacherFrame = new JDialog();
        buttonLesson = new JButton();
        buttonInsert = new JButton();
        buttonIncome = new JButton();
        buttonRemove = new JButton();
        buttonNum = new JButton();
        buttonEvaluation = new JButton();
        backBtn2 = new JButton();
        logFrame = new JDialog();
        usernameField = new JTextField();
        passField = new JTextField();
        enterButton = new JButton();
        employeeFrame = new JDialog();
        button6 = new JButton();
        button7 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        backBtn3 = new JButton();
        noticeFrame = new JDialog();
        noticeLbl = new JLabel();
        backBtn4 = new JButton();
        logErrorDialog = new JDialog();
        logErrorText = new JLabel();
        rmvFrm = new JFrame();
        infoLbl2 = new JLabel();
        rmvLbl = new JLabel();
        rmvFld = new JTextField();
        backBtn5 = new JButton();
        rmvBtn = new JButton();
        label2 = new JLabel();
        dialog = new JDialog();
        dialogLabel = new JLabel();
        addFrm = new JFrame();
        infoLbl3 = new JLabel();
        addLbl = new JLabel();
        addFld = new JTextField();
        backBtn6 = new JButton();
        addBtn = new JButton();
        label3 = new JLabel();
        recordFrm = new JFrame();
        hourFld = new JTextField();
        dateFld = new JTextField();
        recordBtn = new JButton();
        loanFrm = new JFrame();
        loan1Btn = new JButton();
        loan2Btn = new JButton();
        registerFrm = new JFrame();
        registerFld = new JTextField();
        registerBtn = new JButton();
        saveFrm = new JFrame();
        suFld = new JTextField();
        spFld = new JTextField();
        seFld = new JTextField();
        sdBtn = new JButton();
        tuitionFrm = new JDialog();
        tuitionLbl = new JLabel();
        tuitionBtn = new JButton();
        reportFrm = new JFrame();
        label1 = new JLabel();
        reportLbl = new JLabel();
        reportBtn = new JButton();
        tReportFrm = new JFrame();
        label4 = new JLabel();
        tReportLbl = new JLabel();
        tchReportBtn = new JButton();
        failFrm = new JFrame();
        passLbl = new JLabel();
        failBtn = new JButton();
        label6 = new JLabel();
        label7 = new JLabel();
        failLbl = new JLabel();
        scoresFrm = new JFrame();
        label5 = new JLabel();
        scoresLbl = new JLabel();
        scoresBtn = new JButton();
        avgFrm = new JFrame();
        avgLbl = new JLabel();
        avgBtn = new JButton();
        cIDFrm = new JFrame();
        cIDFld = new JTextField();
        cIDBtn = new JButton();
        cReportFrm = new JFrame();
        cReportCountLbl = new JLabel();
        cReportLbl = new JLabel();
        cReportBtn = new JButton();
        scoreFrm = new JFrame();
        idStudentFld = new JTextField();
        scoreFld = new JTextField();
        courseIdFld = new JTextField();
        scoreBtn = new JButton();
        removeFrame = new JFrame();
        removeFld = new JTextField();
        removeFld2 = new JTextField();
        removeButton = new JButton();
        srvyFrm = new JFrame();
        srvyFld = new JTextField();
        srvyBtn = new JButton();
        surveyFrm = new JFrame();
        surveyLbl = new JLabel();
        surveyBtn = new JButton();

        //======== mainFrame ========
        {
            mainFrame.setTitle("golestan system");
            Container mainFrameContentPane = mainFrame.getContentPane();
            mainFrameContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)mainFrameContentPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)mainFrameContentPane.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)mainFrameContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)mainFrameContentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

            //---- studentButton ----
            studentButton.setText("Log In");
            studentButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    studentButtonMouseClicked(e);
                    studentButtonMouseClicked(e);
                }
            });
            mainFrameContentPane.add(studentButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- noticeButton ----
            noticeButton.setText("Notices");
            noticeButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    noticeButtonMouseClicked(e);
                    noticeButtonMouseClicked(e);
                }
            });
            mainFrameContentPane.add(noticeButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            mainFrame.setSize(200, 125);
            mainFrame.setLocationRelativeTo(null);
        }

        //======== studentFrame ========
        {
            studentFrame.setTitle("student's page");
            Container studentFrameContentPane = studentFrame.getContentPane();
            studentFrameContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)studentFrameContentPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)studentFrameContentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)studentFrameContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)studentFrameContentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0E-4};

            //---- selectButton ----
            selectButton.setText("Add Course");
            selectButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selectButtonMouseClicked(e);
                    selectButtonMouseClicked(e);
                }
            });
            studentFrameContentPane.add(selectButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- rmvButton ----
            rmvButton.setText("Edit Selected Courses");
            rmvButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button5MouseClicked(e);
                    rmvButtonMouseClicked(e);
                    rmvButtonMouseClicked(e);
                    rmvButtonMouseClicked(e);
                }
            });
            studentFrameContentPane.add(rmvButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- payButton ----
            payButton.setText("Pay Tuition");
            payButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    payButtonMouseClicked(e);
                }
            });
            studentFrameContentPane.add(payButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- lessonButton ----
            lessonButton.setText("Show Lessons Of Each Term");
            lessonButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    lessonButtonMouseClicked(e);
                }
            });
            studentFrameContentPane.add(lessonButton, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- unitButton ----
            unitButton.setText("Show Units Passed & Failed");
            unitButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    unitButtonMouseClicked(e);
                }
            });
            studentFrameContentPane.add(unitButton, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- scoreButton ----
            scoreButton.setText("Show Scores");
            scoreButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    scoreButtonMouseClicked(e);
                }
            });
            studentFrameContentPane.add(scoreButton, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- averageButton ----
            averageButton.setText("Average");
            averageButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    averageButtonMouseClicked(e);
                }
            });
            studentFrameContentPane.add(averageButton, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- backBtn1 ----
            backBtn1.setText("Back");
            backBtn1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    backBtn1MouseClicked(e);
                }
            });
            studentFrameContentPane.add(backBtn1, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            studentFrame.setSize(225, 300);
            studentFrame.setLocationRelativeTo(null);
        }

        //======== teacherFrame ========
        {
            teacherFrame.setTitle("teacher's page");
            Container teacherFrameContentPane = teacherFrame.getContentPane();
            teacherFrameContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)teacherFrameContentPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)teacherFrameContentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)teacherFrameContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)teacherFrameContentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0E-4};

            //---- buttonLesson ----
            buttonLesson.setText("Show Lessons");
            buttonLesson.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonLessonMouseClicked(e);
                }
            });
            teacherFrameContentPane.add(buttonLesson, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- buttonInsert ----
            buttonInsert.setText("Insert Student Score");
            buttonInsert.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonInsertMouseClicked(e);
                }
            });
            teacherFrameContentPane.add(buttonInsert, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- buttonIncome ----
            buttonIncome.setText("Show Income");
            buttonIncome.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonIncomeMouseClicked(e);
                }
            });
            teacherFrameContentPane.add(buttonIncome, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- buttonRemove ----
            buttonRemove.setText("Remove Student");
            buttonRemove.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonRemoveMouseClicked(e);
                }
            });
            teacherFrameContentPane.add(buttonRemove, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- buttonNum ----
            buttonNum.setText("Students Info for Each Course");
            buttonNum.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonNumMouseClicked(e);
                }
            });
            teacherFrameContentPane.add(buttonNum, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- buttonEvaluation ----
            buttonEvaluation.setText("Survey Score");
            buttonEvaluation.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonEvaluationMouseClicked(e);
                }
            });
            teacherFrameContentPane.add(buttonEvaluation, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- backBtn2 ----
            backBtn2.setText("Back");
            backBtn2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    backBtn2MouseClicked(e);
                }
            });
            teacherFrameContentPane.add(backBtn2, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            teacherFrame.setSize(225, 275);
            teacherFrame.setLocationRelativeTo(null);
        }

        //======== logFrame ========
        {
            logFrame.setTitle("login");
            Container logFrameContentPane = logFrame.getContentPane();
            logFrameContentPane.setLayout(new GridLayout(3, 1));

            //---- usernameField ----
            usernameField.setText("enter username");
            usernameField.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    usernameFieldMouseClicked(e);
                }
            });
            logFrameContentPane.add(usernameField);

            //---- passField ----
            passField.setText("enter password");
            passField.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    passFieldMouseClicked(e);
                }
            });
            logFrameContentPane.add(passField);

            //---- enterButton ----
            enterButton.setText("Enter");
            enterButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    enterButtonMouseClicked(e);
                }
            });
            logFrameContentPane.add(enterButton);
            logFrame.setSize(200, 150);
            logFrame.setLocationRelativeTo(null);
        }

        //======== employeeFrame ========
        {
            employeeFrame.setTitle("employee's page");
            Container employeeFrameContentPane = employeeFrame.getContentPane();
            employeeFrameContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)employeeFrameContentPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)employeeFrameContentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)employeeFrameContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)employeeFrameContentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0E-4};

            //---- button6 ----
            button6.setText("show salary");
            button6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button6MouseClicked(e);
                }
            });
            employeeFrameContentPane.add(button6, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- button7 ----
            button7.setText("record leave");
            button7.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button7MouseClicked(e);
                }
            });
            employeeFrameContentPane.add(button7, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- button1 ----
            button1.setText("report of the latest employee status");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            employeeFrameContentPane.add(button1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- button2 ----
            button2.setText("loan demand");
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                }
            });
            employeeFrameContentPane.add(button2, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- button3 ----
            button3.setText("registering in system");
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button3MouseClicked(e);
                }
            });
            employeeFrameContentPane.add(button3, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- button4 ----
            button4.setText("save,edit personal,educational Specifications");
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked(e);
                }
            });
            employeeFrameContentPane.add(button4, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- backBtn3 ----
            backBtn3.setText("Back");
            backBtn3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    backBtn3MouseClicked(e);
                    backBtn3MouseClicked(e);
                }
            });
            employeeFrameContentPane.add(backBtn3, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            employeeFrame.setSize(325, 275);
            employeeFrame.setLocationRelativeTo(null);
        }

        //======== noticeFrame ========
        {
            noticeFrame.setTitle("Notices");
            Container noticeFrameContentPane = noticeFrame.getContentPane();
            noticeFrameContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)noticeFrameContentPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)noticeFrameContentPane.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)noticeFrameContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)noticeFrameContentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

            //---- noticeLbl ----
            noticeLbl.setText("text");
            noticeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
            noticeFrameContentPane.add(noticeLbl, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- backBtn4 ----
            backBtn4.setText("Back");
            backBtn4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    backBtn4MouseClicked(e);
                }
            });
            noticeFrameContentPane.add(backBtn4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            noticeFrame.setSize(585, 175);
            noticeFrame.setLocationRelativeTo(null);
        }

        //======== logErrorDialog ========
        {
            logErrorDialog.setTitle("Error");
            Container logErrorDialogContentPane = logErrorDialog.getContentPane();

            //---- logErrorText ----
            logErrorText.setText("text");
            logErrorText.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout logErrorDialogContentPaneLayout = new GroupLayout(logErrorDialogContentPane);
            logErrorDialogContentPane.setLayout(logErrorDialogContentPaneLayout);
            logErrorDialogContentPaneLayout.setHorizontalGroup(
                logErrorDialogContentPaneLayout.createParallelGroup()
                    .addGroup(logErrorDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logErrorText, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                        .addContainerGap())
            );
            logErrorDialogContentPaneLayout.setVerticalGroup(
                logErrorDialogContentPaneLayout.createParallelGroup()
                    .addGroup(logErrorDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logErrorText, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addContainerGap())
            );
            logErrorDialog.setSize(200, 100);
            logErrorDialog.setLocationRelativeTo(null);
        }

        //======== rmvFrm ========
        {
            rmvFrm.setTitle("Remove Course");
            Container rmvFrmContentPane = rmvFrm.getContentPane();

            //---- infoLbl2 ----
            infoLbl2.setText("(CouseID\\TeacherID\\Name\\Requirements\\Time\\ClassID)");
            infoLbl2.setHorizontalAlignment(SwingConstants.CENTER);

            //---- rmvLbl ----
            rmvLbl.setText("text");
            rmvLbl.setHorizontalAlignment(SwingConstants.CENTER);

            //---- backBtn5 ----
            backBtn5.setText("Back");
            backBtn5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    backBtn2MouseClicked(e);
                    backBtn5MouseClicked(e);
                }
            });

            //---- rmvBtn ----
            rmvBtn.setText("Remove");
            rmvBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    removeBtnMouseClicked(e);
                    rmvBtnMouseClicked(e);
                }
            });

            //---- label2 ----
            label2.setText("Enter Course ID to remove:");

            GroupLayout rmvFrmContentPaneLayout = new GroupLayout(rmvFrmContentPane);
            rmvFrmContentPane.setLayout(rmvFrmContentPaneLayout);
            rmvFrmContentPaneLayout.setHorizontalGroup(
                rmvFrmContentPaneLayout.createParallelGroup()
                    .addGroup(rmvFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rmvFld, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rmvBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn5, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(rmvFrmContentPaneLayout.createSequentialGroup()
                        .addGroup(rmvFrmContentPaneLayout.createParallelGroup()
                            .addComponent(infoLbl2, GroupLayout.PREFERRED_SIZE, 798, GroupLayout.PREFERRED_SIZE)
                            .addComponent(rmvLbl, GroupLayout.PREFERRED_SIZE, 798, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
            );
            rmvFrmContentPaneLayout.setVerticalGroup(
                rmvFrmContentPaneLayout.createParallelGroup()
                    .addGroup(rmvFrmContentPaneLayout.createSequentialGroup()
                        .addComponent(infoLbl2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rmvLbl, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rmvFrmContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(backBtn5)
                            .addComponent(rmvFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(rmvBtn)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
            );
            rmvFrm.setSize(800, 415);
            rmvFrm.setLocationRelativeTo(null);
        }

        //======== dialog ========
        {
            Container dialogContentPane = dialog.getContentPane();
            dialogContentPane.setLayout(new GridLayout());

            //---- dialogLabel ----
            dialogLabel.setText("Successful");
            dialogLabel.setHorizontalAlignment(SwingConstants.CENTER);
            dialogContentPane.add(dialogLabel);
            dialog.setSize(375, 100);
            dialog.setLocationRelativeTo(null);
        }

        //======== addFrm ========
        {
            addFrm.setTitle("Add Course");
            Container addFrmContentPane = addFrm.getContentPane();

            //---- infoLbl3 ----
            infoLbl3.setText("(CouseID\\TeacherID\\Name\\Requirements\\Time\\ClassID)");
            infoLbl3.setHorizontalAlignment(SwingConstants.CENTER);

            //---- addLbl ----
            addLbl.setText("text");
            addLbl.setHorizontalAlignment(SwingConstants.CENTER);

            //---- backBtn6 ----
            backBtn6.setText("Back");
            backBtn6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    backBtn2MouseClicked(e);
                    backBtn6MouseClicked(e);
                }
            });

            //---- addBtn ----
            addBtn.setText("Add");
            addBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    removeBtnMouseClicked(e);
                    addBtnMouseClicked(e);
                }
            });

            //---- label3 ----
            label3.setText("Enter Course ID to add:");

            GroupLayout addFrmContentPaneLayout = new GroupLayout(addFrmContentPane);
            addFrmContentPane.setLayout(addFrmContentPaneLayout);
            addFrmContentPaneLayout.setHorizontalGroup(
                addFrmContentPaneLayout.createParallelGroup()
                    .addGroup(addFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label3)
                        .addGap(18, 18, 18)
                        .addComponent(addFld, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn6, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(addFrmContentPaneLayout.createSequentialGroup()
                        .addGroup(addFrmContentPaneLayout.createParallelGroup()
                            .addComponent(infoLbl3, GroupLayout.PREFERRED_SIZE, 798, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addLbl, GroupLayout.PREFERRED_SIZE, 798, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
            );
            addFrmContentPaneLayout.setVerticalGroup(
                addFrmContentPaneLayout.createParallelGroup()
                    .addGroup(addFrmContentPaneLayout.createSequentialGroup()
                        .addComponent(infoLbl3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addLbl, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addFrmContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(backBtn6)
                            .addComponent(addBtn)
                            .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
            );
            addFrm.setSize(800, 415);
            addFrm.setLocationRelativeTo(null);
        }

        //======== recordFrm ========
        {
            recordFrm.setTitle("Leave");
            Container recordFrmContentPane = recordFrm.getContentPane();
            recordFrmContentPane.setLayout(new GridLayout(3, 1));

            //---- hourFld ----
            hourFld.setText("enter hour");
            hourFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    hourFldMouseClicked(e);
                }
            });
            recordFrmContentPane.add(hourFld);

            //---- dateFld ----
            dateFld.setText("enter date");
            dateFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dateFldMouseClicked(e);
                }
            });
            recordFrmContentPane.add(dateFld);

            //---- recordBtn ----
            recordBtn.setText("Done");
            recordBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    recordBtnMouseClicked(e);
                }
            });
            recordFrmContentPane.add(recordBtn);
            recordFrm.setSize(200, 150);
            recordFrm.setLocationRelativeTo(null);
        }

        //======== loanFrm ========
        {
            loanFrm.setTitle("Loan");
            Container loanFrmContentPane = loanFrm.getContentPane();
            loanFrmContentPane.setLayout(new GridLayout(2, 1));

            //---- loan1Btn ----
            loan1Btn.setText("1 Million");
            loan1Btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    loan1BtnMouseClicked(e);
                }
            });
            loanFrmContentPane.add(loan1Btn);

            //---- loan2Btn ----
            loan2Btn.setText("2 Million");
            loan2Btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    loan2BtnMouseClicked(e);
                }
            });
            loanFrmContentPane.add(loan2Btn);
            loanFrm.setSize(175, 100);
            loanFrm.setLocationRelativeTo(null);
        }

        //======== registerFrm ========
        {
            registerFrm.setTitle("Register");
            Container registerFrmContentPane = registerFrm.getContentPane();
            registerFrmContentPane.setLayout(new GridLayout(2, 1));

            //---- registerFld ----
            registerFld.setText("enter information");
            registerFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    registerFldMouseClicked(e);
                }
            });
            registerFrmContentPane.add(registerFld);

            //---- registerBtn ----
            registerBtn.setText("Done");
            registerBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    registerBtnMouseClicked(e);
                }
            });
            registerFrmContentPane.add(registerBtn);
            registerFrm.setSize(200, 100);
            registerFrm.setLocationRelativeTo(null);
        }

        //======== saveFrm ========
        {
            saveFrm.setTitle("Save");
            Container saveFrmContentPane = saveFrm.getContentPane();
            saveFrmContentPane.setLayout(new GridLayout(4, 1));

            //---- suFld ----
            suFld.setText("username");
            suFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    suFldMouseClicked(e);
                }
            });
            saveFrmContentPane.add(suFld);

            //---- spFld ----
            spFld.setText("password");
            spFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    spFldMouseClicked(e);
                }
            });
            saveFrmContentPane.add(spFld);

            //---- seFld ----
            seFld.setText("education");
            seFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    suFldMouseClicked(e);
                    seFldMouseClicked(e);
                }
            });
            saveFrmContentPane.add(seFld);

            //---- sdBtn ----
            sdBtn.setText("Done");
            sdBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    sdBtnMouseClicked(e);
                }
            });
            saveFrmContentPane.add(sdBtn);
            saveFrm.setSize(200, 175);
            saveFrm.setLocationRelativeTo(null);
        }

        //======== tuitionFrm ========
        {
            tuitionFrm.setTitle("Tuition");
            Container tuitionFrmContentPane = tuitionFrm.getContentPane();
            tuitionFrmContentPane.setLayout(new GridLayout(2, 1));

            //---- tuitionLbl ----
            tuitionLbl.setText("text");
            tuitionLbl.setHorizontalAlignment(SwingConstants.CENTER);
            tuitionFrmContentPane.add(tuitionLbl);

            //---- tuitionBtn ----
            tuitionBtn.setText("Pay");
            tuitionBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tuitionBtnMouseClicked(e);
                }
            });
            tuitionFrmContentPane.add(tuitionBtn);
            tuitionFrm.setSize(200, 100);
            tuitionFrm.setLocationRelativeTo(null);
        }

        //======== reportFrm ========
        {
            reportFrm.setTitle("Student Report");
            Container reportFrmContentPane = reportFrm.getContentPane();

            //---- label1 ----
            label1.setText("(TermID\\CourseID\\TeacherID\\Fail)");
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            //---- reportLbl ----
            reportLbl.setText("text");
            reportLbl.setHorizontalAlignment(SwingConstants.CENTER);

            //---- reportBtn ----
            reportBtn.setText("Back");
            reportBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    reportBtnMouseClicked(e);
                }
            });

            GroupLayout reportFrmContentPaneLayout = new GroupLayout(reportFrmContentPane);
            reportFrmContentPane.setLayout(reportFrmContentPaneLayout);
            reportFrmContentPaneLayout.setHorizontalGroup(
                reportFrmContentPaneLayout.createParallelGroup()
                    .addGroup(reportFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(reportFrmContentPaneLayout.createParallelGroup()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(reportBtn, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(reportLbl, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                        .addContainerGap())
            );
            reportFrmContentPaneLayout.setVerticalGroup(
                reportFrmContentPaneLayout.createParallelGroup()
                    .addGroup(reportFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reportLbl, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reportBtn)
                        .addContainerGap())
            );
            reportFrm.setSize(300, 200);
            reportFrm.setLocationRelativeTo(null);
        }

        //======== tReportFrm ========
        {
            tReportFrm.setTitle("Teacher Report");
            Container tReportFrmContentPane = tReportFrm.getContentPane();

            //---- label4 ----
            label4.setText("(CourseID\\Name\\Time\\ClassID\\Salary\\Survey)");
            label4.setHorizontalAlignment(SwingConstants.CENTER);

            //---- tReportLbl ----
            tReportLbl.setText("text");
            tReportLbl.setHorizontalAlignment(SwingConstants.CENTER);

            //---- tchReportBtn ----
            tchReportBtn.setText("Back");
            tchReportBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tchReportBtnMouseClicked(e);
                }
            });

            GroupLayout tReportFrmContentPaneLayout = new GroupLayout(tReportFrmContentPane);
            tReportFrmContentPane.setLayout(tReportFrmContentPaneLayout);
            tReportFrmContentPaneLayout.setHorizontalGroup(
                tReportFrmContentPaneLayout.createParallelGroup()
                    .addGroup(tReportFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tReportFrmContentPaneLayout.createParallelGroup()
                            .addComponent(label4, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(tReportLbl, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(tchReportBtn, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                        .addContainerGap())
            );
            tReportFrmContentPaneLayout.setVerticalGroup(
                tReportFrmContentPaneLayout.createParallelGroup()
                    .addGroup(tReportFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tReportLbl, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tchReportBtn)
                        .addContainerGap())
            );
            tReportFrm.setSize(350, 200);
            tReportFrm.setLocationRelativeTo(null);
        }

        //======== failFrm ========
        {
            failFrm.setTitle("Pass\\Fail (TermID\\CourseID\\TeacherID)");
            Container failFrmContentPane = failFrm.getContentPane();

            //---- passLbl ----
            passLbl.setText("text");
            passLbl.setHorizontalAlignment(SwingConstants.CENTER);

            //---- failBtn ----
            failBtn.setText("Back");
            failBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    failBtnMouseClicked(e);
                }
            });

            //---- label6 ----
            label6.setText("Passed:");

            //---- label7 ----
            label7.setText("Failed:");

            //---- failLbl ----
            failLbl.setText("text");
            failLbl.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout failFrmContentPaneLayout = new GroupLayout(failFrmContentPane);
            failFrmContentPane.setLayout(failFrmContentPaneLayout);
            failFrmContentPaneLayout.setHorizontalGroup(
                failFrmContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, failFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(failFrmContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label7, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(failBtn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(failLbl, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                        .addContainerGap())
            );
            failFrmContentPaneLayout.setVerticalGroup(
                failFrmContentPaneLayout.createParallelGroup()
                    .addGroup(failFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passLbl, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(failLbl, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(failBtn)
                        .addContainerGap())
            );
            failFrm.setSize(350, 200);
            failFrm.setLocationRelativeTo(null);
        }

        //======== scoresFrm ========
        {
            scoresFrm.setTitle("Scores");
            Container scoresFrmContentPane = scoresFrm.getContentPane();

            //---- label5 ----
            label5.setText("(CourseID\\Score)");
            label5.setHorizontalAlignment(SwingConstants.CENTER);

            //---- scoresLbl ----
            scoresLbl.setText("text");
            scoresLbl.setHorizontalAlignment(SwingConstants.CENTER);

            //---- scoresBtn ----
            scoresBtn.setText("Back");
            scoresBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    scoresBtnMouseClicked(e);
                }
            });

            GroupLayout scoresFrmContentPaneLayout = new GroupLayout(scoresFrmContentPane);
            scoresFrmContentPane.setLayout(scoresFrmContentPaneLayout);
            scoresFrmContentPaneLayout.setHorizontalGroup(
                scoresFrmContentPaneLayout.createParallelGroup()
                    .addGroup(scoresFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(scoresFrmContentPaneLayout.createParallelGroup()
                            .addComponent(label5, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(scoresBtn, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(scoresLbl, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                        .addContainerGap())
            );
            scoresFrmContentPaneLayout.setVerticalGroup(
                scoresFrmContentPaneLayout.createParallelGroup()
                    .addGroup(scoresFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoresLbl, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoresBtn)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            scoresFrm.setSize(200, 200);
            scoresFrm.setLocationRelativeTo(null);
        }

        //======== avgFrm ========
        {
            avgFrm.setTitle("Averages");
            Container avgFrmContentPane = avgFrm.getContentPane();

            //---- avgLbl ----
            avgLbl.setText("text");
            avgLbl.setHorizontalAlignment(SwingConstants.CENTER);

            //---- avgBtn ----
            avgBtn.setText("Back");
            avgBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    avgBtnMouseClicked(e);
                }
            });

            GroupLayout avgFrmContentPaneLayout = new GroupLayout(avgFrmContentPane);
            avgFrmContentPane.setLayout(avgFrmContentPaneLayout);
            avgFrmContentPaneLayout.setHorizontalGroup(
                avgFrmContentPaneLayout.createParallelGroup()
                    .addGroup(avgFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(avgFrmContentPaneLayout.createParallelGroup()
                            .addComponent(avgBtn, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(avgLbl, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                        .addContainerGap())
            );
            avgFrmContentPaneLayout.setVerticalGroup(
                avgFrmContentPaneLayout.createParallelGroup()
                    .addGroup(avgFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(avgLbl, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avgBtn)
                        .addContainerGap())
            );
            avgFrm.setSize(200, 175);
            avgFrm.setLocationRelativeTo(null);
        }

        //======== cIDFrm ========
        {
            Container cIDFrmContentPane = cIDFrm.getContentPane();
            cIDFrmContentPane.setLayout(new GridLayout(2, 1));

            //---- cIDFld ----
            cIDFld.setText("Enter Course ID");
            cIDFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cIDFldMouseClicked(e);
                }
            });
            cIDFrmContentPane.add(cIDFld);

            //---- cIDBtn ----
            cIDBtn.setText("Done");
            cIDBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cIDBtnMouseClicked(e);
                }
            });
            cIDFrmContentPane.add(cIDBtn);
            cIDFrm.setSize(150, 95);
            cIDFrm.setLocationRelativeTo(null);
        }

        //======== cReportFrm ========
        {
            cReportFrm.setTitle("Course Report (Study Field \\ Entry Year)");
            Container cReportFrmContentPane = cReportFrm.getContentPane();

            //---- cReportCountLbl ----
            cReportCountLbl.setText("stu count");
            cReportCountLbl.setHorizontalAlignment(SwingConstants.CENTER);

            //---- cReportLbl ----
            cReportLbl.setText("text");
            cReportLbl.setHorizontalAlignment(SwingConstants.CENTER);

            //---- cReportBtn ----
            cReportBtn.setText("Back");
            cReportBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cReportBtnMouseClicked(e);
                }
            });

            GroupLayout cReportFrmContentPaneLayout = new GroupLayout(cReportFrmContentPane);
            cReportFrmContentPane.setLayout(cReportFrmContentPaneLayout);
            cReportFrmContentPaneLayout.setHorizontalGroup(
                cReportFrmContentPaneLayout.createParallelGroup()
                    .addGroup(cReportFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cReportFrmContentPaneLayout.createParallelGroup()
                            .addComponent(cReportCountLbl, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(cReportBtn, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(cReportLbl, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                        .addContainerGap())
            );
            cReportFrmContentPaneLayout.setVerticalGroup(
                cReportFrmContentPaneLayout.createParallelGroup()
                    .addGroup(cReportFrmContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cReportCountLbl, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cReportLbl, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cReportBtn)
                        .addContainerGap())
            );
            cReportFrm.setSize(350, 175);
            cReportFrm.setLocationRelativeTo(null);
        }

        //======== scoreFrm ========
        {
            scoreFrm.setTitle("Score");
            Container scoreFrmContentPane = scoreFrm.getContentPane();
            scoreFrmContentPane.setLayout(new GridLayout(4, 1));

            //---- idStudentFld ----
            idStudentFld.setText("enter student id");
            idStudentFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    idStudentFldMouseClicked(e);
                }
            });
            scoreFrmContentPane.add(idStudentFld);

            //---- scoreFld ----
            scoreFld.setText("enter score");
            scoreFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    scoreFldMouseClicked(e);
                }
            });
            scoreFrmContentPane.add(scoreFld);

            //---- courseIdFld ----
            courseIdFld.setText("enter course id");
            courseIdFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    courseIdFldMouseClicked(e);
                }
            });
            scoreFrmContentPane.add(courseIdFld);

            //---- scoreBtn ----
            scoreBtn.setText("Done");
            scoreBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    scoreBtnMouseClicked(e);
                }
            });
            scoreFrmContentPane.add(scoreBtn);
            scoreFrm.setSize(200, 175);
            scoreFrm.setLocationRelativeTo(null);
        }

        //======== removeFrame ========
        {
            removeFrame.setTitle("Remove");
            Container removeFrameContentPane = removeFrame.getContentPane();
            removeFrameContentPane.setLayout(new GridLayout(3, 1));

            //---- removeFld ----
            removeFld.setText("enter student id");
            removeFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    removeFldMouseClicked(e);
                }
            });
            removeFrameContentPane.add(removeFld);

            //---- removeFld2 ----
            removeFld2.setText("enter course id");
            removeFld2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    removeFld2MouseClicked(e);
                }
            });
            removeFrameContentPane.add(removeFld2);

            //---- removeButton ----
            removeButton.setText("Done");
            removeButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    removeBtnMouseClicked(e);
                    removeButtonMouseClicked(e);
                }
            });
            removeFrameContentPane.add(removeButton);
            removeFrame.setSize(200, 125);
            removeFrame.setLocationRelativeTo(null);
        }

        //======== srvyFrm ========
        {
            Container srvyFrmContentPane = srvyFrm.getContentPane();
            srvyFrmContentPane.setLayout(new GridLayout(2, 1));

            //---- srvyFld ----
            srvyFld.setText("Enter Course ID");
            srvyFld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    srvyFldMouseClicked(e);
                }
            });
            srvyFrmContentPane.add(srvyFld);

            //---- srvyBtn ----
            srvyBtn.setText("Done");
            srvyBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    srvyBtnMouseClicked(e);
                }
            });
            srvyFrmContentPane.add(srvyBtn);
            srvyFrm.setSize(150, 95);
            srvyFrm.setLocationRelativeTo(null);
        }

        //======== surveyFrm ========
        {
            surveyFrm.setTitle("Survey");
            Container surveyFrmContentPane = surveyFrm.getContentPane();
            surveyFrmContentPane.setLayout(new GridLayout(2, 1));

            //---- surveyLbl ----
            surveyLbl.setText("text");
            surveyLbl.setHorizontalAlignment(SwingConstants.CENTER);
            surveyFrmContentPane.add(surveyLbl);

            //---- surveyBtn ----
            surveyBtn.setText("Back");
            surveyBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    surveyBtnMouseClicked(e);
                }
            });
            surveyFrmContentPane.add(surveyBtn);
            surveyFrm.setSize(200, 100);
            surveyFrm.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JFrame mainFrame;
    private JButton studentButton;
    private JButton noticeButton;
    private JDialog studentFrame;
    private JButton selectButton;
    private JButton rmvButton;
    private JButton payButton;
    private JButton lessonButton;
    private JButton unitButton;
    private JButton scoreButton;
    private JButton averageButton;
    private JButton backBtn1;
    private JDialog teacherFrame;
    private JButton buttonLesson;
    private JButton buttonInsert;
    private JButton buttonIncome;
    private JButton buttonRemove;
    private JButton buttonNum;
    private JButton buttonEvaluation;
    private JButton backBtn2;
    private JDialog logFrame;
    private JTextField usernameField;
    private JTextField passField;
    private JButton enterButton;
    private JDialog employeeFrame;
    private JButton button6;
    private JButton button7;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton backBtn3;
    private JDialog noticeFrame;
    private JLabel noticeLbl;
    private JButton backBtn4;
    private JDialog logErrorDialog;
    private JLabel logErrorText;
    private JFrame rmvFrm;
    private JLabel infoLbl2;
    private JLabel rmvLbl;
    private JTextField rmvFld;
    private JButton backBtn5;
    private JButton rmvBtn;
    private JLabel label2;
    private JDialog dialog;
    private JLabel dialogLabel;
    private JFrame addFrm;
    private JLabel infoLbl3;
    private JLabel addLbl;
    private JTextField addFld;
    private JButton backBtn6;
    private JButton addBtn;
    private JLabel label3;
    private JFrame recordFrm;
    private JTextField hourFld;
    private JTextField dateFld;
    private JButton recordBtn;
    private JFrame loanFrm;
    private JButton loan1Btn;
    private JButton loan2Btn;
    private JFrame registerFrm;
    private JTextField registerFld;
    private JButton registerBtn;
    private JFrame saveFrm;
    private JTextField suFld;
    private JTextField spFld;
    private JTextField seFld;
    private JButton sdBtn;
    private JDialog tuitionFrm;
    private JLabel tuitionLbl;
    private JButton tuitionBtn;
    private JFrame reportFrm;
    private JLabel label1;
    private JLabel reportLbl;
    private JButton reportBtn;
    private JFrame tReportFrm;
    private JLabel label4;
    private JLabel tReportLbl;
    private JButton tchReportBtn;
    private JFrame failFrm;
    private JLabel passLbl;
    private JButton failBtn;
    private JLabel label6;
    private JLabel label7;
    private JLabel failLbl;
    private JFrame scoresFrm;
    private JLabel label5;
    private JLabel scoresLbl;
    private JButton scoresBtn;
    private JFrame avgFrm;
    private JLabel avgLbl;
    private JButton avgBtn;
    private JFrame cIDFrm;
    private JTextField cIDFld;
    private JButton cIDBtn;
    private JFrame cReportFrm;
    private JLabel cReportCountLbl;
    private JLabel cReportLbl;
    private JButton cReportBtn;
    private JFrame scoreFrm;
    private JTextField idStudentFld;
    private JTextField scoreFld;
    private JTextField courseIdFld;
    private JButton scoreBtn;
    private JFrame removeFrame;
    private JTextField removeFld;
    private JTextField removeFld2;
    private JButton removeButton;
    private JFrame srvyFrm;
    private JTextField srvyFld;
    private JButton srvyBtn;
    private JFrame surveyFrm;
    private JLabel surveyLbl;
    private JButton surveyBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}