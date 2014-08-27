package com.hnmmli.local.javacore.retire;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This applet shows a retirement calculator. The UI is displayed in English, German, and Chinese.
 * 
 * @version 1.22 2007-07-25
 * @author Cay Horstmann
 */
public class Retire extends JApplet
{
    private JButton         computeButton         = new JButton();

    private JTextField      contribField          = new JTextField(10);

    private JLabel          contribLabel          = new JLabel();

    private NumberFormat    currencyFmt;

    private JTextField      currentAgeField       = new JTextField(4);

    private JLabel          currentAgeLabel       = new JLabel();

    private Locale          currentLocale;

    private JTextField      deathAgeField         = new JTextField(4);

    private JLabel          deathAgeLabel         = new JLabel();

    private JTextField      incomeField           = new JTextField(10);

    private JLabel          incomeLabel           = new JLabel();

    private JTextField      inflationPercentField = new JTextField(6);

    private JLabel          inflationPercentLabel = new JLabel();

    private RetireInfo      info                  = new RetireInfo();

    private JTextField      investPercentField    = new JTextField(6);

    private JLabel          investPercentLabel    = new JLabel();

    private JLabel          languageLabel         = new JLabel();

    private JComboBox       localeCombo           = new LocaleCombo(this.locales);

    private static Locale[] locales               = { Locale.ENGLISH, Locale.CHINA, Locale.GERMANY };

    private NumberFormat    numberFmt;

    private NumberFormat    percentFmt;

    private ResourceBundle  res;

    private ResourceBundle  resStrings;

    private JTextField      retireAgeField        = new JTextField(4);

    private JLabel          retireAgeLabel        = new JLabel();

    private RetireCanvas    retireCanvas          = new RetireCanvas();

    private JTextArea       retireText            = new JTextArea(10, 25);

    private JTextField      savingsField          = new JTextField(10);

    private JLabel          savingsLabel          = new JLabel();

    /**
     * Reads the user input from the text fields.
     */
    public void getInfo()
    {
        try
        {
            this.info.setSavings(this.currencyFmt.parse(this.savingsField.getText()).doubleValue());
            this.info.setContrib(this.currencyFmt.parse(this.contribField.getText()).doubleValue());
            this.info.setIncome(this.currencyFmt.parse(this.incomeField.getText()).doubleValue());
            this.info.setCurrentAge(this.numberFmt.parse(this.currentAgeField.getText()).intValue());
            this.info.setRetireAge(this.numberFmt.parse(this.retireAgeField.getText()).intValue());
            this.info.setDeathAge(this.numberFmt.parse(this.deathAgeField.getText()).intValue());
            this.info.setInvestPercent(this.percentFmt.parse(this.investPercentField.getText()).doubleValue());
            this.info.setInflationPercent(this.percentFmt.parse(this.inflationPercentField.getText()).doubleValue());
        }
        catch (ParseException e)
        {
        }
    }

    @Override
    public void init()
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                Retire.this.initUI();
            }
        });
    }

    public void initUI()
    {
        this.setLayout(new GridBagLayout());
        this.add(this.languageLabel, new GBC(0, 0).setAnchor(GBC.EAST));
        this.add(this.savingsLabel, new GBC(0, 1).setAnchor(GBC.EAST));
        this.add(this.contribLabel, new GBC(2, 1).setAnchor(GBC.EAST));
        this.add(this.incomeLabel, new GBC(4, 1).setAnchor(GBC.EAST));
        this.add(this.currentAgeLabel, new GBC(0, 2).setAnchor(GBC.EAST));
        this.add(this.retireAgeLabel, new GBC(2, 2).setAnchor(GBC.EAST));
        this.add(this.deathAgeLabel, new GBC(4, 2).setAnchor(GBC.EAST));
        this.add(this.inflationPercentLabel, new GBC(0, 3).setAnchor(GBC.EAST));
        this.add(this.investPercentLabel, new GBC(2, 3).setAnchor(GBC.EAST));
        this.add(this.localeCombo, new GBC(1, 0, 3, 1));
        this.add(this.savingsField, new GBC(1, 1).setWeight(100, 0).setFill(GBC.HORIZONTAL));
        this.add(this.contribField, new GBC(3, 1).setWeight(100, 0).setFill(GBC.HORIZONTAL));
        this.add(this.incomeField, new GBC(5, 1).setWeight(100, 0).setFill(GBC.HORIZONTAL));
        this.add(this.currentAgeField, new GBC(1, 2).setWeight(100, 0).setFill(GBC.HORIZONTAL));
        this.add(this.retireAgeField, new GBC(3, 2).setWeight(100, 0).setFill(GBC.HORIZONTAL));
        this.add(this.deathAgeField, new GBC(5, 2).setWeight(100, 0).setFill(GBC.HORIZONTAL));
        this.add(this.inflationPercentField, new GBC(1, 3).setWeight(100, 0).setFill(GBC.HORIZONTAL));
        this.add(this.investPercentField, new GBC(3, 3).setWeight(100, 0).setFill(GBC.HORIZONTAL));
        this.add(this.retireCanvas, new GBC(0, 4, 4, 1).setWeight(100, 100).setFill(GBC.BOTH));
        this.add(new JScrollPane(this.retireText), new GBC(4, 4, 2, 1).setWeight(0, 100).setFill(GBC.BOTH));

        this.computeButton.setName("computeButton");
        this.computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                Retire.this.getInfo();
                Retire.this.updateData();
                Retire.this.updateGraph();
            }
        });
        this.add(this.computeButton, new GBC(5, 3));

        this.retireText.setEditable(false);
        this.retireText.setFont(new Font("Monospaced", Font.PLAIN, 10));

        this.info.setSavings(0);
        this.info.setContrib(9000);
        this.info.setIncome(60000);
        this.info.setCurrentAge(35);
        this.info.setRetireAge(65);
        this.info.setDeathAge(85);
        this.info.setInvestPercent(0.1);
        this.info.setInflationPercent(0.05);

        int localeIndex = 0; // US locale is default selection
        for (int i = 0; i < this.locales.length; i++)
        {
            // if current locale one of the choices, select it
            if (this.getLocale().equals(this.locales[i]))
            {
                localeIndex = i;
            }
        }
        this.setCurrentLocale(this.locales[localeIndex]);

        this.localeCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                Retire.this.setCurrentLocale((Locale) Retire.this.localeCombo.getSelectedItem());
                Retire.this.validate();
            }
        });
    }

    /**
     * Sets the current locale.
     * 
     * @param locale the desired locale
     */
    public void setCurrentLocale(Locale locale)
    {
        this.currentLocale = locale;
        this.localeCombo.setSelectedItem(this.currentLocale);
        this.localeCombo.setLocale(this.currentLocale);

        /* 读取配置文件 其中包要指向全路径 */
        this.res = ResourceBundle.getBundle("com.hnmmli.local.javacore.retire.RetireResources", this.currentLocale);
        this.resStrings = ResourceBundle
                .getBundle("com.hnmmli.local.javacore.retire.RetireStrings", this.currentLocale);
        this.currencyFmt = NumberFormat.getCurrencyInstance(this.currentLocale);
        this.numberFmt = NumberFormat.getNumberInstance(this.currentLocale);
        this.percentFmt = NumberFormat.getPercentInstance(this.currentLocale);

        this.updateDisplay();
        this.updateInfo();
        this.updateData();
        this.updateGraph();
    }

    /**
     * Updates the data displayed in the text area.
     */
    public void updateData()
    {
        this.retireText.setText("");
        MessageFormat retireMsg = new MessageFormat("");
        retireMsg.setLocale(this.currentLocale);
        retireMsg.applyPattern(this.resStrings.getString("retire"));

        for (int i = this.info.getCurrentAge(); i <= this.info.getDeathAge(); i++)
        {
            Object[] args = { i, this.info.getBalance(i) };
            this.retireText.append(retireMsg.format(args) + "\n");
        }
    }

    /**
     * Updates all labels in the display.
     */
    public void updateDisplay()
    {
        this.languageLabel.setText(this.resStrings.getString("language"));
        this.savingsLabel.setText(this.resStrings.getString("savings"));
        this.contribLabel.setText(this.resStrings.getString("contrib"));
        this.incomeLabel.setText(this.resStrings.getString("income"));
        this.currentAgeLabel.setText(this.resStrings.getString("currentAge"));
        this.retireAgeLabel.setText(this.resStrings.getString("retireAge"));
        this.deathAgeLabel.setText(this.resStrings.getString("deathAge"));
        this.inflationPercentLabel.setText(this.resStrings.getString("inflationPercent"));
        this.investPercentLabel.setText(this.resStrings.getString("investPercent"));
        this.computeButton.setText(this.resStrings.getString("computeButton"));
    }

    /**
     * Updates the graph.
     */
    public void updateGraph()
    {
        this.retireCanvas.setColorPre((Color) this.res.getObject("colorPre"));
        this.retireCanvas.setColorGain((Color) this.res.getObject("colorGain"));
        this.retireCanvas.setColorLoss((Color) this.res.getObject("colorLoss"));
        this.retireCanvas.setInfo(this.info);
        this.repaint();
    }

    /**
     * Updates the information in the text fields.
     */
    public void updateInfo()
    {
        this.savingsField.setText(this.currencyFmt.format(this.info.getSavings()));
        this.contribField.setText(this.currencyFmt.format(this.info.getContrib()));
        this.incomeField.setText(this.currencyFmt.format(this.info.getIncome()));
        this.currentAgeField.setText(this.numberFmt.format(this.info.getCurrentAge()));
        this.retireAgeField.setText(this.numberFmt.format(this.info.getRetireAge()));
        this.deathAgeField.setText(this.numberFmt.format(this.info.getDeathAge()));
        this.investPercentField.setText(this.percentFmt.format(this.info.getInvestPercent()));
        this.inflationPercentField.setText(this.percentFmt.format(this.info.getInflationPercent()));
    }
}

/**
 * This panel draws a graph of the investment result.
 */
class RetireCanvas extends JPanel
{
    private static final int PANEL_HEIGHT = 200;

    private static final int PANEL_WIDTH  = 400;

    private Color            colorGain;

    private Color            colorLoss;

    private Color            colorPre;

    private RetireInfo       info         = null;

    public RetireCanvas()
    {
        this.setSize(PANEL_WIDTH, PANEL_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if (this.info == null)
        {
            return;
        }

        double minValue = 0;
        double maxValue = 0;
        int i;
        for (i = this.info.getCurrentAge(); i <= this.info.getDeathAge(); i++)
        {
            double v = this.info.getBalance(i);
            if (minValue > v)
            {
                minValue = v;
            }
            if (maxValue < v)
            {
                maxValue = v;
            }
        }
        if (maxValue == minValue)
        {
            return;
        }

        int barWidth = this.getWidth() / (this.info.getDeathAge() - this.info.getCurrentAge() + 1);
        double scale = this.getHeight() / (maxValue - minValue);

        for (i = this.info.getCurrentAge(); i <= this.info.getDeathAge(); i++)
        {
            int x1 = (i - this.info.getCurrentAge()) * barWidth + 1;
            int y1;
            double v = this.info.getBalance(i);
            int height;
            int yOrigin = (int) (maxValue * scale);

            if (v >= 0)
            {
                y1 = (int) ((maxValue - v) * scale);
                height = yOrigin - y1;
            }
            else
            {
                y1 = yOrigin;
                height = (int) (-v * scale);
            }

            if (i < this.info.getRetireAge())
            {
                g2.setPaint(this.colorPre);
            }
            else
                if (v >= 0)
                {
                    g2.setPaint(this.colorGain);
                }
                else
                {
                    g2.setPaint(this.colorLoss);
                }
            Rectangle2D bar = new Rectangle2D.Double(x1, y1, barWidth - 2, height);
            g2.fill(bar);
            g2.setPaint(Color.black);
            g2.draw(bar);
        }
    }

    /**
     * Sets the color to be used after retirement while the account balance is positive.
     * 
     * @param color the desired color
     */
    public void setColorGain(Color color)
    {
        this.colorGain = color;
        this.repaint();
    }

    /**
     * Sets the color to be used after retirement when the account balance is negative.
     * 
     * @param color the desired color
     */
    public void setColorLoss(Color color)
    {
        this.colorLoss = color;
        this.repaint();
    }

    /**
     * Sets the color to be used before retirement.
     * 
     * @param color the desired color
     */
    public void setColorPre(Color color)
    {
        this.colorPre = color;
        this.repaint();
    }

    /**
     * Sets the retirement information to be plotted.
     * 
     * @param newInfo the new retirement info.
     */
    public void setInfo(RetireInfo newInfo)
    {
        this.info = newInfo;
        this.repaint();
    }
}

/**
 * The information required to compute retirement income data.
 */
class RetireInfo
{
    private int    age;

    private double balance;

    private double contrib;

    private int    currentAge;

    private int    deathAge;

    private double income;

    private double inflationPercent;

    private double investPercent;

    private int    retireAge;

    private double savings;

    /**
     * Gets the available balance for a given year.
     * 
     * @param year the year for which to compute the balance
     * @return the amount of money available (or required) in that year
     */
    public double getBalance(int year)
    {
        if (year < this.currentAge)
        {
            return 0;
        }
        else
            if (year == this.currentAge)
            {
                this.age = year;
                this.balance = this.savings;
                return this.balance;
            }
            else
                if (year == this.age)
                {
                    return this.balance;
                }
        if (year != this.age + 1)
        {
            this.getBalance(year - 1);
        }
        this.age = year;
        if (this.age < this.retireAge)
        {
            this.balance += this.contrib;
        }
        else
        {
            this.balance -= this.income;
        }
        this.balance = this.balance * (1 + (this.investPercent - this.inflationPercent));
        return this.balance;
    }

    /**
     * Gets the annual contribution to the retirement account.
     * 
     * @return the contribution amount
     */
    public double getContrib()
    {
        return this.contrib;
    }

    /**
     * Gets the current age.
     * 
     * @return the age
     */
    public int getCurrentAge()
    {
        return this.currentAge;
    }

    /**
     * Gets the expected age of death.
     * 
     * @return the age
     */
    public int getDeathAge()
    {
        return this.deathAge;
    }

    /**
     * Gets the annual income.
     * 
     * @return the income amount
     */
    public double getIncome()
    {
        return this.income;
    }

    /**
     * Gets the estimated percentage of inflation.
     * 
     * @return the percentage
     */
    public double getInflationPercent()
    {
        return this.inflationPercent;
    }

    /**
     * Gets the estimated yield of the investment.
     * 
     * @return the percentage
     */
    public double getInvestPercent()
    {
        return this.investPercent;
    }

    /**
     * Gets the desired retirement age.
     * 
     * @return the age
     */
    public int getRetireAge()
    {
        return this.retireAge;
    }

    /**
     * Gets the amount of prior savings.
     * 
     * @return the savings amount
     */
    public double getSavings()
    {
        return this.savings;
    }

    /**
     * Sets the annual contribution to the retirement account.
     * 
     * @param newValue the contribution amount
     */
    public void setContrib(double newValue)
    {
        this.contrib = newValue;
    }

    /**
     * Sets the current age.
     * 
     * @param newValue the age
     */
    public void setCurrentAge(int newValue)
    {
        this.currentAge = newValue;
    }

    /**
     * Sets the expected age of death.
     * 
     * @param newValue the age
     */
    public void setDeathAge(int newValue)
    {
        this.deathAge = newValue;
    }

    /**
     * Sets the annual income.
     * 
     * @param newValue the income amount
     */
    public void setIncome(double newValue)
    {
        this.income = newValue;
    }

    /**
     * Sets the estimated percentage of inflation.
     * 
     * @param newValue the percentage
     */
    public void setInflationPercent(double newValue)
    {
        this.inflationPercent = newValue;
    }

    /**
     * Sets the estimated yield of the investment.
     * 
     * @param newValue the percentage
     */
    public void setInvestPercent(double newValue)
    {
        this.investPercent = newValue;
    }

    /**
     * Sets the desired retirement age.
     * 
     * @param newValue the age
     */
    public void setRetireAge(int newValue)
    {
        this.retireAge = newValue;
    }

    /**
     * Sets the amount of prior savings.
     * 
     * @param newValue the savings amount
     */
    public void setSavings(double newValue)
    {
        this.savings = newValue;
    }
}
