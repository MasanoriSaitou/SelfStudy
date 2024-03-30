package test01;

public class Test02 {

	public static void main(String[] args) {
		
		var a = new Test02().new A();
		a.main();
	}
	
	public class A{
		
		public int main() {
			
			System.out.println("こんにちは");
			return 0;
		}
	}
}