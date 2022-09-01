class Solution {
    public int mirrorReflection(int p, int q) {
        int h=p;
        while((p%h>0)||(q%h>0))
        {
            if(p%h>0) h=p%h;
            if(q%h>0) h=q%h;
        }
        p/=h;q/=h;
        return ((p+q)%2==0)?1:((p%2==0)?2:0);
    }
}