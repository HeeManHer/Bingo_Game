package bingo;

/**
 * <pre>
 * Class : Bingo
 * Comment : 빙고 게임 진행을 위한 정보 저장 및 메소드 모음
 * History
 * 2023/01/18 (허희만) 
 * 		BingoDTO에 정보 저장, Play에서 DTO를 상속받아 메소드 작성
 * 		Make(), Print(),Turn(), Match() 작성
 * 2023/01/19 (허희만) 
 * 		BingoDTO와 Play를 합쳐 Bingo로 바꿈
 * 		Player와 Com 클레스에 있던 check()메소드 가져옴
 * 2023/01/24 (허희만) 
 * 		주석 작성
 * </pre>
 * 
 * @author 허희만
 * @version 1.0.3
 * @see
 */
public abstract class Bingo {

	private String name; // 플레이어 이름
	private int[][] bingo; // 빙고판 이차원 배열
	private int bingoCount; // 빙고 수 카운트

	/* getter */
	public String getName() {
		return name;
	}

	public int[][] getBingo() {
		return bingo;
	}

	public int getBingoCount() {
		return bingoCount;
	}

	/* setter */
	public void setName(String name) {
		this.name = name;
	}

	public void setBingo(int[][] bingo) {
		this.bingo = bingo;
	}

	public void setBingoCount(int bingoCount) {
		this.bingoCount = bingoCount;
	}

	/**
	 * <pre>
	 * 빙고판 이차원 배열을 채우는 메소드
	 * temp라는 일차원 배열을 만들어 랜덤함수로 중복없이 1 ~ 25 사이의 숫자를 넣고 순서대로 bingo배열에 넣는다.
	 * </pre>
	 */
	public void Make() {

		// 빙고판 이차원 배열을 5 * 5 크기로 할당
		bingo = new int[5][5];

		// 5 * 5 크기의 일차원 배열 temp 생성
		int[] temp = new int[bingo.length * bingo.length];

		// temp배열에 랜덤으로 숫자 넣기
		for (int i = 0; i < temp.length; i++) {

			temp[i] = (int) ((Math.random() * 25) + 1);

			// 만약 이미 앞에 나온 숫자가 있다면 다시 입력
			for (int k = 0; k < i; k++) {
				if (temp[i] == temp[k]) {
					i--;
					break;
				}
			}
		}

		int j = 0; // temp의 인덱스

		// bingo에 temp를 순서대로 입력
		for (int i = 0; i < bingo.length; i++) {
			for (int k = 0; k < bingo[i].length; k++) {
				bingo[i][k] = temp[j++];
			}
		}
	}

	/**
	 * <pre>
	 * 빙고판 출력 메소드
	 * 숫자와 숫자사이를 탭으로 거리를 두고 한 줄이 끝나면 줄바꿈
	 * </pre>
	 */
	public void Print() {
		System.out.println("====== " + name + "의 빙고 카운트 : " + bingoCount + " ======");

		for (int i = 0; i < bingo.length; i++) {
			for (int k = 0; k < bingo[i].length; k++) {
				System.out.print(bingo[i][k] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * <pre>
	 * 플레이어나 컴퓨터의 차례에서 해야할 일을 구현해야할 추상 메소드
	 * </pre>
	 */
	public abstract int Turn();

	/**
	 * <pre>
	 * 숫자를 확인하는 메소드
	 * turn()메소드에서 입력받은 숫자를 받아와
	 * 빙고판에 해당 숫자가 있다면 그 자리를 0으로 바꾸고 true를 반환, 없으면 false을 반환
	 * </pre>
	 * 
	 * @param num turn() 메소드에서 입력받은 숫자
	 * @return 빙고판에 num이 있으면 true, 없으면 false 반환
	 */
	public boolean check(int num) {
		for (int i = 0; i < bingo.length; i++) {
			for (int k = 0; k < bingo[i].length; k++) {
				if (bingo[i][k] == num) {
					bingo[i][k] = 0;
					Match();
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <pre>
	 * 빙고수 확인 메소드
	 * 가로, 세로의 각 한 줄이 0이면 빙고 수 1증가
	 * 대각선 각 한 줄이 0이면 빙고 수 1 증가
	 * </pre>
	 */
	public void Match() {

		int bingoMatch; // 한 줄의 0의 개수
		bingoCount = 0; // bingoMatch가 5이면 빙고 수 1 증가

		/* 가로줄 빙고 */
		for (int i = 0; i < bingo.length; i++) {
			bingoMatch = 0;
			for (int k = 0; k < bingo[i].length; k++) {
				if (bingo[i][k] == 0) {
					bingoMatch++;
				}
			}
			if (bingoMatch == bingo[i].length) {
				bingoCount += 1;
			}
		}

		/* 세로줄 빙고 */
		for (int i = 0; i < bingo.length; i++) {
			bingoMatch = 0;
			for (int k = 0; k < bingo[i].length; k++) {
				if (bingo[k][i] == 0) {
					bingoMatch++;
				}
			}
			if (bingoMatch == bingo[i].length) {
				bingoCount += 1;
			}
		}

		/* 좌상-우하 대각선 빙고 */
		bingoMatch = 0;
		for (int i = 0; i < bingo.length; i++) {
			if (bingo[i][i] == 0) {
				bingoMatch++;
			}
		}
		if (bingoMatch == bingo.length) {
			bingoCount += 1;
		}

		/* 좌하-우상 대각선 빙고 */
		bingoMatch = 0;
		for (int i = 0; i < bingo.length; i++) {
			if (bingo[i][bingo.length - i - 1] == 0) {
				bingoMatch++;
			}
		}
		if (bingoMatch == bingo.length) {
			bingoCount += 1;
		}

	}

}
