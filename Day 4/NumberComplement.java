class Solution {
    public int findComplement(int num) {
        if (num == 1)
            return 0;
        int ans = 0, p = 0;
        while (num > 0) {
            if ((num & 1) == 0)
                ans = ans | (1 << p);

            p++;
            num = num >> 1;
        }
        return ans;
    }
}