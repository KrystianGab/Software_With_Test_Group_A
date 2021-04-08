package ie.gmit;

import java.io.*;

public class FileHandler {

    public void save(CustomerList list) {
        try {
            FileOutputStream writeFileStream = new FileOutputStream("Customerdata.ser");
            ObjectOutputStream writeobjStream = new ObjectOutputStream(writeFileStream);

            writeobjStream.writeObject(list);
            writeobjStream.flush();
            writeobjStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public CustomerList read() {
        CustomerList Customers = null;
        try {
            FileInputStream readFileStream = new FileInputStream("Customerdata.ser");
            ObjectInputStream readObjStream = new ObjectInputStream(readFileStream);

            Customers = (CustomerList) readObjStream.readObject();
            readObjStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Customers;
    }
}
