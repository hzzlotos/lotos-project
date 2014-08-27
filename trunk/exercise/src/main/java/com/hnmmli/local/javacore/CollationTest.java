package com.hnmmli.local.javacore;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This program demonstrates collating strings under various locales.
 * 
 * @version 1.13 2007-07-25
 * @author Cay Horstmann
 */
public class CollationTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {

                JFrame frame = new CollationFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame contains combo boxes to pick a locale, collation strength and decomposition rules, a
 * text field and button to add new strings, and a text area to list the collated strings.
 */
class CollationFrame extends JFrame
{
    public CollationFrame()
    {
        this.setTitle("CollationTest");

        this.setLayout(new GridBagLayout());
        this.add(new JLabel("Locale"), new GBC(0, 0).setAnchor(GBC.EAST));
        this.add(new JLabel("Strength"), new GBC(0, 1).setAnchor(GBC.EAST));
        this.add(new JLabel("Decomposition"), new GBC(0, 2).setAnchor(GBC.EAST));
        this.add(this.addButton, new GBC(0, 3).setAnchor(GBC.EAST));
        this.add(this.localeCombo, new GBC(1, 0).setAnchor(GBC.WEST));
        this.add(this.strengthCombo, new GBC(1, 1).setAnchor(GBC.WEST));
        this.add(this.decompositionCombo, new GBC(1, 2).setAnchor(GBC.WEST));
        this.add(this.newWord, new GBC(1, 3).setFill(GBC.HORIZONTAL));
        this.add(new JScrollPane(this.sortedWords), new GBC(0, 4, 2, 1).setFill(GBC.BOTH));

        this.locales = Collator.getAvailableLocales().clone();
        Arrays.sort(this.locales, new Comparator<Locale>() {
            private Collator collator = Collator.getInstance(Locale.getDefault());

            @Override
            public int compare(Locale l1, Locale l2)
            {
                return this.collator.compare(l1.getDisplayName(), l2.getDisplayName());
            }
        });
        for (Locale loc : this.locales)
        {
            this.localeCombo.addItem(loc.getDisplayName());
        }
        this.localeCombo.setSelectedItem(Locale.getDefault().getDisplayName());

        this.strings.add("America");
        this.strings.add("able");
        this.strings.add("Zulu");
        this.strings.add("zebra");
        this.strings.add("\u00C5ngstr\u00F6m");
        this.strings.add("A\u030angstro\u0308m");
        this.strings.add("Angstrom");
        this.strings.add("Able");
        this.strings.add("office");
        this.strings.add("o\uFB03ce");
        this.strings.add("Java\u2122");
        this.strings.add("JavaTM");
        this.updateDisplay();

        this.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                CollationFrame.this.strings.add(CollationFrame.this.newWord.getText());
                CollationFrame.this.updateDisplay();
            }
        });

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                CollationFrame.this.updateDisplay();
            }
        };

        this.localeCombo.addActionListener(listener);
        this.strengthCombo.addActionListener(listener);
        this.decompositionCombo.addActionListener(listener);
        this.pack();
    }

    /**
     * Updates the display and collates the strings according to the user settings.
     */
    public void updateDisplay()
    {
        Locale currentLocale = this.locales[this.localeCombo.getSelectedIndex()];
        this.localeCombo.setLocale(currentLocale);

        this.currentCollator = Collator.getInstance(currentLocale);
        this.currentCollator.setStrength(this.strengthCombo.getValue());
        this.currentCollator.setDecomposition(this.decompositionCombo.getValue());

        Collections.sort(this.strings, this.currentCollator);

        this.sortedWords.setText("");
        for (int i = 0; i < this.strings.size(); i++)
        {
            String s = this.strings.get(i);
            if (i > 0 && this.currentCollator.compare(s, this.strings.get(i - 1)) == 0)
            {
                this.sortedWords.append("= ");
            }
            this.sortedWords.append(s + "\n");
        }
        this.pack();
    }

    private List<String> strings            = new ArrayList<String>();

    private Collator     currentCollator;

    private Locale[]     locales;

    private JComboBox    localeCombo        = new JComboBox();

    private EnumCombo    strengthCombo      = new EnumCombo(Collator.class, new String[] { "Primary", "Secondary",
            "Tertiary", "Identical"        });

    private EnumCombo    decompositionCombo = new EnumCombo(Collator.class, new String[] { "Canonical Decomposition",
            "Full Decomposition", "No Decomposition" });

    private JTextField   newWord            = new JTextField(20);

    private JTextArea    sortedWords        = new JTextArea(20, 20);

    private JButton      addButton          = new JButton("Add");
}
