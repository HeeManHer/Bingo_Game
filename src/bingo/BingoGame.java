package bingo;

public class BingoGame {

	public void game() {

		System.out.println("빙고게임에 어서오세요.");
		System.out.println("컴퓨터랑 대전합니다.");
		Play player = new Player();
		Play com = new Com();

		int numPlayer;
		int numCom;
		
		numPlayer = player.Turn(0);
		
		while(true) {

			numCom = com.Turn(numPlayer);
			numPlayer = player.Turn(numCom);
		}
//		} while (isPlayer || isCom);
//		
//		if(isPlayer && !isCom) {
//			System.out.println("플레이어가 승리했습니다!!");			
//		}else if(!isPlayer && isCom) {
//			System.out.println("상대가 이겼습니다.");
//		}else {
//			System.out.println("무승부 입니다.");
//		}

	}

}
