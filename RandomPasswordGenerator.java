import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class RandomPasswordGenerator {
    private static JFrame window;
    private static JButton button;
    private static JTextField textfield;
    private static JTextField pass;

    public static void start() {
        window = new JFrame("Random Password Generator");

        button = new JButton("Generate Password");
        button.setBounds(450, 100, 350, 50);
        button.setFont(button.getFont().deriveFont(24f));

        JLabel label = new JLabel();
        label.setText("Password Length:");
        label.setBounds(200, 10, 300, 100);
        label.setFont(label.getFont().deriveFont(24f));

        textfield = new JTextField();
        textfield.setBounds(200, 100, 200, 50);
        textfield.setFont(textfield.getFont().deriveFont(24f));

        pass = new JTextField();
        pass.setBounds(10, 300, 980, 50);
        pass.setFont(textfield.getFont().deriveFont(14f));
        pass.setEditable(false);

        window.add(textfield);
        window.add(pass);
        window.add(label);
        window.add(button);
        window.setSize(1000, 500);
        window.setLayout(null);
        window.setResizable(false);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void waitForClick() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String length = textfield.getText();
                String text;
                try {
                    int intLen = Integer.parseInt(length);
                    if(intLen > 120)
                        text = "Max password length is 120 characters.";
                    else if(intLen <= 5)
                        text = "Password length must be greater than 5!";
                    else
                        text = PasswordGenerator.generatePassword(intLen);
                } catch(NumberFormatException e) {
                    text = "Unable to generate password!";
                }

                textfield.setText("");
                pass.setText(text);
            }
        });
    }

    public static void main(String[] args) {
        start();
        waitForClick();
    }
}