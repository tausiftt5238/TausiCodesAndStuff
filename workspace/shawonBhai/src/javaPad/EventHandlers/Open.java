package javaPad.EventHandlers;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

/**
 * Created by shawon on 6/30/15.
 */
public class Open {
    private JFrame frame;
    private JTextArea ta;

    public Open(JFrame frame, JTextArea ta) { this.frame = frame; this.ta = ta; }

    public void openFile() {
        try {
            JFileChooser fileOpener = new JFileChooser();
            String in = "";

            int rVal = fileOpener.showOpenDialog(frame);

            if(rVal == JFileChooser.APPROVE_OPTION) {
                File file = fileOpener.getSelectedFile();

                Scanner reader = new Scanner(file);
                while(reader.hasNext()) {
                    in = reader.nextLine();
                }

                ta.setText(in);

                reader.close();
            }
            else {
                JOptionPane.showMessageDialog(null, "You didn't choose a file!");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Opening File!");
        }
    }
}
