class Solution {
	static int answer=0;
	static boolean[] visit;
	static int[] array;
	static int upval=0;
	public int solution(int[] numbers, int target) {
		visit = new boolean[numbers.length];
		array = new int[numbers.length];
		DFS(numbers, 0, 0, 0, target);

		return answer;
	}
	static void DFS(int[] numbers, int node,  int next, int sum, int target){
		System.out.println(upval++);
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		if(node==numbers.length){
			//
			//System.out.println(upval++);
			if(sum==target){

				answer+=1;
			}

			return;
		}
		//5 4 3 2 1
		//63, 243
		//1+2+4+8+16+32 (지수가 자릿수야)
		for(int i=next; i<numbers.length; i++){

			array[node] = numbers[i];

			DFS(numbers, node+1, i+1, sum+numbers[i], target);

			//array[node] = (-1)*numbers[i];
			DFS(numbers, node+1, i+1, sum+(-1)*numbers[i], target);


		}
	}

}