package com.julia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App extends JFrame implements ActionListener {

    // main container
    JPanel container = new JPanel(new BorderLayout());

    JPanel boardPanel = new JPanel(new GridLayout(1, 3)); // container inside scrollPane
    JScrollPane scrollPane = new JScrollPane(boardPanel); // vertical scroll for board

    JPanel headers = new JPanel(new GridLayout(1, 3, 10, 10)); // NORTH for board headers

    JPanel notStartedColumn = new JPanel();
    JPanel inProgressColumn = new JPanel();
    JPanel completeColumn = new JPanel();

    RoundedLabel notStartedLabel = new RoundedLabel("Not Started", 12);
    RoundedLabel inProgressLabel = new RoundedLabel(    "In Progress", 12);
    RoundedLabel completeLabel = new RoundedLabel("Complete", 12);

    JPanel card = new JPanel();

    JPanel buttonPanel = new JPanel();
    JButton addCard = new JButton("Add card");
    JButton deleteCard = new JButton("Delete card");


    public static void main(String[] args) throws Exception {
        App window = new App("Kanban board");
        window.init();

        window.setVisible(true);


    }

    public App (String title){
        super(title);
    }


    void init(){

        setSize(1000,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        add(container);

        container.setPreferredSize(new Dimension(700, 600));
        container.add(headers, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBorder(null);

        container.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(addCard);
        buttonPanel.add(deleteCard);

        // label styling

        notStartedLabel.setBackground(Color.LIGHT_GRAY);
        notStartedLabel.setPreferredSize(new Dimension(100,40));

        inProgressLabel.setBackground(ColorEnum.LIGHT_PURPLE.toColor());
        inProgressLabel.setPreferredSize(new Dimension(100,40));

        completeLabel.setBackground(ColorEnum.LIGHT_GREEN.toColor());
        completeLabel.setPreferredSize(new Dimension(100,40));

        // headers
        headers.add(notStartedLabel);
        headers.add(inProgressLabel);
        headers.add(completeLabel);


        notStartedColumn.setBackground(ColorEnum.VERY_LIGHT_GRAY.toColor());
        notStartedColumn.setPreferredSize(new Dimension(100, 500));

        inProgressColumn.setBackground(ColorEnum.VERY_LIGHT_PURPLE.toColor());
        inProgressColumn.setPreferredSize(new Dimension(100, 500));

        completeColumn.setBackground(ColorEnum.VERY_LIGHT_GREEN.toColor());
        completeColumn.setPreferredSize(new Dimension(100, 500));


        boardPanel.add(notStartedColumn);
        boardPanel.add(inProgressColumn);
        boardPanel.add(completeColumn);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
