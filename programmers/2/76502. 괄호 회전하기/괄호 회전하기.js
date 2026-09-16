function solution(s) {
    
    let stack = [];
    for(let word of s){
        stack.push(word);
    }
    
    let count = 0;
    for(let i=0; i<s.length; i++){
        if(i != 0) {
            stack.push(stack.shift());
        }
        // console.log(stack);
        if(isRightWord(stack) ){
            // console.log(isRightWord(stack));
            count++;
        }
    }
    
    function isRightWord(stack){
        let words = [];
        let check = true;
        for(let s of stack){
            if(s === "[" || s === "(" || s === "{"){
                words.push(s);
            }else{
                if(words.length > 0){
                    if(s === "]" && words[words.length - 1] === "["){
                        words.pop();
                    }else if(s === ")" && words[words.length - 1] === "("){
                        words.pop();
                    }else if(s === "}" &&  words[words.length - 1] === "{"){
                        words.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        
        if(words.length > 0){
            return false;
        }
        
        return true;
    }
    
    return count;
}