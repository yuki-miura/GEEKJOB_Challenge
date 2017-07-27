/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.*;

/**
 *
 * @author yuki
 */
class Dealer extends Human {

    ArrayList<Integer> cards = new ArrayList<Integer>();

    //52枚の山札を作成
    public Dealer() {
        for (int i = 1; i <= 4; i++) {
            for (int x = 1; x <= 13; x++) {
                if (x >= 10) {
                    cards.add(10);
                } else {
                    cards.add(x);
                }
            }
        }
    }

    public ArrayList<Integer> deal() {

        //山札から2枚引いてArrayListにセット
        ArrayList<Integer> dealCard = new ArrayList<Integer>();
        Random rand = new Random();

        //乱数番目の要素をdealCardに2枚セット
        for (int i = 0; i < 2; i++) {
            //乱数をcardsの枚数に設定
            int index = rand.nextInt(cards.size());
            dealCard.add(cards.get(index));
            cards.remove(index);
        }

        //2枚カードがセットされたArrayListを返却
        return dealCard;
    }

    public ArrayList<Integer> hit() {

        //山札から1枚引いてArrayListにセット
        ArrayList<Integer> hitCard = new ArrayList<Integer>();
        Random rand = new Random();
        int index1 = rand.nextInt(cards.size());

        //引いたカードをhitCardにセット
        hitCard.add(cards.get(index1));

        //引いたカードを山札から排除
        cards.remove(index1);

        return hitCard;
    }

    //手札を合計する
    @Override
    public int open() {
        int y = 0;
        for (int i = 0; i < myCards.size(); i++) {
            y += myCards.get(i);
        }
        return y;
    }

    //入手たカードの値をmyCardsにセット
    @Override
    public void setCard(ArrayList<Integer> set) {
        for (int i = 0; i < set.size(); i++) {
            myCards.add(set.get(i));
        }
    }

    //Openの合計が17以下ならhitする
    @Override
    public boolean checkSum() {
        int total = open();
        return total < 17;
    }

}
