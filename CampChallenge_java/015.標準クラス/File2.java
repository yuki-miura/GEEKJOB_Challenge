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

public class File2 {
    public static void main(String[] args){
        try{
            //Fileインスタンスを作成
            File me = new File("self introduce");
            //FileReaderを生成
            FileReader fr = new FileReader(me);
            //BufferedReaderを生成
            BufferedReader br = new BufferedReader(fr);
            //Fileを出力
            System.out.print(br.readLine());
            
        }catch(Exception ex){
    }
    } 
}
