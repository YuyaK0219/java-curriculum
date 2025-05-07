package curriculum_B;

import java.util.Random;
import java.util.Scanner;

public class Qes1_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        /*
        ログイン時の入力チェックシステムを下記条件で作成してください
        ・コンソールにユーザー名を入力できるようにしてください
        ・ユーザー名の文字数が10文字より大きい場合「名前を10文字以内にしてください」と出力してください
        ・ユーザー名の文字数が0文字以下もしくはnullの場合「名前を入力してください」と出力してください
        ・ユーザー名が正常な値だった場合「ユーザー名「 入力したユーザー名 」を登録しました」と出力してください
        */
        
        //ユーザー名入力
        System.out.println("ユーザー名を入力してください：");
        String username = scanner.nextLine();
        System.out.println();

        if (username == null || username.isEmpty()) {  //空白、空文字列ではないか
            System.out.println("名前を入力してください");
        } else if (username.length() > 10) {           //10文字以内
            System.out.println("名前を10文字以内にしてください");
            
        /*
         ユーザー名が半角英数字以外の場合「半角英数字のみで名前を入力してください」と出力してください
         */
        } else if (!username.matches("^[a-zA-Z0-9]+$")) {    //半角英数字のみ
            System.out.println("半角英数字のみで名前を入力してください");
        } else {
            System.out.println("ユーザー名「" + username + "」を登録しました");

        System.out.println();
        
        /*
        じゃんけんのシステムを下記の条件で作成してください	
        ・「0はグー、1：チョキ、2：パー」とすること	
        ・じゃんけんに勝つまでループすること	
        ・一回ごとに自分の手と相手の手を下記の通り出力してください	
  	     ユーザー名「name」を登録しました
	     nameの手は「パー」
	     相手の手は「グー」
         */
        
        //じゃんけん
        Random random = new Random();
        int count = 0;

        while (true) {
            System.out.print("じゃんけんの手を入力してください（0: グー, 1: チョキ, 2: パー）：");
            System.out.println();

            int playerHand;
            try {
                playerHand = Integer.parseInt(scanner.nextLine()); //入力された数字をInt型に変換
            } catch (NumberFormatException e) {  //数字以外の時のエラー処理
                System.out.println("0〜2の数字を入力してください");
                continue;  //条件に当てはまっていないときのループ
            }

            if (playerHand < 0 || playerHand > 2) {  //数字の0−2以外を入力したときのエラー処理
                System.out.println("0〜2の数字を入力してください"); 
                continue;
            }
            System.out.println();

            int enemyHand = random.nextInt(3); //じゃんけんの手数種
            count++;  //じゃんけんの回数カウント

            String[] hands = {"グー", "チョキ", "パー"};

            System.out.println(username + "の手は「" + hands[playerHand] + "」");
            System.out.println("相手の手は「" + hands[enemyHand] + "」¥n");

            if (playerHand == enemyHand) {  //あいこの時
                System.out.println("DRAW あいこ もう一回しましょう！¥n");
                continue;
            }

            boolean win = (playerHand == 0 && enemyHand == 1) ||
                          (playerHand == 1 && enemyHand == 2) ||
                          (playerHand == 2 && enemyHand == 0);  //じゃんけんの勝ち処理

            if (win) {      //・条件分岐の設定
                System.out.println("やるやん。");  //勝った場合の処理
                System.out.println("次は俺にリベンジさせて");
                break;
            } else {        //負けた場合
                System.out.println("俺の勝ち！");
                switch (playerHand) {
                    case 0:  //自分がグーで負けたとき
                        System.out.println("なんで負けたか、明日まで考えといてください。");
                        System.out.println("そしたら何かが見えてくるはずです");
                        break;
                    case 1:  //自分がチョキで負けたとき
                        System.out.println("負けは次につながるチャンスです！");
                        System.out.println("ネバーギブアップ！");
                        break;
                    case 2:  //自分がパーで負けたとき
                        System.out.println("たかがじゃんけん、そう思ってないですか？");
                        System.out.println("それやったら次も、俺が勝ちますよ");
                        break;
                   
               }
            }
            System.out.println();
        }
            System.out.println("勝つまでにかかった合計回数は" + count + "回です");
        }
        scanner.close();
    }
}