import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] crewTimeTable = new int[timetable.length];
        for(int i=0; i<timetable.length; i++){
            int hour = Integer.parseInt(timetable[i].substring(0,2));
            int minute = Integer.parseInt(timetable[i].substring(3,5));
            int total = hour*60+minute;
            crewTimeTable[i] = total;
        }
        Arrays.sort(crewTimeTable);
        int[][] waitOrder = new int[n][m];
        int[] waitOrderIdx = new int[n];
        
        int[] shuttle = new int[n];
        for(int i=0; i<n; i++){
            shuttle[i] = 540 + i*t;
        }
        
        for(int i=0; i<crewTimeTable.length; ++i){
            for(int j=0; j<n; ++j){
                if(crewTimeTable[i]<=shuttle[j]){
                    if(waitOrderIdx[j]>=m){
                        continue;
                    }
                    waitOrder[j][waitOrderIdx[j]] = crewTimeTable[i];
                    waitOrderIdx[j]++;
                    break;
                }
            }
        }        
        for(int i=0; i<waitOrder.length; i++){
            for(int j=0; j<waitOrder[i].length; j++){
                System.out.print(waitOrder[i][j]+" ");
            }
            System.out.println();
        }
        int hour = 0;
        int min = 0;
        if(waitOrderIdx[n-1]>=m){
            hour = waitOrder[n-1][m-1]/60;
            min = waitOrder[n-1][m-1]%60;
            if(min-1<0){
                answer =""+(hour-1>9?hour-1:"0"+(hour-1))+":59";
            }else{
                answer = ""+(hour>9?hour:"0"+hour)
                            +":"+(min-1>9?min-1:"0"+(min-1));
            }
        }else{
            answer =""+((shuttle[n-1]/60)>9 ? (shuttle[n-1]/60) : "0"+(shuttle[n-1]/60))+":"+((shuttle[n-1]%60)>10 ?(shuttle[n-1]%60) : "0"+(shuttle[n-1]%60));
        }
        return answer;
    }
}