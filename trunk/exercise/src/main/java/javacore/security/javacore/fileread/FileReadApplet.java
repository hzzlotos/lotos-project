package javacore.security.javacore.fileread;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This applet can run "outside the sandbox" and read local files when it is given the right
 * permissions.
 * 
 * @version 1.11 2007-10-06
 * @author Cay Horstmann
 */
public class FileReadApplet extends JApplet
{
    @Override
    public void init()
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                FileReadApplet.this.fileNameField = new JTextField(20);
                JPanel panel = new JPanel();
                panel.add(new JLabel("File name:"));
                panel.add(FileReadApplet.this.fileNameField);
                JButton openButton = new JButton("Open");
                panel.add(openButton);
                ActionListener listener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        FileReadApplet.this.loadFile(FileReadApplet.this.fileNameField.getText());
                    }
                };
                FileReadApplet.this.fileNameField.addActionListener(listener);
                openButton.addActionListener(listener);

                FileReadApplet.this.add(panel, "North");

                FileReadApplet.this.fileText = new JTextArea();
                FileReadApplet.this.add(new JScrollPane(FileReadApplet.this.fileText), "Center");
            }
        });
    }

    /**
     * Loads the contents of a file into the text area.
     * 
     * @param filename the file name
     */
    public void loadFile(String filename)
    {
        try
        {
            this.fileText.setText("");
            Scanner in = new Scanner(new FileReader(filename));
            while (in.hasNextLine())
            {
                this.fileText.append(in.nextLine() + "\n");
            }
            in.close();
        }
        catch (IOException e)
        {
            this.fileText.append(e + "\n");
        }
        catch (SecurityException e)
        {
            this.fileText.append("I am sorry, but I cannot do that.\n");
            this.fileText.append(e + "\n");
        }
    }

    private JTextField fileNameField;

    private JTextArea  fileText;
}
