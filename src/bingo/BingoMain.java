package bingo;

/**
 * <pre>
 * Class : Bingo
 * Comment : 게임 실행을 위한 클래스
 * History
 * 2023/01/17 (허희만)
		BingoGame에서 혼자서 빙고게임을 진행
 * 		BingoMain 클래스에 BingoGame의 객체를 만들어 게임 실행을 함
 * 2023/01/24 (허희만) 주석 처리함
 * </pre>
 * 
 * @author 허희만
 * @version 1.0.0
 * @see bingo.BingoGame
 */
public class BingoMain {
	public static void main(String[] args) {

		// 빙고 게임 시작을 위해 객체 생성 후 game() 메소드 호출
		BingoGame bingo = new BingoGame();
		bingo.game();

	}

}
