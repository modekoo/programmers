package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MaxNumberTest {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		int[] numbers = {3, 30, 34, 5, 9};
		assertEquals("9534330", solution(numbers));
	}
	
	@Test
	void test2() {
		int[] numbers = {6, 10, 2};
		assertEquals("6210", solution(numbers));
	}
	
	@Test
	void test3() {
		int[] numbers = {0, 0, 0};
		assertEquals("0", solution(numbers));
	}
	
    public String solution(int[] numbers) {
        String answer = "";
        
        Comparator<String> comp = (a, b) -> Integer.parseInt(b+a) - Integer.parseInt(a+b);
        
        List<String> numberStrArray = Arrays.stream(numbers)
        									.mapToObj(Integer::toString)
        									.sorted(comp)
        									.collect(Collectors.toList());

        if(numberStrArray.stream().filter(p -> p.equals("0")).count() == numberStrArray.size())
        	return "0";
        
        
        for(int i=0; i<numberStrArray.size(); i++) {
        	answer += numberStrArray.get(i);
        }
        
        if(answer.startsWith("0"))
        	return "0";
        
        return answer;
    }

}
