function solution(tickets) {
    var answer = [];
    
    let sortedTickets = tickets.sort((a, b) => {
        if (a[0] === b[0]) {
            return a[1].localeCompare(b[1]); 
        }
        return a[0].localeCompare(b[0]);
    });
    
    function getRoute(start) {
    let queue = [[start, [start], Array(sortedTickets.length).fill(false)]]; 
     
    while (queue.length > 0) {
        let [city, route, used] = queue.shift();

        if (used.every(ticket => ticket)) {
            return route;
        }

        for (let i = 0; i < sortedTickets.length; i++) {
            let nextTicket = sortedTickets[i];
            if (city === nextTicket[0] && !used[i]) {
                let nextRoute = [...route, nextTicket[1]];
                let newUsed = [...used]; 
                newUsed[i] = true; 
                queue.push([nextTicket[1], nextRoute, newUsed]); 
            }
        }
    }
}
    
//     function getRoute(start){
//         let queue = [[start, [start]]];
//         let used = Array.from({length : sortedTickets.length} ,() => false);
        
//         while(queue.length > 0 ){
//             let [city, route] = queue.shift();
            
//             if(route.length === used.length + 1){
//                 return route
//             }
            
//             for(let i=0; i<used.length; i++){
//                 let nextTicket = sortedTickets[i];
//                 if(city === nextTicket[0] && !used[i]){
//                     let nextRoute = [...route, nextTicket[1]];
//                     queue.push([nextTicket[1], nextRoute]);
//                     used[i] = true;
//                 }                
//             }
//         }
//     }
    
    answer = getRoute("ICN");
    
    
    return answer;
}