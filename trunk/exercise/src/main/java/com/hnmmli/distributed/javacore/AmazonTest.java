package com.hnmmli.distributed.javacore;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.xml.ws.Holder;

import com.amaznon.webservices.AWSECommerceService;
import com.amaznon.webservices.AWSECommerceServicePortType;
import com.amaznon.webservices.Item;
import com.amaznon.webservices.ItemSearchRequest;
import com.amaznon.webservices.Items;

/**
 * The client for the Amazon e-commerce test program.
 * 
 * @version 1.10 2007-10-20
 * @author Cay Horstmann
 */
public class AmazonTest
{
    public static void main(String[] args)
    {
        JFrame frame = new AmazonTestFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

/**
 * A frame to select the book author and to display the server response.
 */
class AmazonTestFrame extends JFrame
{
    public AmazonTestFrame()
    {
        this.setTitle("AmazonTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JPanel panel = new JPanel();

        panel.add(new JLabel("Author:"));
        this.author = new JTextField(20);
        panel.add(this.author);

        JButton searchButton = new JButton("Search");
        panel.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                AmazonTestFrame.this.result.setText("Please wait...");
                new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception
                    {
                        String name = AmazonTestFrame.this.author.getText();
                        String books = AmazonTestFrame.this.searchByAuthor(name);
                        AmazonTestFrame.this.result.setText(books);
                        return null;
                    }
                }.execute();
            }
        });

        this.result = new JTextArea();
        this.result.setLineWrap(true);
        this.result.setEditable(false);

        if (accessKey.equals("your key here"))
        {
            this.result.setText("You need to edit the Amazon access key.");
            searchButton.setEnabled(false);
        }

        this.add(panel, BorderLayout.NORTH);
        this.add(new JScrollPane(this.result), BorderLayout.CENTER);
    }

    /**
     * Calls the Amazon web service to find titles that match the author.
     * 
     * @param name the author name
     * @return a description of the matching titles
     */
    private String searchByAuthor(String name)
    {
        AWSECommerceService service = new AWSECommerceService();
        AWSECommerceServicePortType port = service.getPort(AWSECommerceServicePortType.class);
        ItemSearchRequest request = new ItemSearchRequest();
        request.getResponseGroup().add("ItemAttributes");
        request.setSearchIndex("Books");

        Holder<List<Items>> responseHolder = new Holder<List<Items>>();

        request.setAuthor(name);
        port.itemSearch("", accessKey, "", "", "", request, null, null, responseHolder);

        List<Item> response = responseHolder.value.get(0).getItem();

        StringBuilder r = new StringBuilder();
        for (Item item : response)
        {
            r.append("authors=");
            List<String> authors = item.getItemAttributes().getAuthor();
            r.append(authors);
            r.append(",title=");
            r.append(item.getItemAttributes().getTitle());
            r.append(",publisher=");
            r.append(item.getItemAttributes().getPublisher());
            r.append(",pubdate=");
            r.append(item.getItemAttributes().getPublicationDate());
            r.append("\n");
        }
        return r.toString();
    }

    private static final int    DEFAULT_WIDTH  = 450;

    private static final int    DEFAULT_HEIGHT = 300;

    private static final String accessKey      = "12Y1EEATQ8DDYJCVQYR2";

    private JTextField          author;

    private JTextArea           result;
}
