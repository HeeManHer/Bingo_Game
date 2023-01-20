package bingo;

public abstract class Bingo {

	private String name;
	private int[][] bingo;
	private int bingoCount;

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

	public void Make() {
		bingo = new int[5][5];

		int[] temp = new int[bingo.length * bingo.length];

		for (int i = 0; i < temp.length; i++) {

			temp[i] = (int) ((Math.random() * 25) + 1);

			for (int k = 0; k < i; k++) {
				if (temp[i] == temp[k]) {
					i--;
					break;
				}
			}
		}

		int j = 0;

		for (int i = 0; i < bingo.length; i++) {
			for (int k = 0; k < bingo[i].length; k++) {
				bingo[i][k] = temp[j++];
			}
		}

	}

	public void Print() {
		System.out.println("====== " + name + "의 빙고 카운트 : " + bingoCount + " ======");

		for (int i = 0; i < bingo.length; i++) {
			for (int k = 0; k < bingo[i].length; k++) {
				System.out.print(bingo[i][k] + "\t");

			}
			System.out.println();
		}
	}

	public abstract int Turn();

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

	public void Match() {

		int bingoMatch;
		bingoCount = 0;

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
