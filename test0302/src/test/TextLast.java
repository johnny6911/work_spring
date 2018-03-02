package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextLast {
	
	public static void main(String[] args) {
		Map<String, String> phoneBook = new HashMap<String, String>();
		phoneBook.put("한국아이티", "010 1122 7777");
		phoneBook.put("제이플라츠", "010 3388 9933");
		
		Scanner input = new Scanner(System.in);
		System.out.println("검색할 이름을 적으세요 >> ");
		String name = input.nextLine();
		
		System.out.println("입력하신 " + name + "의 전화번호는");
		System.out.println(phoneBook.get(name) + "입니다");
	}
}
