function solution(answers) {
    var answer = [];
    
    let p1 = [1,2,3,4,5];
    let p2 = [2, 1, 2, 3, 2, 4, 2, 5];
    let p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
    let count = [0,0,0];
    
    
    for(let i=0; i<answers.length; i++){
        if(p1[i%5] === answers[i]){
            count[0] += 1;
        }
        
        if(p2[i%8] === answers[i]){
           count[1] += 1;
        } 
        
        if(p3[i%10] === answers[i]){
           count[2] += 1;
        }
    }
    
    const maxValue = Math.max(...count);
    
    answer = count
        .map((value, index) => value === maxValue ? index +1 : -1)
        .filter( value => value !== -1); 
    
    answer.sort((a,b) => a-b);
  
  
    
    return answer;
}