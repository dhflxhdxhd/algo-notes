function solution(elements) {
    var answer = 0;
    
    let numbers = new Set();
    let temp = Array(elements.length).fill(0);
    const len = elements.length;
    
    function getSums(){
        let count = 0;
        while(count < len){
            for(let i=0; i<len; i++){
                let idx = i + count;
                if(idx >= len){
                    idx %= len;
                }
                temp[i] += elements[idx];
                numbers.add(temp[i]);
            }
            count++;
        }
    }
    
    getSums();
    answer = numbers.size;
    
    return answer;
}