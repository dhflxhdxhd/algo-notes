function solution(genres, plays) {
    const genreMap = new Map();
    const songMap = new Map();

    genres.forEach((genre, index) => {
        const playCount = plays[index];
        
        genreMap.set(genre, (genreMap.get(genre) || 0) + playCount);
        
        if (!songMap.has(genre)) {
            songMap.set(genre, []);
        }
        songMap.get(genre).push({ id: index, plays: playCount });
    });

    const sortedGenres = [...genreMap.entries()].sort((a, b) => b[1] - a[1]);

    const result = [];

    sortedGenres.forEach(([genre]) => {
        const songs = songMap.get(genre);
        
        songs.sort((a, b) => {
            if (b.plays === a.plays) {
                return a.id - b.id; 
            }
            return b.plays - a.plays; 
        });

        for (let i = 0; i < Math.min(2, songs.length); i++) {
            result.push(songs[i].id);
        }
    });

    return result;
}