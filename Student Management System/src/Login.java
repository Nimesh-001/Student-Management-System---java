import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Login {




    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton LOGINButton;
    private JButton CLEARButton;

    public Login() {

        Dbconnector dc = new Dbconnector();
        Connection conn = dc.getConnection();

        JFrame frame = new JFrame("Login");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(1000,500);

        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = new String(passwordField1.getPassword());

                if(username.isEmpty() || password.isEmpty()) {
                    //JOptionPane.showMessageDialog(frame, "Please enter username and password");
                    JOptionPane.showMessageDialog(frame, "Please enter username and password");
                }

            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                passwordField1.setText("");

            }
        });
    }

    public static void main(String[] args) {
        new Login();

    }
}
