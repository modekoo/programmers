package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BracketTest {
	@Test
	void test() {
		String s = "(())()";
		Assertions.assertTrue(checkBracket(s));
	}

	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		return answer;
	}

	public boolean checkBracket(String words){
		char[] wordsArr = words.toCharArray();
		int count = 0;
		for(char c : wordsArr){
			if(c == '(')
				count++;
			else if(c == ')') {
				if (count < 1)
					return false;
				count--;
			}
		}

		if(count > 0)
			return false;
		else
			return true;
	}

}
