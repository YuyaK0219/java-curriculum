package sample;
import org.mindrot.jbcrypt.BCrypt;

public class sample2 {
    public static void main(String[] args) {

            String password = "pass1234";

            // コスト12でソルト生成（通常より安全性アップ）
            String salt = BCrypt.gensalt(12);

            // ソルト付きでハッシュ化
            String hash = BCrypt.hashpw(password, salt);

            System.out.println("コスト12のソルト: " + salt);
            System.out.println("ハッシュ値: " + hash);
        
    }
}