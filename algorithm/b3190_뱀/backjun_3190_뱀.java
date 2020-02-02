package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjun_3190_�� {
	static int n;
	static int apple_cnt;
	static int[][] map;
	static int[][] apple_map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		apple_cnt = Integer.parseInt(br.readLine());
		apple_map = new int[n][n];
		map = new int[n][n];
		for(int i=0; i<apple_cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int apple_x = Integer.parseInt(st.nextToken())-1;
			int apple_y = Integer.parseInt(st.nextToken())-1;
			apple_map[apple_x][apple_y] = 1;
		}//��� �Է�
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = -1;
			}
		}//map init
		
		int current_time=0;
		int len = 1; //������
		int init_x = 0;
		int init_y = 0;
		int dir = 0;
		String ndir="";
		int time = 0;
		map[init_x][init_y] = 0; //ó�� ���� ��ġ�� ��
		int direction_cnt = Integer.parseInt(br.readLine()); //direction 
		u:for(int i=0; i<=direction_cnt; i++) {
			time = n*n+1; //time init
			ndir = "L"; //ndir init
			if(i<direction_cnt) { //���� ������ �ʰ� ���� ������ ���� ��� 
				StringTokenizer st= new StringTokenizer(br.readLine());
				time = Integer.parseInt(st.nextToken());
				ndir = st.nextToken();
			}
			while(current_time<time) { //�Է����� �־��� N�ð� �ȿ� ���� ������ �� �ִٸ� 
				current_time +=1; //�ð� �����ϰ�
				init_x += dx[dir]; //x�̵�
				init_y += dy[dir]; //y�̵�
				
				if(init_x<0 || init_x>=n || init_y<0 || init_y>=n) {
					//�� �Ǵ� �ڱ��ڽ��� ���� �ε����� ������ ������.
					System.out.println(current_time);
					return ; 
				}
				if(apple_map[init_x][init_y]==1) {
					len+=1;
					apple_map[init_x][init_y] = 0;
				}//����� ���� ���
				
				if(map[init_x][init_y]!=-1 && current_time-map[init_x][init_y]<=len) {
					System.out.println(current_time);
					return ; 
				}
				map[init_x][init_y] = current_time;
				}
				if(ndir.equals("D")){
					//������
					dir = (dir+1)%4;
				}else {
					//���� 
					dir = (dir+3)%4;
				}
		}
	}
}
