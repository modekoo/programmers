package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FunctionDevelopTest {
//	@Test
	void test() {

		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};

		int[] result = {2,1};

		Assertions.assertArrayEquals(result(progresses, speeds), result);

	}

	@Test
	void test2() {

		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};

		int[] result = {1, 3, 2};

		Assertions.assertArrayEquals(result(progresses, speeds), result);

	}

	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		return answer;
	}

	public int[] result(int[] progresses, int[] speeds){
		int day = 1;
		int count = 0;
		boolean end = false;
		List<Integer> resultList = new ArrayList<>();

		for(int i=0; i<progresses.length; i++){
			if(end)
				break;
			if(day * speeds[i] + progresses[i] >= 100){
				count++;
				for(int j=i+1; j<progresses.length; j++){
					if(day * speeds[j] + progresses[j] >= 100){
						count++;
						if(j+1 == progresses.length)
							end = true;
					}
					else{
						i = j-1;
						break;
					}
				}
				resultList.add(count);
				count = 0;
			}
			else {
				day++;
				i--;
			}
		}
		return resultList.stream().mapToInt(Integer::intValue).toArray();
	}

}
