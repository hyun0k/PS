package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012 { // 괄호 : http://www.acmicpc.net/problem/9012

	static int test_case;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		test_case = Integer.parseInt(br.readLine());

		while (test_case-- > 0) {

			boolean isVPS = true;
			String input = br.readLine();
			Stack<Character> stack = new Stack<Character>();

			char temp;
			for (int i = 0; i < input.length(); i++) {
				temp = input.charAt(i);
				if (temp == '(') {
					stack.push(temp);
				} else {
					if (!stack.isEmpty()) {
						stack.pop();
					} else {
						isVPS = false;
						break;
					}
				}
			}
			if (!stack.isEmpty()) {
				isVPS = false;
			}

			if (isVPS) {
				sb.append("YES").append(System.lineSeparator());
			} else {
				sb.append("NO").append(System.lineSeparator());
			}
		}

		System.out.println(sb);
	}

}
