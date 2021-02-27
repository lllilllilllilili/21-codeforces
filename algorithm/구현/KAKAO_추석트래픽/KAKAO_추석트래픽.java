import java.util.*;
import java.io.*;
class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        for(int i=0; i<lines.length; i++){
            String hour, min, second, millsec;
            int hourTomillsec, minTomillsec, secTomillsec;
            int Ptime;
            hour = lines[i].substring(11,13);
            min = lines[i].substring(14,16);
            second = lines[i].substring(17,19);
            millsec = lines[i].substring(20,23);

            //double pPtime = Double.parseDouble(lines[i].substring(25,lastIndex));
            Ptime = (int)(Float.parseFloat(lines[i].substring(24,lines[i].length()-1))*1000);
            System.out.println(Ptime);
            hourTomillsec = Integer.parseInt(hour) * 3600 * 1000;
            minTomillsec = Integer.parseInt(min) * 60 * 1000;
            secTomillsec = Integer.parseInt(second) * 1000 + Integer.parseInt(millsec);
            start.add(hourTomillsec+minTomillsec+secTomillsec-Ptime+1);
            end.add(hourTomillsec+minTomillsec+secTomillsec);
        }
        for(int i=0; i<lines.length; i++){
            int finish = end.get(i) + 1000;
            int count = 0;
            for(int j=i; j<lines.length; j++){
                if(start.get(j) < finish)
                    count++;
            }
            if(answer<count)
                answer = count;
        }
        return answer;
    }
}