import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663 { // N-Queen
	static int N;
	static int cnt;
	static int[] a;

	static boolean check(int[] a, int row) { // 해당 행에 퀸을 놓을 수 있는지 열을 순회하며 확인 
		for (int i = 0; i < row; i++) {
			if (a[row] == a[i] || row - i == Math.abs(a[row] - a[i])) { // 같은 열이거나 대각선 방향에 있으면 불가능 
				return false;
			}
		}
		return true;
	}

	static void nqueen(int[] a, int row, int N) { 
		for (int i = 0; i < N; i++) {
			a[row] = i;
			if (check(a, row)) { // 퀸을 놓을 수 있으면 
				if (row == N - 1) { // 마지막행이면 cnt 증가시킴. 모든 행에 하나씩 배치했다는 뜻.
					cnt++;
				} else {
					nqueen(a, row + 1, N); // 마지막행이 아니라면 다음행에 퀸을 놓는다.  
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		nqueen(a, 0, N);
		System.out.println(cnt);
	}

}
