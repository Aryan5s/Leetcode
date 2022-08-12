class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        
        
        for(int index = 1; index <= n ; index ++){
              if(index % 3 == 0 && index % 5 == 0){
                  list.add("FizzBuzz");
              }else if (index % 3 == 0){
                  list.add("Fizz");
              }else if(index % 5 == 0){
                  list.add("Buzz");
              }else{
                  list.add( String.valueOf(index));
              }
        }
        
        return list;
    }
}