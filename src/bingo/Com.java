package bingo;

public class Com extends Play {
	
	public Com() {
		setName("com");
	}

	@Override
	public int Turn() {
		while (true){
			int num = (int) (Math.random() * 25 + 1);
			
			if(check(num)) {
				return num;
			}
		} 
	}
}
