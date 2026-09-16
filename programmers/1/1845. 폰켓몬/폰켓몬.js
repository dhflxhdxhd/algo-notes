function solution(nums) {
    var answer = 0;
    
    if(nums.length <= 2) return nums.length / 2;
    
    const allowSize = nums.length /2; // 가져갈 수 있는 폰켓몬 수
    const map = new Map();
    for(let number of nums){
        if(map.has(number)){
            map.set(number, map.get(number) + 1);
        }else{
            map.set(number, 1);
        }
    }

    answer = Math.min(map.size, allowSize)
    
    return answer;
}