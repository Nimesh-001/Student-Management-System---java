import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admindashbord {
    private JPanel panel1;
    private JLabel profilePicLabel;
    private JButton logoutButton;
    private JButton editProfileButton;
    private JLabel adminUsernameLabel;
    private JButton timetablesButton1;
    private JButton noticesButton1;
    private JButton coursesButton1;
    private JButton userProfilesButton1;

    private String username;

    public Admindashbord(String username) {
        this.username = username;

        JFrame frame = new JFrame("Admindashbord");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(1000,500);

        loadProfileImage();

        userProfilesButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        coursesButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        noticesButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        timetablesButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Login();

            }
        });
    }


    private void loadProfileImage() {
        Dbconnector dbc = new Dbconnector();
        Connection con = dbc.getConnection();

        String sql = "SELECT Profile_Pic_Path, First_Name FROM USER WHERE Username=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, username); // Use dynamic username
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String path = rs.getString("Profile_Pic_Path");
                String firstName = rs.getString("First_Name");

                adminUsernameLabel.setText("WELCOME " + firstName);

                if (path != null && !path.isEmpty()) {
                    ImageIcon image = new ImageIcon(path);
                    Image img = image.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    profilePicLabel.setIcon(new ImageIcon(img));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading image: " + e.getMessage());
        }
    }


//    public static void main(String[] args) {
//
//
//    }
}
