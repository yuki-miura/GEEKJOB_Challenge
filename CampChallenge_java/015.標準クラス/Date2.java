/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */

import java.util.Date;
import java.text.SimpleDateFormat;

public class Date2 {
    public static void main(String[] args){
        //今日の日付作成
        Date now = new Date();
        //SimpleDateFormat作成
        //年-月-日　時:分:秒を設定
        SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //現在時間を表示
        System.out.print(a.format(now));
    }
}
