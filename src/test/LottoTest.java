package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class LottoTest {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		int[] result = {3, 5};
		assertArrayEquals(result,  solution(lottos, win_nums));
	}
	
	@Test
	void test2() {
		int[] lottos = {0, 0, 0, 0, 0, 0};
		int[] win_nums = {38, 19, 20, 40, 15, 25};
		
		int[] result = {1, 6};
		assertArrayEquals(result,  solution(lottos, win_nums));
	}
	
	@Test
	void test3() {
		int[] lottos = {45, 4, 35, 20, 3, 9};
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		
		int[] result = {1, 1};
		assertArrayEquals(result,  solution(lottos, win_nums));
	}
	
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = {0, 0};

		//�ְ�� �������� �� �´°� max
		//������ �����ߴ°� min
		//������ 6,5,4,3,2,1
		//0�� ������ ���ϰ�, ������ ���� �´��� Ȯ���ϱ�

		int zeroCnt = 0;
		int hitCnt = 0;
		int minRank = 0;
		int maxRank = 0;

		for(int num : lottos) {
			if(num == 0) 
				zeroCnt++;
			for(int winNum : win_nums) {
				if(num == winNum && num != 0)
					hitCnt++;
			}
		}

		maxRank = hitCnt + zeroCnt;
		minRank = hitCnt;

		answer[0] = rank(maxRank);
		answer[1] = rank(minRank);

		return answer;
	}

	private int rank(int cnt) {
		int rank = 6;

		switch(cnt) {
		case 6 :
			rank = 1;
			break;
		case 5 :
			rank = 2;
			break;
		case 4 :
			rank = 3;
			break;
		case 3 :
			rank = 4;
			break;
		case 2 :
			rank = 5;
			break;
		}

		return rank;
	}

}
