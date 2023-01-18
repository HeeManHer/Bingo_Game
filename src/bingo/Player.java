package bingo;

import java.util.Scanner;

public class Player extends Play {

	@Override
	public int Turn(int vsNum) {
		
		if(vsNum !=0 ) {
			
			
			
			
			
		}
		
		
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean isTrue = true;
		
		System.out.println("플레이어의 차례입니다.");
		
		
		
		
		
		

		while (isTrue) {
			System.out.print("숫자를 하나 입력하세요 : ");
			num = sc.nextInt();

			if (num > getBingo().length * getBingo().length || num < 1) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			} else {
				isTrue = false;
			}
		}
		
		for (int i = 0; i < getBingo().length; i++) {
			for (int k = 0; k < getBingo()[i].length; k++) {
				if (getBingo()[i][k] == num) {
					getBingo()[i][k] = 0;
				}
			}
		}
		Match();

		Print();
		if (getBingoCount() > getBingo().length / 2) {
			System.out.println("BINGO!!");
			return num;
		}
		return num;
	}

}
