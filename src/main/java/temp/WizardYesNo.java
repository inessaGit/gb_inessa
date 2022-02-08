package temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WizardYesNo extends JFrame {
    private  static final String [] ANSWER = {
            "Yes.",
            "Go for it!",
            "Yes, definitely.",
            "For sure!",
            "I would say yes.",
            "Most likely yes.",
            "No.",
            "I wouldn't.",
            "In my opinion, no.",
            "Definitely not!",
            "Probably not.",
            "It is very doubtful."
    };
    public WizardYesNo(){
        initUI();
        // setSize(200,100);
        // Always call setResizable() before you call pack().
        setTitle("Wizard of Yes No");
        setResizable(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    /*
      We can add a JLabel object to a window with JFrame’s add() method and the JLabel object
      set as the parameter value. Because WizardOfYesNo extends JFrame, WizardOfYesNo can use JFrame’s add() method.
       */
    private void initUI(){
        JPanel centerPanel= new JPanel();
        centerPanel.setBackground(Color.BLUE);
        add(centerPanel,BorderLayout.CENTER);

        JPanel leftPanel= new JPanel();
        leftPanel.setBackground(Color.PINK);
        add(leftPanel,BorderLayout.LINE_START); //left

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.GREEN);
        add(rightPanel,BorderLayout.LINE_END); //right

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.YELLOW);
        add(bottomPanel,BorderLayout.PAGE_END);

        JLabel labelView = new JLabel();
        Font font = new Font(Font.SANS_SERIF, Font.BOLD+Font.ITALIC, 32);
        labelView.setFont(font);
        labelView.setHorizontalAlignment(JLabel.CENTER);
        add(labelView, BorderLayout.CENTER);
        labelView.setText("Label text");

        Random rand = new Random();
        int numberOfAnswers =ANSWER.length;
        int pick = rand.nextInt(numberOfAnswers);

        String answer = ANSWER[pick];
        JLabel label = new JLabel();
        label.setText(answer);
        label.setFont(font);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);

    };

}

class TestWizardYesNo{
    public static void main (String args[]){
        WizardYesNo wz= new WizardYesNo();
    }
}