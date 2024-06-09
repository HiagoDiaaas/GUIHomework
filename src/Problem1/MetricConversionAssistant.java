package Problem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MetricConversionAssistant extends JFrame {

    private final JTextField mileField;
    private final JTextField kilometerField;
    private final JTextField poundField;
    private final JTextField kilogramField;
    private final JTextField gallonField;
    private final JTextField literField;
    private final JTextField fahrenheitField;
    private final JTextField centigradeField;

    public MetricConversionAssistant() {
        setTitle("Metric Conversion Assistant");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 3));

        // Mile to Kilometer
        add(new JLabel("Mile:"));
        mileField = new JTextField();
        add(mileField);
        kilometerField = new JTextField();
        kilometerField.setEditable(false);
        add(new JLabel("Kilometer:"));
        add(kilometerField);

        // Pound to Kilogram
        add(new JLabel("Pound:"));
        poundField = new JTextField();
        add(poundField);
        kilogramField = new JTextField();
        kilogramField.setEditable(false);
        add(new JLabel("Kilogram:"));
        add(kilogramField);

        // Gallon to Liter
        add(new JLabel("Gallon:"));
        gallonField = new JTextField();
        add(gallonField);
        literField = new JTextField();
        literField.setEditable(false);
        add(new JLabel("Liter:"));
        add(literField);

        // Fahrenheit to Centigrade
        add(new JLabel("Fahrenheit:"));
        fahrenheitField = new JTextField();
        add(fahrenheitField);
        centigradeField = new JTextField();
        centigradeField.setEditable(false);
        add(new JLabel("Centigrade:"));
        add(centigradeField);

        // Convert Button
        JButton convertButton = new JButton("Convert");
        add(convertButton);
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performConversion();
            }
        });

        setVisible(true);
    }

    private void performConversion() {
        // Mile to Kilometer
        try {
            double miles = Double.parseDouble(mileField.getText());
            double kilometers = miles * 1.60934;
            kilometerField.setText(String.format("%.2f", kilometers));
        } catch (NumberFormatException e) {
            kilometerField.setText("Invalid input");
        }

        // Pound to Kilogram
        try {
            double pounds = Double.parseDouble(poundField.getText());
            double kilograms = pounds * 0.453592;
            kilogramField.setText(String.format("%.2f", kilograms));
        } catch (NumberFormatException e) {
            kilogramField.setText("Invalid input");
        }

        // Gallon to Liter
        try {
            double gallons = Double.parseDouble(gallonField.getText());
            double liters = gallons * 3.78541;
            literField.setText(String.format("%.2f", liters));
        } catch (NumberFormatException e) {
            literField.setText("Invalid input");
        }

        // Fahrenheit to Centigrade
        try {
            double fahrenheit = Double.parseDouble(fahrenheitField.getText());
            double centigrade = (fahrenheit - 32) * 5 / 9;
            centigradeField.setText(String.format("%.2f", centigrade));
        } catch (NumberFormatException e) {
            centigradeField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new MetricConversionAssistant();
    }
}

