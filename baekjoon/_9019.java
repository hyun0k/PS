import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _9019 { // DSLR : https://www.acmicpc.net/problem/9019

	static int test_case, start, target;
	static int MAX = 10001;
	static Queue<Integer> q; 
	static int[] from; 
	static char[] how; 
	static boolean[] check;
	static char[] operation = { 'D', 'S', 'L', 'R' };

	static int command_D(int N) {
		return 2 * N % 10000;
	}

	static int command_S(int N) {
		return N == 0 ? 9999 : N - 1;
	}

	static int command_L(int N) { // 왼쪽으로 밀기
		return N / 1000 + (N % 1000) * 10;
	}

	static int command_R(int N) { // 오른쪽으로 밀기
		return N / 10 + (N % 10) * 1000;
	}

	static void bfs() {
		q.offer(start);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == target) {
				break;
			}
			for (int i = 0; i < 4; i++) {
				int next;
				if (operation[i] == 'D') {
					next = command_D(cur);
					if (!check[next]) {
						check[next] = true;
						from[next] = cur;
						how[next] = 'D';
						q.offer(next);
					}
				} else if (operation[i] == 'S') {
					next = command_S(cur);
					if (!check[next]) {
						check[next] = true;
						from[next] = cur;
						how[next] = 'S';
						q.offer(next);
					}
				} else if (operation[i] == 'L') {
					next = command_L(cur);
					if (!check[next]) {
						check[next] = true;
						from[next] = cur;
						how[next] = 'L';
						q.offer(next);
					}
				} else if (operation[i] == 'R') {
					next = command_R(cur);
					if (!check[next]) {
						check[next] = true;
						from[next] = cur;
						how[next] = 'R';
						q.offer(next);
					}
				}

			}
		}
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		while(target != start) {
			stack.push(how[target]);
			target = from[target];
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		test_case = Integer.parseInt(br.readLine());

		for (int t = 0; t < test_case; t++) {

			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());
			
			from = new int[MAX];       // 테스트케이스마다 모든 배열, 큐 초기화 
			how = new char[MAX];
			check = new boolean[MAX];
			q = new LinkedList<>();

			bfs();
			print();
		}

	}

}
