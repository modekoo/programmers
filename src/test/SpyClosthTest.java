package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class SpyClosthTest {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		assertEquals(5, solution(clothes));
	}
	
	@Test
	void test2() {
		String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		assertEquals(3, solution(clothes));
	}
	
	public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, Integer> clothClassMap = new HashMap<String, Integer>();
        
        for(String[] cloth : clothes) {
        	for(int i=1; i<cloth.length; i=i+2) {
        		if(clothClassMap.containsKey(cloth[i]))
        			clothClassMap.put(cloth[i], clothClassMap.get(cloth[i]) + 1);
        		else
        			clothClassMap.put(cloth[i], 1);
        	}
        }
        
        Set<String> set = clothClassMap.keySet();
        Iterator<String> iter = set.iterator();
        
        int multiplyNum = 1;
        
        while(iter.hasNext()) {
        	String clothClass = iter.next();
        	if(clothClassMap.containsKey(clothClass)) {
        		multiplyNum *= (clothClassMap.get(clothClass)+1);
        	}
        }
        
        answer = multiplyNum-1;
        
        return answer;
    }

}
