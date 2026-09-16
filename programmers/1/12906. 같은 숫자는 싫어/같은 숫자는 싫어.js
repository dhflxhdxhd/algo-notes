function solution(arr)
{
    return arr.filter((value, index) => value != arr[index + 1]);
//     var answer = [];
    
//     let temp = arr[0];
//     answer.push(temp);
//     for (let i = 1; i < arr.length; i++) {
//         if (temp != arr[i]) {
//             temp = arr[i];
//             answer.push(temp);
//         }
//     }
//     return answer;
}