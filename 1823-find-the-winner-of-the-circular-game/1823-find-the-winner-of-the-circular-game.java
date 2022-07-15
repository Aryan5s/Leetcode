
class Solution {
    public int findTheWinner(int n, int k) {
     Queue<Integer> queue = new LinkedList<>();
        for(int i =1; i<=n; i++){
            queue.offer(i);
        }
        
        while(queue.size() != 1){
            for(int j =0; j<k-1; j++){
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        
        return queue.poll();
    }
}