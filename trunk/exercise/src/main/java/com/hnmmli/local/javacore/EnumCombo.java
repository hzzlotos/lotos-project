package com.hnmmli.local.javacore;

import java.util.Map;
import java.util.TreeMap;

import javax.swing.JComboBox;

/**
 * A combo box that lets users choose from among static field
 * values whose names are given in the constructor.
 * 
 * @version 1.13 2007-07-25
 * @author Cay Horstmann
 */
public class EnumCombo extends JComboBox
{
    /**
     * Constructs an EnumCombo.
     * 
     * @param cl a class
     * @param labels an array of static field names of cl
     */
    public EnumCombo(Class<?> cl, String[] labels)
    {
        for (String label : labels)
        {
            String name = label.toUpperCase().replace(' ', '_');
            int value = 0;
            try
            {
                java.lang.reflect.Field f = cl.getField(name);
                value = f.getInt(cl);
            }
            catch (Exception e)
            {
                label = "(" + label + ")";
            }
            this.table.put(label, value);
            this.addItem(label);
        }
        this.setSelectedItem(labels[0]);
    }

    /**
     * Returns the value of the field that the user selected.
     * 
     * @return the static field value
     */
    public int getValue()
    {
        return this.table.get(this.getSelectedItem());
    }

    private Map<String, Integer> table = new TreeMap<String, Integer>();
}
