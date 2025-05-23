package curriculum1_29.main;

import java.util.*;
import curriculum1_29.geography.Prefecture;

public class Main {
    public static void main(String[] args) {
        // 都道府県データ
        String[] rawData = {
            "北海道:札幌市:83424",
            "青森県:青森市:9646",
            "岩手県:盛岡市:15275",
            "宮城県:仙台市:7282",
            "秋田県:秋田市:11638",
            "山形県:山形市:9323",
            "福島県:福島市:13784",
            "茨城県:水戸市:6097",
            "栃木県:宇都宮市:6408",
            "群馬県:前橋市:6362",
            "埼玉県:さいたま市:3798"
        };

        Scanner scanner = new Scanner(System.in);

        // 番号入力
        System.out.print("番号をカンマで入力（例：8,5,9）：");
        String[] indices = scanner.nextLine().split(",");

        // 昇順 or 降順
        System.out.print("昇順 or 降順（asc / desc）：");
        String order = scanner.nextLine().trim().toLowerCase();

        List<Prefecture> selected = new ArrayList<>();

        // 入力に応じて都道府県データを取り出す
        for (String indexStr : indices) {
            try {
                int index = Integer.parseInt(indexStr.trim());
                String[] parts = rawData[index].split(":");

                String name = parts[0];
                String capital = parts[1];
                double area = Double.parseDouble(parts[2]);

                Prefecture p = new Prefecture(name, capital, area);
                selected.add(p);
            } catch (Exception e) {
                System.out.println("入力エラー：" + indexStr);
            }
        }

        // 匿名クラスを使ってソート
        if (order.equals("desc")) {
            Collections.sort(selected, new Comparator<Prefecture>() {
                public int compare(Prefecture a, Prefecture b) {
                    return Double.compare(b.getArea(), a.getArea());
                }
            });
        } else {
            Collections.sort(selected, new Comparator<Prefecture>() {
                public int compare(Prefecture a, Prefecture b) {
                    return Double.compare(a.getArea(), b.getArea());
                }
            });
        }

        // 出力
        for (Prefecture p : selected) {
            System.out.println("\n都道府県名：" + p.getName());
            System.out.println("県庁所在地：" + p.getCapital());
            System.out.println("面積：" + p.getArea() + "km2");
        }
    }
}