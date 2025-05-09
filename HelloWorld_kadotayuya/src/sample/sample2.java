package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class sample2 {
    public static void main(String[] args) {
        System.out.println("知りたい商品を「、」で区切って入力してください");

        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        List<String> productList = new ArrayList<>();
        for (String item : inputLine.split("、")) {
            productList.add(item.trim());
        }

        Random rand = new Random();

        final int TV_TOTAL = 11;
        int tvCount = rand.nextInt(TV_TOTAL + 1);       // 0〜11
        int displayCount = TV_TOTAL - tvCount;

        for (String product : productList) {
            String message = "";

            // 三項演算子でテレビ／ディスプレイの台数を判断
            int stock = (product.equals("テレビ")) ? tvCount :
                        (product.equals("ディスプレイ")) ? displayCount :
                        rand.nextInt(12); // その他商品はランダム

            // 出力メッセージ判定（switch）
            switch (product) {
                case "パソコン":
                case "冷蔵庫":
                case "扇風機":
                case "洗濯機":
                case "加湿器":
                case "テレビ":
                case "ディスプレイ":
                    message = product + "の残りは" + stock + "台です";
                    break;

                default:
                    message = "対象の商品ではありません";
                    break;
            }

            System.out.println(message);
        }

        scanner.close();
    }
}