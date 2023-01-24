package bingo;

import java.util.Scanner;

/**
 * <pre>
 * Class : BingoGame
 * Comment : 빙고 게임 진행을 위한 클래스
 * History
 * 2023/01/17 (허희만) 
 * 		혼자서(컴퓨터 없이) 빙고게임을 구현
 * 2023/01/18 (허희만) 
 * 		컴퓨터와의 대전을 구현
 * 2023/01/19 (허희만)
 * 		객체 배열을 활용해 플레이어끼리 또는 컴퓨터와의 대전을 구현
 * 		중복된 코드를 줄이고자 반복문을 사용.
 * 		계단식 코드가 되어 메소드 분리
 * 2023/01/24 (허희만) 
 * 		주석 작성
 * 
 * </pre>
 * 
 * @author 허희만
 * @version 1.0.3
 * @see
 */
public class BingoGame {

	Bingo[] play = new Bingo[2];

	/**
	 * <pre>
	 * 빙고 게임 준비 메소드
	 * 1. 플레이어 수를 정합니다. (혼자서 또는 둘이서)
	 * 1-1. 혼자서 한다면 플레이어와 컴퓨터가 대전합니다.
	 * 1-2. 둘이서 한다면 플레이어 둘이서 게임을 합니다.
	 * 2. gamePlay() 메소드를 이용하여 게임을 진행합니다.
	 * 3. 게임이 끝나면 서로의 빙고판을 공개한 후 빙고 수가 더 많은 쪽이 승리한다.
	 * </pre>
	 */
	public void game() {
		Scanner sc = new Scanner(System.in);

		// 1. 플레이어 수 정하기
		System.out.println("빙고게임을 시작합니다.");
		System.out.println("0. 종료");
		System.out.println("1. 혼자서");
		System.out.println("2. 둘이서");
		int no = sc.nextInt();

		String name;
		switch (no) {
		case 0:
			System.out.println("게임을 종료합니다.");
			return;

		case 1: // 1-1. 혼자서 게임을 할 경우
			System.out.println("컴퓨터랑 대전합니다.");
			System.out.println("플레이어1의 이름을 입력하세요 : ");
			sc.nextLine();
			name = sc.nextLine();
			play[0] = new Player(name);
			play[0].Make();

			play[1] = new Com();
			play[1].Make();

			break;

		case 2: // 1--2. 둘이서 게임을 할 경우
			System.out.println("플레이어끼리 대전합니다.");
			for (int i = 0; i < play.length; i++) {
				System.out.println("플레이어" + (i + 1) + "의 이름을 입력하세요 : ");
				sc.nextLine();
				name = sc.nextLine();
				play[i] = new Player(name);
				play[i].Make();
			}
			break;

		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
			break;
		}

		// 2. 게임 진행
		gamePlay();

		// 3. 게임 종료
		System.out.println("B! I! N! G! O!");
		System.out.println("게임 종료!!");

		System.out.println();

		play[0].Print();
		play[1].Print();

		// 빙고 수가 더 높은 쪽이 승리한다.
		if (play[0].getBingoCount() > play[1].getBingoCount()) {
			System.out.println(play[0].getName() + "의 승리 입니다.");
		} else if (play[0].getBingoCount() < play[1].getBingoCount()) {
			System.out.println(play[1].getName() + "의 승리입니다.");
		} else {
			System.out.println("무승부 입니다.");
		}
	}

	/**
	 * <pre>
	 * 게임 진행 메소드
	 * 1. 컴퓨터를 제외한 모든 플레이어의 빙고판을 공개한다.
	 * 2. 플레이어 순서대로 차례를 진행한다.
	 * 3. 각 턴에서 반환 받은 숫자를 다른 플레이어도 받아서 빙고 확인
	 * 4. 만약 각 턴에서 빙고 수가 3이상이면 게임 종료
	 * </pre>
	 */
	public void gamePlay() {

		int[] num = new int[play.length];

		while (true) {
			// 플레이어 수만큼 반복
			for (int i = 0; i < play.length; i++) {
				if (play[i] != null) {

					// 플레이어의 수만큼 빙고판 출력
					for (int j = 0; j < play.length; j++) {
						if (!(play[j] instanceof Com) && play[j] != null) {
							play[j].Print();
						}
					}

					// 플레이어의 턴이 끝나고 반환받은 숫자
					num[i] = play[i].Turn();
					System.out.println(play[i].getName() + "가 선택한 숫자는 " + num[i] + "입니다.\n");

					// 다른 플레이어도 해당 숫자를 확인
					for (int k = 0; k < play.length; k++) {
						if (k != i) {
							play[k].check(num[i]);
						}
					}

					// 만약 빙고 수가 3이상이면 게임 종료
					for (int a = 0; a < play.length; a++) {
						if (play[a].getBingoCount() >= 3) {
							return;
						}
					}
				}
			}
		}

	}

}
