package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1931 { // 회의실 배정 : http://www.acmicpc.net/problem/1931

	static int N, cnt;
	static Time[] time;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		time = new Time[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// 종료시간 기준으로 오름차순 정렬
		Arrays.sort(time, new Comparator<Time>() {
			public int compare(Time a, Time b) {
				if(a.end==b.end) {
					return Integer.compare(a.start, b.start);
				}
				return Integer.compare(a.end, b.end);
			}
		});

		int cur = 0;
		cnt = 0;
		for (int i = 0; i < N; i++) {
			if (cur <= time[i].start) {
				cur = time[i].end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static class Time {
		int start;
		int end;

		Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}
