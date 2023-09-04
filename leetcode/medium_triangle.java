class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] accSum = new int[triangle.size() + 1];
        
        for(int i = triangle.size() - 1; i >= 0; i--){
            List<Integer> list = triangle.get(i);
            for(int j = 0; j < list.size(); j++){
                int min = Math.min(accSum[j], accSum[j + 1]);
                accSum[j] = list.get(j) + min;
            }
        }

        return accSum[0];
    }
}