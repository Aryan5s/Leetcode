/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer, HashMap<Integer, List<Integer>>> map = new HashMap<Integer, HashMap<Integer, List<Integer>>>();
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        recurse(root, 0, 0);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //sort map keys
        List<Integer> mapKeys = new ArrayList<Integer>();
        for(Integer key: map.keySet())
            mapKeys.add(key);
        Collections.sort(mapKeys);
        
        for(Integer key: mapKeys){
            HashMap<Integer, List<Integer>> innerMap = map.get(key);
            
            //sort inner map keys by height
            List<Integer> innerMapKeys = new ArrayList<Integer>();
            for(Integer innerKeys: innerMap.keySet())
                innerMapKeys.add(innerKeys);
            Collections.sort(innerMapKeys);
            
            List<Integer> currentList = new ArrayList<Integer>();
            for(Integer innerKey: innerMapKeys){
                
                //sort inner nodes by value
                List<Integer> resultRow = innerMap.get(innerKey);
                Collections.sort(resultRow);
                
                for(Integer res: resultRow)
                    currentList.add(res);
            } 
            result.add(currentList);
        }
        
        return result;
    }
    
    public void recurse(TreeNode node, int row, int col){
        if(node == null)
            return;
        
        if(map.containsKey(col)){
            HashMap<Integer, List<Integer>> innerMap = map.get(col);
            if(innerMap.containsKey(row)){
                List<Integer> list = innerMap.get(row);
                list.add(node.val);
                Collections.sort(list);
                innerMap.put(row, list);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(node.val);
                innerMap.put(row, list);
            }
            
            map.put(col, innerMap);
        }else{
            HashMap<Integer, List<Integer>> innerMap = new HashMap<Integer, List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            innerMap.put(row, list);
            map.put(col, innerMap);
        }
        
        recurse(node.left, row + 1, col - 1);
        recurse(node.right, row + 1, col + 1);
    }
}