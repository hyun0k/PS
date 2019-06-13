import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2206 { // 벽 부수고 이동하기 : https://www.acmicpc.net/problem/2206 
	
	static int N,M;
	static int[][] map;
	static int cnt;
	
	static int go(int x, int y) {
		
		return 0;
	}
	
	static void bfs() {
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
	}

}
