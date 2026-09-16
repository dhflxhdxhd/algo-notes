function solution(clothes) {
    var answer = 1;
    const types = new Map();
    clothes.forEach(([name, type]) => {
        types.set(type, (types.get(type) || 0) +1 );
    })
    
//     for(let c of clothes){
//         let name = c[0];
//         let type = c[1];
        
//         if(types.has(type)){
//             types.set(type, types.get(type) + 1);
//         }else{
//             types.set(type, 1);
//         }
//     }
    
    for(let count of types.values()){
        answer *= (count+1);
    }
    
    // const valuesArray = [...types.values()]
    // for(let i=0; i<types.size; i++){
    //     answer *= valuesArray[i] + 1;
    // }

    return answer -1;
}