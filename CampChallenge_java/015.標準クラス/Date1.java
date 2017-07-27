/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
import java.util.Calendar;

public class Date1 {

    public static void main(String[] args) {

        //Carendarインスタンスの生成
        Calendar a = Calendar.getInstance();
        //インスタンスに2016年1月1日1時1分1秒をセット
        a.set(2016, 0, 1, 01, 01, 01);
        //Calendar　aを表示
        System.out.print(a.getTime());

    }
}
