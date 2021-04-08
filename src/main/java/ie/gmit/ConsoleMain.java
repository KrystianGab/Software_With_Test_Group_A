package ie.gmit;
import javax.swing.*;

public class ConsoleMain {
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConsoleFrame newFrame = new ConsoleFrame();
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.setSize(375, 225);
                newFrame.setVisible(true);
            }
        });

    }
}
