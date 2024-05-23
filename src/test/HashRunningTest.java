package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class FHashRunningTest {

	@Test
	void test() {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};	
		assertEquals("leo", solution(participant, completion));		
	}
	
	@Test
	void test2() {
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		assertEquals("vinko", solution(participant, completion));		
	}
	
	@Test
	void test3() {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};	
		assertEquals("mislav", solution(participant, completion));		
	}

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> completionMap = new HashMap<String, Integer>();
        
        for(String com : completion) {
        	if(completionMap.containsKey(com))
        		completionMap.put(com, completionMap.get(com)+1);
        	else 
        		completionMap.put(com, 1);
        }
        
        for(String participantUser : participant) {
        	if(!completionMap.containsKey(participantUser)) {
        		answer = participantUser;
        		break;
        	}
        	else {
        		if(completionMap.get(participantUser) == 0) {
        			answer = participantUser;
            		break;
        		}
        		else {
        			completionMap.put(participantUser, completionMap.get(participantUser)-1);
        		}
        	}
        	
        }
        return answer;
    }

}
