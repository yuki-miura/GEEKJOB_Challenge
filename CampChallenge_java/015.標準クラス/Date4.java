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
import java.util.Date;

public class Date4 {
    public static void main(String[] args){
        //Calendarインスタンスを作成
        Calendar a = Calendar.getInstance();
        //2015年12月31日23時59分59秒をセット
        a.set(2015,11,31,23,59,59);                
        //Date型に変換
        Date c = a.getTime();
        System.out.println(c.getTime());
        
        //Calendarインスタンスの生成
        Calendar b = Calendar.getInstance();
        //2015年1月1日00時00分00秒をセット
        b.set(2015,00,01,00,00,00);
        //Date型に変換
        Date d = b.getTime();
        System.out.println(d.getTime());
        
        //Date cとDate dの差を表示
        System.out.println(c.getTime() - d.getTime());
        
    } 
    
}
