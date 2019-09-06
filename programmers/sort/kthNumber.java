package sort;

import java.util.Arrays;

public class kthNumber {
	public int[] solution(int[] arr, int[][] commands) { // commands[i,j,k]
		
		int[] answer = new int[commands.length];
		int index = 0;
		
		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			int k = commands[i][2];

			int[] temp = new int[end - start + 1];
			int idx = 0;
			for (int j = start-1; j < end; j++) {
				temp[idx++] = arr[j];
			}
			
			Arrays.sort(temp);
			answer[index++] = temp[k-1];
			
		}
		
		return answer;
	}
}
