package ui;

import query.Query;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * A UI panel for entering new queries.
 */
public class NewQueryPanel extends JPanel {
    private final JTextField newQuery = new JTextField(10);
    private final JPanel colorSetter;
    private final Application app;
    private final Random random;

    public NewQueryPanel(Application app) {
        this.app = app;
        this.colorSetter = new JPanel();

        random = new Random();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        GridBagConstraints c = new GridBagConstraints();

        // Create search label and field.
        JLabel queryLabel = new JLabel("Enter Search: ");
        queryLabel.setLabelFor(newQuery);
        labelLayout(c, 0, queryLabel);
        newQuery.setMaximumSize(new Dimension(200, 20));
        add(newQuery, c);

        addDivider();

        // Create color label and field.
        JLabel colorLabel = new JLabel("Select Color: ");
        colorSetter.setBackground(getRandomColor());
        labelLayout(c, 1, colorLabel);
        colorSetter.setMaximumSize(new Dimension(200, 20));
        add(colorSetter, c);

        addDivider();

        // Create search button.
        JButton searchButton = new JButton("Add New Search");
        c.gridx = GridBagConstraints.RELATIVE; //aligned with button 2
        c.gridwidth = 2; //2 columns wide
        c.gridy = GridBagConstraints.RELATIVE; //third row
        add(searchButton, c);

        // Add border around search UI options.
        setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("New Search"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));

        // Add functionality to search button.
        searchButton.addActionListener(e -> {
            if (!newQuery.getText().equals("")) {
                addQuery(newQuery.getText().toLowerCase());
                newQuery.setText("");
            }
        });

        // This makes the "Enter" key submit the query.
        app.getRootPane().setDefaultButton(searchButton);

        initColorListener();
    }

    private void addDivider() {
        add(Box.createRigidArea(new Dimension(5, 5)));
    }

    private void labelLayout(GridBagConstraints c, int posY, JLabel l) {
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.NONE;
        c.gridy = posY;
        c.gridx = 0;
        add(l, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
    }

    // Open palette when button is clicked to set query color.
    private void initColorListener() {
        colorSetter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Color newColor = JColorChooser.showDialog(
                            app,
                            "Choose Background Color",
                            colorSetter.getBackground());
                    // newColor is "null" if user clicks "Cancel" button on JColorChooser popup.
                    if (newColor != null) {
                        colorSetter.setBackground(newColor);
                    }
                }
            }
        });
    }

    private void addQuery(String newQuery) {
        Query query = new Query(newQuery, colorSetter.getBackground(), app.map());
        app.addQuery(query);
        colorSetter.setBackground(getRandomColor());
    }

    public Color getRandomColor() {
        // Pleasant colors: https://stackoverflow.com/questions/4246351/creating-random-colour-in-java#4246418
        final float hue = random.nextFloat();
        final float saturation = (random.nextInt(2000) + 1000) / 10000f;
        final float luminance = 0.9f;
        return Color.getHSBColor(hue, saturation, luminance);
    }
}
