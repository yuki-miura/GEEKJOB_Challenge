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
class User extends Human {

    @Override
    public int open() {
        int y = 0;
        for (int i = 0; i < myCards.size(); i++) {
            y += myCards.get(i);
        }
        return y;

    }

    @Override
    public void setCard(ArrayList<Integer> set) {
        for (int i = 0; i < set.size(); i++) {
            myCards.add(set.get(i));
        }
    }

    @Override
    public boolean checkSum() {

        int total = open();
        return total < 17;

    }
}
