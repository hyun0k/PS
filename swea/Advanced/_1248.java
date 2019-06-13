package Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1248 { // 공통조상

	static int T, V, E, v1, v2, size;
	static int[] ans1, ans2;
	static Node[] n;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		ans1 = new int[T + 1]; // 공통조상을 저장할 배열. 
		ans2 = new int[T + 1]; // 공통조상의 서브트리 크기를 저장할 배열. 

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());

			n = new Node[V + 1];
			for (int i = 1; i <= V; i++) {
				n[i] = new Node(i);
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int temp1 = Integer.parseInt(st.nextToken());
				int temp2 = Integer.parseInt(st.nextToken());
				insert(temp1, temp2);
			}

			ans1[tc] = getCommonAncestor();
			size = 1;
			getSize(ans1[tc]);
			ans2[tc] = size;
			sb.append("#" + tc + " " + ans1[tc] + " " + ans2[tc] + "\n");
		}
		System.out.println(sb);
	}

	static int getCommonAncestor() {
		Queue<Integer> q = new LinkedList<>();
		Node cur = n[v1];
		while (cur.parent != null) {
			cur = cur.parent;
			q.add(cur.data);
		}
		cur = n[v2];
		while (cur.parent != null) {
			cur = cur.parent;
			if (q.contains(cur.data)) {
				break;
			}
		}
		return cur.data;
	}

	static void getSize(int i) {
		if (n[i].left != null) {
			size++;
			getSize(n[i].left.data);
		}
		if (n[i].right != null) {
			size++;
			getSize(n[i].right.data);
		}
	}

	static void insert(int from, int to) {
		if (n[from].left == null) {
			n[from].left = n[to];
		} else {
			n[from].right = n[to];
		}
		n[to].parent = n[from];
	}

	static class Node {
		int data;
		Node parent, left, right;

		Node(int data) {
			this.data = data;
		}
	}

}
