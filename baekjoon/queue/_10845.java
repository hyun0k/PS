/**
 * 
 */
package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Project : codePlus
 * @Package : queue
 * @FileName : _10845.java
 * @Author : hyunyoungkim
 * @Date : Feb 3, 2019
 */
public class _10845 { // 큐 : http://www.acmicpc.net/problem/10845

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
		Queue<Integer> queue = new LinkedList<Integer>();

		int last = 0;
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			command = str.split(" ");

			if (command[0].equals("push")) {
				queue.offer(Integer.parseInt(command[1]));
				last = Integer.parseInt(command[1]);
			}

			else if (command[0].equals("pop")) {
				if (queue.isEmpty()) {
					sb.append(-1).append(System.lineSeparator());
				} else {
					sb.append(queue.poll()).append(System.lineSeparator());
				}
			}

			else if (command[0].equals("size")) {
				sb.append(queue.size()).append(System.lineSeparator());
			}

			else if (command[0].equals("empty")) {
				if (queue.isEmpty()) {
					sb.append(1).append(System.lineSeparator());
				} else {
					sb.append(0).append(System.lineSeparator());
				}
			}

			else if (command[0].equals("front")) {
				if (queue.isEmpty()) {
					sb.append(-1).append(System.lineSeparator());
				} else {
					sb.append(queue.peek()).append(System.lineSeparator());
				}
			}

			else if (command[0].equals("back")) {
				if (queue.isEmpty()) {
					sb.append(-1).append(System.lineSeparator());
				} else {
					sb.append(last).append(System.lineSeparator());
				}
			}
		}
		System.out.println(sb);
	}

}
