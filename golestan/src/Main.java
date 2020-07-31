import employees.Repository;
import notices.Entity;
import notices.Service;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> usernames = new ArrayList<>();
    public static List<String> passes = new ArrayList<>();
    public static void main(String[] args) {
        try {
//            Service.getInstance().save(new Entity().setId(1).setNotice("كليه دانشجويان لازم است كارت امتحانات پايان ترم(گزارش 428) را از تاريخ 12 تير به بعد مشاهده و اخذ نمايند."));
//            Service.getInstance().save(new Entity().setId(2).setNotice("تاريخ شركت در ارزشيابی و نظرسنجی از روز شنبه مورخ ۸ لغايت ۱۲ تیر می باشد."));
//            Thread.sleep(10);
//            Service.getInstance().save(new Entity().setId(3).setNotice("لازم است كليه دانشجويان ميهمان جهت شركت در كلاسهاي غير حضوري نسبت به تكميل اطلاعات از منوي آموزش: مشخصات دانشجو: تكميل و تاييد اطلاعات شخصي دانشجو اقدام فرمايند."));
//            employees.Service.getInstance().save(new employees.Entity().setId(1).setusername("e1").setPass("1").setName("q").setAge(51).setJob("Monshi").setSalary("1000000").setEducation("diplom").setImputation(""));
//            Thread.sleep(10);
//            employees.Service.getInstance().save(new employees.Entity().setId(2).setusername("e2").setPass("2").setName("w").setAge(21).setJob("Modir Goroh").setSalary("1500000").setEducation("lisans").setImputation(""));
//            students.Service.getInstance().save(new students.Entity().setId(1).setusername("s1").setPass("1").setName("a").setYear(98).setField("Computer Engineering").setTuition("500000").setPayment("0").setTermNum(1));
//            Thread.sleep(10);
//            students.Service.getInstance().save(new students.Entity().setId(2).setusername("s2").setPass("2").setName("s").setYear(97).setField("Electrical Engineering").setTuition("500000").setPayment("100000").setTermNum(2));
//            students.Service.getInstance().save(new students.Entity().setId(3).setusername("s3").setPass("3").setName("d").setYear(96).setField("Mechanical Engineering").setTuition("500000").setPayment("250000").setTermNum(3));
//            Thread.sleep(10);
//            students.Service.getInstance().save(new students.Entity().setId(4).setusername("s4").setPass("4").setName("f").setYear(98).setField("Industrial Engineering").setTuition("500000").setPayment("500000").setTermNum(1));
//            students.Service.getInstance().save(new students.Entity().setId(5).setusername("s5").setPass("5").setName("g").setYear(97).setField("Computer Engineering").setTuition("400000").setPayment("0").setTermNum(2));
//            Thread.sleep(10);
//            students.Service.getInstance().save(new students.Entity().setId(6).setusername("s6").setPass("6").setName("h").setYear(96).setField("Electrical Engineering").setTuition("400000").setPayment("100000").setTermNum(3));
//            students.Service.getInstance().save(new students.Entity().setId(7).setusername("s7").setPass("7").setName("j").setYear(98).setField("Mechanical Engineering").setTuition("400000").setPayment("250000").setTermNum(1));
//            Thread.sleep(10);
//            students.Service.getInstance().save(new students.Entity().setId(8).setusername("s8").setPass("8").setName("k").setYear(97).setField("Industrial Engineering").setTuition("400000").setPayment("500000").setTermNum(2));
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(1).setTermid(98).setCourseid(1).setFail("no"));
//            Thread.sleep(10);
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(2).setTermid(98).setCourseid(1).setFail("no"));
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(2).setTermid(97).setCourseid(1).setFail("yes"));
//            Thread.sleep(10);
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(3).setTermid(98).setCourseid(2).setFail("no"));
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(3).setTermid(97).setCourseid(2).setFail("yes"));
//            Thread.sleep(10);
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(3).setTermid(96).setCourseid(1).setFail("no"));
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(4).setTermid(98).setCourseid(2).setFail("no"));
//            Thread.sleep(10);
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(5).setTermid(98).setCourseid(3).setFail("no"));
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(5).setTermid(97).setCourseid(3).setFail("yes"));
//            Thread.sleep(10);
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(6).setTermid(98).setCourseid(3).setFail("no"));
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(6).setTermid(97).setCourseid(3).setFail("yes"));
//            Thread.sleep(10);
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(6).setTermid(96).setCourseid(2).setFail("no"));
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(7).setTermid(98).setCourseid(4).setFail("yes"));
//            Thread.sleep(10);
//            stuinfo.Service.getInstance().save(new stuinfo.Entity().setStuid(8).setTermid(98).setCourseid(4).setFail("yes"));
//            teachers.Service.getInstance().save(new teachers.Entity().setId(1).setusername("t1").setPass("1").setName("z").setSalary("1000000"));
//            Thread.sleep(10);
//            teachers.Service.getInstance().save(new teachers.Entity().setId(2).setusername("t2").setPass("2").setName("x").setSalary("800000"));
//            courses.Service.getInstance().save(new courses.Entity().setTermid(96).setCrsid(1).setTchid(1).setName("Programming").setRequirements(" ").setTime("Saturday 8-11").setPlace(1).setSalary("500000").setSurvey(5));
//            Thread.sleep(10);
//            courses.Service.getInstance().save(new courses.Entity().setTermid(96).setCrsid(2).setTchid(1).setName("Programming").setRequirements(" ").setTime("Sunday 8-11").setPlace(1).setSalary("500000").setSurvey(4));
//            courses.Service.getInstance().save(new courses.Entity().setTermid(96).setCrsid(3).setTchid(2).setName("Math 2").setRequirements("Math 1").setTime("Monday 10-12").setPlace(2).setSalary("400000").setSurvey(4));
//            Thread.sleep(10);
//            courses.Service.getInstance().save(new courses.Entity().setTermid(96).setCrsid(4).setTchid(2).setName("Math 2").setRequirements("Math 1").setTime("Monday 2-4").setPlace(2).setSalary("400000").setSurvey(3));
//            courses.Service.getInstance().save(new courses.Entity().setTermid(97).setCrsid(1).setTchid(1).setName("Programming").setRequirements(" ").setTime("Saturday 8-11").setPlace(1).setSalary("500000").setSurvey(4));
//            Thread.sleep(10);
//            courses.Service.getInstance().save(new courses.Entity().setTermid(97).setCrsid(2).setTchid(1).setName("Programming").setRequirements(" ").setTime("Sunday 8-11").setPlace(1).setSalary("500000").setSurvey(3));
//            courses.Service.getInstance().save(new courses.Entity().setTermid(97).setCrsid(3).setTchid(2).setName("Math 2").setRequirements("Math 1").setTime("Monday 10-12").setPlace(2).setSalary("400000").setSurvey(3));
//            Thread.sleep(10);
//            courses.Service.getInstance().save(new courses.Entity().setTermid(97).setCrsid(4).setTchid(2).setName("Math 2").setRequirements("Math 1").setTime("Monday 2-4").setPlace(2).setSalary("400000").setSurvey(2));
//            courses.Service.getInstance().save(new courses.Entity().setTermid(98).setCrsid(1).setTchid(1).setName("Programming").setRequirements(" ").setTime("Saturday 8-11").setPlace(1).setSalary("500000").setSurvey(5));
//            Thread.sleep(10);
//            courses.Service.getInstance().save(new courses.Entity().setTermid(98).setCrsid(2).setTchid(1).setName("Programming").setRequirements(" ").setTime("Sunday 8-11").setPlace(1).setSalary("500000").setSurvey(4));
//            courses.Service.getInstance().save(new courses.Entity().setTermid(98).setCrsid(3).setTchid(2).setName("Math 2").setRequirements("Math 1").setTime("Monday 10-12").setPlace(2).setSalary("400000").setSurvey(4));
//            Thread.sleep(10);
//            courses.Service.getInstance().save(new courses.Entity().setTermid(98).setCrsid(4).setTchid(2).setName("Math 2").setRequirements("Math 1").setTime("Monday 2-4").setPlace(2).setSalary("400000").setSurvey(3));
//            crsinfo.Service.getInstance().save(new crsinfo.Entity().setCrsid(1).setStuid(1).setAbsence(0).setScore(20));
//            Thread.sleep(10);
//            crsinfo.Service.getInstance().save(new crsinfo.Entity().setCrsid(1).setStuid(2).setAbsence(1).setScore(18));
//            crsinfo.Service.getInstance().save(new crsinfo.Entity().setCrsid(2).setStuid(3).setAbsence(1).setScore(16));
//            Thread.sleep(10);
//            crsinfo.Service.getInstance().save(new crsinfo.Entity().setCrsid(2).setStuid(4).setAbsence(2).setScore(14));
//            crsinfo.Service.getInstance().save(new crsinfo.Entity().setCrsid(3).setStuid(5).setAbsence(2).setScore(12));
//            Thread.sleep(10);
//            crsinfo.Service.getInstance().save(new crsinfo.Entity().setCrsid(3).setStuid(6).setAbsence(3).setScore(10));
//            crsinfo.Service.getInstance().save(new crsinfo.Entity().setCrsid(4).setStuid(7).setAbsence(0).setScore(8));
//            Thread.sleep(10);
//            crsinfo.Service.getInstance().save(new crsinfo.Entity().setCrsid(4).setStuid(8).setAbsence(1).setScore(6));
            employees.Service.getInstance().report();
            students.Service.getInstance().report();
            teachers.Service.getInstance().report();
            usernames.addAll(Repository.usernames);
            usernames.addAll(students.Repository.usernames);
            usernames.addAll(teachers.Repository.usernames);
            passes.addAll(Repository.passes);
            passes.addAll(students.Repository.passes);
            passes.addAll(teachers.Repository.passes);
        } catch (Exception e) {
            System.out.println("failed to save " + e.getMessage());
        }
        GolestanForm golestanForm = new GolestanForm();
    }
}
/*
create table notices (id number, notice varchar2(300));
create table employees (id number, username varchar2(4), pass varchar2(4), name varchar2(4), age number, job varchar2(15), salary varchar2(8), education varchar2(10), imputation varchar2(50));
create table students (id number, username varchar2(4), pass varchar2(4), name varchar2(4), year number, field varchar2(25), tuition varchar2(7), payment varchar2(7), termNum number);
create table stuinfo (stuid number, termid number, courseid number, fail varchar2(4));
create table teachers (id number, username varchar2(4), pass varchar2(4), name varchar2(4), salary varchar2(8));
create table courses (termid number, crsid number, tchid number, name varchar2(25), requirements varchar2(12), time varchar2(13), place number, salary varchar2(7), survey number);
create table crsinfo (crsid number, stuid number, absence number, score number);

drop table notices;
drop table employees;
drop table students;
drop table stuinfo;
drop table teachers;
drop table courses;
drop table crsinfo;

select * from notices;
select * from employees;
select * from students;
select * from stuinfo;
select * from teachers;
select * from courses;
select * from crsinfo;

*/