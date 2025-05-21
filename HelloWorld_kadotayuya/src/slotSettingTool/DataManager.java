package slotSettingTool;

import java.io.*;
import java.util.*;

public class DataManager {
    private static final String SAVE_FILE = "counts.txt";

    public static void saveCounts(
        int gameCount, int[] zoneCounts, int etcCount, int czCount, int directHitCount
    ) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(SAVE_FILE))) {
            pw.println(gameCount);
            for (int count : zoneCounts) pw.println(count);
            pw.println(etcCount);
            pw.println(czCount);
            pw.println(directHitCount);
        } catch (IOException e) {
            System.out.println("保存失敗: " + e.getMessage());
        }
    }

    public static int[] loadCounts(int[] zoneCounts, int[] counts) {
        File file = new File(SAVE_FILE);
        if (!file.exists()) return new int[]{0, 0, 0, 0}; // game, etc, cz, direct

        try (Scanner scanner = new Scanner(file)) {
            int gameCount = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;
            for (int i = 0; i < zoneCounts.length && scanner.hasNextLine(); i++) {
                zoneCounts[i] = Integer.parseInt(scanner.nextLine());
            }
            for (int i = 0; i < 3 && scanner.hasNextLine(); i++) {
                counts[i] = Integer.parseInt(scanner.nextLine());
            }
            return new int[]{gameCount, counts[0], counts[1], counts[2]};
        } catch (Exception e) {
            System.out.println("読み込み失敗: " + e.getMessage());
            return new int[]{0, 0, 0, 0};
        }
    }
}