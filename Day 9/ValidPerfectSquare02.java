class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1) {
            return true;
        }
        boolean result = false;
        long ll = 1;
        long ul = num/2;
        
        while(ll <= ul) {
            long mid = ll + ((ul - ll) / 2);
            long res = mid * mid;
            if(res == num) {
                result = true;
                break;
            } 
            
            if(ll == ul) {
                break;
            }
            
            if(res > num) {
                ul = mid-1;
            }
            
            if(res < num) {
                ll = mid + 1;
            }
        }
        return result;
    }
}