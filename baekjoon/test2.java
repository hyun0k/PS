
public class test2 {
	
	static boolean[] broken = new boolean[10];
	
	
	static int numMove(int channel) {
		int len = 0;
		if (channel == 0) {
			return broken[0] ? 0 : 1;
		}
		while (channel > 0) {
			if (broken[channel % 10]) {
				return 0;
			}
			len += 1;
			channel /= 10;
		}
		return len;
	}
	public static void main(String[] args) {
		
	System.out.println(broken[0]);
	
		

 }
}