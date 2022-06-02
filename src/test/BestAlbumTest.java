package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class BestAlbumTest {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays	= {500, 600, 150, 800, 2500};
		
		int[] answer = {4, 1, 3, 0};
		assertArrayEquals(answer, solution(genres, plays));
		
	}
	
	@Test
	void test2() {
		String[] genres = {"pop"};
		int[] plays	= {1000};
		
		int[] answer = {0};
		assertArrayEquals(answer, solution(genres, plays));
	}
	
	@Test
	void test3() {
		String[] genres = {"wow", "pop","classic","classic", "pop"};
		int[] plays	= {1301, 1000, 1000, 300, 100};
		
		int[] answer = {0, 2, 3, 1, 4};
		assertArrayEquals(answer, solution(genres, plays));
	}
	
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<Integer>();
        
        HashMap<String, Integer> sumMap = new HashMap<String, Integer>();
        HashMap<String, HashMap<Integer, Integer>> resultMap = new HashMap<String, HashMap<Integer,Integer>>();
        
        //장르별 합 구하기
        for(int i=0; i<genres.length; i++) {
        	HashMap<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        	tempMap.put(i, plays[i]);
        	if(sumMap.containsKey(genres[i])) {
        		sumMap.put(genres[i], sumMap.get(genres[i]) + plays[i]);
        		resultMap.get(genres[i]).putAll(tempMap);
        		
        	}
        	else {
        		sumMap.put(genres[i], plays[i]);
        		resultMap.put(genres[i], tempMap);
        		
        	}
        }
        
        //장르별 내림차순
        List<Entry<String, Integer>> rankList = new LinkedList<>(sumMap.entrySet());
        rankList.sort(((o1, o2) -> o2.getValue() - o1.getValue()));
        
        //내림차순 된 장르에서 노래별 내림차순 후 순위
        for(Entry<String, Integer> rank : rankList) {
        	String first = rank.getKey();
        	HashMap<Integer, Integer> tempMap = resultMap.get(first);
        	
            List<Entry<Integer, Integer>> rankResultList = new LinkedList<>(tempMap.entrySet());
            rankResultList.sort(((o1, o2) -> o2.getValue() - o1.getValue() == 0? o1.getKey() - o2.getKey() : o2.getValue() - o1.getValue()));
            
            for(int i=0; i<rankResultList.size(); i++) {
            	answer.add(rankResultList.get(i).getKey());
            	if(i == 1) break;
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
