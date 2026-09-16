function solution(word) {
    var answer = 0;
    
    let count = 0;
    let alpha = ['A', 'E', 'I', 'O', 'U'];
    function getWord(result){        
        if(result.join('') === word){
           answer = count;
            return;
        }
        
        if(result.length === 5){
            return;
        }
        
        for(let a  of alpha){
            count++;
            result.push(a);
            getWord(result);
            result.pop(a);
        }
        
        return;
    }
    
    getWord([]);

    return answer;
}