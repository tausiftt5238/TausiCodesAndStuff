package javaPad.EventHandlers;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;


/**
 * Created by shawon on 6/30/15.
 */
public class Save {
    private JFrame frame;
    private JTextArea ta;

    public Save(JFrame frame, JTextArea ta) { this.frame = frame; this.ta = ta; }

    public void saveFile() {
        JFileChooser fc = new JFileChooser();
        String out = "";

        int rVal = fc.showSaveDialog(frame);

        if(rVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            out = ta.getText();
            try {
                FileWriter writer = new FileWriter(file.getAbsolutePath());
                writer.write(out);

                writer.close();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error Writing to file");
            }
        }
    }
}
