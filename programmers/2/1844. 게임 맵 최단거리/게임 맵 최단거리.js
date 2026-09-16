function solution(maps) {
    var answer = 0;
    
    const n = maps.length;
    const m = maps[0].length;
    
    function isInArea(row, col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
    
    const dr = [0,0,1,-1];
    const dc = [1,-1,0,0];
    function getMinRoute(row, col){
        let queue = [[row,col,1]];
        let visited = new Set();

        visited.add(`${row},${col}`);
        
        while(queue.length > 0){
            let currentCell = queue.shift();

            if(currentCell[0] == (n-1) && currentCell[1] == (m-1) ){
                return currentCell[2];
            }
            
            for(let d = 0; d <4; d++){
                let nextRow = currentCell[0] + dr[d];
                let nextCol = currentCell[1] + dc[d];
                
                if(isInArea(nextRow, nextCol) && maps[nextRow][nextCol] === 1){
                   if(!visited.has(`${nextRow},${nextCol}`)){
                    visited.add(`${nextRow},${nextCol}`);
                    queue.push([nextRow, nextCol, currentCell[2] + 1]);
                    }
                }
            }
        }
        
        return -1;
    }

    
    answer = getMinRoute(0,0);
    

    
    return answer;
}


