
import java.util.*;
import java.io.*;

public class p3 {
	static int answer = Integer.MAX_VALUE;
	static int answer_sum = 0;
	static int total_len =0;
	static int numberOfDigit(int num) {
		return (int)(Math.log10(num)+1);
	}
	static void DFS(int cut, int number, int cnt) {
//		int po = (int) Math.pow(10,cut);
//		int a = number/po;
//		int b = number%po;
//      0이 포함된 숫자가 있어서 10007을 1000으로 나누면 안됨
		char[] c_number = Integer.toString(number).toCharArray();
		String f="";
		String s="";
		int f_loop = cut;
		int s_loop = numberOfDigit(number)-cut;
		for(int i=0; i<f_loop; i++)
			f+=c_number[i];
		for(int i=s_loop; i>=1; i--)
			s+=c_number[numberOfDigit(number)-i];
		if(f.length()>=2 && f.charAt(0)=='0') return ;
		if(s.length()>=2 && s.charAt(0)=='0') return ;

		int sum = Integer.parseInt(f) + Integer.parseInt(s);
		int nLength = numberOfDigit(sum);
		if(nLength==1) {
			if(answer>=cnt){
				answer_sum = sum;
				answer = cnt;
			}
			return ;
		}
		for(int i=nLength-1; i>=1; i--)
			DFS(i,sum,cnt+1);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1번 인풋
		//int n = 73425;

		//2번 인풋
		//int n = 10007;

		//3번 인풋
		int n = 9;
		int nLength = numberOfDigit(n);
		total_len = nLength;
		boolean find = false;
		for(int i=nLength-1; i>=1; i--) {
			find = true;
			DFS(i,n,1);
		}

		int[] arr = new int[2];
		if(find) {
			arr[0] = answer;
			arr[1] = answer_sum;
		}else {
			arr[0] = 0;
			arr[1] = n;
		}
		System.out.println(Arrays.toString(arr));
	}
}
