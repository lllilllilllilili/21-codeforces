package programmers;

public class 프로그래머스_체육복_v1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int answer = 0;
		 int n = 5;
		 int[] lost = {2,4};
		 int[] reserve = {1,3,5};
	        int lost1 = 0;
	        for(int i=0; i<lost.length; i++){
	            for(int j=0; j<reserve.length; j++){
	                if(lost[i]==reserve[j]){
	                    lost1+=1;
	                    lost[i] = -1;
	                    reserve[j] = -1;
	                    break;
	                }
	            }
	        }
	        int cnt = 0;
	        for(int i=0; i<lost.length; i++){
	            for(int j=0; j<reserve.length; j++){
	                if(reserve[j]+1==lost[i] || reserve[j]-1==lost[i]){
	                    cnt+=1;
	                    reserve[j] = -1;
	                    break;
	                }
	            }
	        }
	        
	        System.out.println(n-lost.length+lost1+cnt);
	}

}
