package _1章;

public final class _1ー3ー3 {

	public static void main(String[] args) {
		final double pi = 3.14;  //final：定数宣言。C++でいうところのconst。
		                         //       Javaではconstは予約語(未だ使われていない)で使用できない
		int pie = 5;
		System.out.println("半径" + pie + "cmのパイの面積は、");
		System.out.println(pie * pie * pi);
		System.out.println("パイ半径を倍にします");
		//pi = 10;
		System.out.println("半径" + pie + "cmのパイの面積は、");
		System.out.println(pie * pie * pi);
	}
}