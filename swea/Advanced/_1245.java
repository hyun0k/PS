package Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1245 { // 균형점

	/**
	 * 이분탐색을 이용해서 균형점을 구한다.
	 */

	static int T, N;
	static int[] x;
	static int[] m;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			x = new int[N];
			m = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				m[i] = Integer.parseInt(st.nextToken());
			}
			sb.append("#" + tc);
			for (int i = 0; i < N - 1; i++) {
				sb.append(" " + getBalancePoint(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static String getBalancePoint(int l) {
		double left = x[l];
		double right = x[l + 1];
		double object = (left + right) / 2.0;

		while (true) {
			double f_left = 0;
			double f_right = 0;
			for (int i = 0; i < l + 1; i++) {
				f_left += getForce(m[i], x[i], object);
			}
			for (int i = l + 1; i < N; i++) {
				f_right += getForce(m[i], x[i], object);
			}

			if (0 < (right - left) && (right - left) < Math.pow(10, -12)) {
				return String.format("%.10f", object);
			} else if (f_left > f_right) {
				left = object;
				object = (right + object) / 2.0;
			} else {
				right = object;
				object = (left + object) / 2.0;
			}
		}
	}

	static double getForce(double m, double p, double x) {
		return (double) (m / Math.pow(p - x, 2));
	}

}
