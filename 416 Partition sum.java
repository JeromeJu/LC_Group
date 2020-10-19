
class Solution {
     // dp[n] == true <=> dp[n - nums[0]] == true
     public boolean canPartition(int[] nums) {
          int sum = 0;
          for (int num : nums) {
               sum += num;
          }
          if (sum % 2 != 0) return false;
          sum /= 2;
          boolean[] dp = new boolean[sum + 1];
          dp[0] = true; // dp[i], sum= i
          for (int num : nums) {
               for (int j = sum; j >= 0; j--) {
                    if (j >= num) {
                         // dp[j]: not taken
                         // dp[j-sum]: taken
                         dp[j] = dp[j] || dp[j - num];
                    }
               }
          }
          return dp[sum];
     }
}