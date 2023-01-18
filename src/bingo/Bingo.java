package bingo;

public class Bingo {

	private int[][] bingo = new int[5][5];
	private int bingoCount = 0;
	
	/* getter */
	public int[][] getBingo() {
		return bingo;
	}
	
	public int getBingoCount() {
		return bingoCount;
	}
	
	/* setter */
	public void setBingo(int[][] bingo) {
		this.bingo = bingo;
	}
	
	public void setBingoCount(int bingoCount) {
		this.bingoCount = bingoCount;
	}
	
	

}
