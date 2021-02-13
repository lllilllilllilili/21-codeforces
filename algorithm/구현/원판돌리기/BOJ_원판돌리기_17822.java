import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

class Pos{
	int first;
	int second;
	Pos(int first, int second){
		this.first = first;
		this.second = second;
	}
}
public class Main {
	private static int n,m,rot,x,d,k;
	private static ArrayList<Pos> group = new ArrayList<>();
	private static int[][] a;
	private static boolean range(int x, int y) {
		if(1<=x && x<n+1 && 0<=y && y<m) return true; else return false;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); rot = Integer.parseInt(st.nextToken());
		a = new int[n+1][m];
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());}}//end of for loop
		for(int r=1; r<=rot; r++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());		d = Integer.parseInt(st.nextToken());		k = Integer.parseInt(st.nextToken());
			//1step :: 돌려야할 원판 고르고 회전시키기 + 0은 시계방향, 1은 반시계 방향
			for(int i=1; i<n+1; i++) { //돌려야 하는 원판
				if(i%x==0) {
					for(int j=1; j<=k; j++) { //몇번 회전 시킬건지
						if(d==0) {
							//시계방향
							int temp = a[i][m-1];
							int c = m-2;
							for(int u=m-1; u>=1; u--) {
								a[i][u] = a[i][c];
								c-=1;
							} a[i][0] = temp;
						}else {
							//반시계방향
							int temp = a[i][0];
							int c = 1;
							for(int u=0; u<m-1; u++) {
								a[i][u] = a[i][c];
								c+=1;
							}a[i][m-1] = temp;
						}}}}//end of for loop

			//step2 :: 인접한 수 지우기, 없다며 평균 구해서 평균보다 작으면 +1 / 크면 -1 을 해준다.

		/*
		 * (i, 1)은 (i, 2), (i, M)과 인접하다.
		   (i, M)은 (i, M-1), (i, 1)과 인접하다.
	       (i, j)는 (i, j-1), (i, j+1)과 인접하다. (2 ≤ j ≤ M-1)
	       (1, j)는 (2, j)와 인접하다.
	       (N, j)는 (N-1, j)와 인접하다.
	       (i, j)는 (i-1, j), (i+1, j)와 인접하다. (2 ≤ i ≤ N-1)
		 */
			//System.out.println("debug--");
			boolean find = false; //인접 한 경우가 없다면 false 유지;
			for(int i=1; i<=n; i++) {
				for(int j=0; j<m; j++) {
					//(i, 1)은 (i, 2), (i, M)과 인접하다.
					if(a[i][j] == 0) continue;
					if(j==0 && range(i,j+1)) {
						if(a[i][j] == a[i][j+1]) {
							group.add(new Pos(i,j));
							group.add(new Pos(i,j+1));
						}
						if(a[i][j] == a[i][m-1]) {
							group.add(new Pos(i,j));
							group.add(new Pos(i,m-1));
						}}
					//(i, M)은 (i, M-1), (i, 1)과 인접하다. => 1case에 대해서 순차적으로 처리하므로
					if(j==m-1 && range(i,j-1)){
						if(a[i][j] == a[i][j-1]) {
							group.add(new Pos(i,j));
							group.add(new Pos(i,j-1));
						}
						if(a[i][j] == a[i][0]) {
							group.add(new Pos(i,j));
							group.add(new Pos(i,0));
						}}
					//(i, j)는 (i, j-1), (i, j+1)과 인접하다. (2 ≤ j ≤ M-1) => 1case에 대해서 순차적으로 처리
					if(j>=2 && j<=m-1 && range(i,j-1) && range(i,j+1)) {
						if(a[i][j] == a[i][j-1]) {
							group.add(new Pos(i,j));
							group.add(new Pos(i,j-1));
						}
						if(a[i][j] == a[i][j+1]) {
							group.add(new Pos(i,j));
							group.add(new Pos(i,j+1));
						}}
					//(1, j)는 (2, j)와 인접하다.
					if(i==0 && range(i+1,j)) {
						if(a[i][j] == a[i+1][j]) {
							group.add(new Pos(i,j));
							group.add(new Pos(i+1,j));
						}}
					//(N, j)는 (N-1, j)와 인접하다.
					if(i==n && range(i-1,j)) {
						if(a[i][j] == a[i-1][j]) {
							group.add(new Pos(i,j));
							group.add(new Pos(i-1,j));
						}}
					//(i, j)는 (i-1, j), (i+1, j)와 인접하다. (2 ≤ i ≤ N-1)
					if(2<=i && i<=n-1 && range(i-1,j) && range(i+1,j)) {
						if(a[i][j] == a[i-1][j]) {
							group.add(new Pos(i,j));
							group.add(new Pos(i-1,j));
						}
						if(a[i][j] == a[i+1][j]) {
							group.add(new Pos(i,j));
							group.add(new Pos(i+1,j));
						}}
				}}//end of for loop

			//System.out.println("debug--");
			if(group.size()==0) {
				int sum = 0;
				int cnt = 0;
				for(int i=1; i<=n; i++) {
					for(int j=0; j<m; j++) {
						if(a[i][j]==0) continue;
						else {
							sum+=a[i][j]; cnt+=1;
						}
					}}
				double d = (double)sum/cnt;
				for(int i=1; i<n+1; i++) {
					for(int j=0; j<m; j++) {
						if(a[i][j] == 0) continue;
						if(a[i][j]>d) {
							a[i][j]-=1;
						}else if(a[i][j]<d) {
							a[i][j]+=1;
						}
					}}
			}else {
				for(int i=0; i<group.size(); i++) {
					if(a[group.get(i).first][group.get(i).second]==0) continue;
					else
						a[group.get(i).first][group.get(i).second]=0;
				}}
			group.clear();

		}

		//System.out.println("debug");
		int ans = 0;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<m; j++) {
				ans+=a[i][j];
			}}
		System.out.println(ans);

	}
}
