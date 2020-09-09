package online;

public class MaxHeap {

	public static void main(String[] args) {
		MaxHeap maxHeap =new MaxHeap(15);
		maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9); 
        System.out.println("Max heap is :");
        maxHeap.print();
        int t=maxHeap.remove();
       System.out.println("deleted element is "+t);
        System.out.println("after deletion heap is ");
        maxHeap.print();

	}
	
private int[] heap;
private int maxsize;
private int size;

public MaxHeap(int maxsize)
{
	this.maxsize=maxsize;
	heap=new int[this.maxsize+1];
	size=0;
	heap[0]=Integer.MAX_VALUE;
}
public int front=1;
public int parent(int pos)
{
	return (pos/2);
}

public void swap(int cpos,int ppos)
{
	int temp=0;
	temp=heap[cpos];
	heap[cpos]=heap[ppos];
	heap[ppos]=temp;
}
public void insert(int element)
{
	heap[++size]=element;
	int current=size;
	
	while(heap[current]>heap[parent(current)])
	{
		swap(current,parent(current));
		current=parent(current);
	}
	
}

public void print() {
for(int i=1;i<=(size/2);i++)
{
	System.out.println("root is "+heap[i]+", left child is "+heap[2*i]+", right child is "+heap[2*i+1]);
	
}
}

//deletion in heap

public int left(int pos)
{
	return 2*pos;
}
public int right(int pos)
{
	return (2*pos)+1;
}
public boolean isleaf(int pos)
{
	if(pos>=(size/2) && pos<=size)
	{
		return true;
	}
	else
	{
		return false;
	}
}

public void heapify(int pos)
{
	if(!isleaf(pos))
	{
		if(heap[pos]<heap[left(pos)] || heap[pos]<heap[right(pos)])
		{
			if(heap[left(pos)]>heap[right(pos)])
			{
				swap(pos,left(pos));
				heapify(left(pos));
			}
			else
			{
				swap(pos,right(pos));
				heapify(right(pos));
			}
		}
	}
}

public int remove()
{
	int t=heap[front];
	heap[front]=heap[size];
	size=size-1;
	heapify(1);
	return t;
}
}
