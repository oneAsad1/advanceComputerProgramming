import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;

public class Mar18 {
    public static void main(String[] args){
        FrameOwner owner = new FrameOwner();
        System.out.println(owner.obj.isActive());
    }
}

class FrameOwner extends WindowAdapter implements ActionListener {
    Frame obj;
    TextField tf;
    Label label1, label2;
    Button b1, b2;
    FrameOwner(){
        obj = new Frame();
        obj.setTitle("AWT first Lab");
        label1 = new Label("Enter your id: ");
        label2 = new Label("where im i");
        tf = new TextField();
        b1 = new Button("Send");
        b2 = new Button("clear");

        label1.setBounds(20,80,80,20);
        label2.setBounds(20, 130, 250, 20);
        tf.setBounds(20,100,100,30);
        b1.setBounds(120,98,80,30);
        b2.setBounds(200,98,80,30);
        obj.setSize(300,300);

        obj.add(b1);
        obj.add(b2);
        obj.add(label1);
        obj.add(label2);
        obj.add(tf);

        obj.setLayout(null);
        obj.setVisible(true);
        obj.addWindowListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        tf.addActionListener(this);
        //b.addActionListener(new ActionListener(){
        //            public void actionPerformed(ActionEvent e){
        //                tf.setText("hello");
        //            }
        //        });
    }
    public void windowClosing(WindowEvent e){
        obj.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1 || e.getSource() == tf)
        {
            try {
                String host = tf.getText();
                String ip = java.net.InetAddress.getByName(host).getHostAddress();
                label2.setText("IP of "+host+" is: "+ip);
            }
            catch (Exception ex) {
                label2.setText(ex.getMessage());
            }
        }
        else
        {
            tf.setText("");
            label2.setText("");
        }

    }
}