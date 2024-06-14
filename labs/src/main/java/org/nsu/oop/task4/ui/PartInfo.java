package org.nsu.oop.task4.ui;

import javax.swing.*;
import java.awt.*;
public class PartInfo extends JPanel {

    //tbd from


    private static final String font_name = "Serif";
    private static final int font_size = 16;
    private static final int title_font_size = 20;

    private final JLabel current_amount;
    private final JLabel total_amount;
    public PartInfo(String label){
        super(new GridLayout(3, 1));

        current_amount = new JLabel();
        total_amount = new JLabel();
        JLabel titleLabel = new JLabel(label);

        Font boldFont = new Font(font_name, Font.BOLD, title_font_size);
        titleLabel.setFont(boldFont);

        Font italicFont = new Font(font_name, Font.ITALIC, font_size);
        current_amount.setFont(italicFont);
        total_amount.setFont(italicFont);

        add(titleLabel);
        add(current_amount);
        add(total_amount);
    }

    public void setAmounts(int current_amount, int total_amount) {
        SwingUtilities.invokeLater(() -> {
            this.current_amount.setText("Current: " + current_amount);
            this.total_amount.setText("Total: " + total_amount);
        });
    }
}
