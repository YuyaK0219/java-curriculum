package curriculum_A;

public class Qes_13 {
	public static void main(String[] args) {
		
		
		/*下記9個をローカル変数として宣言のみしてください
		・バイト型・短整数型・整数型・長整数型・単精度浮動小数点数型・倍精度浮動小数点数型
		・文字型・文字列型・ブーリアン型
		それぞれのローカル変数をローカル内でそれぞれの初期値を代入し初期化してください*/
		byte i = 0;
		short j = 0;
		int k = 0;
		long l = 0;
		float m = 0f; 
		double n =0;
		char o = 0;
		String p = "";
		boolean q = true; 
		
		//ローカル変数を宣言	
		i = 10;
		j = 100;
		k = 1000;
		l = 10000;
		m = 9.5f;
		n = 10.5;
		o = 'a';
		p = "ハロー";
		//それぞれの変数に値を代入
		
        /*下記の通りにコンソール出力されるようにしてください
		上記で作成した変数を必ず使用すること*/
		System.out.println( i + j + k + l );  
		System.out.println( m + n ); 
		System.out.println( o + " " + p + " " + q );
		System.out.println( i + j + k + l + m + n );  //数字を全て足す
		System.out.println( i * j * k * l );  //小数点以外の数字を全てかける
		System.out.println( n / j);  //10.5割る100をする
		System.out.println( i - j );  //10引く100をする
		
		/* 次のプログラムを実行すると「ハローJAVA2023」という結果が表示されます。
		「ハローJAVA43」と表示とさせたいのですが、意図通りに動きません。正しく動作するように修正してください。
		String num="20";
		int num1=23;
		System.out.println("ハローJAVA"+(num+num1));*/
		
		int num=20;
		int num1=23;
		System.out.println("ハローJAVA"+(num+num1));
		//「ハローJAVA43」と表示。正しく動作するように修正。
		
		/*『』で囲われた人の情報を変数にして、formatの通りコンソールに出力してください
		ローカル変数に代入し○○に入れてください
		『山田太郎 18歳 170.5cm 62.2kg 寿司』*/
		String name = "山田太郎" ;
		int age = 18 ;
		float height = 170.5f;
		float weight = 62.2f;
		String likefood = "寿司";
		// ローカル変数へ代入 『山田太郎 18歳 170.5cm 62.2kg 寿司』
		
		
		/*6で作成した自己紹介に続いてBMIが出力されるようにしてください
		「BMIは○○です」
		ただし計算は数値を直書きせず、全て変数を使ってすること*/
		System.out.println("『初めまして" + name + "です』");
		System.out.println("『年齢は" + age + "歳です』");
		System.out.println("『身長は" + height + "cmです』");
		System.out.println("『体重は" + weight + "kgです』");
		System.out.println("『好きな食べ物は" + likefood+ "です』");
		//format通りに出力
		
		float heightM = height / 100;
		//ここでcmをmに変更
		float rawBmi = weight / (heightM * heightM);
		//BMIの計算
		float roundedBmi = Math.round(rawBmi * 10) / 10.0f ;
		//少数第1位以下四捨五入処理
	    System.out.println("『BMIは" + roundedBmi + "です』");
		//作成した自己紹介に続いてBMIが出力されるよう出力。
		
		/*6で宣言した変数に再代入し下記の通りコンソールに出力してください*/
		name = "鈴木一郎" ;
		age = 24 ;
		height = 168.5f;
		weight = 64.2f;
		likefood = "オムライス";
		heightM = height / 100;
		rawBmi = weight / (heightM * heightM);
		roundedBmi = Math.round(rawBmi * 10) / 10.0f ;
		boolean isAdult = age >= 25; //25歳以上はtrueと出力
		String combinedInfo = String.valueOf(age) + "・" + String.valueOf(height) + "・" + String.valueOf(weight);
		/*8で使用した【年齢・身長・体重】を文字列型に型変換し繋げて出力*/
		
		/*6で宣言した変数に再代入し下記の通りコンソールに出力してください*/
		System.out.println("初めまして" + name + "です");
		System.out.println("年齢は" + age + "歳です");
		System.out.println("身長は" + height + "cmです");
		System.out.println("体重は" + weight + "kgです");
		System.out.println("好きな食べ物は" + likefood+ "です");
		System.out.println("BMIは" + roundedBmi + "です");
		//上記の変数に再代入し、出力。
		System.out.println("年齢は25歳以上ですか？ " + isAdult);//25歳以上はtrueと出力(この場合faise)
		System.out.println("年齢・身長・体重を連結すると: " + combinedInfo);//8で使用した【年齢・身長・体重】を文字列型に型変換し繋げて出力
		
		/*11で変換した【年齢・身長】を整数型に変換して出力してください*/
		String[] parts = combinedInfo.split("・");
		// 文字列から整数型に変換
		int parsedAge = Integer.parseInt(parts[0]);
		int parsedHeight = (int) Float.parseFloat(parts[1]); // 168.5 → 168

		System.out.println("整数型の年齢: " + parsedAge);
		System.out.println("整数型の身長: " + parsedHeight);
		
		/*12で変換した【年齢・身長】で【年齢が25もしくは身長が160以上】であればtrueを出力してください*/
		System.out.println("年齢・身長】で【年齢が25もしくは身長が160以上】: " + (parsedAge >= 25 || parsedHeight >= 160));
		
		
		/*8で使用した変数【年齢・身長・体重】の数値を和算で自己代入し、下記の通りコンソールに出力してください*/
		name = "鈴木一郎";
		age += age;        // 年齢を2倍にする
		height += height;  // 身長を2倍にする
		weight += weight;  // 体重を2倍にする
		isAdult = age >= 25; //25歳以上はtrueと出力
		roundedBmi = Math.round(rawBmi * 100) / 100.00f ;//rawBmi を100倍して小数第2位を整数に変換 → 四捨五入 → 100で割って戻す
		/*6で宣言した変数に再代入し下記の通りコンソールに出力してください*/
		System.out.println("初めまして" + name + "です");
		System.out.println("年齢は" + age + "歳です");
		System.out.println("身長は" + height + "cmです");
		System.out.println("体重は" + weight + "kgです");
		System.out.println("好きな食べ物は" + likefood+ "です");
		System.out.println("BMIは" + String.format("%.2f", roundedBmi / 2) + "です");
		//少数第2位まで出す
		/*8で使用した年齢が25歳以上ならtrueが出力されるようにしてください。ただしif文は使いません*/
		System.out.println("年齢は25歳以上ですか？ " + isAdult);

	}
	}

