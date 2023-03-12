import java.awt.event.*;
import javax.swing.*;
import model.*;

public class CalculatorView extends JFrame
{
    private MyPanel panel = new MyPanel();

    public CalculatorView()
    {
        super("Calculator");
        setup();
        build();
        setVisible(true);
    }

    private void setup()
    {
        setSize(300, 100);
        setLocation(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void build()
    {
        add(panel);
    }
    private class MyPanel extends JPanel implements MyObserver
    {
        private JTextField num1Field = new JTextField(5);
        private JTextField num2Field = new JTextField(5);
        private JTextField resultField = new JTextField(10);
        private JButton addButton = new JButton("+");
        private JButton subButton = new JButton("-"); 
        private JButton multiplyButton = new JButton("*");
        private JButton divButton = new JButton("/");
        private JButton clearButton = new JButton("Clear");
        private CalculatorModel model = new CalculatorModel();

        public MyPanel()
        {
            setup();
            build();
            model.attach(this);
        }

        private void setup()
        {
            addButton.addActionListener(new AddActionListener());
            subButton.addActionListener(new SubActionListener());
            multiplyButton.addActionListener(new MultiplyActionListener());
            divButton.addActionListener(new DivActionListener());
            clearButton.addActionListener(new ClearActionListener());
        }

        private void build()
        {
            add(num1Field);
            add(num2Field);
            add(resultField);
            add(addButton);
            add(subButton);
            add(multiplyButton);
            add(divButton);
            add(clearButton);
        }

        public void update()
        {
            resultField.setText(Double.toString(model.getResult()));
        }

        //controller
        private class AddActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                model.add(Double.parseDouble(num1Field.getText()), Double.parseDouble(num2Field.getText()));
            }
        }

        private class AddListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                model.add(Double.parseDouble(num1Field.getText()), Double.parseDouble(num2Field.getText()));
            }
        }

        private class SubActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                model.subtract(Double.parseDouble(num1Field.getText()), Double.parseDouble(num2Field.getText()));
            }
        }

        private class MultiplyActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                model.multiply(Double.parseDouble(num1Field.getText()), Double.parseDouble(num2Field.getText()));
            }
        }

        private class DivActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                model.divide(Double.parseDouble(num1Field.getText()), Double.parseDouble(num2Field.getText()));
            }
        }

        private class ClearActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                num1Field.setText("");
                num2Field.setText("");
                resultField.setText("");
            }
        }
    }
}

class main {
    public static void main(String[] args) {
        CalculatorView calc1 = new CalculatorView();
    }
}
