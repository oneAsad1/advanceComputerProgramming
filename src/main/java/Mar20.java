import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Mar20 {
    public static void main(String[] args){
        new Card();
    }
}

class Card extends WindowAdapter implements ActionListener {
    Frame loginPanel, welcomePanel;
    TextField usernameField;
    JPasswordField passwordField;
    Button loginButton, logoutButton;
    Label statusLabel, errorLabel;

    public Card() {
        statusLabel = new Label();
        errorLabel = new Label();
        createLoginPanel();
        createWelcomePanel();
    }

    public void createLoginPanel() {
        loginPanel = new Frame();
        loginPanel.setLayout(null);
        loginPanel.setVisible(true);
        loginPanel.addWindowListener(this);
        loginPanel.setSize(350, 350);

        usernameField = new TextField();
        passwordField = new JPasswordField();
        loginButton = new Button("Login");
        loginButton.addActionListener(this);

        int labelWidth = 80;
        int labelHeight = 20;
        int fieldWidth = 100;
        int fieldHeight = 30;
        int buttonWidth = 250;
        int buttonHeight = 20;

        // Labels
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Label registerLabel = new Label("Register New User");

        //setBounds
        usernameLabel.setBounds(20, 80, labelWidth, labelHeight);
        passwordLabel.setBounds(140, 80, labelWidth, labelHeight);
        registerLabel.setBounds(70, 50, 120, 30);
        errorLabel.setBounds(50, 132, 220, labelHeight);

        // Fields
        usernameField.setBounds(20, 100, fieldWidth, fieldHeight);
        passwordField.setBounds(130, 100, fieldWidth, fieldHeight);
        loginButton.setBounds(20, 160, buttonWidth, buttonHeight);

        // Add components to panel
        loginPanel.add(usernameLabel);
        loginPanel.add(passwordLabel);
        loginPanel.add(registerLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(errorLabel);
    }

    public void createWelcomePanel() {
        welcomePanel = new Frame();
        welcomePanel.setLayout(null);
        welcomePanel.setVisible(false);
        logoutButton = new Button("Logout");
        welcomePanel.addWindowListener(this);
        logoutButton.addActionListener(this);

        int labelWidth = 120;
        int labelHeight = 30;
        int buttonWidth = 250;
        int buttonHeight = 20;

        welcomePanel.setSize(350,350);
        statusLabel.setBounds(20, 50, labelWidth, labelHeight);
        logoutButton.setBounds(20, 150, buttonWidth, buttonHeight);

        welcomePanel.add(statusLabel);
        welcomePanel.add(logoutButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            System.out.println("username: " + username);
            System.out.println("password: " + password);
            if (username.equals("admin") && password.equals("123")) {
                usernameField.setText("");
                passwordField.setText("");
                statusLabel.setText("Welcome user");
                welcomePanel.setVisible(true);
                loginPanel.setVisible(false);
            } else {
                errorLabel.setText("Incorrect Username or password");
            }
        } else if (e.getSource() == logoutButton) {
            statusLabel.setText("");
            welcomePanel.setVisible(false);
            loginPanel.setVisible(true);
        }
    }

    public void windowClosing(WindowEvent e){
        loginPanel.dispose();
        welcomePanel.dispose();
    }
}