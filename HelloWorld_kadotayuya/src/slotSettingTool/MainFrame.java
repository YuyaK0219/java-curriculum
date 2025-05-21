package slotSettingTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MainFrame {
    static final String[] zones = {
        "天国", "100G", "200G", "300G", "400G", "500G",
        "600G", "700G", "800G", "900G", "1000G", "1100G"
    };
    static int[] zoneCounts = new int[zones.length];

    static GraphPanel graph;
    static JPanel ratioPanel;

    public static void main(String[] args) {
        int[] extraCounts = new int[3]; // etc, cz, direct
        int[] loadResult = DataManager.loadCounts(zoneCounts, extraCounts);
        int gameCount = loadResult[0];
        int etcCount = loadResult[1];
        int czCount = loadResult[2];
        int directCount = loadResult[3];

        JFrame frame = new JFrame("スロットカウンター");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 900);
        frame.setLayout(new BorderLayout());

        // ゲーム数入力
        JPanel topPanel = new JPanel();
        JLabel gameLabel = new JLabel("ゲーム数：");
        JTextField gameField = new JTextField(10);
        gameField.setText(String.valueOf(gameCount));
        topPanel.add(gameLabel);
        topPanel.add(gameField);
        frame.add(topPanel, BorderLayout.NORTH);

        // 左パネル（ゾーンカウント）
        JPanel leftPanel = new JPanel(new GridLayout(zones.length, 1, 5, 5));
        JLabel[] zoneLabels = new JLabel[zones.length];
        for (int i = 0; i < zones.length; i++) {
            int index = i;
            JPanel panel = new JPanel(new BorderLayout());
            JButton btn = new ColorSplitButton(zones[i]);
            JLabel label = new JLabel("", SwingConstants.CENTER);
            zoneLabels[i] = label;

            btn.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    int x = e.getX();
                    if (x < btn.getWidth() * 0.7) zoneCounts[index]++;
                    else if (zoneCounts[index] > 0) zoneCounts[index]--;
                    updateZoneLabels(zoneLabels);
                    graph.repaint();
                    updateRatioTable(ratioPanel, zoneCounts);
                }
            });

            panel.add(btn, BorderLayout.CENTER);
            panel.add(label, BorderLayout.SOUTH);
            leftPanel.add(panel);
        }

        // 右パネル
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        CountSection etcSection = new CountSection("通常時幕間チャンス", gameField);
        etcSection.setCount(etcCount);
        rightPanel.add(etcSection);
        rightPanel.add(Box.createVerticalStrut(15));

        CountSection czSection = new CountSection("CZ確率", gameField);
        czSection.setCount(czCount);
        rightPanel.add(czSection);
        rightPanel.add(Box.createVerticalStrut(15));

        CountSection directSection = new CountSection("モードA→C回数", gameField);
        directSection.setCount(directCount);
        rightPanel.add(directSection);
        rightPanel.add(Box.createVerticalStrut(25));

        rightPanel.add(new JLabel("ゾーン棒グラフ", SwingConstants.CENTER));

        graph = new GraphPanel(zoneCounts, zones);
        graph.setMaximumSize(new Dimension(400, 400));
        rightPanel.add(graph);

        // センターパネル結合
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 10));
        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);
        frame.add(centerPanel, BorderLayout.CENTER);

        // 比率表（Excel風）
        ratioPanel = new JPanel();
        updateRatioTable(ratioPanel, zoneCounts);
        frame.add(ratioPanel, BorderLayout.SOUTH);

        // リセットボタン
        JButton resetButton = new JButton("🔘 リセット");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Arrays.fill(zoneCounts, 0);
                etcSection.setCount(0);
                czSection.setCount(0);
                directSection.setCount(0);
                gameField.setText("0");
                updateZoneLabels(zoneLabels);
                updateRatioTable(ratioPanel, zoneCounts);
                graph.repaint();
                DataManager.saveCounts(0, zoneCounts, 0, 0, 0);
            }
        });
        frame.add(resetButton, BorderLayout.PAGE_END);

        // ウィンドウ閉じるとき保存
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    int g = Integer.parseInt(gameField.getText());
                    DataManager.saveCounts(g, zoneCounts,
                        etcSection.getCount(), czSection.getCount(), directSection.getCount());
                } catch (NumberFormatException ex) {
                    DataManager.saveCounts(0, zoneCounts,
                        etcSection.getCount(), czSection.getCount(), directSection.getCount());
                }
            }
        });

        updateZoneLabels(zoneLabels);
        frame.setVisible(true);
    }

    static void updateZoneLabels(JLabel[] labels) {
        int total = Arrays.stream(zoneCounts).sum();
        for (int i = 0; i < zones.length; i++) {
            double percent = (total == 0) ? 0 : (double) zoneCounts[i] / total * 100;
            labels[i].setText(zoneCounts[i] + "回（" + String.format("%.1f", percent) + "%）");
        }
    }

    static void updateRatioTable(JPanel panel, int[] counts) {
        panel.removeAll();
        panel.setLayout(new GridLayout(zones.length + 1, 3, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("ゾーン割合表"));
        panel.add(new JLabel("ゾーン名", SwingConstants.CENTER));
        panel.add(new JLabel("回数", SwingConstants.CENTER));
        panel.add(new JLabel("割合", SwingConstants.CENTER));
        int total = Arrays.stream(counts).sum();
        for (int i = 0; i < zones.length; i++) {
            panel.add(new JLabel(zones[i], SwingConstants.CENTER));
            panel.add(new JLabel(String.valueOf(counts[i]), SwingConstants.CENTER));
            double percent = (total == 0) ? 0 : (double) counts[i] / total * 100;
            panel.add(new JLabel(String.format("%.1f%%", percent), SwingConstants.CENTER));
        }
        panel.revalidate();
        panel.repaint();
    }
}