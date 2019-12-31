import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Interface_Switch extends JFrame implements ActionListener {

    JButton button;
    JButton button2;
    JTextField textField;

    public Interface_Switch() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Button");
        button.addActionListener(this);
        button.setActionCommand("btn");

        button2 = new JButton("Button1");
        button2.addActionListener(this);
        button2.setActionCommand("btn1");

        textField = new JTextField(20);
        textField.addActionListener(this);
        textField.setActionCommand("text");

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(button2);
        panel.add(textField);

        getContentPane().add(panel, BorderLayout.NORTH);

        setVisible(true);

    }

    /*
     * public void actionPerformed(ActionEvent e) { String cmd
     * =e.getActionCommand(); if (cmd.equals("btn")) {
     * textField.setText("Button 1 was clicked");
     * 
     * } else if (cmd.equals("btn1")) { textField.setText("Button 2 was clicked"); }
     * else if (cmd.equals("text")) { textField.setText("Enter key was pressed"); }
     * }
     *
     * 
     * package old_code /* public void actionPerformed(ActionEvent e) { if
     * (e.getSource() == button) { textField.setText("Button 1 was clicked"); } else
     * if (e.getSource() == button2) { textField.setText("Button 2 was clicked"); }
     * else if (e.getSource() == textField) {
     * textField.setText("Enter key was pressed"); } }
     */

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
        case "btn":
            textField.setText("Button 1 was Preesed");
            break;
        case "btn1":
            textField.setText("Button 2 was clicked");
            break;
        case "text":
            textField.setText("Enter key was pressed");
            break;
        default:
            break;
        }
    }

    public static void main(String[] args) {
        new Interface_Switch();
    }
}