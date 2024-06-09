package Problem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringUtility extends JFrame {

    private final JTextField inputField;
    private final JTextField outputField;

    public StringUtility() {
        setTitle("String Utility");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));

        // Buttons
        JButton countButton = new JButton("Count Letters");
        JButton reverseButton = new JButton("Reverse Letters");
        JButton removeButton = new JButton("Remove Duplicates");

        buttonPanel.add(countButton);
        buttonPanel.add(reverseButton);
        buttonPanel.add(removeButton);

        // Panel for input and output
        JPanel ioPanel = new JPanel();
        ioPanel.setLayout(new GridBagLayout());
        GridBagConstraints ioGbc = new GridBagConstraints();

        inputField = new JTextField();
        outputField = new JTextField();
        outputField.setEditable(false);

        ioGbc.gridx = 0;
        ioGbc.gridy = 0;
        ioGbc.insets = new Insets(5, 5, 5, 5);
        ioGbc.fill = GridBagConstraints.HORIZONTAL;
        ioPanel.add(new JLabel("Input:"), ioGbc);

        ioGbc.gridx = 1;
        ioGbc.gridy = 0;
        ioGbc.weightx = 1.0;
        ioPanel.add(inputField, ioGbc);

        ioGbc.gridx = 0;
        ioGbc.gridy = 1;
        ioGbc.weightx = 0.0;
        ioPanel.add(new JLabel("Output:"), ioGbc);

        ioGbc.gridx = 1;
        ioGbc.gridy = 1;
        ioGbc.weightx = 1.0;
        ioPanel.add(outputField, ioGbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.VERTICAL;
        add(buttonPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(ioPanel, gbc);

        // Adding action listeners to the buttons
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCountLetters();
            }
        });

        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performReverseLetters();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performRemoveDuplicates();
            }
        });

        setVisible(true);
    }

    private void performCountLetters() {
        String input = inputField.getText();
        int count = input.length();
        outputField.setText(String.valueOf(count));
    }

    private void performReverseLetters() {
        String input = inputField.getText();
        String reversed = new StringBuilder(input).reverse().toString();
        outputField.setText(reversed);
    }

    private void performRemoveDuplicates() {
        String input = inputField.getText();
        Set<Character> charSet = new LinkedHashSet<>();
        for (char c : input.toCharArray()) {
            charSet.add(c);
        }
        StringBuilder result = new StringBuilder();
        for (char c : charSet) {
            result.append(c);
        }
        outputField.setText(result.toString());
    }

    public static void main(String[] args) {
        new StringUtility();
    }
}