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

    }

    public void addCard(Card card) {
        cardList.add(card);
        add(card);
        revalidate(); // tells layout manager to recalculate
        repaint(); // redraws the panel
    }


}
