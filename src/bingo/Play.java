package bingo;

public abstract class Play extends Bingo {
	
	public Play() {
		int[] temp = new int[25];

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
		for (int i = 0; i < getBingo().length; i++) {
			for (int k = 0; k < getBingo()[i].length; k++) {
				getBingo()[i][k] = temp[j++];
			}
		}

		System.out.println("빙고판이 완성되었습니다.");
	}
	
	public void Print() {
		for (int i = 0; i < getBingo().length; i++) {
			for (int k = 0; k < getBingo()[i].length; k++) {
				if (getBingo()[i][k] == 0) {
					System.out.print("\t");
				} else {
					System.out.print(getBingo()[i][k] + "\t");
				}
			}
			System.out.println();
		}
	}
	
	public abstract int Turn(int vsNum);

	public void Match() {

		int bingoMatch;
		setBingoCount(0);

		/* 가로줄 빙고 */
		for (int i = 0; i < getBingo().length; i++) {
			bingoMatch = 0;
			for (int k = 0; k < getBingo()[i].length; k++) {
				if (getBingo()[i][k] == 0) {
					bingoMatch++;
				}
			}
			if (bingoMatch == getBingo()[i].length) {
				setBingoCount(getBingoCount()+1);
			}
		}

		/* 세로줄 빙고 */
		for (int i = 0; i < getBingo().length; i++) {
			bingoMatch = 0;
			for (int k = 0; k < getBingo()[i].length; k++) {
				if (getBingo()[k][i] == 0) {
					bingoMatch++;
				}
			}
			if (bingoMatch == getBingo()[i].length) {
				setBingoCount(getBingoCount()+1);
			}
		}

		/* 좌상-우하 대각선 빙고 */
		bingoMatch = 0;
		for (int i = 0; i < getBingo().length; i++) {
			if (getBingo()[i][i] == 0) {
				bingoMatch++;
			}
		}
		if (bingoMatch == getBingo().length) {
			setBingoCount(getBingoCount()+1);
		}

		/* 좌하-우상 대각선 빙고 */
		bingoMatch = 0;
		for (int i = 0; i < getBingo().length; i++) {
			if (getBingo()[i][getBingo().length - i - 1] == 0) {
				bingoMatch++;
			}
		}
		if (bingoMatch == getBingo().length) {
			setBingoCount(getBingoCount()+1);
		}

	}

	
}
