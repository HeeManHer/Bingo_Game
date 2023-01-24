package bingo;

import java.util.Scanner;

/**
 * <pre>
 * Class : Player
 * Comment : 플레이어측 행동 클래스
 * History
 * 2023/01/18 (허희만) 
 * 		Play에서 상속받음
 * 		플레이어의 턴에서 해야 할 일을 메소드화
 * 2023/01/19 (허희만) 
 * 		부모 클레스의 이름이 PLay에서 Bingo로 변경
 * 		숫자 확인부분을 Play 클래스로 이전
 * 2023/01/24 (허희만) 
 * 		주석 작성
 * </pre>
 * 
 * @author 허희만
 * @version 1.0.3
 * @see
 */
public class Player extends Bingo {

	/**
	 * <pre>
	 * 객체 생성 시 name을 받아와
	 * 플레이어의 이름을 name으로 초기화한다.
	 * 만약 name이 공백이면 "플레이어"로 초기화한다.
	 * </pre>
	 */
	public Player(String name) {
		if ("".equals(name)) {
			setName("플레이어");
		} else {
			setName(name);
		}
	}

	/**
	 * <pre>
	 * 플레이어의 차례
	 * 숫자 하나를 입력받아 check() 메소드로 숫자 확인 후
	 * true를 반환 받으면 입력한 숫자를 반환한다.
	 * 입력한 숫자가 빙고판 범위를 벗어나거나 check() 메소드가 false이면 다시 입력받는다.
	 * </pre>
	 * 
	 * @see bingo.Bingo#Turn()
	 * @return check(num)이 true면 num반환
	 */
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
				if (check(num)) {
					return num;
				} else {
					System.out.println("이미 선택한 숫자입니다. 다시 입력하세요.");
				}
			}
		}
	}

}
