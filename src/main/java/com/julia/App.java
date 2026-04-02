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

//    JPanel notStartedColumn = new JPanel();
//    JPanel inProgressColumn = new JPanel();
//    JPanel completeColumn = new JPanel();

    // column classes
    Column notStartedC = new Column(ColorEnum.VERY_LIGHT_GRAY);
    Column inProgressC = new Column(ColorEnum.VERY_LIGHT_PURPLE);
    Column completeC = new Column(ColorEnum.VERY_LIGHT_GREEN);


    RoundedLabel notStartedLabel = new RoundedLabel("Not Started", 12);
    RoundedLabel inProgressLabel = new RoundedLabel("In Progress", 12);
    RoundedLabel completeLabel = new RoundedLabel("Complete", 12);

    JPanel buttonContainer = new JPanel();
    JPanel buttonPanel = new JPanel();
    JButton addCard = new JButton("Add card");
    JButton deleteCard = new JButton("Delete card");

    String taskNameInput = "";

    JLabel deleteCardMessage = new JLabel("");

    public static void main(String[] args) throws Exception {
        App window = new App("Kanban board");
        window.init();

        window.setVisible(true);

        // how to use Card class
        // Card card = new Card("Fix bug", "Null pointer in login", "red", Priority.HIGH);


    }

    public App(String title) {
        super(title);
    }


    void init() {

        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        add(container);

        container.setPreferredSize(new Dimension(700, 600));
        container.add(headers, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBorder(null);

        container.add(buttonContainer, BorderLayout.SOUTH);

        buttonContainer.setLayout(new BorderLayout());
        buttonContainer.setPreferredSize(new Dimension(300, 60));
        buttonContainer.add(buttonPanel, BorderLayout.NORTH);
        buttonContainer.add(deleteCardMessage, BorderLayout.SOUTH);
        deleteCardMessage.setHorizontalAlignment(SwingConstants.CENTER);

        // buttons
        buttonPanel.add(addCard);
        buttonPanel.add(deleteCard);
        addCard.addActionListener(this);
        deleteCard.addActionListener(this);


        // label styling

        notStartedLabel.setBackground(Color.LIGHT_GRAY);
        notStartedLabel.setPreferredSize(new Dimension(100, 40));

        inProgressLabel.setBackground(ColorEnum.LIGHT_PURPLE.toColor());
        inProgressLabel.setPreferredSize(new Dimension(100, 40));

        completeLabel.setBackground(ColorEnum.LIGHT_GREEN.toColor());
        completeLabel.setPreferredSize(new Dimension(100, 40));

        // headers
        headers.add(notStartedLabel);
        headers.add(inProgressLabel);
        headers.add(completeLabel);

        // columns
//        notStartedColumn.setBackground(ColorEnum.VERY_LIGHT_GRAY.toColor());
//        notStartedColumn.setPreferredSize(new Dimension(100, 500));
//
//        inProgressColumn.setBackground(ColorEnum.VERY_LIGHT_PURPLE.toColor());
//        inProgressColumn.setPreferredSize(new Dimension(100, 500));
//
//        completeColumn.setBackground(ColorEnum.VERY_LIGHT_GREEN.toColor());
//        completeColumn.setPreferredSize(new Dimension(100, 500));


//        boardPanel.add(notStartedColumn);
//        boardPanel.add(inProgressColumn);
//        boardPanel.add(completeColumn);

        boardPanel.add(notStartedC);
        boardPanel.add(inProgressC);
        boardPanel.add(completeC);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == addCard) {
            deleteCardMessage.setText("");

            CustomAddDialog dialog = new CustomAddDialog();

            int result = JOptionPane.showOptionDialog(
                    this,
                    dialog,
                    "Add Card",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, null, null
            );

            if (result == JOptionPane.OK_OPTION) {
                taskNameInput = dialog.getTaskName();
                Priority selectedPriority = dialog.getPriority();

                if (!validateInput(taskNameInput) || taskNameInput == null) {
                    JOptionPane.showMessageDialog(
                            this,                       // parent
                            "Invalid input.",   // message
                            "Add Card",              // title
                            JOptionPane.PLAIN_MESSAGE   // no icon
                    );
                }

                Card card = new Card(taskNameInput, selectedPriority);
                notStartedC.addCard(card);
            }

        } else if (source == deleteCard) {
            deleteCardMessage.setText("Select card to delete.");
        }

//            taskNameInput = (String) JOptionPane.showInputDialog(
//                    this,                   // parent
//                    "Enter task name:",     // message
//                    "Add Card",             // title
//                    JOptionPane.PLAIN_MESSAGE, // no icon
//                    null,                   // no custom icon
//                    null,                   // no predefined options
//                    ""                      // initial input value
//            );


    }

    public static boolean validateInput(String input) {
        return (input.length() >= 3 && input.length() < 25);
    }
}
