package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1021 { // 회전하는 큐 : http://www.acmicpc.net/problem/1021

	static int n, m;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			list.add(i + 1);
		}

		int cur = 0;
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int head = list.indexOf(Integer.parseInt(st.nextToken()));
			int d = Math.abs(head - cur);
			cnt += Math.min(d, list.size() - d);
			list.remove(head);
			cur = head;
		}
		System.out.println(cnt);

	}

}
