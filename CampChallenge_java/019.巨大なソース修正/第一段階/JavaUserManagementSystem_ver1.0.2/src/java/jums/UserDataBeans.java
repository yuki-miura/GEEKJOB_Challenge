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

    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //year
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        if (!(year.equals(null))) {
            this.year = year;
        } else {
            this.year = "";
        }
    }

    //month
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        if (!(month.equals(null))) {
            this.month = month;
        } else {
            this.month = "";
        }
    }

    //day
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        if (!(day.equals(null))) {
            this.day = day;
        } else {
            this.day = "";
        }
    }

    //type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //tell
    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    //comment
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
