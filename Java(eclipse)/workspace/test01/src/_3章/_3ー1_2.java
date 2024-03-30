package _3章;

public class _3ー1_2 {

	public static void main(String[] args) {
		//doorCloseにtrueを入れると無限ループするので注意
		boolean doorClose = false;
		while(doorClose) {
			System.out.println("ノックする");
			System.out.println("１分待つ");
		}

	}

}
