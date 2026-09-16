class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
       
        makeNumbers(numbers, target, 0,0);
        
        return count;
    }
    
    private static void makeNumbers(
        int[] numbers, int target, int idx, int result){
        if(idx == numbers.length){
            if(result == target){
                count++;
            }
            return;
        }
        
        makeNumbers(numbers, target,  idx + 1, result + numbers[idx]);
        makeNumbers(numbers, target,  idx + 1, result - numbers[idx]);
        
    }
}