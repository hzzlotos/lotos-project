package javacore.local.javacore;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This program demonstrates formatting dates under various locales.
 * 
 * @version 1.13 2007-07-25
 * @author Cay Horstmann
 */
public class DateFormatTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new DateFormatFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame contains combo boxes to pick a locale, date and time formats, text fields to display
 * formatted date and time, buttons to parse the text field contents, and a "lenient" check box.
 */
class DateFormatFrame extends JFrame
{
    public DateFormatFrame()
    {
        this.setTitle("DateFormatTest");

        this.setLayout(new GridBagLayout());
        this.add(new JLabel("Locale"), new GBC(0, 0).setAnchor(GBC.EAST));
        this.add(new JLabel("Date style"), new GBC(0, 1).setAnchor(GBC.EAST));
        this.add(new JLabel("Time style"), new GBC(2, 1).setAnchor(GBC.EAST));
        this.add(new JLabel("Date"), new GBC(0, 2).setAnchor(GBC.EAST));
        this.add(new JLabel("Time"), new GBC(0, 3).setAnchor(GBC.EAST));
        this.add(this.localeCombo, new GBC(1, 0, 2, 1).setAnchor(GBC.WEST));
        this.add(this.dateStyleCombo, new GBC(1, 1).setAnchor(GBC.WEST));
        this.add(this.timeStyleCombo, new GBC(3, 1).setAnchor(GBC.WEST));
        this.add(this.dateParseButton, new GBC(3, 2).setAnchor(GBC.WEST));
        this.add(this.timeParseButton, new GBC(3, 3).setAnchor(GBC.WEST));
        this.add(this.lenientCheckbox, new GBC(0, 4, 2, 1).setAnchor(GBC.WEST));
        this.add(this.dateText, new GBC(1, 2, 2, 1).setFill(GBC.HORIZONTAL));
        this.add(this.timeText, new GBC(1, 3, 2, 1).setFill(GBC.HORIZONTAL));

        this.locales = DateFormat.getAvailableLocales().clone();
        Arrays.sort(this.locales, new Comparator<Locale>() {
            @Override
            public int compare(Locale l1, Locale l2)
            {
                return l1.getDisplayName().compareTo(l2.getDisplayName());
            }
        });
        for (Locale loc : this.locales)
        {
            this.localeCombo.addItem(loc.getDisplayName());
        }
        this.localeCombo.setSelectedItem(Locale.getDefault().getDisplayName());
        this.currentDate = new Date();
        this.currentTime = new Date();
        this.updateDisplay();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                DateFormatFrame.this.updateDisplay();
            }
        };

        this.localeCombo.addActionListener(listener);
        this.dateStyleCombo.addActionListener(listener);
        this.timeStyleCombo.addActionListener(listener);

        this.dateParseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String d = DateFormatFrame.this.dateText.getText().trim();
                try
                {
                    DateFormatFrame.this.currentDateFormat.setLenient(DateFormatFrame.this.lenientCheckbox.isSelected());
                    Date date = DateFormatFrame.this.currentDateFormat.parse(d);
                    DateFormatFrame.this.currentDate = date;
                    DateFormatFrame.this.updateDisplay();
                }
                catch (ParseException e)
                {
                    DateFormatFrame.this.dateText.setText("Parse error: " + d);
                }
                catch (IllegalArgumentException e)
                {
                    DateFormatFrame.this.dateText.setText("Argument error: " + d);
                }
            }
        });

        this.timeParseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String t = DateFormatFrame.this.timeText.getText().trim();
                try
                {
                    DateFormatFrame.this.currentDateFormat.setLenient(DateFormatFrame.this.lenientCheckbox.isSelected());
                    Date date = DateFormatFrame.this.currentTimeFormat.parse(t);
                    DateFormatFrame.this.currentTime = date;
                    DateFormatFrame.this.updateDisplay();
                }
                catch (ParseException e)
                {
                    DateFormatFrame.this.timeText.setText("Parse error: " + t);
                }
                catch (IllegalArgumentException e)
                {
                    DateFormatFrame.this.timeText.setText("Argument error: " + t);
                }
            }
        });
        this.pack();
    }

    /**
     * Updates the display and formats the date according to the user settings.
     */
    public void updateDisplay()
    {
        Locale currentLocale = this.locales[this.localeCombo.getSelectedIndex()];
        int dateStyle = this.dateStyleCombo.getValue();
        this.currentDateFormat = DateFormat.getDateInstance(dateStyle, currentLocale);
        String d = this.currentDateFormat.format(this.currentDate);
        this.dateText.setText(d);
        int timeStyle = this.timeStyleCombo.getValue();
        this.currentTimeFormat = DateFormat.getTimeInstance(timeStyle, currentLocale);
        String t = this.currentTimeFormat.format(this.currentTime);
        this.timeText.setText(t);
    }

    private Locale[]   locales;

    private Date       currentDate;

    private Date       currentTime;

    private DateFormat currentDateFormat;

    private DateFormat currentTimeFormat;

    private JComboBox  localeCombo     = new JComboBox();

    private EnumCombo  dateStyleCombo  = new EnumCombo(DateFormat.class, new String[] { "Default", "Full", "Long",
            "Medium", "Short"         });

    private EnumCombo  timeStyleCombo  = new EnumCombo(DateFormat.class, new String[] { "Default", "Full", "Long",
            "Medium", "Short"         });

    private JButton    dateParseButton = new JButton("Parse date");

    private JButton    timeParseButton = new JButton("Parse time");

    private JTextField dateText        = new JTextField(30);

    private JTextField timeText        = new JTextField(30);

    private JCheckBox  lenientCheckbox = new JCheckBox("Parse lenient", true);
}
