class MaxHeap {
    constructor() {
        this.heap = [];
    }

    insert(value) {
        this.heap.push(value);
        this.bubbleUp();
    }

    bubbleUp() {
        let index = this.heap.length - 1;
        const element = this.heap[index];

        while (index > 0) {
            let parentIndex = Math.floor((index - 1) / 2);
            let parent = this.heap[parentIndex];

            if (element <= parent) break; 
            this.heap[parentIndex] = element;
            this.heap[index] = parent;
            index = parentIndex;
        }
    }

    extractMax() {
        const max = this.heap[0];
        const end = this.heap.pop(); 
        if (this.heap.length > 0) {
            this.heap[0] = end;
            this.bubbleDown(); 
        }
        return max;
    }

    bubbleDown() {
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
                if (leftChild > element) {
                    swap = leftChildIndex;
                }
            }
            if (rightChildIndex < length) {
                rightChild = this.heap[rightChildIndex];
                if ((swap === null && rightChild > element) ||
                    (swap !== null && rightChild > leftChild)) {
                    swap = rightChildIndex;
                }
            }
            if (swap === null) break; 
            this.heap[index] = this.heap[swap];
            this.heap[swap] = element;
            index = swap;
        }
    }

    isEmpty() {
        return this.heap.length === 0;
    }
}

function solution(n, works) {
    works = works.filter(work => work > 0);

    const maxHeap = new MaxHeap();
    for (const work of works) {
        maxHeap.insert(work);
    }

    for (let i = 0; i < n; i++) {
        if (maxHeap.isEmpty()) break; 

        const maxWork = maxHeap.extractMax(); 
        if (maxWork > 1) {
            maxHeap.insert(maxWork - 1);
        }
    }

    let fatigue = 0;
    while (!maxHeap.isEmpty()) {
        const value = maxHeap.extractMax();
        fatigue += Math.pow(value, 2);
    }

    return fatigue;
}