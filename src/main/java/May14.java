import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class UI extends JFrame implements ActionListener {

    // <editor-fold desc="Global declarations">
    JLabel idLabel, nameLabel, desLabel;
    JTextField idField, nameField, desField;
    JButton submitButton;
    JComboBox<String> desList;
    Connection conn;
    Statement st;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    UI(){

        databaseConnectivity();

        idLabel = new JLabel("RegNumber");
        nameLabel = new JLabel("firstName");
        desLabel = new JLabel("Designation");
        idField = new JTextField("");
        nameField = new JTextField("");
        desField = new JTextField("");
        //idField.setEditable(false);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        String[] desOptions ={ "Create", "Read", "Update", "Delete"};
        desList = new JComboBox<>(desOptions);
        desList.setBounds(50, 50,90,20);

        JPanel panel = new JPanel();
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(grid);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(idLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(idField, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(nameField, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(desLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(desList, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(submitButton, gbc);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
        setSize(300, 300);
        setPreferredSize(getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    // </editor-fold>

    // <editor-fold desc="DataBase Connectivity">
    void databaseConnectivity(){
        String url = "jdbc:mysql://localhost:3306/xeven";
        String user = "root";
        String pass = "ItisHard@1234";
        try {
            conn = DriverManager.getConnection(url, user, pass);
            st = conn.createStatement();
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
    }
    //</editor-fold>

    // <editor-fold desc="ActionPerformed">
    @Override
    public void actionPerformed(ActionEvent e) {
        String field = desList.getItemAt(desList.getSelectedIndex());
        String id = idField.getText();
        String name = nameField.getText();
        System.out.println(id);
        System.out.println(field);
        if(!id.isEmpty() && !name.isEmpty() && field.equals("Create")){
            PreparedStatement pStat;
            try {
                pStat = conn.prepareStatement("INSERT INTO practice (reg, name) VALUES ( ?, ?)");
                pStat.setInt(1, Integer.parseInt(id));
                pStat.setString(2, name);
                pStat.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            JOptionPane.showMessageDialog(this, "Entry Successful", "Approved", JOptionPane.PLAIN_MESSAGE);

        }
        else
            JOptionPane.showMessageDialog(this,"Error in credentials","Warning", JOptionPane.WARNING_MESSAGE);
    }
    // </editor-fold>
}

public class May14 { public static void main(String[] args) { new UI(); } }
