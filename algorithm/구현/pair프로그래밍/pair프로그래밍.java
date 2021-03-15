
public class pair프로그래밍 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1번
//		int[][] input = { 
//				{1, 2}, 
//				{2, 1}, 
//				{3, 3}, 
//				{4, 5}, 
//				{5, 6}, 
//				{7, 8}
//		};
		
		//2번
//		int[][] input = {
//				{1, 2}, 
//				{3, 4}, 
//				{5, 6}
//		};
		
		//3번
		int[][] input = {
				{1, 2}, 
				{2, 3}, 
				{3, 1}
		};
		
		int answer = 0;
		int box_cnt = input.length;
		int[] product = new int[1000001];
		//step1 : product 전수 조사 
		for(int i=0; i<input.length; i++) {
			product[input[i][0]]+=1;
			product[input[i][1]]+=1;
		}//eofl
		
		//setp2 : 2미만 개수에 대해 정답을 +1 단, 상자의 개수를 초과하면 더이상 조회하지 않음
		for(int i=0; i<product.length; i++) {
			if(box_cnt == 0) break;
			if(product[i]==0) continue;
			else if(product[i]%2==0) {
				box_cnt--;
			}else {
				box_cnt--;
				answer+=1;
			}
		}//eofl
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		System.out.println(sb.toString());
		
	}

}
