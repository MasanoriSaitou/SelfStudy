package _1章;

public class _1ー3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int age;
		age = 30;
		char a = '\0'; //char型は''のように、空にはできない(ヌル文字(\0)を代入する)
		char b = '辰'; //char型(文字型)は全角１文字も入れられる
		String c = ""; //String型(文字列型)は""のように、空にできる（０文字以上可能）
		String d = "すがわら";  //'（シングルクォーテーション）で囲むと１文字として認識し、エラー
		System.out.println(Character.toString(a) + Character.toString(b) +
				            c + d + Integer.toString(age));	
	}//main end
}//class end
