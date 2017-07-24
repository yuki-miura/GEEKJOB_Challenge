/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuki
 */

public class Class2 {
   
    //パブリックな2つの変数を宣言
    public String name = "";
    public int age = 0; 
    
    //2つの変数に値を設定するパブリックなメソッド
    public void setHuman(){
        name = "田中";
        age = 60;
    }
    //2つの変数をprintするパブリックなメソッド
    public void printOut(){
        System.out.print(name +"<br>" +age);
    }
    
}
//上記のクラスを継承
//2つの変数の中身をクリアするパブリックなメソッド
class class1 extends Class2 {
    public void clear(){
        name = "";
        age = 0;
    }
    
}
