# 01 빙고 게임

# 02 요약
플레이어와 컴퓨터 간의 빙고게임을 합니다.

빙고판은 5 * 5 크기입니다.

먼저 3빙고를 한 사람이 승리합니다.

# 03 요구사항
1. 게임은 플레이어와 컴퓨터가 진행합니다.
1. 플레이어가 정해지면 자동으로 빙고판을 만듭니다.
	1. 빙고판은 5 * 5의 크기를 가집니다.
1. 만들어진 빙고판을 보여주면서 게임을 시작합니다.
	1. 빙고판은 플레이어의 빙고판만 보여지고, Com의 빙고판은 보여주지 않습니다.
	2. 플레이어 1이 선공으로 시작합니다.
1. 선공이 먼저 숫자를 선택합니다.
	1. 빙고판에 그 숫자가 있는지 확인해서 있으면 해당 위치에 0을 넣고 선택한 숫자를 반환합니다.
	2. 반환 받은 숫자를 상대의 빙고판과 비교해 그 숫자가 있는 위치의 값을 0으로 바꿉니다.
1. 빙고 수를 확인합니다.
	1. 각 가로줄에 있는 0의 개수가 가로줄의 크기(5)와 같으면 1빙고
	2. 각 세로줄에 있는 0의 개수가 세로줄의 크기(5)와 같으면 1빙고
	3. 각 대각선에 있는 0의 개수가 대각선의 크기(5)와 같으면 1빙고
1. 후공이 숫자를 선택합니다.
	1. 컴퓨터는 랜덤으로 숫자를 선택하고 빙고판과 비교해 숫자가 없으면 다시 선택,  있으면 0으로 바꾼 뒤 숫자 반환
	3. 반환받은 숫자는 플레이어에게 전달 후 비교 확인
1. 빙고 수를 확인합니다.
1. 4 ~ 7번 과정을 반복해서 빙고 수가 면저 3이상이 되면 승리합니다.

## 추가

1. 게임 시작 전 혼자서 할건지 둘이서 할 건지 정합니다
	1. 혼자서 진행하면 상대는 컴퓨터, 둘이서 진행하면 상대는 플레이어2
	2. 플레이어들의 정보는 객체배열에 입력합니다.
	3. 플레이어는 플레이어 이름을 입력합니다.
	
# 04 클래스 다이어그램
![class_diagram](https://github.com/HeeManHer/Bingo_Game/blob/master/class_diagram.png)
# 05 커뮤니케이션 다이어그램
![communication_diagram](https://github.com/HeeManHer/Bingo_Game/blob/master/communication_diagram.png)