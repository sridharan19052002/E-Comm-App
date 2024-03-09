package demo_lomdok;

import lombok.Builder;

public class run {

	public static void main(String[] args) {
		
		employee e=employee.builder().name("sridharan").id(1).natives("Trichy").build();
		System.out.println(e);
	}
}
