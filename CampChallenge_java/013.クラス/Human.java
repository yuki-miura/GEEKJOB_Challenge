/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;

/**
 *
 * @author yuki
 */
public abstract class Human {

    //手札の合計を確認
    abstract public int open();

    //山札からカードを補充して手札に加える    
    abstract public void setCard(ArrayList<Integer> set);

    //設定した基準に基づき判断する    
    abstract public boolean checkSum();

    //手札
    ArrayList<Integer> myCards = new ArrayList<Integer>();

}
