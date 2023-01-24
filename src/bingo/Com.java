package bingo;

/**
 * <pre>
 * Class : Com
 * Comment : 컴퓨터의 행동 메소드
 * History
 * 2023/01/18 (허희만) 
 * 		Play에서 상속받음
 * 		컴퓨터의 턴에서 해야 할 일을 메소드화
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
public class Com extends Bingo {

	/**
	 * <pre>
	 * 객체 생성 시 이름을 "컴퓨터"로 초기화
	 * </pre>
	 */
	public Com() {
		setName("com");
	}

	/**
	 * <pre>
	 * 숫자를 랜덤으로 입력받아 빙고판에 있으면 num 반환
	 * </pre>
	 * 
	 * @see bingo.Bingo#Turn()
	 */
	@Override
	public int Turn() {
		while (true) {
			int num = (int) (Math.random() * 25 + 1);

			if (check(num)) {
				return num;
			}
		}
	}
}
