import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//trying to add a background image for entire application interface
class loginForm extends JFrame implements ActionListener {
    JLabel idLabel, nameLabel, desLabel;
    JTextField idField, nameField, desField;
    JButton submitButton;
    JComboBox<String> desList;
    loginForm(){
        idLabel = new JLabel("RegNumber");
        nameLabel = new JLabel("firstName");
        desLabel = new JLabel("Designation");
        idField = new JTextField("123456789");
        nameField = new JTextField("123456789");
        desField = new JTextField("123456789");
        //idField.setEditable(false);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        String[] desOptions ={ "Select", "HR", "Staff"};
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String field = desList.getItemAt(desList.getSelectedIndex());
        String id = idField.getText();
        String name = nameField.getText();
        System.out.println(id);
        System.out.println(field);
        if(id.equals("123") && field.equals("HR") && !name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Welcome HR", "Greeting", JOptionPane.PLAIN_MESSAGE);

        }
        else if(id.equals("123") && field.equals("Staff") && !name.isEmpty())
            JOptionPane.showMessageDialog(this, "Welcome Staff", "Greeting", JOptionPane.PLAIN_MESSAGE);
        else
            JOptionPane.showMessageDialog(this,"Error in credentials","Warning", JOptionPane.WARNING_MESSAGE);
    }
}

public class April02 {
    public static void main(String[] args){
        new loginForm();
    }
}
