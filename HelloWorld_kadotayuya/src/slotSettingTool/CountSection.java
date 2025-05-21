package slotSettingTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountSection extends JPanel {
    private int count = 0;
    private JLabel displayLabel;
    private String title;
    private JTextField gameField;

    public CountSection(String title, JTextField gameField) {
        this.title = title;
        this.gameField = gameField;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btn = new ColorSplitButton(title);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);

        displayLabel = new JLabel();
        displayLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        displayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                if (x < btn.getWidth() * 0.7) count++;
                else if (count > 0) count--;
                updateDisplay();
            }
        });

        add(titleLabel);
        add(Box.createVerticalStrut(5));
        add(btn);
        add(Box.createVerticalStrut(5));
        add(displayLabel);

        updateDisplay();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int c) {
        count = c;
        updateDisplay();
    }

    private void updateDisplay() {
        int games;
        try {
            games = Integer.parseInt(gameField.getText());
        } catch (NumberFormatException e) {
            games = 0;
        }

        if (games <= 0 || count == 0) {
            displayLabel.setText(count + "回 / " + games + "G = 1/--");
        } else {
            double rate = (double) games / count;
            displayLabel.setText(count + "回 / " + games + "G = 1/" + String.format("%.1f", rate));
        }
    }
}