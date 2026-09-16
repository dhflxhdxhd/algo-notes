function solution(s)
{

    let stack = [];
    stack.push(s[0]);
    for(let i=1; i<s.length; i++){
        let current = s[i];
        if(stack[stack.length -1] === current){
            stack.pop();
        }else{
            stack.push(current);
        }
    }
    
    if(stack.length > 0){
        return 0;
    }else{
        return 1;
    }
}