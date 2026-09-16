function solution(n, words) {
    var answer = [];

    let wordMap = new Map();
    let count = 0;
    let check = true;
    for(let i=0; i<words.length; i++){
        count++;
        let nowWord = words[i];
        if(wordMap.has(nowWord)){
            check = false;
            break;
        }else{
            if(i == 0){
                wordMap.set(nowWord, 1);
            }else{
                if(checkEndStart(words[i-1],nowWord)){
                  wordMap.set(nowWord, 1);  
                }else{
                    check = false;
                    break;
                }
            }
           
        }
    }
    
    if(check && count === words.length ){
        return [0,0];
    }else{
        let rest = count % n;
        let number = rest === 0 ? n : rest;
        let turn = Math.ceil(count/n);
        
        return [number, turn];
    }
}

// 끝말이 이어지는지 확인하는 메소드
function checkEndStart(before, now){
    if(before[before.length-1] === now[0]){
        return true;
    }else{
        return false;
    }
}