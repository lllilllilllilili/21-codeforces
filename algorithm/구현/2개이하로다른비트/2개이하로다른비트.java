import java.util.*;
import java.io.*;
class Solution {
	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		for(int i=0; i<numbers.length; i++){
			String binary = Long.toBinaryString(numbers[i]);
			char[] strToChar = binary.toCharArray();

			int memoryIdx = -1;
			for(int j=strToChar.length-1; j>=0; j--){
				if(strToChar[j]=='0'){
					memoryIdx = j;
					strToChar[j]='1';

					break;
				}
			}

			if(memoryIdx == -1){
				binary = "1"+binary;
				strToChar = binary.toCharArray();
				if(strToChar[1]=='1')
					strToChar[1]='0';
			}else{
				if(memoryIdx+1<strToChar.length && strToChar[memoryIdx+1]=='1'){
					strToChar[memoryIdx+1]='0';
				}

			}
			
			long sum = 0;
			int cnt = 0;
			for(int j=1; j<=strToChar.length; j++){
				sum+=(Math.pow(2,cnt++)*Long.parseLong(""+strToChar[strToChar.length-j]));
			}
			answer[i] = sum;
		}
		return answer;
	}
}