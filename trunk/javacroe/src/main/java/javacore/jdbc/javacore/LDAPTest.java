package javacore.jdbc.javacore;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * This program demonstrates access to a hierarchical database through LDAP
 * 
 * @version 1.01 2007-06-28
 * @author Cay Horstmann
 */
public class LDAPTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new LDAPFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * The frame that holds the data panel and the navigation buttons.
 */
class LDAPFrame extends JFrame
{
    public LDAPFrame()
    {
        this.setTitle("LDAPTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new java.awt.GridLayout(1, 2, 3, 1));
        northPanel.add(new JLabel("uid", SwingConstants.RIGHT));
        this.uidField = new JTextField();
        northPanel.add(this.uidField);
        this.add(northPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.findButton = new JButton("Find");
        this.findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                LDAPFrame.this.findEntry();
            }
        });
        buttonPanel.add(this.findButton);

        this.saveButton = new JButton("Save");
        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                LDAPFrame.this.saveEntry();
            }
        });
        buttonPanel.add(this.saveButton);

        this.deleteButton = new JButton("Delete");
        this.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                LDAPFrame.this.deleteEntry();
            }
        });
        buttonPanel.add(this.deleteButton);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event)
            {
                try
                {
                    if (LDAPFrame.this.context != null)
                    {
                        LDAPFrame.this.context.close();
                    }
                }
                catch (NamingException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Finds the entry for the uid in the text field.
     */
    public void findEntry()
    {
        try
        {
            if (this.scrollPane != null)
            {
                this.remove(this.scrollPane);
            }
            String dn = "uid=" + this.uidField.getText() + ",ou=people,dc=mycompany,dc=com";
            if (this.context == null)
            {
                this.context = getContext();
            }
            this.attrs = this.context.getAttributes(dn);
            this.TheDataPanel = new TheDataPanel(this.attrs);
            this.scrollPane = new JScrollPane(this.TheDataPanel);
            this.add(this.scrollPane, BorderLayout.CENTER);
            this.validate();
            this.uid = this.uidField.getText();
        }
        catch (NamingException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    /**
     * Saves the changes that the user made.
     */
    public void saveEntry()
    {
        try
        {
            if (this.TheDataPanel == null)
            {
                return;
            }
            if (this.context == null)
            {
                this.context = getContext();
            }
            if (this.uidField.getText().equals(this.uid)) // update existing entry
            {
                String dn = "uid=" + this.uidField.getText() + ",ou=people,dc=mycompany,dc=com";
                Attributes editedAttrs = this.TheDataPanel.getEditedAttributes();
                NamingEnumeration<? extends Attribute> attrEnum = this.attrs.getAll();
                while (attrEnum.hasMore())
                {
                    Attribute attr = attrEnum.next();
                    String id = attr.getID();
                    Attribute editedAttr = editedAttrs.get(id);
                    if (editedAttr != null && !attr.get().equals(editedAttr.get()))
                    {
                        this.context.modifyAttributes(dn, DirContext.REPLACE_ATTRIBUTE, new BasicAttributes(id,
                                editedAttr.get()));
                    }
                }
            }
            else
            // create new entry
            {
                String dn = "uid=" + this.uidField.getText() + ",ou=people,dc=mycompany,dc=com";
                this.attrs = this.TheDataPanel.getEditedAttributes();
                Attribute objclass = new BasicAttribute("objectClass");
                objclass.add("uidObject");
                objclass.add("person");
                this.attrs.put(objclass);
                this.attrs.put("uid", this.uidField.getText());
                this.context.createSubcontext(dn, this.attrs);
            }

            this.findEntry();
        }
        catch (NamingException e)
        {
            JOptionPane.showMessageDialog(LDAPFrame.this, e);
            e.printStackTrace();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(LDAPFrame.this, e);
            e.printStackTrace();
        }
    }

    /**
     * Deletes the entry for the uid in the text field.
     */
    public void deleteEntry()
    {
        try
        {
            String dn = "uid=" + this.uidField.getText() + ",ou=people,dc=mycompany,dc=com";
            if (this.context == null)
            {
                this.context = getContext();
            }
            this.context.destroySubcontext(dn);
            this.uidField.setText("");
            this.remove(this.scrollPane);
            this.scrollPane = null;
            this.repaint();
        }
        catch (NamingException e)
        {
            JOptionPane.showMessageDialog(LDAPFrame.this, e);
            e.printStackTrace();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(LDAPFrame.this, e);
            e.printStackTrace();
        }
    }

    /**
     * Gets a context from the properties specified in the file ldapserver.properties
     * 
     * @return the directory context
     */
    public static DirContext getContext() throws NamingException, IOException
    {
        Properties props = new Properties();
        FileInputStream in = new FileInputStream("ldapserver.properties");
        props.load(in);
        in.close();

        String url = props.getProperty("ldap.url");
        String username = props.getProperty("ldap.username");
        String password = props.getProperty("ldap.password");

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, password);
        DirContext initial = new InitialDirContext(env);
        DirContext context = (DirContext) initial.lookup(url);

        return context;
    }

    public static final int DEFAULT_WIDTH  = 300;

    public static final int DEFAULT_HEIGHT = 200;

    private JButton         findButton;

    private JButton         saveButton;

    private JButton         deleteButton;

    private JTextField      uidField;

    private TheDataPanel    TheDataPanel;

    private Component       scrollPane;

    private DirContext      context;

    private String          uid;

    private Attributes      attrs;
}

/**
 * This panel displays the contents of a result set.
 */
class TheDataPanel extends JPanel
{
    /**
     * Constructs the data panel.
     * 
     * @param attributes the attributes of the given entry
     */
    public TheDataPanel(Attributes attrs)
    {
        try
        {
            this.setLayout(new java.awt.GridLayout(0, 2, 3, 1));

            NamingEnumeration<? extends Attribute> attrEnum = attrs.getAll();
            while (attrEnum.hasMore())
            {
                Attribute attr = attrEnum.next();
                String id = attr.getID();

                NamingEnumeration<?> valueEnum = attr.getAll();
                while (valueEnum.hasMore())
                {
                    Object value = valueEnum.next();
                    if (id.equals("userPassword"))
                    {
                        value = new String((byte[]) value);
                    }

                    JLabel idLabel = new JLabel(id, SwingConstants.RIGHT);
                    JTextField valueField = new JTextField("" + value);
                    if (id.equals("objectClass"))
                    {
                        valueField.setEditable(false);
                    }
                    if (!id.equals("uid"))
                    {
                        this.add(idLabel);
                        this.add(valueField);
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Attributes getEditedAttributes()
    {
        Attributes attrs = new BasicAttributes();
        for (int i = 0; i < this.getComponentCount(); i += 2)
        {
            JLabel idLabel = (JLabel) this.getComponent(i);
            JTextField valueField = (JTextField) this.getComponent(i + 1);
            String id = idLabel.getText();
            String value = valueField.getText();
            if (id.equals("userPassword"))
            {
                attrs.put("userPassword", value.getBytes());
            }
            else
                if (!id.equals("") && !id.equals("objectClass"))
                {
                    attrs.put(id, value);
                }
        }
        return attrs;
    }
}
