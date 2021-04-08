package ie.gmit;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsoleFrame extends JFrame {

    private final JTextField textField1;
    private final JButton findItem;
    private final JButton pickUpPrescription;
    private final JButton addCustomerDetails;
    private static int buttonWidth = 300;
    private static int buttonHeight = 20;

    public ConsoleFrame()
    {
        super("Inventory App");
        setLayout(new FlowLayout()); // set frame layout

        textField1 = new JTextField("Welcome! Please pick your option");
        textField1.setEditable(false);
        textField1.setHorizontalAlignment(JTextField.CENTER);
        add(textField1); // add textField1 to JFrame

        findItem = new JButton("Find an item"); // button with text
        findItem.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(findItem); // add plainJButton to JFrame

        pickUpPrescription = new JButton("Pick up an existing prescription"); // button with text
        pickUpPrescription.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(pickUpPrescription); // add plainJButton to JFrame

        addCustomerDetails = new JButton("Add new Customer Details"); // button with text
        addCustomerDetails.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(addCustomerDetails); // add plainJButton to JFrame
    }

    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
