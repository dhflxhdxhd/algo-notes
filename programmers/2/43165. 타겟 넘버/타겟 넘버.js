function solution(numbers, target) {
    var answer = 0;
    
    function makeTarget(numbers, target, idx, result){
        if(idx === numbers.length){
            if(result === target) answer++;
            return;
        }
        
        makeTarget(numbers, target, idx+1, result+numbers[idx]);
        makeTarget(numbers, target, idx+1, result-numbers[idx]);
    }   
    
    makeTarget(numbers, target, 0, 0);

    
    return answer;
}


