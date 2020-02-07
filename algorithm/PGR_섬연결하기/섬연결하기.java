
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Solution {
    
    static int[] d;
    
    //연결 되어있는지 여부 확인 
    static int find(int nn){
        if(nn == d[nn]) return nn;
        else
            return d[nn] = find(d[nn]);
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<int[]> al = new ArrayList<>();
        for(int i=0; i<costs.length; i++)
            al.add(new int[]{costs[i][0], costs[i][1], costs[i][2]});
        
        //내림차순 정렬 
        Collections.sort(al, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
        d = new int[n];
        for(int i=0; i<d.length; i++){
            d[i] = i;
        }
        
        //최소 스패닝 트리 찾기 
        for(int i=0; i<costs.length; i++){
            int first = find(al.get(i)[0]);
            int second = find(al.get(i)[1]);
            int cost = al.get(i)[2];
            
            if(first!=second){
                d[first]=second;
                answer+=cost;
            }
        }
        
        return answer;
    }
}