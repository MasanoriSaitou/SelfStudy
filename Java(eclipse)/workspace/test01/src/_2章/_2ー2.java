package _2章;

public class _2ー2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int a = 2_000_000;  //整数リテラルは「,」のような使い方で「_」をつけることができる
				
		System.out.println("\\"+String.format("%,d", a));//String.formatで実行結果の桁区切りも表現できる
		
		System.out.println("私の好きな記号は二重引用符(\")です");
	}

}
