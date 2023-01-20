package bingo;

import java.util.Scanner;

public class BingoGame {

	Bingo[] play = new Bingo[2];

	public void game() {
		Scanner sc = new Scanner(System.in);

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

		case 1:
			System.out.println("컴퓨터랑 대전합니다.");
			System.out.println("플레이어1의 이름을 입력하세요 : ");
			sc.nextLine();
			name = sc.nextLine();
			play[0] = new Player(name);
			play[0].Make();

			play[1] = new Com();
			play[1].Make();

			break;

		case 2:
			System.out.println("플레이어끼리 대전합니다.");
			System.out.println("플레이어1의 이름을 입력하세요 : ");
			sc.nextLine();
			name = sc.nextLine();
			play[0] = new Player(name);
			play[0].Make();

			System.out.println("플레이어2의 이름을 입력하세요 : ");
			name = sc.nextLine();
			play[1] = new Player(name);
			play[1].Make();
			break;
			
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
			break;
		}

		gamePlay();		

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
	
	public void gamePlay() {
		
		int[] num = new int[play.length];
		
		while (true) {
			for (int i = 0; i < play.length; i++) {
				if (play[i] != null) {

					for (int j = 0; j < play.length; j++) {
						if (!(play[j] instanceof Com) && play[j] != null) {
							play[j].Print();
						}
					}

					num[i] = play[i].Turn();
					System.out.println(play[i].getName() + "가 선택한 숫자는 " + num[i] + "입니다.\n");

					for (int k = 0; k < play.length; k++) {
						if (k != i) {
							play[k].check(num[i]);
						}
					}

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
