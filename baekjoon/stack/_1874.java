package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874 { // 스택 수열 : http://www.acmicpc.net/problem/1874

	static int n;
	static int[] a;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		a = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0;

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n; i++) {
			stack.push(i + 1);
			sb.append("+").append(System.lineSeparator());
			while (!stack.isEmpty() && stack.peek() == a[index]) {
				index++;
				stack.pop();
				sb.append("-").append(System.lineSeparator());
			}
		}

		if (stack.isEmpty()) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}

	}

}
