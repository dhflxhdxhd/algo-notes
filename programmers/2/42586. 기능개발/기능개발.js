function solution(progresses, speeds) {
    
    const days = [];
    progresses.forEach((value, index) => {
        let day = Math.ceil((100-value)/speeds[index]);
        days.push(day);
    })
    
    const answer = [];
    let count = 1;
    let lastDay = days[0];
    for(let i=1; i<days.length; i++){
        if(days[i] <= lastDay){
            count++;
        }else{
            answer.push(count);
            count = 1;
            lastDay = days[i];
        }
    }
    
    answer.push(count);

    
    return answer;
}