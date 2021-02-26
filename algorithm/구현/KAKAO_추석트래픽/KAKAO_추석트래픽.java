class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        for(int i=0; i<lines.length; i++){
            String hour, min, second, millsec;
            int hourTomillsec, minTomillsec, secTomillsec, Ptime;

            hour = lines[i].substring(11,13);
            min = lines[i].substring(14,16);
            second = lines[i].substring(17,19);
            millsec = lines[i].substring(20,23);
            int lastIndex = lines[i].length()-1;
            double pPtime = Double.parseDouble(lines[i].substring(25,lastIndex));
            System.out.println(pPtime);
        }
        return answer;
    }
}