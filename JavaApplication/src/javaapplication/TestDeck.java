/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import java.util.List;

/**
 *
 * @author INT303
 */
public class TestDeck {

    public static void main(String[] args) {
        Deck d = new Deck();
        d.randomOrder();
        for (int i = 0; i < 10; i++) {
            List<Card> cardOnhands = d.getCardsOnHand(2);
            int value = cardOnhands.get(0).getValue() + cardOnhands.get(1).getValue();
            String pok = (value % 10 == 8 || value % 10 == 9 ? " -> POK" : "");
            System.out.println("[" + i + "] " + cardOnhands + pok);
        }
        System.out.println("--------------------");
        System.out.println(d.getCards());
    }
}
