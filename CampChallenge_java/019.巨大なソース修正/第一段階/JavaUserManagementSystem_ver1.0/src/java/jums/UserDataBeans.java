package jums;

import java.io.Serializable;

/**
 *
 * @author guest1Day
 */
public class UserDataBeans implements Serializable {

    public UserDataBeans() {
    }

    private String name = "";
    private String year = "";
    private String month = "";
    private String day = "";
    private String tell = "";
    private String type = "";
    private String comment = "";

    //getter
    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }
    
    public int getMonth1(){
        return Integer.parseInt(month);
    }

    public String getDay() {
        return day;
    }

    public String getType() {
        return type;
    }

    public String getTell() {
        return tell;
    }

    public String getComment() {
        return comment;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setType(String type) {
       this.type = type;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
