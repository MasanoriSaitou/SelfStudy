package _3章;

public class _3ー8_練習問題 {

	public static void main(String[] args) {
		//練習3-1
		//①
		int weight = 60;
		if(weight == 60) {}
		//②
		int age1= 0;
		int age2 = 0;
		if((age1+age2)*2 > 60) {};
		//③
		int age = 1;
		if((age % 2) == 1) {};
		//④
		String name = "湊";
		if(name.equals("湊")) {}; //String型がなぜか==で比較ができない。専用のequalsを使う

		
		//練習3-3
		int isHungry = 1;
		String food = "バナナ";
		System.out.println("こんにちは");
		//System.out.println(isHungry == 0 ? "お腹がいっぱいです" : "はらぺこです");//三項条件演算子も使える
		if(isHungry == 0) {
			System.out.println("お腹がいっぱいです");		
		}else {
			System.out.println("はらぺこです");	
		}//else end
		if(isHungry == 1) {
			System.out.println(food+"をいただきます");
		}
		System.out.println("ごちそうさまでした");
		
		//練習3-4
		boolean tenki = false;
		if(tenki) {
			System.out.println("洗濯をします");
			System.out.println("散歩に行きます");
		}else {
			System.out.println("DVDを見ます");
			System.out.println("寝ます");
		}//if end
		
		//練習3-5
		System.out.print("[メニュー] 1:検索 2:登録 3:削除 4:変更>");
		int selected = new java.util.Scanner(System.in).nextInt();
		switch(selected) {
		  case 1:System.out.println("検索します");
		  		 break;
		  case 2:System.out.println("登録します");
	  		     break;
		  case 3:System.out.println("削除します");
	  		 	 break;
		  case 4:System.out.println("変更します");
	  		     break;
		}//switch end
		
		//練習3-6
		System.out.println("【数あてゲーム】");
		int ans = new java.util.Random().nextInt(10);
		for(int i = 0;i<5;i++) {
			System.out.println("0～9の数字を入力してください");
			int num = new java.util.Scanner(System.in).nextInt();
			if(num == ans) {
				System.out.println("アタリ！");
				break;
			}else {
				System.out.println("違います");
			}			
		}//for end
		System.out.println("ゲームを終了します");
		
	}//main end
}//class end
