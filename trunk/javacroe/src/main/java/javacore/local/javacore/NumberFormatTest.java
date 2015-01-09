package javacore.local.javacore;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This program demonstrates formatting numbers under various locales.
 * 
 * @version 1.13 2007-07-25
 * @author Cay Horstmann
 */
public class NumberFormatTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new NumberFormatFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame contains radio buttons to select a number format, a combo box to pick a locale, a text
 * field to display a formatted number, and a button to parse the text field contents.
 */
class NumberFormatFrame extends JFrame
{
    public NumberFormatFrame()
    {
        this.setTitle("NumberFormatTest");
        this.setLayout(new GridBagLayout());

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                NumberFormatFrame.this.updateDisplay();
            }
        };

        JPanel p = new JPanel();
        this.addRadioButton(p, this.numberRadioButton, this.rbGroup, listener);
        this.addRadioButton(p, this.currencyRadioButton, this.rbGroup, listener);
        this.addRadioButton(p, this.percentRadioButton, this.rbGroup, listener);

        this.add(new JLabel("Locale:"), new GBC(0, 0).setAnchor(GBC.EAST));
        this.add(p, new GBC(1, 1));
        this.add(this.parseButton, new GBC(0, 2).setInsets(2));
        this.add(this.localeCombo, new GBC(1, 0).setAnchor(GBC.WEST));
        this.add(this.numberText, new GBC(1, 2).setFill(GBC.HORIZONTAL));
        this.locales = NumberFormat.getAvailableLocales().clone();
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
        this.currentNumber = 123456.78;
        this.updateDisplay();

        this.localeCombo.addActionListener(listener);

        this.parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String s = NumberFormatFrame.this.numberText.getText().trim();
                try
                {
                    Number n = NumberFormatFrame.this.currentNumberFormat.parse(s);
                    if (n != null)
                    {
                        NumberFormatFrame.this.currentNumber = n.doubleValue();
                        NumberFormatFrame.this.updateDisplay();
                    }
                    else
                    {
                        NumberFormatFrame.this.numberText.setText("Parse error: " + s);
                    }
                }
                catch (ParseException e)
                {
                    NumberFormatFrame.this.numberText.setText("Parse error: " + s);
                }
            }
        });
        this.pack();
    }

    /**
     * Adds a radio button to a container.
     * 
     * @param p the container into which to place the button
     * @param b the button
     * @param g the button group
     * @param listener the button listener
     */
    public void addRadioButton(Container p, JRadioButton b, ButtonGroup g, ActionListener listener)
    {
        b.setSelected(g.getButtonCount() == 0);
        b.addActionListener(listener);
        g.add(b);
        p.add(b);
    }

    /**
     * Updates the display and formats the number according to the user settings.
     */
    public void updateDisplay()
    {
        Locale currentLocale = this.locales[this.localeCombo.getSelectedIndex()];
        this.currentNumberFormat = null;
        if (this.numberRadioButton.isSelected())
        {
            this.currentNumberFormat = NumberFormat.getNumberInstance(currentLocale);
        }
        else
            if (this.currencyRadioButton.isSelected())
            {
                this.currentNumberFormat = NumberFormat.getCurrencyInstance(currentLocale);
            }
            else
                if (this.percentRadioButton.isSelected())
                {
                    this.currentNumberFormat = NumberFormat.getPercentInstance(currentLocale);
                }
        String n = this.currentNumberFormat.format(this.currentNumber);
        this.numberText.setText(n);
    }

    private Locale[]     locales;

    private double       currentNumber;

    private JComboBox    localeCombo         = new JComboBox();

    private JButton      parseButton         = new JButton("Parse");

    private JTextField   numberText          = new JTextField(30);

    private JRadioButton numberRadioButton   = new JRadioButton("Number");

    private JRadioButton currencyRadioButton = new JRadioButton("Currency");

    private JRadioButton percentRadioButton  = new JRadioButton("Percent");

    private ButtonGroup  rbGroup             = new ButtonGroup();

    private NumberFormat currentNumberFormat;
}
