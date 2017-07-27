/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
import java.io.*;

public class File1 {

    public static void main(String[] args) {
        try {
            //Fileインスタンスを作成
            File me = new File("self introduce");
            //FileWriterを生成
            FileWriter fw = new FileWriter(me);
            //ファイルに自己紹介を書き込み
            fw.write("遠からんものは音に聞け、近くば寄って目にも見よ！三浦優輝です");
            //ファイルを閉じる
            fw.close();
        } catch (Exception ex) {

        }

    }

}
