package com.data.yibsi;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckFrame extends JFrame {

    Interact interact;
    JPanel deckList;
    JScrollPane scrollFrame;

    public DeckFrame(Interact interact) {

        this.interact = interact;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deckList = new JPanel();
        deckList.setLayout(new BorderLayout());
        scrollFrame = new JScrollPane(deckList);
        scrollFrame.getVerticalScrollBar().setUnitIncrement(16);

        deckList.setAutoscrolls(true);
        this.add(scrollFrame);
        this.repaint();
    }

    public void showDeck(Deck deck){ //o(n)
        deckList.removeAll();
        Panel leftPanel = new Panel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension( 150,deck.deck.size()*258);
            }
        };
        Panel RightPanel = new Panel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200,deck.deck.size()*258);
            }
        };
        leftPanel.setLayout(new GridLayout(0,1));
        RightPanel.setLayout(new GridLayout(0,1));
        for (Card card: //o(n)
                deck.deck) {
            JLabel name = new JLabel();
            name.setIcon(new ImageIcon(getClass().getClassLoader().getResource(card.getImage()).getFile()));

            JLabel meaning = new JLabel(card.toHTMLString());

            leftPanel.add(name);
            RightPanel.add(meaning);
        }
        deckList.add(leftPanel, BorderLayout.WEST);
        deckList.add(RightPanel, BorderLayout.CENTER);
        JButton rerun = new JButton("Play");
        rerun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                interact.resetFrame();
            }
        });
        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DeckFrame.this.setSize(DeckFrame.this.getWidth()+40,DeckFrame.this.getHeight());
                DeckFrame.this.setSize(DeckFrame.this.getWidth()-40,DeckFrame.this.getHeight());
            }
        });
        JPanel button = new JPanel();
        button.add(rerun);
        button.add(refresh);
        this.add(button,BorderLayout.SOUTH);
        interact.setVisible(false);

        deckList.setPreferredSize(new Dimension(500,deck.deck.size()*258));
        scrollFrame.setPreferredSize(new Dimension(500,4*258));

        this.setSize(500,4*258+10);
        this.setMinimumSize(new Dimension(500,4*258+10));
        this.setMaximumSize(new Dimension(500, 4*258+10));
        this.setVisible(true);
        this.repaint();

    }
}
