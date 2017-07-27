/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class String3 {

    public static void main(String[] args) {
        String retu = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        //「I」を「い」に入れ替え
        String a = retu.replace("I", "い");
        //「U」を「う」に入れ替え
        String b = a.replace("U", "う");
        System.out.print(b);

    }

}
