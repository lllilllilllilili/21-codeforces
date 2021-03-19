
import java.util.*;
import java.io.*;
public class p4_2 {

	static int[][] maze;
	static Direction currentDirection = Direction.NORTH;
	public enum Direction {NORTH,EAST,SOUTH,WEST};
	static int[][] left= {{-1,0},{0,-1},{1,0},{0,1}};
	static int[][] go = {{0,-1},{1,0},{0,1},{-1,0}}; //북, 동, 남, 서
	static int cnt=0;
	static void checkLeftAndModifyDirection(int sx, int sy) {

		int nx=sx+left[currentDirection.ordinal()][0];
		int ny=sy+left[currentDirection.ordinal()][1];

		if(nx<0 || nx>=maze.length || ny<0 || ny>=maze.length) return ;
		if(maze[ny][nx]==1) return ;

		else {

			switch(currentDirection) {
				case NORTH :
					currentDirection=Direction.WEST;
					break;
				case EAST :
					currentDirection=Direction.NORTH;
					break;
				case SOUTH :
					currentDirection=Direction.EAST;
					break;
				case WEST :
					currentDirection=Direction.SOUTH;
					break;
			}
			//checkLeftAndModifyDirection(sx,sy);
		}
	}
	//함수밖은 static
	static int[] goingOn(int sx, int sy) {
		int[] answer = {sx,sy};
		int nx=sx+go[currentDirection.ordinal()][0];
		int ny=sy+go[currentDirection.ordinal()][1];
		if(nx<0 || nx>=maze.length || ny<0 || ny>=maze.length || maze[ny][nx]==1) ;
		else {
			answer[0]=nx;
			answer[1]=ny;
			System.out.println(sx+" "+sy);
			cnt+=1;
		}

		return answer;
	}
	static void turnRight() {
		switch(currentDirection) {
			case NORTH :
				currentDirection=Direction.EAST;
				break;
			case EAST :
				currentDirection=Direction.SOUTH;
				break;
			case SOUTH :
				currentDirection=Direction.WEST;
				break;
			case WEST :
				currentDirection=Direction.NORTH;
				break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maze=new int[][] {
				{0, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0, 0},
				{1, 0, 1, 1, 1, 1},
				{0, 0, 0, 0, 0, 0},
				{1, 1, 0, 1, 1, 0}
		};

		int sx=0;
		int sy=0;
		int ex=maze.length-1;
		int ey=maze.length-1;

		while(sx!=ex || sy!=ey) {

			checkLeftAndModifyDirection(sx,sy);
			int[] pos = goingOn(sx,sy);
			if(pos[0]==sx && pos[1]==sy) {

				turnRight();
			}
			sx=pos[0];
			sy=pos[1];

		}
		System.out.println(cnt);
	}
}
