package bingo;

public class Com extends Play {

	@Override
	public int Turn(int vsNum) {
		
		int num;

		boolean isTrue = false;

		do {
			num = (int) (Math.random() * 25 + 1);

			for (int i = 0; i < getBingo().length; i++) {
				for (int k = 0; k < getBingo()[i].length; k++) {
					if (getBingo()[i][k] == num) {
						getBingo()[i][k] = 0;
						isTrue = true;
					}
				}
			}
		} while (!isTrue);

		Match();

		Print();
		if (getBingoCount() > getBingo().length / 2) {
			System.out.println("BINGO!!");
			return num;
		}
		return num;
	}
}
