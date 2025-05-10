import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {




    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton LOGINButton;
    private JButton CLEARButton;

    public Login() {



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

                Dbconnector dbc = new Dbconnector();
                Connection conn = dbc.getConnection();

                String sql="select * from USER where Username = ? and BINARY Password = ?";
                try {
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1,username);
                    pst.setString(2,password);
                    ResultSet rs = pst.executeQuery();

                    if(rs.next()) {
                        String designation = rs.getString("designation");

                        switch(designation.toLowerCase()) {
                            case "admin":
                                frame.dispose();
                                new Admindashbord(username);
                                break;

                            case "lecturer":
                                frame.dispose();
                               // new Lecturdashbord(username);
                                break;

                            case "student":
                                frame.dispose();
                                //new Studentdashboard(username);
                                break;

                            case "technical officer":
                                frame.dispose();
                                //new ToDashbord(username);
                                break;

                            default:
                                JOptionPane.showMessageDialog(frame, "Invalid designation");
                                break;
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                    JOptionPane.showMessageDialog(null,"database error..");
                }
                finally {
                    if(conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
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
