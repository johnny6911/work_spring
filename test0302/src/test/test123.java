package test;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class test123 {
	public static void main(String[] args) {
		Random random = new Random();
			
		Set<Integer> a = new TreeSet<Integer>();
		
		while (a.size() < 6) {
			Integer b = random.nextInt(45) + 1;
			
			a.add(b);
		}
		
		for (Integer c : a) {
			System.out.print(c + " ");
		}
	}
}
