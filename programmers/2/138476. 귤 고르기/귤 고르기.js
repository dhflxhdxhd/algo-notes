function solution(k, tangerine) {
    var answer = 0;

    let map = new Map();
    for(let t of tangerine){
        map.set(t, (map.get(t) || 0) + 1);
    }
    
    let sortedEntries = [...map.entries()].sort((a,b) => b[1] - a[1]);
    
    let count = 0;
    for(let i=0; i < sortedEntries.length; i++){
        k -= sortedEntries[i][1];
        count++;
        
        if(k <= 0){
            answer = count;
            break;
        }
    }
    
    return answer;
}