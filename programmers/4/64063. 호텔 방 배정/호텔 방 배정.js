function solution(k, room_number) {
    var answer = [];
    let hotel = new Map();
    for(let i=0; i< room_number.length; i++){
        let room = getRoomNumber(room_number[i]);
        answer.push(room);
    }
    
    function getRoomNumber(room){
       if(!hotel.has(room)){
          hotel.set(room, room+1);
          return room;
       }else{
          
           let another = getRoomNumber(hotel.get(room));
           hotel.set(room, another+1);
           return another;
       }
    }
    
    return answer;
}