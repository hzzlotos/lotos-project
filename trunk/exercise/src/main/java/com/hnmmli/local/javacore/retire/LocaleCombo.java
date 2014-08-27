package com.hnmmli.local.javacore.retire;

import java.awt.Component;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListDataListener;

/**
 * This combo box lets a user pick a locale. The locales are displayed in the locale of the combo
 * box, and sorted according to the collator of the display locale.
 * 
 * @version 1.00 2004-09-15
 * @author Cay Horstmann
 */
public class LocaleCombo extends JComboBox
{
    /**
     * Constructs a locale combo that displays an immutable collection of locales.
     * 
     * @param locales the locales to display in this combo box
     */
    public LocaleCombo(Locale[] locales)
    {
        this.locales = locales.clone();
        this.sort();
        this.setSelectedItem(this.getLocale());
    }

    @Override
    public void setLocale(Locale newValue)
    {
        super.setLocale(newValue);
        this.sort();
    }

    private void sort()
    {
        Object selected = this.getSelectedItem();
        final Locale loc = this.getLocale();
        final Collator collator = Collator.getInstance(loc);
        final Comparator<Locale> comp = new Comparator<Locale>() {
            @Override
            public int compare(Locale a, Locale b)
            {
                return collator.compare(a.getDisplayName(loc), b.getDisplayName(loc));
            }
        };
        Arrays.sort(this.locales, comp);
        this.setModel(new ComboBoxModel() {
            @Override
            public Object getElementAt(int i)
            {
                return LocaleCombo.this.locales[i];
            }

            @Override
            public int getSize()
            {
                return LocaleCombo.this.locales.length;
            }

            @Override
            public void addListDataListener(ListDataListener l)
            {
            }

            @Override
            public void removeListDataListener(ListDataListener l)
            {
            }

            @Override
            public Object getSelectedItem()
            {
                return this.selected >= 0 ? LocaleCombo.this.locales[this.selected] : null;
            }

            @Override
            public void setSelectedItem(Object anItem)
            {
                if (anItem == null)
                {
                    this.selected = -1;
                }
                else
                {
                    this.selected = Arrays.binarySearch(LocaleCombo.this.locales, (Locale) anItem, comp);
                }
            }

            private int selected;
        });
        this.setSelectedItem(selected);
    }

    @Override
    public ListCellRenderer getRenderer()
    {
        if (this.renderer == null)
        {
            final ListCellRenderer originalRenderer = super.getRenderer();
            if (originalRenderer == null)
            {
                return null;
            }
            this.renderer = new ListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                        boolean cellHasFocus)
                {
                    String renderedValue = ((Locale) value).getDisplayName(LocaleCombo.this.getLocale());
                    return originalRenderer.getListCellRendererComponent(list, renderedValue, index, isSelected,
                            cellHasFocus);
                }
            };
        }
        return this.renderer;
    }

    @Override
    public void setRenderer(ListCellRenderer newValue)
    {
        this.renderer = null;
        super.setRenderer(newValue);
    }

    private Locale[]         locales;

    private ListCellRenderer renderer;
}
