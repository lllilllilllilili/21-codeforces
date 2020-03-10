package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
DFS 에 쓰인 변수
c : 문자열 길이를 체크하는 변수, example . 5가 되면 5개의 글자가 된다.
cnt : 문제에서 사전순으로 출력하라 했으므로 매 재귀 호출때마다 cnt+1 로 for 문의 시작 포인트를 업데이트 
str : 사전순으로 숫자들을 저장하기 위해 String 으로 선언하였고 매 재귀마다 이를 매개변수로 넣어줬습니다.
*/

/*
동작 방식
처음 접근할때는 배열을 하다 둬서 백트래킹으로 시도해 볼려 했으나 
사전순으로 출력한다를 유념하여 매 재귀함수 호출마다 시작 포인트를 이전 포인트보다 하나 앞으로 설정하면 간단하게 해결 할 수 있는 문제였습니다.
*/
public class 로또_6603 {  
    static int[] arr;
    static int t;
    private static void DFS(int c, int cnt, String str) {
        if(c == 5) { 
            System.out.println(str);
            return;
        }

        for(int a=cnt+1; a<t; a++) {        
            DFS(c+1,a, str+" "+arr[a]);     
        }

    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
    System.setIn(new FileInputStream("res/backjun_6603.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = 1; // 몇개의 숫자를 입력 받을지 결정하는 변수

    while(t!=0) { 
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken()); 
        arr = new int[t];
        String str = "";
        for(int k=0; k<t; k++) { //개수만큼 arr에 저장
            arr[k] = Integer.parseInt(st.nextToken());
        }
        for(int g=0; g<t; g++) { //t만큼 arr를 순회하면서 str 에 사전순으로 저장
            DFS(0,g, str+arr[g]);
        }
        System.out.println();
    }
    }

}
