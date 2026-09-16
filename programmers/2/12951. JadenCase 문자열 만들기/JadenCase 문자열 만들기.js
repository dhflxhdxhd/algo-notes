function solution(s) {

    let temp = s.split(" ");
    
    let result = temp.map((value) => value.charAt(0).toUpperCase() + value.slice(1).toLowerCase());
    
    
    return result.join(" ");
}