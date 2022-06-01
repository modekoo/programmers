package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class RecommandNewId {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		assertEquals("bat.y.abcdefghi", solution(new_id));
	}
	
	@Test
	void test2() {
		String new_id = "z-+.^.";
		assertEquals("z--", solution(new_id));
	}
	
	@Test
	void test3() {
		String new_id = "=.=";
		assertEquals("aaa", solution(new_id));
	}

	@Test
	void test4() {
		String new_id = "123_.def";
		assertEquals("123_.def", solution(new_id));
	}

	@Test
	void test5() {
		String new_id = "abcdefghijklmn.p";
		assertEquals("abcdefghijklmn", solution(new_id));
	}


	public String solution(String new_id) {
        String answer = "";
		
		//1단계
		new_id = new_id.toLowerCase();
		
		//2단계
		new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
		
		//3단계
		new_id = new_id.replaceAll("[.]{2,}", ".");
		
		//4단계
		char[] new_id_char = new_id.toCharArray();
		if(new_id_char.length > 1 && new_id_char[0] == '.')
			new_id = new_id.substring(1, new_id_char.length);
		else if(new_id.length() == 1 && new_id.indexOf(".") == 0)
			new_id = "";
		
		if(new_id_char.length > 1 && new_id_char[new_id_char.length-1] == '.')
			new_id = new_id.substring(0, new_id_char.length-1);
		
		//5단계
		if(new_id.equals(""))
			new_id = "a";
		
		//6단계
		if(new_id.length() >= 16)
			new_id = new_id.substring(0,15);
		new_id = new_id.replaceAll("[.]$", "");
		
		//7단계
		if(new_id.length() <=2) {
			for(int i=new_id.length(); i<3; i++) {
				new_id += new_id.toCharArray()[new_id.toCharArray().length-1];
			}
		}
			
		answer = new_id;
		return answer;
    }
}
