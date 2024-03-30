package _3章;

public class _3ー4 {

	public static void main(String[] args) {
		System.out.println("あなたの運勢を占います");
		int fortune = new java.util.Random().nextInt(5) + 1;
		System.out.println("結果は…" + fortune + "です。");
		switch(fortune) {
			case 1:  //あえてbreakを書かない
			case 2:
				System.out.println("いいね！");
				break;
			case 3:
				System.out.println("普通です");
				break;
			case 4:
			case 5:
				System.out.println("うーん…");
		}

	}

}
