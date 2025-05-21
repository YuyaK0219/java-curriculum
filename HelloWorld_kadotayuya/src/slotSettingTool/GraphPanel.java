package slotSettingTool;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    private int[] zoneCounts;
    private String[] zones;

    public GraphPanel(int[] zoneCounts, String[] zones) {
        this.zoneCounts = zoneCounts;
        this.zones = zones;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int total = 0;
        for (int count : zoneCounts) total += count;
        if (total == 0) return;

        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth(), h = getHeight();
        int barHeight = h / zones.length;

        for (int i = 0; i < zones.length; i++) {
            int val = zoneCounts[i];
            double percent = (double) val / total;
            int barWidth = (int) (percent * (w - 200));
            int y = i * barHeight + 10;

            g2.setColor(Color.getHSBColor((float) i / zones.length, 0.6f, 0.9f));
            g2.fillRect(120, y, barWidth, barHeight - 15);

            g2.setColor(Color.BLACK);
            g2.drawString(zones[i], 10, y + 15);
            g2.drawString(String.format("%.1f%%", percent * 100), 130 + barWidth, y + 15);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}