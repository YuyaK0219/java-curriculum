// パッケージ宣言：このクラスが所属するパッケージ名
package curriculum1_25.Main;

// 標準入力を受け取るためのScannerクラスをインポート
import java.util.Scanner;
// Playerクラスを使用するためにインポート（自作クラス）
import curriculum1_25.logic.Player;

public class Main {
    public static void main(String[] args) {
        // ユーザーの入力を受け取るためのScannerオブジェクトを作成
        Scanner sc = new Scanner(System.in);

        // 名前の入力を促す
        System.out.print("名前を入力してください：");
        // 入力された名前を取得（1行分）
        String inputName = sc.nextLine();

        // 入力された名前を使ってPlayerクラスのインスタンスを生成
        Player player = new Player(inputName);

        // 空行（見やすさのため）
        System.out.println();

        // プレイヤーの挨拶とステータスの表示
        System.out.println("こんにちは「" + player.getName() + "」さん");
        System.out.println("ステータス");
        System.out.println("HP：" + player.getHp());     // HP
        System.out.println("MP：" + player.getMp());     // MP
        System.out.println("攻撃力：" + player.getAtk()); // 攻撃力
        System.out.println("素早さ：" + player.getAgi()); // 素早さ
        System.out.println("防御力：" + player.getDef()); // 防御力

        // 空行（見やすさのため）
        System.out.println();

        // 冒険開始のメッセージ
        System.out.println("さあ冒険に出かけよう！");
    }
}