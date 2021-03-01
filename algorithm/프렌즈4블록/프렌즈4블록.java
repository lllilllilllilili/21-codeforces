class Solution {
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		//System.out.println(board[0].length());
		char[][] map = new char[m][n];
		for(int i=0; i<board.length; i++){
			map[i] = board[i].toCharArray();
		}//end of for loop

		// for(int i=0; i<map.length; i++){
		//     for(int j=0; j<map[i].length; j++){
		//         System.out.print(map[i][j]+" ");
		//     }
		//     System.out.println();
		// }//end of for loop
		boolean[][] check;
		boolean find;
		while(true){
			//1. 전체 순회하면서 같은것이 4개 있는지 확인 (오른쪽, 아래, 대각선) 4개가 있다면 지운다.
			find = false;
			check = new boolean[m][n];
			for(int i=0; i<map.length; i++){
				for(int j=0; j<map[i].length; j++){

					if(i+1<map.length && j+1<map[i].length){
						if(map[i][j]!='0' && map[i][j]==map[i+1][j] &&
								map[i][j]==map[i][j+1] &&
								map[i][j]==map[i+1][j+1]){
							check[i][j] = true;
							check[i+1][j] = true;
							check[i][j+1] = true;
							check[i+1][j+1] = true;
							find = true;
						}
					}
				}
			}//end of for loop

			if(find == false)
				break;
			// for(int i=0; i<check.length; i++){
			//     for(int j=0; j<check[i].length; j++){
			//         System.out.print(check[i][j]+" ");
			//     }
			//     System.out.println();
			// }

			for(int i=0; i<check.length; i++){
				for(int j=0; j<check[i].length; j++){
					if(check[i][j] == true){
						map[i][j] = '0';
						answer += 1;
					}
				}
			}

			//2. 내린다.
			for(int i=map.length-1; i>=0; i--){
				for(int j=map[i].length-1; j>=0; j--){
					if(map[i][j]!='0'){
						int tempi = i;
						int count = 0;
						int value = map[i][j];
						while(tempi+1<m && map[tempi+1][j]=='0') {
							tempi+=1;
							count+=1;
						}
						if(count>=1){
							map[tempi][j] = map[i][j];
							map[i][j] = '0';
						}
						// System.out.println("i : "+i+" j : "+j);
						// System.out.println("count : "+count);

						// for(int u=0; u<map.length; u++){
						//       for(int v=0; v<map[u].length; v++){
						//             System.out.print(map[u][v]+" ");
						//       }
						//       System.out.println();
						// }
						// System.out.println(tempi+" "+j);
						// System.out.println("------------------------");
					}
				}
			}//end of for loop


			//3. 1을 반복한다.
			//4. 1을 수행했을때 지울것이 없으면 while를 빠져나온다.
		}
		System.out.println(answer);
		return answer;
	}
}