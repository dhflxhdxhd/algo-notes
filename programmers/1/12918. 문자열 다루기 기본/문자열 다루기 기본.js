function solution(s) {
    var answer = false;
    
    // const regex = /^\d{4}$|^\d{6}$/;
    // const regex = /^(\d{4}|\d{6})$/;
    const regex = new RegExp("^(\\d{4}|\\d{6})$");    
    answer = regex.test(s);
    return answer;
}
