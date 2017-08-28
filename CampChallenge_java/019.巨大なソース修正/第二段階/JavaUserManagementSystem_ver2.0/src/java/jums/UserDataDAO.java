package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する DB接続系はDBManagerクラスに一任 基本的にはやりたい1種類の動作に対して1メソッド
 *
 * @author hayashi-s
 */
public class UserDataDAO {

    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance() {
        return new UserDataDAO();
    }

    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void insert(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /**
     * データの検索処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ArrayList<UserDataDTO> uddArray = new ArrayList<UserDataDTO>();
        try {
            con = DBManager.getConnection();

            String sql = "SELECT * FROM user_t";

            //変数でsql文のセット位置を調整。iはBirthday用、ｊはType用の変数
            int i = 1;
            int j = 1;

            if (!ud.getName().equals("") || ud.getBirthday() != null || ud.getType() != 0) {
                boolean flag = false;

                if (!ud.getName().equals("")) {
                    sql += " WHERE name like ?";
                    flag = true;
                    i++;
                    j++;
                }

                if (ud.getBirthday() != null) {
                    if (!flag) {
                        sql += " WHERE birthday like ?";
                    } else {
                        sql += " AND birthday like ?";
                        j++;
                    }
                }

                if (ud.getType() != 0) {
                    if (!flag) {
                        sql += " WHERE type like ?";
                    } else {
                        sql += " AND type like ?";
                    }
                }

                st = con.prepareStatement(sql);

                if (!ud.getName().equals("")) {
                    st.setString(1, "%" + ud.getName() + "%");
                }

                if (ud.getBirthday() != null) {
                    st.setString(i, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");

                }

                if (ud.getType() != 0) {
                    st.setInt(j, ud.getType());
                }

                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    UserDataDTO resultUd = new UserDataDTO();
                    resultUd.setUserID(rs.getInt(1));
                    resultUd.setName(rs.getString(2));
                    resultUd.setBirthday(rs.getDate(3));
                    resultUd.setTell(rs.getString(4));
                    resultUd.setType(rs.getInt(5));
                    resultUd.setComment(rs.getString(6));
                    resultUd.setNewDate(rs.getTimestamp(7));
                    uddArray.add(resultUd);
                }

            } else {

                st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    UserDataDTO resultUd = new UserDataDTO();
                    resultUd.setUserID(rs.getInt(1));
                    resultUd.setName(rs.getString(2));
                    resultUd.setBirthday(rs.getDate(3));
                    resultUd.setTell(rs.getString(4));
                    resultUd.setType(rs.getInt(5));
                    resultUd.setComment(rs.getString(6));
                    resultUd.setNewDate(rs.getTimestamp(7));
                    uddArray.add(resultUd);
                }
            }
            System.out.println("search completed");

            return uddArray;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();

            String sql = "SELECT * FROM user_t WHERE userID = ?";

            st = con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());

            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));

            System.out.println("searchByID completed");

            return resultUd;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /**
     * データの削除処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void delete(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            String sql = "DELETE FROM user_t WHERE userID = ?";

            st = con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            int i = st.executeUpdate();

            if (i == 0) {//削除失敗時のフォロー
                throw new Exception("削除に失敗しました。");
            }

        } catch (SQLException e_sql) {
            System.out.println(e_sql.getMessage());
            throw new SQLException(e_sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * データの更新処理を行う。現在時刻は挿入直前に生成
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void update(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            String sql = "UPDATE user_t SET name=?,birthday=?,tell=?,type=?,comment=?,newDate=? WHERE userID = ?";

            st = con.prepareStatement(sql);
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, ud.getUserID());

            int i = st.executeUpdate();
            if (i == 0) {//更新失敗時のフォロー
                throw new Exception("更新に失敗しました。");
            }
            
        } catch (SQLException e_sql) {
            System.out.println(e_sql.getMessage());
            throw new SQLException(e_sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
