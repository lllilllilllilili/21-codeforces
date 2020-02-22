package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;

/*
 * 
 * 
 * 
 * 
 * 
 */

/*
 * 동작원리 
 * 하노이 타워는 아래로 갈수록 원판의 크기가 커진다는 특징이 있습니다. 
 * 따라서, 일정한 규칙을 지니고 있는데 
 * 1) 원판이 하나 이상일 경우 b와 c의 위치를 스와핑 해서 스택에 쌓습니다. 
 * 2) 원판을 하나 뽑았을 경우 스와핑하고 a와 b의 위치를 스와핑 합니다. 
 * 쌓인 원판의 개수와 앞으로 이동할 위치를 스택에 갱신하면 하노이 타워의 이동흐름을 파악할 수 있습니다. 
 * 
 * 
 */

public class 하노이 {
	static int cnt; 
    static Stack<Integer> st = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    private static void endPrint(int n, int a, int c) {
        //System.out.println(n+" : "+a+" -> "+c);
//        System.out.println(a+" "+c);
    	sb.append(a+" ");
    	sb.append(c+"\n");
    	cnt +=1; 
    }
    private static void go(int n, int a, int b, int c) {
        while(true) {

            while(n>1) { 
                /*
                 * 
                 * 확인하고자 하는것은 하나의 원판의 이동 경로이므로 
                 * 1보다 큰 경우 1씩 감소하며 b,c 의 위치를 
                 * 번갈아 스와핑 하면 스택에 저장합니다.
                 * stack에 담겨있는 n인 원판의 쌓인 위치를 의미하며, b 와 c를 바꾸는 까닭은 해당 위치의 원판이 앞으로 이동할 위치를 갱신합니다. 
                 * 
                 */
                st.push(c);
                st.push(b);
                st.push(a);
                st.push(n);
                n-=1;
                int temp = c;
                c = b;
                b = temp; //자리 바꿈 
            }
            endPrint(n, a, c); 
            if(!st.isEmpty()) {
                /*
                 * stack에서 꺼낸 쌓인 원판의 위치를 다음 위치로 이동시키고 
                 * 
                 * 
                 */
                n = st.pop();
                a = st.pop();
                b = st.pop();
                c = st.pop();

                endPrint(n, a, c); //위치 이동 
                /*
                 * 
                 * 
                 * 옮겨진 원판이 다음에 가야할 위치를 갱신합니다. 
                 */
                n-=1;
                int temp = b;
                b = a;
                a = temp;

            }else
                break; //스택이 비어있으면 종결 됩니다. 

        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(br.readLine());

        BigInteger result = new BigInteger("1");
        
        if(start<=20) {
        	go(start, 1,2,3);
            System.out.println(cnt);
            System.out.println(sb.toString());
        }
        else{
        	for(int i=0; i<start; i++) {
        		result = result.multiply(new BigInteger("2"));
        	}
        	result = result.subtract(new BigInteger("1"));
        	System.out.println(result);
        	
        }
        //1이 첫번째 자리
        //2가 두번째 자리 
        //3이 세번째 자리 

        
    }

}