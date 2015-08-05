package javaPad.graphicalInterface;

import javaPad.EventHandlers.About;
import javaPad.EventHandlers.Close;
import javaPad.EventHandlers.Open;
import javaPad.EventHandlers.Save;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shawon on 6/30/15.
 */
public class GuiInterface {
    private JFrame mainWindow; // the main application window

    private JTextArea editor; // editor area

    // the menubar

    private JMenuBar menuBar;

    // menus

    private JMenu file;
    private JMenu edit;
    private JMenu about;

    // file menu items
    
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem close;

    // edit menu items

    private JMenuItem selectAll;
    private JMenuItem copyText;
    private JMenuItem pasteText;

    // about menu items

    private JMenuItem aboutTheApplication;


    //***************************************

    // Constructor



    public GuiInterface() {
        initGUI();

        addItemsToFileMenu();
        addItemsToEditMenu();
        addItemsToAboutMenu();

        addToMenuBar();

        addToMainWindow();
        setMainWindowProperties();

        addEventHandlers();
    }




    //************* design methods



    // instantiates the components and the frame
    private void initGUI() {
        mainWindow = new JFrame("JavaPad");
        mainWindow.setDefaultLookAndFeelDecorated(true);

        editor = new JTextArea();

        menuBar = new JMenuBar();

        // menus

        file = new JMenu("File");
        edit = new JMenu("Edit");
        about = new JMenu("About");


        // file menu items
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        close = new JMenuItem("Close");


        // edit menu items
        selectAll = new JMenuItem("Select All");
        copyText = new JMenuItem("Copy");
        pasteText = new JMenuItem("Paste");


        // about menu items
        aboutTheApplication = new JMenuItem("About");
    }

    // adds items to the file menu
    private void addItemsToFileMenu() {
        file.add(open);
        file.add(save);
        file.add(close);
    }

    // add items to edit menu
    private void addItemsToEditMenu() {
        edit.add(selectAll);
        edit.add(copyText);
        edit.add(pasteText);
    }

    // add items to about menu
    private void addItemsToAboutMenu() {
        about.add(aboutTheApplication);
    }

    // add menus to the menubar
    private void addToMenuBar() {
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(about);
    }

    //****** finally add all to the mainWindow

    private void addToMainWindow() {
        mainWindow.setLayout(new BorderLayout());

        mainWindow.setJMenuBar(menuBar);

        mainWindow.add(editor, BorderLayout.CENTER);
    }

    // add mainWindow properties

    private void setMainWindowProperties() {
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(640, 480);
        mainWindow.setVisible(true);
        mainWindow.setLocationRelativeTo(null);
    }


    //*********** add functionality,
    // because nobody likes a numb application

    private void addEventHandlers() {
        Handler h = new Handler();

        open.addActionListener(h);
        save.addActionListener(h);
        close.addActionListener(h);

        aboutTheApplication.addActionListener(h);
    }

    //******************

    private class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == open) {
                Open openFile = new Open(mainWindow, editor);
                openFile.openFile();
            }

            if(e.getSource() == save) {
                Save saveFile = new Save(mainWindow, editor);
                saveFile.saveFile();
            }

            if(e.getSource() == close) {
                Close closeApplication = new Close();
                closeApplication.closeApp();
            }

            if (e.getSource() == aboutTheApplication) {
                About app = new About();
                app.showInfo();
            }
        }
    }

}
