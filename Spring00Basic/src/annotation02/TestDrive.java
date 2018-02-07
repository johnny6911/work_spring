package annotation02;

public class TestDrive {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException{
		User jeon = new User("jeong", 33, "seoul");
		User kim = new User("kim", 15, null);
		User park = new User("park", 101, "busan");
		
		Validator validator = new Validator();
		validator.validate(jeon);
		validator.validate(kim);
		validator.validate(park);
	}
}
