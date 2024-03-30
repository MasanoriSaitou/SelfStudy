package _2章;

public class _2ー6 {

	public static void main(String[] args) {
		
		//画面に文字を表示後、改行する
		String name = "すがわら"; //①宣言
		String message;
		message = name + "さん、こんにちは";  //②計算
		System.out.println(message);//実行
		
		//画面に文字を表示する(改行なし)
		String name2 = "すがわら"; 
		System.out.print("私の名前は");
		System.out.print(name2);
		System.out.print("です。");
		
		//大きい方の数値を代入する命令
		int a = 5;
		int b = 2;
		int m = Math.max(a, b);
		System.out.println("\n比較実験："+ a + "と" + b + "とで大きい方は…" + m);
		
		//文字列を数値に変換する
		String age = "31";
		int n = Integer.parseInt(age);//「こんにちは」など、数値以外を入れるとエラー
		System.out.println("あなたは来年、" + (n +1)+"歳になりますね。");
		
		//乱数生成
		int r = new java.util.Random().nextInt(90);//90を含まない0～89までの乱数
		System.out.println("あなたはたぶん、" + r + "歳ですね？");
		
		//キーボードから入力を受け付ける命令
		System.out.println("あなたの名前を入力してください");
		String name3 = new java.util.Scanner(System.in).nextLine();
		System.out.println("あなたの年齢を入力してください。");
		int age2 = new java.util.Scanner(System.in).nextInt();//数値以外を入れるとエラー(全角数値はOK)
		System.out.println("ようこそ、"+age2+"歳の"+name3+"さん");
	}

}
