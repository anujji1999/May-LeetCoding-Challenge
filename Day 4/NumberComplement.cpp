class Solution
{
public:
  int findComplement(int num)
  {
    if (num == 1)
      return 0;
    int ans = 0, p = 0;
    while (num)
    {
      if (!(num & 1))
        ans = ans | (1 << p);

      p++;
      num = num >> 1;
    }
    return ans;
  }
};