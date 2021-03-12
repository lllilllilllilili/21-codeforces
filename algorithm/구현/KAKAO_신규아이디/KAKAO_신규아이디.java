class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();

        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        String second_new_id = "";
        for(int i=0; i<new_id.length(); i++){
            if(Character.isLetterOrDigit(new_id.charAt(i)) || new_id.charAt(i)=='-'
                    || new_id.charAt(i)=='_' || new_id.charAt(i)=='.'
            ) second_new_id += new_id.charAt(i);
        }
        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        boolean find = false;
        String third_new_id = "";
        for(int i=0; i<second_new_id.length(); i++){
            if(find == false && second_new_id.charAt(i)=='.'){
                third_new_id += second_new_id.charAt(i);
                find = true;
            }else if(find == true && second_new_id.charAt(i)=='.'){
                continue;
            }else{
                find = false;
                third_new_id += second_new_id.charAt(i);
            }
        }//end of for loop

        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        String forth_new_id = "";
        for(int i=0; i<third_new_id.length(); i++){
            if(i==0 && third_new_id.charAt(i)=='.') continue;
            if(i==third_new_id.length()-1 && third_new_id.charAt(i)=='.') continue;
            forth_new_id += third_new_id.charAt(i);
        }
        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(forth_new_id.length() == 0) forth_new_id += "a";

        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        String six_new_id = "";
        if(forth_new_id.length() >= 16){
            int cnt = 0;
            for(int i=0; ; ){
                if(cnt>=15) break;
                if(cnt==14 && forth_new_id.charAt(cnt) == '.') break;
                six_new_id += forth_new_id.charAt(cnt);
                cnt+=1;
            }
        }//end of if
        else{
            six_new_id = forth_new_id;
        }
        //System.out.println(six_new_id);
        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(six_new_id.length()<=2){
            char lastLetter = six_new_id.charAt(six_new_id.length()-1);
            for(int i=0; ; ){
                if(six_new_id.length()>2) break;
                six_new_id+=lastLetter;
            }
        }
        System.out.println(six_new_id);
        return six_new_id;
    }
}