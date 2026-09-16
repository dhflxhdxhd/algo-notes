function solution(numbers) {
    let arr = numbers.split("")
    
    const primes = new Set();
    getPer('', numbers, primes);
    
    return primes.size;
}

function getPer(current, remain, primes){
    if(current.length > 0){
        const num = parseInt(current, 10);
        if(isPrime(num)){
            primes.add(num);
        }
    }
    
    for(let i = 0; i<remain.length; i++){
        getPer(current+remain[i] , remain.slice(0,i) + remain.slice(i+1)  , primes )
    }
}

function isPrime(number){
    if(number < 2) return false;
    
    for(let i = 2; i*i <= number; i++ ){
        if(number % i == 0){
            return false;
        }
    }
    
    return true;
}