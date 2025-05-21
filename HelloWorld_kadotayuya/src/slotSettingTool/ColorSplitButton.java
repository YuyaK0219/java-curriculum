package slotSettingTool;

import javax.swing.*;
import java.awt.*;

public class ColorSplitButton extends JButton {
    public ColorSplitButton(String text) {
        super(text);
        setPreferredSize(new Dimension(200, 40));
        setMinimumSize(new Dimension(200, 40));
        setMaximumSize(new Dimension(200, 40));
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(new Color(200, 255, 200)); // 左：加算
        g2.fillRect(0, 0, (int) (w * 0.7), h);

        g2.setColor(new Color(255, 200, 200)); // 右：減算
        g2.fillRect((int) (w * 0.7), 0, (int) (w * 0.3), h);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("SansSerif", Font.BOLD, 16));
        g2.drawString("+", 10, h / 2 + 6);
        g2.drawString("-", w - 25, h / 2 + 6);

        String text = getText();
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        g2.drawString(text, (w - textWidth) / 2, (h + fm.getAscent()) / 2 - 2);

        g2.dispose();
    }
}