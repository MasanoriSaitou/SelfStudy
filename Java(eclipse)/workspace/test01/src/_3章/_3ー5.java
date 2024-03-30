package _3章;

public class _3ー5 {

	public static void main(String[] args) {
		int n=5;
		
		for(; n< 10; n++) {  //ループ変数は省略可能
			System.out.println("こんにちは");
		}
		
		//breakを貼らないと無限ループ
		for(;;) {
			break;
		}
		
		for(int i = 0;i<3;i++) {
			System.out.print("現在" + ( i + 1) + "周目→");
		}
		System.out.println();
		
		//九九の表
		for(int i = 1;i<10;i++) {
			for(int j = 1; j<10;j++) {
				System.out.print(i*j);
				System.out.print(" ");
			}//for end
			System.out.println("");
		}//for end	

	}//main end
}//class end
