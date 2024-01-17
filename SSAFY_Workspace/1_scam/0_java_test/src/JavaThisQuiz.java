
public class JavaThisQuiz {

	public static void main(String[] args) {
		A a1 = new B();
		a1.run();
		a1.test();
//		a1. // -> 논리적으로 기능은 3개임 (run하면 3개 뜸) 

	}

}

class A {
	void test() {
		this.run();
	}
	
	void run() {
		System.out.println("A is Run");
	}
	void run(int a) {
		System.out.println();
	}
}

class B extends A {
	void run() {
		System.out.println("SSAFY");
	}
}
// Method Overriding -> 재정의의 범위가 달라질 수 있음 (용도에 따라 다바꿈 or 적다하게 바꿈)
// class간의 크기 비교가 가능하다면, 참조형 역시 포함 관계가 존재하여 Casting이 할 수 있음.
// 상속을 통해 Generalization이 가능하다면, 상위 / 하위 관계가 존재하면 Up Casting이 가능함 (상속 트리에 근거한 형 변환)
// Object 표현이 불가능한 객체는 없다. Primitive는 안되지만, Wrapper class를 통해 객체 표현이 가능함 ()
// B를 만들어서 B / A / Object class에 담을 수 있음. (다 같은 B 인데 담긴 그릇이 달라 기능이 달라짐. )
// a1.test();
// A라는 타입으로 B객체를 담고 있음. a1에 대한 참조값은 B에 대한 참조를 담고 있음. -> stack에 담겨 있는 this은 B의 run();이 나옴.