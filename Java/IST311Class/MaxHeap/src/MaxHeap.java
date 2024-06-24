import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {
    ArrayList<T> maxHeap;

    int heapSize;

    public MaxHeap() {
        this.maxHeap = new ArrayList<>();
        this.heapSize = 0;
    }//end public MaxHeap

    public void insert(T data) {
        this.maxHeap.add(data);
        this.heapSize++;
        heapifyUp(this.heapSize-1);
    }

    public void heapifyUp(int index){
        if(index ==0){
            return;
        }
        int parentIndex = (int) Math.floor((index-1)/2.0);
        if(this.maxHeap.get(index).compareTo(this.maxHeap.get(parentIndex))>0){
            T parentValue = this.maxHeap.get(parentIndex);
            this.maxHeap.set(parentIndex,this.maxHeap.get(index));
            this.maxHeap.set(index,parentValue);
            heapifyUp(parentIndex);
        }else{
            return;
        }
    }

    public void heapifyDown(int index){
        int leftIndex = 2* index + 1;
        int rightIndex = 2 * index + 2;

        int maxIndex = index;

        if(leftIndex < this.heapSize && this.maxHeap.get(leftIndex).compareTo(this.maxHeap.get(maxIndex))>0){
            maxIndex = leftIndex;
        }

        if(rightIndex < this.heapSize && this.maxHeap.get(rightIndex).compareTo(this.maxHeap.get(maxIndex))>0){
            maxIndex = rightIndex;
        }

        if(maxIndex != index){
            T temp = this.maxHeap.get(index);
            this.maxHeap.set(index, this.maxHeap.get(maxIndex));
            this.maxHeap.set(maxIndex, temp);

            this.heapifyDown(maxIndex);
        }
    }//end method

    public T extract() {
        if(this.heapSize>0) {
            T extractVal = this.maxHeap.get(0);
            this.maxHeap.set(0, this.maxHeap.get(this.heapSize - 1));
            this.maxHeap.remove(this.heapSize - 1);
            this.heapSize--;
            if(heapSize>1) {
                heapifyDown(0);
            }
            return extractVal;
        }else{
            return null;
        }
    }

    public T[] sort(T[] myArray){
        //Turn Heap into a Max Heap
        for(T i: myArray){
            this.insert(i);//O(log n)
        }// O(n logn) Insert Array Values into heap

        for(int i=myArray.length-1;i>=0;i--){
            T root = this.extract(); // O(log n)
            myArray[i] = root;
        } // O(n logn)

        return myArray;


    }//end sort method

}//end public class