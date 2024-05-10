package swingCRUD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AllFrames implements ActionListener {
    JLabel idLabel, nameLabel, desLabel;
    JTextField idField, nameField, desField;
    JButton submitButton;
    JComboBox<String> opsList;
    JFrame MainFrame, SecondFrame;
    JTable dataTable;
    DataBase dataBase;

    AllFrames(){
        createMainPage();
        dataBase = new DataBase("xeven");
    }

    void createMainPage() {
        idLabel = new JLabel("RegNumber");
        nameLabel = new JLabel("firstName");
        desLabel = new JLabel("Operation");
        idField = new JTextField();
        nameField = new JTextField();
        desField = new JTextField("Select Ops");
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        String[] desOptions = {"Create", "Read", "Update", "Delete"};
        opsList = new JComboBox<>(desOptions);
        opsList.setBounds(50, 50, 90, 20);


        JPanel panel = new JPanel();
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(grid);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(idField, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(nameField, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(desLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(opsList, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(submitButton, gbc);

        MainFrame = new JFrame("Login");
        MainFrame.add(panel, BorderLayout.CENTER);
        MainFrame.setVisible(true);
        MainFrame.setSize(300, 300);
        MainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void createSecondPage(DefaultTableModel model) {
        dataTable = new JTable(model);
        SecondFrame = new JFrame("View Data");
        SecondFrame.add(new JScrollPane(dataTable));
        SecondFrame.setVisible(true);
        SecondFrame.setSize(300, 300);
        SecondFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String operation = opsList.getItemAt(opsList.getSelectedIndex());
        String id = "", name = "";
        int regNo = 0;
        if(!idField.getText().isEmpty()){
            id = idField.getText();
            regNo = Integer.parseInt(id);
            name = nameField.getText();
        }
        Boolean result;
        if (operation.equals("Create") && !id.isEmpty() && !name.isEmpty()) {
            try {
                result = dataBase.createData(regNo, name);
                if (result)
                    JOptionPane.showMessageDialog(MainFrame, "Student Added Successfully");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(MainFrame, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if (operation.equals("Read")) {
            try {
                DefaultTableModel model = dataBase.readData();
                createSecondPage(model);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(MainFrame, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if (operation.equals("Update") && !id.isEmpty() && !name.isEmpty()) {
            try {
                result = dataBase.updateData(regNo, name);
                if (result)
                    JOptionPane.showMessageDialog(MainFrame, "Record updated Successfully");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(MainFrame, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if (operation.equals("Delete") && !id.isEmpty()) {
            try {
                result = dataBase.deleteData(regNo);
                if (result)
                    JOptionPane.showMessageDialog(MainFrame, "This Student is Removed: " + regNo);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(MainFrame, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(MainFrame, "Error in credentials", "Warning", JOptionPane.WARNING_MESSAGE);
    }//end of actionPerformed()
}
