package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1966 { // 프린터 큐 : http://www.acmicpc.net/problem/1966

	static int T, n, m;
	static int[] origin, sorted;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		/**
		 * 원래 문서들의 순서로 된 배열과 중요도 순으로 정렬한 배열의 인덱스를 비교하면서 출력될 순서를
		 * 찾는다. 
		 */
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			origin = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				origin[i] = Integer.parseInt(st.nextToken());
			}
			
			// 중요도 순으로 오름차순 정렬. 
			sorted = origin.clone();
			Arrays.sort(sorted);

			int cnt = 0;
			int index = 0;
			int s_index = sorted.length - 1;
			while (true) {
				
				// origin의 처음 문서가 중요도가 제일 높으면 출력.  
				if (origin[index] == sorted[s_index]) {
					cnt++;
					s_index--;
					
					// 출력 순서를 구하고자하는 문서의 인덱스와 같으면 반복문 탈출. 
					if (index == m) {
						break;
					}
				}
				index++;
				
				// 한바퀴돌면 index를 다시 0으로. 
				if (index == n) {
					index = 0;
				}
			}
			sb.append(cnt).append(System.lineSeparator());
		}
		System.out.println(sb);

	}

}
