/**
 * 
 */
package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Project : codePlus
 * @Package : sort
 * @FileName : _10825.java
 * @Author : hyunyoungkim
 * @Date : Jan 29, 2019
 */
public class _10825 {

	/**
	 * @param args
	 */
	static int n;
	static List<Student> std;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		std = new ArrayList<Student>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			std.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		Collections.sort(std, new Comparator<Student>() {
			public int compare(Student a, Student b) {
				if (a.ko == b.ko) {
					if (a.en == b.en) {
						if (a.ma == b.ma) {
							return a.name.compareTo(b.name);
						}
						return Integer.compare(b.ma, a.ma);
					}
					return Integer.compare(a.en, b.en);
				}
				return Integer.compare(b.ko, a.ko);
			}
		});

		for (Student student : std) {
			sb.append(student.name).append(System.lineSeparator());
		}
		System.out.println(sb);
	}

}

class Student {
	String name;
	int ko;
	int en;
	int ma;

	public Student(String name, int ko, int en, int ma) {
		this.name = name;
		this.ko = ko;
		this.en = en;
		this.ma = ma;
	}
}
