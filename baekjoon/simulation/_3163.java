package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _3163 { // 떨어지는 개미 : http://www.acmicpc.net/problem/3163

	static int T, N, L, k;
	static ArrayList<Ant> ant;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			ant = new ArrayList<Ant>();
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				ant.add(new Ant(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
		}
	}

	static class Ant {
		int Pos;
		int ID;

		Ant(int Pos, int ID) {
			this.Pos = Pos;
			this.ID = ID;
		}
	}

}
