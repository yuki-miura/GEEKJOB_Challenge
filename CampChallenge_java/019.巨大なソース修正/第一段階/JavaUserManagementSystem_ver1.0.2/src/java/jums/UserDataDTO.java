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

    public UserDataDTO() {
    }

    private int userID;
    private String name;
    private Date birthday;
    private String tell;
    private int type;
    private String comment;
    private Timestamp newDate;

    //ID
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //birthday
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //tell
    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    //type
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //comment
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //newDate
    public Timestamp getNewDate() {
        return newDate;
    }

    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }

}
