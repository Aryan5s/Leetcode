class Solution {
    public int subarraySum(int[] nums, int k) {
       HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0,c=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            int req=sum-k; //This is important please note and do not use Math.abs as it'll alter the solution
            if(map.containsKey(req))
                c+=map.get(req);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return c;
    }
}