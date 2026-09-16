function solution(phone_book) { 
    if(phone_book.length <= 1 ) return true;
    
    phone_book.sort();
    
    for(let i=0; i<phone_book.length -1; i++){
        let currentPhone = phone_book[i];
        let prefix = phone_book[i+1].slice(0,currentPhone.length);
        
        if(currentPhone === prefix) {
            return false;
        }
    }
    return true;
}