package bingo;

import java.util.Scanner;

public class Player extends Bingo {

	public Player() {
		setName("플레이어");
	}

	public Player(String name) {
		setName(name);
	}

	

	@Override
	public int Turn() {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		System.out.println(getName() + "의 차례입니다.");
		
		while (true) {
			System.out.print("숫자를 하나 입력하세요 : ");
			num = sc.nextInt();

			if (num > getBingo().length * getBingo().length || num < 1) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			} else {
				if(check(num)) {
					return num;
				}else {
					System.out.println("이미 선택한 숫자입니다. 다시 입력하세요.");
				}
			}
		}
	}

}
