package jums;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

/**
 * ユーザー情報を持ちまわるJavaBeans データベースのカラムと型に対応させている(DTO)。データの挿入、取り出しどちらにも便利
 *
 * @version 1.00
 * @author hayashi-s
 */
public class UserDataDTO implements Serializable {

    private int userID;
    private String name;
    private Date birthday;
    private String tell;
    private int type;
    private String comment;
    private Timestamp newDate;

    public UserDataDTO(){}

    //UserID
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    //Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Birthday
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //Tell
    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    //Type
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    //Comment
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //Date
    public Timestamp getNewDate() {
        return newDate;
    }

    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }

}
