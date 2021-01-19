package leetcode;

public class Valid_Parentheses {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> st = new Stack<>();
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');
        
        char[] cstr = s.toCharArray();
        for(int i=0; i<cstr.length; i++){
            if(!hm.containsKey(cstr[i]))
                st.add(cstr[i]);
            else if(st.isEmpty() || hm.get(cstr[i])!=st.pop()){
                return false;        
            }
        }
        
        return st.size()==0;
	}
}
