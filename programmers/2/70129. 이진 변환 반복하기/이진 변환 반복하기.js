
let count = 0;
function solution(s) {
    let turn = 0;
    let current = s;  
    while(current !== "1"){
        current = removeZero(current); 
        current = convertToBinary(current.length);
                
        turn++;
    }
    
    return [turn, count];
}

function convertToBinary(length){
    return length.toString(2);
}

function removeZero(s) {
    const filtered = s.split('').filter(value => value === '1');
    count += s.length - filtered.length;
    return filtered.join('');
}

// function removeZero(s){
//     let newStr= "";

//     s.split('').forEach((value) => {
//         if(value === "1"){
//             newStr += value;
//         }else{
//             count++;
//         }
//     })
    
//     return newStr;
// }