package annotation03;

public class ClassA {

	@Call(seq=1)
	public void second() { //평범한 메소드 3개 만듬
		System.out.println("second 호출 ...");
	}
	
	@Call(seq=3)
	public void first() {
		System.out.println("first 호출 ...");
	}
	
	@Call(seq=2)
	public void third() {
		System.out.println("third 호출 ...");
	}
}
