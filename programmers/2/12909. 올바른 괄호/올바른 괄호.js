function solution(s){
    
    let stack = [];
    for(let word of s){
        if(word === "("){
            stack.push(word);
        }else if(word === ")"){
            if(stack[stack.length-1] == "("){
                stack.pop();
            }else{
                return false;
            }
        }
    }
    
    return stack.length === 0;
}