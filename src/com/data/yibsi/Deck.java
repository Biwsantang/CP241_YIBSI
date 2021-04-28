package com.data.yibsi;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    LinkedList<Card> deck = new LinkedList<>();

    public Deck(int i){ //o(n)
        try {
            this.cardXml(); //o(n)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Deck(){

    }

    //o(n)
    public void cardXml() throws Exception { //o(n)
            Xml xml = new Xml();
            String[][] read = xml.readXml(); //o(n)
            for (String[] card: //o(n)
                    read) {
                addCard(card[0],card[1],card[2]);
            }
    }
    public void addCard(String name,String meaning,String image){
        Card card = new Card(name,meaning,image);
        deck.add(card);
    }

    public void addCard(Card card){
        addCard(card.getName(),card.getMeaning(),card.getImage());
    }

    public void selectCard(Card card,Deck selectDeck) {
        if(selectDeck.deck.contains(card)){
            selectDeck.deck.remove(card);
        }else {
            selectDeck.deck.add(card);
        }
        System.out.println(selectDeck.deck.toString());
    }

    public void shuffle(){
        Collections.shuffle(this.deck);
    }

}
