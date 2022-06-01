package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class HashTellNumberList {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String[] phone_book = {"119", "97674223", "1195524421"};
		assertEquals(false, solution(phone_book));
	}

	@Test
	void test2() {
		String[] phone_book = {"123","456","789"};
		assertEquals(true, solution(phone_book));
	}

	@Test
	void test3() {
		String[] phone_book = {"12","123","1235","567","88"};
		assertEquals(false, solution(phone_book));
	}

	@Test
	void test4() {
		String[] phone_book = {"119"};
		assertEquals(true, solution(phone_book));
	}

	public boolean solution(String[] phone_book) {
		boolean answer = true;

		//        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
		Arrays.sort(phone_book);

//		HashSet<String> phoneSet = new HashSet<>(Arrays.asList(phone_book));
//		Iterator<String> iterator = phoneSet.iterator();

		for(int i=0; i<phone_book.length; i++) {
			if(i+1 == phone_book.length) break;
			
			if(!phone_book[i].equals(phone_book[i+1]) && (phone_book[i+1].startsWith(phone_book[i]))) {
				answer = false;
				break;
			}
			if(!answer) break;
		}
		return answer;
	}

}
