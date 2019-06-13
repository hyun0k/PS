package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10219 { // Meats On the Grill : http://www.acmicpc.net/problem/10219

	/**
	 * 고기를 뒤집은 상태중 아무거나 출력하면 되므로 불판을 뒤집는 경우를 출력한다. 불판을 뒤집으면 고기 전체가
	 * 뒤집히므로 좌우대칭하여 출력하면 된다.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = W - 1; j >= 0; j--) {
					sb.append(str.charAt(j));
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
