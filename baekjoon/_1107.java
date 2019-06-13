import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1107 { // 리모콘 : https://www.acmicpc.net/problem/1107 

	static int target, brokenCnt;
	static boolean[] broken = new boolean[10];

	static int numMove(int channel) {
		int len = 0;
		if (channel == 0) {
			return broken[0] ? 0 : 1;
		}
		while (channel > 0) {
			if (broken[channel % 10]) { // channel의 숫자버튼이 고장이면 0 리턴
				return 0; // 리턴하면 그 이하 구문은 실행 X
			}
			len += 1; // 고장이 아니면 len을 1증가 (그 숫자버튼을 눌러서 이동가능)
			channel /= 10; // 자리수마다 위 과정 반복
		}
		return len;
	}

	static int findAns() {
		int ans = Math.abs(target - 100);
		for (int i = 0; i <= 1000000; i++) { // 모든 채널에 대해 이동해본다. 
			int channel = i;
			int len = numMove(channel);
			if (len > 0) {
				int press = Math.abs(channel - target); // press는 + or - 로 이동하는 횟수 즉 target과 channel의 거리
				if (ans > len + press) {
					ans = len + press;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		target = Integer.parseInt(br.readLine());
		brokenCnt = Integer.parseInt(br.readLine());

		if (brokenCnt != 0) { // 고장난 버튼이 있으면
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < brokenCnt; i++) {
				broken[Integer.parseInt(st.nextToken())] = true; // 고장난 버튼은 true
			}
		}

		System.out.println(findAns());
	}

}
