package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1152 { // 단어의 개수 : http://www.acmicpc.net/problem/1152

	static ArrayList<String> a = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			a.add(st.nextToken());
		}

		System.out.println(a.size());

	}

}
