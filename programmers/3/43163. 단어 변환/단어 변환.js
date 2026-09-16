function solution(begin, target, words) {
    var answer = 0;
    
    function getMinRoute(){
        let queue = [[begin,0]];
        let visited = new Set([begin]);
    
        while(queue.length > 0){
            let [currentWord, currentCount] = queue.shift();
            
            if(currentWord === target){
                return currentCount;    
            }
            
            for(let nextWord of words){
                // 사용한 적이 없으면 
                if(!visited.has(nextWord)){
                    let diffCount = 0;
                    for(let i=0; i<nextWord.length; i++){
                        if(nextWord[i] !== currentWord[i]){
                            diffCount++;
                        }
                    }
                    
                    if(diffCount === 1){
                        queue.push([nextWord, currentCount+1]);
                        visited.add(nextWord);
                    }
                }
            }
        }
        return 0;
    }
    
    answer = getMinRoute();
    return answer;
}