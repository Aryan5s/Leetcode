class Solution {
    public int romanToInt(String s) {
        int[] nums = {1,5,10,50,100,500,1000};
        
        int res = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == 'I'){
                
                if(i != s.length()-1 && s.charAt(i+1) == 'V'){
                    res += nums[1]-nums[0];
                    i++;
                    
                }
                else if(i != s.length()-1 && s.charAt(i+1) == 'X'){
                    res += nums[2]-nums[0];
                    i++;
                    
                }else{
                    res += nums[0];
                }
                
            }else if(s.charAt(i) == 'V'){
                res += nums[1];
                
            }else if(s.charAt(i) == 'X'){
                
                if(i != s.length()-1 &&  s.charAt(i+1) == 'C'){
                    res += nums[4]-nums[2];
                    i++;
                    
                }else if(i != s.length()-1 &&  s.charAt(i+1) == 'L'){
                    res += nums[3]-nums[2];
                    i++;
                    
                }else{
                    res += nums[2];
                }
            }else if(s.charAt(i) == 'L' ){
                res += nums[3];
                
            }else if(s.charAt(i) == 'C'){
                
                if(i != s.length()-1 && s.charAt(i+1) == 'D'){
                    res += nums[5]-nums[4];
                    i++;
                }else if(i != s.length()-1 && s.charAt(i+1) == 'M'){
                    res += nums[6]-nums[4];
                    i++;
                    
                }else{
                    
                    res += nums[4];
                }
            }else if(s.charAt(i) == 'D'){
                res += nums[5];
            }else if(s.charAt(i) == 'M'){
                res += nums[6];
            }
        }
        return res;
    }
}