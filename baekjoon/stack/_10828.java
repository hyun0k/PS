/**
 * 
 */
package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Project : codePlus
 * @Package : stack
 * @FileName : _10828.java
 * @Author : hyunyoungkim
 * @Date : Feb 2, 2019
 */
public class _10828 { // 스택 : http://www.acmicpc.net/problem/10828

	/**
	 * @param args
	 */
	static int n;
	static String[] command;
	static String str;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			str = br.readLine();
			command = str.split(" ");

			if (command[0].equals("push")) {
				stack.push(Integer.parseInt(command[1]));
			}

			else if (command[0].equals("pop")) {
				if (stack.isEmpty()) {
					sb.append(-1).append(System.lineSeparator());
				} else {
					sb.append(stack.pop()).append(System.lineSeparator());
				}
			}

			else if (command[0].equals("size")) {
				sb.append(stack.size()).append(System.lineSeparator());
			}

			else if (command[0].equals("empty")) {
				if (stack.isEmpty()) {
					sb.append(1).append(System.lineSeparator());
				} else {
					sb.append(0).append(System.lineSeparator());
				}
			}

			else if (command[0].equals("top")) {
				if (stack.isEmpty()) {
					sb.append(-1).append(System.lineSeparator());
				} else {
					sb.append(stack.peek()).append(System.lineSeparator());
				}
			}
		}

		System.out.println(sb);

	}

}
