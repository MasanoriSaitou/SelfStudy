package _2章;

public class _2ー4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	   System.out.println(9 / 2);  //9/2はその商の結果の４となってしまう
	   System.out.println(9.0 / 2);  //9.0 / 2のようにどちらかのオペランドを小数にすると4.5になる
	
	   int a = 10;
	   int b = 10;
	   System.out.println(++a + 50); //インクリメントやデクリメントは演算子の位置で計算タイミングが変わってしまう！
	   System.out.println(b++ + 50); //バグを減らすため、なるべくインクリメントデクリメントはそれ単体で実行するようにする
	
	   float c = (float)3.0; //double型リテラルをfloat型変数に代入はできない！⇒キャストが必要
	}

}
