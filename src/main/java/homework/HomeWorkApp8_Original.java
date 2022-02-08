package homework;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

/*
- Why use EventQueue?
JFrame is in the javax.swing package. Therefore, JFrame is a Swing component.
Java expects all Swing objects to be created on an event queue. The main() method does not run on the event queue.
Therefore, we will write code to add any swing objects created to the event queue, through the main()
Sometimes program code may not run in the expected order if the swing objects aren’t created on the event queue.
The invokeLater, Runnable, and run() methods are all related to Java threads.
- Use the cross-platform look and feel
-Why use serial UID?
Java expects JFrames and many other components to have a serialVersionUID.
The ID is meant to be unique for the current version of the class.
We can use any integer value. The “L” after the integer means the integer is a long integer. We can set this first version of the program to 1L. If we create a new version of this program later, we can change the version number to 2L.
Think of 1L and 2L values as versions 1.0 and 2.0.
 */
public class HomeWorkApp8_Original {
    public static void main(String[] args) {
        try{
            String className=UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        }
        catch(Exception e){}

        // new CounterApp(0);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CounterApp();
            }
        });
    }
}

class CounterApp_Original extends JFrame {
    private int value;
    private static final long serialVersionUID = 1L;

    public CounterApp_Original(int initialValue) {
        initUI();
        setResizable(true);
        setLocationRelativeTo(null); //to center JFrame in the display area of the screen
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
    private void clickEnterButton(){
        System.out.println("Enter button clicked");

    }

    private void clickClearButton(){
        System.out.println("Clear button clicked");

    }
    private int clickCountButton(String text){
        System.out.println("Count button clicked:counting vowels");
        int len=text.length();
        int counter=0;

        for (int i=0;i<len;i++){
            char ch = text.charAt(i);
            if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'||ch == ' '){
                counter ++;
            }
        }
        System.out.println("Number of vowels in the given sentence is "+counter);
        this.setValue(counter);
        return counter;
    }
    private void initUI(){
        setBounds(700, 700, 300, 320);
        Dimension size = new Dimension(50,50);
        setTitle("Simple Vowel Counter");

        JPanel centerPanel= new JPanel();
        centerPanel.setBackground(Color.BLACK);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        add(centerPanel,BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.YELLOW);
        bottomPanel.setPreferredSize(size);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        add(bottomPanel,BorderLayout.PAGE_END);//bottom

        JPanel leftPanel= new JPanel();
        leftPanel.setBackground(Color.PINK);
        leftPanel.setPreferredSize(size);
        add(leftPanel,BorderLayout.LINE_START); //left

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.GREEN);
        rightPanel.setPreferredSize(size);
        add(rightPanel,BorderLayout.LINE_END); //right

        String textAreaMessage ="Please enter text";
        JTextArea textArea = new JTextArea(textAreaMessage,15, 50);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(true);

        textArea.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                textArea.setText("");
            }
            public void focusLost(FocusEvent e) {
                // nothing
            }
        });
        JButton countButton = new JButton("Count");

        JLabel counterValueView = new JLabel();
        Font font = new Font(Font.SANS_SERIF, Font.BOLD+Font.ITALIC, 32);
        counterValueView.setBackground(Color.BLUE);
        counterValueView.setForeground(Color.WHITE);

        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);

        // value = this.getValue();
        //  counterValueView.setText(String.valueOf(this.getValue()));
        centerPanel.add(counterValueView); //add label to center panel
        countButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
            String text = textArea.getText();
            System.out.println(text);
            int counter =clickCountButton(text);
            setValue(counter);
            counterValueView.setText(String.valueOf(counter));
        }
        });
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
            clickClearButton();
            textArea.setText("");
        }
        });
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

         /*
            JPanel inputPanel = new JPanel();
         inputPanel.setLayout(new FlowLayout());
         JTextField input = new JTextField(20);
         JButton enterButton = new JButton("Enter");
         inputPanel.add(input);
         inputPanel.add(enterButton);
         centerPanel.add(inputPanel);
         enterButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
             clickEnterButton();
         }
         });
          */

        centerPanel.add(scroller);
        bottomPanel.add(countButton);//?
        bottomPanel.add(clearButton);//?


        JLabel labelTop = new JLabel();
        labelTop.setPreferredSize(new Dimension(80,80));
        labelTop.setText("Vowel Counter Label");
        labelTop.setForeground(Color.GREEN);
        centerPanel.add(labelTop); //add label to center panel

        JButton decrementButton = new JButton("-");
        decrementButton.setBackground(Color.BLUE);
        decrementButton.setContentAreaFilled(true);
        decrementButton.setOpaque(true);
        decrementButton.setFont(font);
        leftPanel.add(decrementButton);          //add button to the panel

        JButton incrementButton = new JButton("+");
        incrementButton.setBackground(Color.BLUE);
        incrementButton.setContentAreaFilled(true);
        incrementButton.setOpaque(true);
        incrementButton.setFont(font);
        rightPanel.add(incrementButton);          //add button to the panel

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value--;
                counterValueView.setText(String.valueOf(value));
            }
        });

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value++;
                counterValueView.setText(String.valueOf(value));
            }
        });
    };

}