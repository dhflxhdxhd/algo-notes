function solution(array, commands) {
    var answer = [];
    
    const len = commands.length;
    for(let temp=0; temp<len; temp++){
        let i = commands[temp][0];
        let j = commands[temp][1];
        let k = commands[temp][2];
        
        answer.push(array.slice(i-1,j).sort((a,b) => a-b )[k-1]);
    }
    
    return answer;
}