package com.data.yibsi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Interact extends JFrame {

    public JFrame frame;
    JPanel buttonLayout;
    Deck deck = null;
    Deck selectDeck = null;
    DeckFrame deckFrame;
    List<JButton> buttonList;

    public Interact(Deck deck) { //o(n)

        this.deck = deck;
        selectDeck = new Deck(); //o(n)

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(6*100,6*149);
        this.setMinimumSize(new Dimension(6*100,6*149));
        this.setMaximumSize(new Dimension(6*100, 6*149));

        buttonLayout = new JPanel();
        buttonLayout.setSize(6*100,6*149);
        buttonLayout.setMinimumSize(new Dimension(6*100,6*149));
        buttonLayout.setMaximumSize(new Dimension(6*100, 6*149));

        this.addButton(); //o(n)
        this.add(buttonLayout);

        //this.setVisible(true);

    }

    public void setDeckFrame(DeckFrame deckFrame){
        this.deckFrame = deckFrame;
    }

    public void resetFrame(){ //o(n)
        buttonLayout.removeAll();
        this.addButton(); //o(n)
        deckFrame.setVisible(false);
        this.setVisible(true);
        this.selectDeck = new Deck(); //o(n)
    }

    private void addButton() { //o(n)

        buttonLayout.setLayout(new GridLayout(0, 5));
        this.deck.shuffle();
        buttonList = new ArrayList<JButton>();
        for (Card card: //o(n)
             this.deck.deck) {
            JButton button = new JButton();
            button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/b2.png").getFile()));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //System.out.println(deck.get(index).name);
                    Interact.this.deck.selectCard(card, selectDeck);
                    JButton button = (JButton) e.getSource();
                    if(card.getStatus()==0){
                        card.setStatus(1);
                        button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/b1.png").getFile()));
                    }else{
                        card.setStatus(0);
                        button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/b2.png").getFile()));
                    }

                }
            });
            button.setSize(100,149);
            button.setMinimumSize(new Dimension(100,149));
            button.setMaximumSize(new Dimension(100, 149));
            buttonList.add(button);
            buttonLayout.add(button);
        } // Adds Button to content pane of frame

        JButton thinkButton = new JButton("Think");
        thinkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(selectDeck.deck.size() == 4) {
                    deckFrame.showDeck(selectDeck); //o(n)
                }else if(selectDeck.deck.size() > 4) {
                    JOptionPane.showMessageDialog(null,String.format("You over selected %d card",selectDeck.deck.size()-4));
                }else {
                    JOptionPane.showMessageDialog(null,String.format("You need to select another %d more card",4-selectDeck.deck.size()));
                }
            }
        });
        buttonLayout.add(thinkButton);
    }
}
