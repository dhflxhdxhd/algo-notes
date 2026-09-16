function solution(n) {
    var memo = Array(n + 1).fill(-1); 
    
    function getRoutes(now) {
        if (now === n) return 1;
        if (now > n) return 0;
        if (memo[now] !== -1) return memo[now]; 
        
        memo[now] = (getRoutes(now + 1) + getRoutes(now + 2)) % 1234567;
        return memo[now];
    }
    
    return getRoutes(0);
}