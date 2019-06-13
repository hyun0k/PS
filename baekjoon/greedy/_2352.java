package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2352 { // 반도체 설계 : http://www.acmicpc.net/problem/2352
	/**
	 * LIS 를 구할때 O(NlogN) 방법으로 구해야 시간초과가 나지 않는다. 이분탐색이용. 
	 */
	static int N, ans;
	static int[] port;
	static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		port = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			port[i] = Integer.parseInt(st.nextToken());
		}

		ans = getLIS(port, N);
		
		System.out.println(ans);

		// Arrays.sort(port, new Comparator<int[]>() {
		// public int compare(int[] entry1, int[] entry2) {
		// Integer port1 = entry1[0];
		// Integer port2 = entry2[0];
		// return port1.compareTo(port2);
		// }
		// });

	}

	private static int getLIS(int[] arr, int n) {
		int[] d = new int[n];
		int size = 0;

		d[0] = arr[0];
		size = 1;

		for (int i = 0; i < n; i++) {
			if (arr[i] < d[0]) {
				d[0] = arr[i];
			} else if (arr[i] > d[size - 1]) {
				d[size] = arr[i];
				size++;
			} else {
				int idx = Arrays.binarySearch(d, 0, size, arr[i]);
				idx = idx < 0 ? -idx - 1 : idx;
				d[idx] = arr[i];
			}
		}
		return size;
	}

}