package programmers;

public class 프로그래머스_체육복_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n = 5;
		 int[] lost = {2,4};
		 int[] reserve = {1,3,5};
		 int[] people = new int[n];
	        int answer = n;

	        for (int l : lost) 
	            people[l-1]--;
	        for (int r : reserve) 
	            people[r-1]++;

	        for (int i = 0; i < people.length; i++) {
	            if(people[i] == -1) {
	                if(i-1>=0 && people[i-1] == 1) {
	                    people[i]++;
	                    people[i-1]--;
	                }else if(i+1< people.length && people[i+1] == 1) {
	                    people[i]++;
	                    people[i+1]--;
	                }else 
	                    answer--;
	            }
	        }
	        System.out.println(answer);
	}

}
