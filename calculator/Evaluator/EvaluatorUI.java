package Evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
        "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C is for clear, clears entire expression CE is for clear expression,
     * clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[bText.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.txField.setPreferredSize(new Dimension(600, 50));
        this.txField.setFont(new Font("Courier", Font.BOLD, 28));

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button bt;
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            bt = new Button(bText[i]);
            bt.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = bt;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0) {

        if (arg0.getSource() == buttons[0]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "7");

        } else if (arg0.getSource() == buttons[1]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "8");

        } else if (arg0.getSource() == buttons[2]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "9");

        } else if (arg0.getSource() == buttons[3]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "+");

        } else if (arg0.getSource() == buttons[4]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "4");

        } else if (arg0.getSource() == buttons[5]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "5");

        } else if (arg0.getSource() == buttons[6]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "6");

        } else if (arg0.getSource() == buttons[7]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "-");

        } else if (arg0.getSource() == buttons[8]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "1");

        } else if (arg0.getSource() == buttons[9]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "2");

        } else if (arg0.getSource() == buttons[10]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "3");

        } else if (arg0.getSource() == buttons[11]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "*");

        } else if (arg0.getSource() == buttons[12]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "0");

        } else if (arg0.getSource() == buttons[13]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "^");

        } else if (arg0.getSource() == buttons[14]) {
            Evaluator GUIexprs = new Evaluator();

            String res = Integer.toString(GUIexprs.eval(txField.getText()));

            txField.setText(res + " ");

        } else if (arg0.getSource() == buttons[15]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "/");

        } else if (arg0.getSource() == buttons[16]) {
            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + "(");

        } else if (arg0.getSource() == buttons[17]) {

            if (txField.getText().contains(" ")) {
                txField.setText("");
            }
            txField.setText(txField.getText() + ")");

        } else if (arg0.getSource() == buttons[18]) {

            txField.setText("");

        } else if (arg0.getSource() == buttons[19]) {

            txField.setText("");

        }
    }

}
