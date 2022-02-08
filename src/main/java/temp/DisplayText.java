package temp;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class DisplayText {
    private JTextArea text;
    private Action[] textActions = { new DefaultEditorKit.CutAction(),
            new DefaultEditorKit.CopyAction(), new DefaultEditorKit.PasteAction(), };

    public DisplayText(String title, String info) {
        JMenu menu = new JMenu("Edit");
        for (Action textAction : textActions) {
            menu.add(new JMenuItem(textAction));
        }
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        JFrame f = new JFrame(title);
        f.setJMenuBar(menuBar);

        Container c = f.getContentPane();

        text = new JTextArea(info, 20, 50);

        JScrollPane sp = new JScrollPane(text);
        c.add(sp);

        // f.setBounds(100,200, 500, 400 );
        f.pack();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new DisplayText("Title", "This is info text");
    }
}