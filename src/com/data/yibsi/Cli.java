package com.data.yibsi;

import java.util.ArrayList;
import java.util.Scanner;

public class Cli {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        Deck deck = null;
        try {
            deck = new Deck();
            deck.cardXml();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        Deck selectDeck = new Deck();
        while(true){
            String input = sc.nextLine();
            if(input == null || input.length()==0){
                break;
            }else if(Integer.parseInt(input) >= deck.deck.size()) {
                System.out.println("not have that card you select");
                continue;
            }
            int index;
            try {
                index = Integer.parseInt(input);
            } catch (Exception e){
                break;
            }
            if(selectDeck.deck.contains(deck.deck.get(index))){
                selectDeck.deck.remove(deck.deck.get(index));
            }else {
                selectDeck.deck.add(deck.deck.get(index));
            }
            System.out.println(selectDeck.deck.toString());
        }

    }
}
