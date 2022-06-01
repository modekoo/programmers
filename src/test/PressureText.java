package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class PressureText {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String s = "aabbaccc";
		assertEquals(7, solution(s));
	}
	@Test
	void test2() {
		String s ="ababcdcdababcdcd";
		assertEquals(9, solution(s));
	}
	@Test
	void test3() {
		String s = "abcabcdede";
		assertEquals(8, solution(s));
	}
	@Test
	void test4() {
		String s = "abcabcabcabcdededededede";	
		assertEquals(14, solution(s));
	}
	@Test
	void test5() {
		String s = "xababcdcdababcdcd";
		assertEquals(17, solution(s));
	}
	
	public int solution(String s) {
        int answer = 0;
        return answer;
    }
	
	public String selfSearch(String s, int idx, int minLength) {
		
		String tempStr = new String(s);
		String subStr = s.substring(0, idx);
		int matched = 0;
		
		while(!Pattern.matches(subStr, tempStr)) {
			matched ++;
			tempStr = tempStr.replaceFirst(subStr, tempStr);
		}
		
		
		if(idx == 1) 
			return s;
		else
			return selfSearch(s, idx--, minLength);
	}
	

}
