package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class NoSameNumberTest {
	@Test
	void test() {

		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		int[] result = {1, 3, 0, 1};

		Assertions.assertArrayEquals(solution(arr), result);

	}

	public int[] solution(int[] arr) {

		if(arr.length == 0)
			return arr;

		int[] answer = {};
		answer = searchSameNumber(arr);
		return answer;
	}

	int[] searchSameNumber(int[] arr){
		List<Integer> resultList = new ArrayList();

		int checkNum = arr[0];
		resultList.add(checkNum);

		for(int i=1; i<arr.length; i++){
			if(checkNum != arr[i]) {
				checkNum = arr[i];
				resultList.add(checkNum);
			}
		}

		return resultList.stream().mapToInt(Integer::intValue).toArray();
	}

	int[] noSameNumberNotRecursion(int[] arr){
		List<Integer> tempList = Arrays.stream(arr).boxed().collect(Collectors.toList());

		int idx = 0;

		while(idx <= tempList.size() - 1) {
			if (idx == tempList.size() - 1)
				return tempList.stream().mapToInt(Integer::intValue).toArray();

			if (tempList.get(idx) == tempList.get(idx + 1))
				tempList.remove(idx + 1);
			else {
				idx++;
			}
		}

		return tempList.stream().mapToInt(Integer::intValue).toArray();
	}

	int[] noSameNumber(int[] arr){
		List<Integer> tempList = Arrays.stream(arr).boxed().collect(Collectors.toList());

		tempList = noSameNumberRecursion(tempList, 0);

		int[] resultList = tempList.stream().mapToInt(e -> Integer.parseInt(String.valueOf(e))).toArray();
		return resultList;
	}

	List noSameNumberRecursion(List list, int idx){
		if(idx == list.size() -1)
			return list;

		if(list.get(idx) == list.get(idx+1))
			list.remove(idx+1);
		else{
			idx++;
		}
		return noSameNumberRecursion(list, idx);
	}


}
