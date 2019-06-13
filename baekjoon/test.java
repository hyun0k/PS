import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) throws NumberFormatException, IOException {

		new test().sol2();
	}

	int[] dx = { 0, 0, -1, 1 };
	int[] dy = { 1, -1, 0, 0 };

	void sol2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		while (test-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			char[][] temp = new char[n][m];
			int map[][] = new int[n][m];
			// 0:빈공간 1:사람 2:불 3:벽
			int startX = 0, startY = 0;
			Queue<pos> q = new LinkedList();
			Queue<pos> fire = new LinkedList();
			for (int i = 0; i < n; i++) {
				temp[i] = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					if (temp[i][j] == '@') {
						q.add(new pos(i, j, 0));
						map[i][j] = 1;
					} else if (temp[i][j] == '#') {
						map[i][j] = 3;

					} else if (temp[i][j] == '*') {
						map[i][j] = 2;
						fire.add(new pos(i, j, 1));
					}
				}

			}
			int escape = 0;
			while (!q.isEmpty()) {
				int f_size = fire.size();
				while (f_size-- > 0) {
					pos c = fire.poll();
					int cx = c.x;
					int cy = c.y;

					for (int i = 0; i < 4; i++) {
						int nx = cx + dx[i];
						int ny = cy + dy[i];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] >= 2)
							continue;
						map[nx][ny] = 2;
						fire.add(new pos(nx, ny, 0));
					}
				}
				int p_size = q.size();
				while (p_size-- > 0) {
					pos cur = q.poll();
					int curx = cur.x;
					int cury = cur.y;
					int cnt = cur.cnt;
					for (int i = 0; i < 4; i++) {
						int nextx = curx + dx[i];
						int nexty = cury + dy[i];

						if (nextx < 0 || nexty < 0 || nextx >= n || nexty >= m) {
							escape = ++cnt;
							break;

						}
						if (map[nextx][nexty] > 0)
							continue;
						q.add(new pos(nextx, nexty, cnt + 1));
						map[nextx][nexty] = 1;
					}
				}

				if (escape > 0)
					break;

			}
			System.out.println(escape == 0 ? "IMPOSSIBLE" : escape);

		} // while(test-->0)
	}

	class pos {
		int x, y, cnt;

		pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}