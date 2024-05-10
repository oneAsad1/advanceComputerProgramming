import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator extends JFrame implements ActionListener {
    JPanel body;
    JTextField screen;
    String num1, num2, operand;

    Calculator() {
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\masad\\Pictures\\calculator-icon.png");
        setIconImage(icon);
        num1 = num2 = operand = "";
        body = new JPanel();
        body.setLayout(new GridLayout(6, 4));

        screen = new JTextField();
        screen.setPreferredSize(new Dimension(300, 100));
        screen.setEditable(false);

        createButtons();
        add(screen, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        setSize(338, 544);
        setTitle("Calculator");
        setVisible(true);
    }

    public void createButtons(){
        JButton[] allButtons = {
                new JButton("%"), new JButton("CE"), new JButton("C"), new JButton("@"),
                new JButton("1/x"), new JButton("pow"), new JButton("sqr"), new JButton("/"),
                new JButton("7"), new JButton("8"), new JButton("9"), new JButton("x"),
                new JButton("4"), new JButton("5"), new JButton("6"), new JButton("-"),
                new JButton("1"), new JButton("2"), new JButton("3"), new JButton("+"),
                new JButton("+/-"), new JButton("0"), new JButton("."), new JButton("=")
        };

        for (JButton btn: allButtons){
            body.add(btn);
            btn.addActionListener(this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!operand.isEmpty()) num2 = num2 + s;
            else num1 = num1 + s;

            // set the value of text
            screen.setText(num1 + operand + num2);
        } else if (s.charAt(0) == 'C'){
            num1 = operand = num2 = "";
            screen.setText("");
        }
        else if (s.charAt(0) == '=') {
            double temp = getTemp();

            // set the value of text
            screen.setText(num1 +" "+ operand +" "+ num2 + " = " + temp);

            // convert it to string
            num1 = Double.toString(temp);
            operand = num2 = "";
        } else {
            // if there was no operand
            if (operand.isEmpty() || num2.isEmpty()) operand = s;
                // else evaluate
            else {
                double te = switch (operand) {
                    case "+" -> (Double.parseDouble(num1) + Double.parseDouble(num2));
                    case "-" -> (Double.parseDouble(num1) - Double.parseDouble(num2));
                    case "/" -> (Double.parseDouble(num1) / Double.parseDouble(num2));
                    default -> (Double.parseDouble(num1) * Double.parseDouble(num2));
                };

                // convert it to string
                num1 = Double.toString(te);

                // place the operator
                operand = s;

                // make the operand blank
                num2 = "";
            }

            // set the value of text
            screen.setText(num1 + operand + num2);
        }
    }

    private double getTemp() {
        double temp, first = 0.0, second = 0.0;
        if(!num1.isEmpty())
            first = Double.parseDouble(num1);
        if (!num2.isEmpty())
            second = Double.parseDouble(num2);

        // store the value in 1st
        temp = switch (operand) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "/" -> first / second;
            case "pow" -> Math.pow(first, second);
            case "sqr" -> Math.sqrt(first);
            default -> (Double.parseDouble(num1) * Double.parseDouble(num2));
        };
        return temp;
    }
}
public class Mar27 {
    public static void main(String[] args){

        Calculator simple = new Calculator();
        simple.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
