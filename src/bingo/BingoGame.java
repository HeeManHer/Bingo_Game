package bingo;

import java.util.Scanner;

public class BingoGame {

	Play[] play = new Play[2];

	public void game() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			if (play[0] != null) {
				break;
			}
			System.out.println("빙고게임을 시작합니다.");
			System.out.println("0. 종료");
			System.out.println("1. 혼자서");
			System.out.println("2. 둘이서");
			int no = sc.nextInt();

			switch (no) {
			case 0:
				System.out.println("게임을 종료합니다.");
				return;

			case 1:
				System.out.println("컴퓨터랑 대전합니다.");
				play[0] = new Player();
				play[0].Make();

				play[1] = new Com();
				play[1].Make();

				break;

			case 2:
				System.out.println("플레이어끼리 대전합니다.");
				play[0] = new Player("p1");
				play[0].Make();

				play[1] = new Player("p2");
				play[1].Make();

				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
				break;
			}
		}

		int[] num = { 0, 0 };

		do {
			play[0].Print();
			play[1].Print();
			num[0] = play[0].Turn(num[1]);
			System.out.println(play[0].getName() + "가 선택한 숫자는 " + num[0] + "입니다.\n");
			play[1].check(num[0]);

			if (play[0].getBingoCount() >= 3 || play[1].getBingoCount() >= 3) {
				break;
			}
			
			play[0].Print();
			play[1].Print();

			num[1] = play[1].Turn(num[0]);
			System.out.println(play[1].getName() + "이 선택한 숫자는 " + num[1] + "입니다.\n");
			play[0].check(num[1]);

		} while (play[0].getBingoCount() < 3 || play[1].getBingoCount() < 3);

		System.out.println("B! I! N! G! O!");
		System.out.println("게임 종료!!");

		System.out.println();

		play[0].Print();
		play[1].Print();

		if (play[0].getBingoCount() > play[1].getBingoCount()) {
			System.out.println(play[0].getName() + "의 승리 입니다.");
		} else if (play[0].getBingoCount() < play[1].getBingoCount()) {
			System.out.println(play[1].getName() + "의 승리입니다.");
		} else {
			System.out.println("무승부 입니다.");
		}
	}

}
