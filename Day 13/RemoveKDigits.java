import java.util.LinkedList;

class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> st = new LinkedList<>();
        StringBuffer ans = new StringBuffer();

        for(int i=0; i<num.length(); i++){
            while(st.size() != 0 && k != 0 && st.getFirst() > num.charAt(i)){
                st.removeFirst();
                k--;
            }
            if(st.size() != 0 || num.charAt(i) != '0'){
                st.addFirst(num.charAt(i));
            }
        }
        while(st.size() != 0 && k != 0){
            st.removeFirst();
            k--;
        }

        if(st.size() == 0){
            return "0";
        }

        while(st.size() != 0){
            ans.append(st.getFirst());
            st.removeFirst();
        }
        ans.reverse();

        return ans.toString();
    }
}