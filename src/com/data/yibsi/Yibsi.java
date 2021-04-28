package com.data.yibsi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Yibsi extends JFrame{

    Interact interact;
    DeckFrame deckFrame;

    Deck deck = null;

    public static void main(String[] args){

        Yibsi yibsi = new Yibsi(); //o(n)

    }

    public Yibsi() { //o(n)
            deck = new Deck(1); //o(n)

        interact = new Interact(deck); //o(n)
        deckFrame = new DeckFrame(interact);

        interact.setDeckFrame(deckFrame);

        JPanel frame = new JPanel();

        frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
        //frame.setSize(200,400);

        JLabel name = new JLabel("Yibsi");
        JLabel version = new JLabel("Version 1.0.0");
        JLabel by = new JLabel("By");
        JLabel f = new JLabel("ปริวัตร รัตนปรารมย์");
        JLabel b = new JLabel("วรากร แซ่ตั้ง");
        JLabel m = new JLabel("จิรายุ พรศิริอนันต์");
        //name.setSize(200,100);

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(deck.get(index).name);
                interact.setVisible(true);
                Yibsi.this.setVisible(false);
            }
        });

        JButton cardButton = new JButton("Card");
        cardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deckFrame.showDeck(new Deck(1)); //o(n)
                Yibsi.this.setVisible(false);
            }
        });

        name.setAlignmentX(CENTER_ALIGNMENT);
        version.setAlignmentX(CENTER_ALIGNMENT);
        by.setAlignmentX(CENTER_ALIGNMENT);
        f.setAlignmentX(CENTER_ALIGNMENT);
        b.setAlignmentX(CENTER_ALIGNMENT);
        m.setAlignmentX(CENTER_ALIGNMENT);
        playButton.setAlignmentX(CENTER_ALIGNMENT);
        cardButton.setAlignmentX(CENTER_ALIGNMENT);

        frame.add(Box.createVerticalGlue());
        frame.add(name);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(version);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(by);
        frame.add(f);
        frame.add(b);
        frame.add(m);
        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(playButton);
        frame.add(Box.createRigidArea(new Dimension(0, 5)));
        frame.add(cardButton);
        frame.add(Box.createVerticalGlue());

        this.add(frame);

        this.setSize(300,400);
        this.setPreferredSize(new Dimension(200,400));

        this.setVisible(true);
    }
}
