class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count =0;
        int a =0;
        int b =0;
        
        while(a!= g.length && b!=s.length){
            if(s[b] >= g[a]){
                count +=1;
                a++;
                b++;
            }else{
                b++;
            }
        }
        return count;
    }
}