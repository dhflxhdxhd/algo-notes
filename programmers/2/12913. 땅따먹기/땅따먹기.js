// function solution(land) {
//     var answer = 0;

//     const n = land.length;
//     const m = land[0].length;
    
//     let maxNum = 0;
//     function getScore(row, col, result){
//         if(row === n){
//             maxNum = Math.max(maxNum, result);
//             return;
//         }
        
//         for(let i=0; i<m; i++){
//             if(col !== i) {
//                 getScore(row+1, i, result + land[row][i])
//             };
//         }
//     }
    
//     getScore(0,0,0);
//     answer = maxNum;
//     return answer;
// }


function solution(land){
    var answer = 0;

    const row = land.length;
    for(let i=1; i<row; i++){
        land[i][0] += Math.max(land[i-1][1],land[i-1][2],land[i-1][3]);
        land[i][1] += Math.max(land[i-1][0],land[i-1][2],land[i-1][3]);
        land[i][2] += Math.max(land[i-1][0],land[i-1][1],land[i-1][3]);
        land[i][3] += Math.max(land[i-1][0],land[i-1][1],land[i-1][2]);
    }
    
    answer = Math.max(land[row-1][0],land[row-1][1],land[row-1][2],land[row-1][3])
    return answer;
}