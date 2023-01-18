package bingo;

public class Com extends Play {
	
	public Com() {
		setName("com");
	}

	@Override
	public int Turn(int vsNum) {
		while (true){
			int num = (int) (Math.random() * 25 + 1);
			
			if(check(num)) {
				return num;
			}
		} 
	}
}
