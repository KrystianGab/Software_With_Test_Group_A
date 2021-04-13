package ie.gmit;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsoleFrame extends JFrame {

    private final JTextField textField1;
    private final JTextField pps;
    private final JTextField address;
    private final JTextField email;
    private final JTextField phone;
    private final JButton findItem;
    private final JButton pickUpPrescription;
    private final JButton addCustomerDetails;
    private final JButton backButton;
    private final JButton returnItem;
    private final JButton returnPrescription;
    private final JButton addDetails;

    private static int buttonWidth = 300;
    private static int buttonHeight = 20;

    public ConsoleFrame()
    {
        super("Inventory App");
        setLayout(new FlowLayout());

        textField1 = new JTextField("Welcome! Please pick your option");
        textField1.setEditable(false);
        textField1.setHorizontalAlignment(JTextField.CENTER);
        add(textField1);

        pps = new JTextField("PPS");
        pps.setEditable(true);
        pps.setColumns(25);
        pps.setHorizontalAlignment(JTextField.CENTER);
        add(pps);

        address = new JTextField("Address");
        address.setEditable(true);
        address.setColumns(25);
        address.setHorizontalAlignment(JTextField.CENTER);
        add(address);

        email = new JTextField("Email");
        email.setEditable(true);
        email.setColumns(25);
        email.setHorizontalAlignment(JTextField.CENTER);
        add(email);

        phone = new JTextField("Phone");
        phone.setEditable(true);
        phone.setColumns(25);
        phone.setHorizontalAlignment(JTextField.CENTER);
        add(phone);

        findItem = new JButton("Find an item");
        findItem.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(findItem);

        pickUpPrescription = new JButton("Pick up an existing prescription");
        pickUpPrescription.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(pickUpPrescription);

        addCustomerDetails = new JButton("Add new Customer Details");
        addCustomerDetails.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(addCustomerDetails);

        returnItem = new JButton("Find Item");
        returnItem.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(returnItem);

        returnPrescription = new JButton("Get Prescription");
        returnPrescription.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(returnPrescription);

        addDetails = new JButton("Add Details");
        addDetails.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(addDetails);

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(75, 20));
        add(backButton);

        ButtonHandler handler = new ButtonHandler();
        findItem.addActionListener(handler);
        pickUpPrescription.addActionListener(handler);
        addCustomerDetails.addActionListener(handler);
        backButton.addActionListener(handler);
        returnItem.addActionListener(handler);
        returnPrescription.addActionListener(handler);
        addDetails.addActionListener(handler);

        setMainScreen();
    }

    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == findItem){
                setInventoryCheckScreen();
                returnItem.setVisible(true);
            }
            if(e.getSource() == pickUpPrescription){
                setInventoryCheckScreen();
                returnPrescription.setVisible(true);
            }
            if(e.getSource() == addCustomerDetails){
                textField1.setText("Name");
                textField1.setEditable(true);
                textField1.setColumns(25);
                pps.setVisible(true);
                address.setVisible(true);
                email.setVisible(true);
                phone.setVisible(true);
                findItem.setVisible(false);
                pickUpPrescription.setVisible(false);
                addCustomerDetails.setVisible(false);
                addDetails.setVisible(true);
                backButton.setVisible(true);
            }
            if(e.getSource() == returnItem) {
                returnInventory();
                returnItem.setVisible(false);
            }
            if(e.getSource() == returnPrescription) {
                returnInventory();
                returnPrescription.setVisible(false);
            }
            if(e.getSource() == addDetails) {
                try {
                    Customer newCustomer = new Customer(textField1.getText(), pps.getText(), address.getText(), email.getText(), phone.getText());
                    CustomerList customers = new CustomerList();
                    FileHandler fh = new FileHandler();

                    customers = fh.read(); //reads current file
                    customers.addCustomer(newCustomer); //adds new customer to ist
                    fh.save(customers); // saves new list
                }
                catch(Exception ex) {
                    textField1.setText(ex.getMessage());
                }
                textField1.setEditable(false);
                pps.setVisible(false);
                address.setVisible(false);
                email.setVisible(false);
                phone.setVisible(false);
                addDetails.setVisible(false);

            }
            if(e.getSource() == backButton) {
                setMainScreen();
            }
        }
    }

    private void setMainScreen() {
        textField1.setText("Welcome! Please pick your option");
        textField1.setEditable(false);
        findItem.setVisible(true);
        pickUpPrescription.setVisible(true);
        addCustomerDetails.setVisible(true);
        returnItem.setVisible(false);
        returnPrescription.setVisible(false);
        addDetails.setVisible(false);
        backButton.setVisible(false);
        pps.setVisible(false);
        address.setVisible(false);
        email.setVisible(false);
        phone.setVisible(false);
    }

    private void setInventoryCheckScreen() {
        textField1.setText("");
        textField1.setColumns(35);
        textField1.setEditable(true);
        findItem.setVisible(false);
        pickUpPrescription.setVisible(false);
        addCustomerDetails.setVisible(false);
        backButton.setVisible(true);
    }

    private void returnInventory() {
        String itemName = textField1.getText();
        try {
            Printable printable = InventoryDB.getInventory(itemName.toLowerCase());
            textField1.setText(printable.toString());
        }
        catch(Exception e) {
            textField1.setText(e.getMessage());
        }
        textField1.setEditable(false);
    }
}
