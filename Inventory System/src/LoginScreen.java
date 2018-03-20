import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
Shows the login screen to either login as the user or vendor
 */
public class LoginScreen extends JPanel {
    private JFrame frame;

    public LoginScreen(JFrame frame) {
        this.frame = frame;
        frame.setSize(400,200);
        setLayout(new GridBagLayout());
        initialize(); // Initializing the view

        // Creating empty border for the panel
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    /*
    Filling the panel
     */
    private void initialize() {
        frame.setTitle("MFIS");

        GridBagConstraints c = new GridBagConstraints();

        // Creating login label
        JLabel loginLabel = new JLabel();
        loginLabel.setText("Login");
        loginLabel.setFont(new Font(loginLabel.getFont().getName(), Font.PLAIN, 30));
        loginLabel.setHorizontalAlignment(JLabel.CENTER);

        // Creating username and password text field
        JTextField usernameField = new JTextField("Username");
        JPasswordField passwordField = new JPasswordField("password");
        usernameField.setColumns(20);
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER) {
                    // If 'ENTER' key is pressed then try to login
                    try {
                        if (usernameField.getText().equals("Manager") && passwordField.getText().equals("password")) {
                            // Removing user login screen and showing movie browse screen
                            frame.getContentPane().removeAll();
                            frame.getContentPane().add(new ManagerView(frame));
                            frame.pack();
                            frame.getContentPane().setVisible(true);
                        } else if (usernameField.getText().equals("Vendor") && passwordField.getText().equals("password")) {
                            // Login to inventory screen for manager
                            frame.getContentPane().removeAll();
                            frame.getContentPane().add(new VendorView(frame));
                            frame.pack();
                            frame.getContentPane().setVisible(true);
                        } else {
                            return;
                        }
                    } catch (Exception loginErr) {

                    }
                }
            }
        });
        usernameField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                usernameField.setText("");
            }
        });

        passwordField.setColumns(20);
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER) {
                    // If 'ENTER' key is pressed then try to login
                    try {
                        if (usernameField.getText().equals("Manager") && passwordField.getText().equals("password")) {
                            // Removing user login screen and showing movie browse screen
                            frame.getContentPane().removeAll();
                            frame.getContentPane().add(new ManagerView(frame));
                            frame.pack();
                            frame.getContentPane().setVisible(true);
                        } else if (usernameField.getText().equals("Vendor") && passwordField.getText().equals("password")) {
                            // Login to inventory screen for manager
                            frame.getContentPane().removeAll();
                            frame.getContentPane().add(new VendorView(frame));
                            frame.pack();
                            frame.getContentPane().setVisible(true);
                        } else {
                            return;
                        }
                    } catch (Exception loginErr) {

                    }
                }
            }
        });
        passwordField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                passwordField.setText("");
            }
        });

        // Creating login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameField.getText().equals("Manager") && passwordField.getText().equals("password")) {
                    // Login to inventory screen for manager
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(new ManagerView(frame));
                    frame.pack();
                    frame.getContentPane().setVisible(true);
                } else if (usernameField.getText().equals("Vendor") && passwordField.getText().equals("password")) {
                    // Login to inventory screen for manager
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(new VendorView(frame));
                    frame.pack();
                    frame.getContentPane().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Username or password is incorrect.",
                            "Error",
                            JOptionPane.PLAIN_MESSAGE
                    );
                }

            }
        });

        // Creating exit button to exit the program
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        // Adding components to the frame
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        add(loginLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.insets = new Insets(20, 0, 10, 0);
        add(usernameField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.insets = new Insets(0, 0, 40, 0);
        add(passwordField, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        add(loginButton, c);

        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        add(exitButton, c);
    }
}
