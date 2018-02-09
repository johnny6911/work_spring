package bean;

public class PersonImpl implements Person{
	
	// 1-1. 필드 만들기
	private String name;
	private int age;
	private String greeting;
	
	// 1-2. 기본생성자 만들기
	public PersonImpl() {}
	// 1-3. 필드 초기화하는 생성자 만들기
	
	
	public PersonImpl(String name,int age, String greeting) {
		this.name = name;
		this.age = age;
		this.greeting = greeting;
	}
	
	// 1-4. name 필드 getter 만들기
	@Override
	public String getName() {
		return this.name;
	}


	@Override
	public String getGreeting() {
		return this.greeting;
	}


	@Override
	public int getAge() {
		return this.age;
	}
}
