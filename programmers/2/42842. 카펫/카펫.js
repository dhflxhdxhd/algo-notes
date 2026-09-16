function solution(brown, yellow) {
    var answer = [];
    
    const total = brown + yellow;
    
    for(let width=3; width<= total; width++){
        if(total % width === 0){
            let height = total / width;
            
            if(2*(width + height) - 4 === brown){
                answer.push(width);
                answer.push(height);
                break;
            }
        }
    }
    
    answer.sort((a,b) => b-a);
    return answer;
}