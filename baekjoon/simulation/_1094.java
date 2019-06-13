package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1094 { // 막대기 : http://www.acmicpc.net/problem/1094

	/**
	 *  64cm 막대기를 절반으로만 잘라서 이어붙이기 때문에 Xcm를 만들기 위해서 사용될 막대기의 길이는 64, 32, 16, 8, 4, 2, 1cm 이다.
	 *  여기서 이진수에 대한 아이디어를 얻었다. 
	 *  입력받은 정수를 이진수로 바꾼뒤 1의 개수를 세면 된다.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int cnt = 0;
		int q = 0;
		while (n != 0) {
			if (n % 2 == 1) {
				cnt++;
			}
			q = n / 2;

			n = q;
		}
		System.out.println(cnt);
	}

}
