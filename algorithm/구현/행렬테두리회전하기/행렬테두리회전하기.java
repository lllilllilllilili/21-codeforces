
class Solution {
	static int sx, sy, ex, ey;
	static int[][] map;
	static int minValue = Integer.MAX_VALUE;
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		map = new int[rows][columns];
		int number = 1;

		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				map[i][j] = number++;
			}
		}//end of for loop

		for(int i=0; i<queries.length; i++){
			sx = queries[i][0]-1;
			sy = queries[i][1]-1;
			ex = queries[i][2]-1;
			ey = queries[i][3]-1;
			int[][] cmap = new int[map.length][map[0].length];
			move(sx, sy+1, map[sx][sy], 1);

			answer[i]= minValue;
			minValue = Integer.MAX_VALUE;
		}
		return answer;
	}
	static void move(int x, int y,int temp, int dir){
		minValue = Math.min(minValue,temp);
		if(dir==1){
			//오른쪽
			if(y+1>ey){
				// int d = y+1;
				// System.out.println(d+" "+ey);
				int next = map[x][y];
				map[x][y]=temp;
				move(x+1,y,next,2);
			}else{
				int next = map[x][y];
				map[x][y] = temp;
				move(x, y+1, next, dir);
			}
		}else if(dir==2){
			//밑으로
			if(x+1>ex){
				int next = map[x][y];
				map[x][y]=temp;
				move(x,y-1,next,3);
			}else{
				int next = map[x][y];
				map[x][y]=temp;
				move(x+1,y,next,2);
			}
		}else if(dir==3){
			//왼쪽
			if(y-1<sy){
				int next = map[x][y];
				map[x][y]=temp;
				move(x-1,y,next,4);
			}else{
				int next = map[x][y];
				map[x][y]=temp;
				move(x,y-1,next,3);
			}
		}else if(dir==4){
			//위쪽
			if(x-1<sx){
				map[x][y]=temp;
			}else{
				int next = map[x][y];
				map[x][y]=temp;
				move(x-1,y,next,4);
			}
		}
	}
}