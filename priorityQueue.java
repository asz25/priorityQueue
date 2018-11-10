/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_csc311;

/**
 *  IMPLEMENTATION OF PRIORITY QUEUE WAS OBTAINED FROM HERE: https://www.sanfoundry.com/java-program-priority-queue/
 * @author awdsa
 */
public class priorityQueue {
   
    private Patient[] heap; 
    private int heapSize, capacity;
 
    /** Constructor
     * @param capacity **/
    public priorityQueue(int capacity)
    {    
        this.capacity = capacity + 1;
        heap = new Patient[this.capacity];
        heapSize = 0;
    }
    /** function to clear **/
    public void clear()
    {
        heap = new Patient[capacity];
        heapSize = 0;
    }
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
    /** function to check if full **/
    public boolean isFull()
    {
        return heapSize == capacity - 1;
    }
    /** function to get Size **/
    public int size()
    {
        return heapSize;
    }
    /** function to insert task **/
    public void insert(Patient newJob)
    {
        heap[++heapSize] = newJob;
        int pos = heapSize;
        while (pos != 1 && newJob.getUrg() < heap[pos/2].getUrg())
        {
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = newJob;    
    }
    /** function to remove task **/
    public Patient remove()
    {
        int parent, child;
        Patient item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }
 
        item = heap[1];
        temp = heap[heapSize--];
 
        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && heap[child].getUrg() > heap[child + 1].getUrg())
                child++;
            if (temp.getUrg() <= heap[child].getUrg())
                break;
 
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
 
        return item;
    }
    
    public Patient peek()
    {
        return heap[1];
    }
    
    public static void main(String args[])
    {
        Patient test1 = new Patient("Patient 1","6/6/7","Small cut",20,30,2);
        Patient test2 = new Patient("Patient 2","1/2/96","Big slash",36,6);
        Patient test3 = new Patient("Patient 3","2/26/96","Heart attack",55,1);
        Patient test4 = new Patient("Patient 4","11/2/80","Asphyxiation",10,95);
        Patient test5 = new Patient("Patient 5","5/2/11","Liver problems",48,1);
        
        priorityQueue heap =new priorityQueue(25);
        heap.insert(test1);
        heap.insert(test2);
        System.out.println("WE ARE PEEKING:" +heap.peek());
        heap.insert(test3);
        heap.insert(test4);
        heap.insert(test5);
        System.out.println("WE ARE PEEKING:" +heap.peek());
        
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        
    }
}

