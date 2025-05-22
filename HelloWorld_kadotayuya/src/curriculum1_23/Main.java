// パッケージ宣言：このクラスが所属するフォルダ（グループ）を表す
package curriculum1_23;

public class Main {

    public static void main(String[] args) {
        // Encapsulationクラスのインスタンス（オブジェクト）を作成
        // 「らいおーん」という名前、体長2.1m、速度80km/h の値を渡している
        Encapsulation lion = new Encapsulation("らいおーん", 2.1, 80);

        // オブジェクトからgetterを使って情報を取得し、出力
        System.out.println("動物名：" + lion.getName());         // 名前を表示
        System.out.println("体長：" + lion.getHeight() + "m");   // 体長を表示（単位：メートル）
        System.out.println("速度：" + lion.getSpead() + "km/h"); // 速度を表示（単位：km/h）
    }
}