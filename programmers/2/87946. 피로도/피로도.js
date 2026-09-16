function solution(k, dungeons) {
    let maxDungeon = 0;

    function backtrack(energy, visited, count) {
        maxDungeon = Math.max(maxDungeon, count);
        
        if(maxDungeon === dungeons.length){ // 던전이 가질 수 있는 최대 크기
            return maxDungeon;
        }

        for (let i = 0; i < dungeons.length; i++) {
            if (!visited[i] && energy >= dungeons[i][0]) {
                visited[i] = true;
                backtrack(energy - dungeons[i][1], visited, count + 1);
                visited[i] = false;
            }
        }
    }

    backtrack(k, Array(dungeons.length).fill(false), 0);
    return maxDungeon;
}


