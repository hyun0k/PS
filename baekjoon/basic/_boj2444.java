package basic;
import java.util.*;
import java.io.*;

public class _boj2444 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + i; j++) {
				if (j < n - (i + 1)) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		for (int i = n; i > 0; i--) {
			for (int j = 0; j < n + (i - 2); j++) {
				if (j <= n - i) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
