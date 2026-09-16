function solution(prices) {
    var answer = [];
    
    for(let i = 0; i<prices.length -1; i++){
        let count = 0;
        let check = false;
        for(let j = i+1; j<prices.length; j++){
            if(prices[i] > prices[j]){
                check = true;
                break;
            }else{
                count++;
            }
        }
        
        if(check){
            answer.push(++count);
        }else{
            answer.push(count);
        }
    }
    
    answer.push(0);
    return answer;
}