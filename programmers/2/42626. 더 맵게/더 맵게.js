// class PriorityQueue{
//     constructor(){
//         this.queue = [];
//     }
    
//     enqueue(value){
//         this.queue.push(value);
//         this.queue.sort((a,b) => a-b);
//     }
    
//     dequeue(){
//         return this.queue.shift();
//     }
    
//     isEmpty(){
//         return this.queue.length === 0;
//     }
// }

class PriorityQueue{
    constructor(){
        this.heap = [];
    }
    
    enqueue(value){
        this.heap.push(value);
        this.bubbleUp();
    }
    
    dequeue(){
        if (this.isEmpty()) return null;

        const min = this.heap[0];
        const end = this.heap.pop();
        
        if (this.heap.length > 0) {
            this.heap[0] = end;
            this.bubbleDown();
        }

        return min;
    }
    
    isEmpty(){
        return this.heap.length === 0;    
    }
    
    bubbleUp(){
        let index = this.heap.length - 1;
        const element = this.heap[index];
        
        while (index > 0) {
            let parentIndex = Math.floor((index - 1) / 2);
            let parent = this.heap[parentIndex];

            if (element >= parent) break;

            this.heap[index] = parent;
            index = parentIndex;
        }

        this.heap[index] = element;
    }
    
    bubbleDown(){
        let index = 0;
        const length = this.heap.length;
        const element = this.heap[0];

        while (true) {
            let leftChildIndex = 2 * index + 1;
            let rightChildIndex = 2 * index + 2;
            let leftChild, rightChild;
            let swap = null;

            if (leftChildIndex < length) {
                leftChild = this.heap[leftChildIndex];
                if (leftChild < element) swap = leftChildIndex;
            }

            if (rightChildIndex < length) {
                rightChild = this.heap[rightChildIndex];
                if ((swap === null && rightChild < element) || 
                    (swap !== null && rightChild < leftChild)) {
                    swap = rightChildIndex;
                }
            }

            if (swap === null) break;

            this.heap[index] = this.heap[swap];
            index = swap;
        }

        this.heap[index] = element;
    }
}


function solution(scoville, K) {
    let answer = new PriorityQueue();
    
    for(let s of scoville){
        answer.enqueue(s);
    }
    
    let count = 0;
    while(answer.heap[0] < K){
        if (answer.heap.length === 1) return -1;
        let first = answer.dequeue();
        let second = answer.dequeue();
        
        answer.enqueue(mixFood(first, second));
        count++;
    }
    
    return count;
}

function mixFood(first, second){
    return first + second*2;
}