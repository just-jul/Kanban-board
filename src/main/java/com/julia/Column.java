package com.julia;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Column extends JPanel {
    ArrayList<Card> cardList;
    ColorEnum color;


    public Column(ColorEnum color) {
        this.cardList = new ArrayList<>();
        setBackground(color.toColor());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(100, 500));
        setBorder(BorderFactory.createEmptyBorder(20, 6, 20, 6)); // padding around the edges of the column
    }

    public void addCard(Card card) {
        cardList.add(card);
        add(card);
        add(Box.createRigidArea(new Dimension(0, 8))); // 8px gap after each card
        revalidate(); // tells layout manager to recalculate
        repaint(); // redraws the panel
    }
    public void deleteCard(Card card){
        cardList.remove(card);
        remove(card);
        revalidate();
        repaint();
    }
    public ColorEnum getBackgroundColor(){
        return this.color;
    }


}
