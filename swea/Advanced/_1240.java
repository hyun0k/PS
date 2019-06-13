package Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1240 { // 단순 2진 암호코드

	static int T, N, M, ans;
	static char[][] map;
	static String[] code;
	static int[] code10;
	static String[] codeList = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
			"0110111", "0001011" }; // 순서대로 0,1,2,...,9

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			code = new String[8];
			code10 = new int[8];

			Arrays.fill(code, "");
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			extractCode(map);
			
			// 추출한 코드를 십진수로 바꿔서 code10에 한자리씩 저장. 
			for (int i = 0; i < code.length; i++) {
				for (int j = 0; j < 10; j++) {
					if (code[i].equals(codeList[j])) {
						code10[i] = j;
					}
				}
			}
			
			checkCode(code10);

			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	static void extractCode(char[][] arr) { // 코드의 끝자리는 항상 1이므로 코드 뒤에서부터 확인하며 처음 1이 나온 위치부터 56자리가 코드임. 
		int start_x = 0;
		int start_y = 0;
		for (int i = 0; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) {
				if (arr[i][j] == '1') {
					start_x = i;
					start_y = j - 55;
					break;
				}
			}
		}
		// 7자리씩 끊어서 code배열에 저장. 이후에 codeList의 코드들과 비교하여 십진수로 바꾼다. 
		int idx = 0;
		for (int i = 0; i < 56; i++) {
			code[idx] += arr[start_x][start_y + i];
			if ((i + 1) % 7 == 0) {
				idx++;
			}
		}

	}

	static void checkCode(int[] arr) {
		int sum = 0;
		int key = ((arr[0] + arr[2] + arr[4] + arr[6]) * 3) + arr[1] + arr[3] + arr[5] + arr[7];
		if (key % 10 == 0) {
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			ans = sum;
		} else {
			ans = 0;
		}
	}

}
