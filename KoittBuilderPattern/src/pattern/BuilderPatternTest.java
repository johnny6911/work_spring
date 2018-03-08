package pattern;

import java.util.Date;

public class BuilderPatternTest {
	public static void main(String[] args) {
		StringBuilder builder01 = new StringBuilder();
		builder01
		.append("안녕하세요 \t")
		.append("반갑습니다.")
		.append("오랜만임.");
		
		System.out.println(builder01);
	
		UserBuilder builder02 = new UserBuilder() 
				.setAge(10) // 객체생성후 메소드 호출, 현재까진 유저빌더에 age값이 10인 객체가 생성됨
				.setDob(new Date())
				.setEmail("a@gamil.com")
				.setName("홍길동");
		
		System.out.println(builder02);
		
		String name = "안녕하세요";
		String nice = "반가움";
		String longtime = "오랜만이네요";
	}
}
