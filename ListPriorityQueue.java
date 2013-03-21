public class ListPriorityQueue {
  private int[] queue; 
  private int headIndex; 
  private int tailIndex; //Tail points to next empty
  
  public ListPriorityQueue(int initialSize) { 
    this.queue = new int[initialSize]; 
    this.headIndex = 0; 
    this.tailIndex = 0; 
  }
  
  public int removeSmallest() {
    
    if(headIndex != tailIndex) { 
      int r = queue[headIndex]; 
      queue[headIndex] = 0; 
      headIndex = nextIndex(headIndex);

      return r; 
    }

    return 0; 
  }
  
    public int insert(int elem) { 
      
    	if(headIndex == tailIndex) {
    		queue[headIndex] = elem; 
    		tailIndex = nextIndex(tailIndex);   		
    	} else { 
    		//find insert location
    		int i = headIndex; 
    		while(i != tailIndex) { 
    			if(queue[i] > elem)
    				break; 
    			i = nextIndex(i);
    		}
    		
    		//Shift and insert
    		int j = tailIndex; 
    		while(j != i) { 
    			queue[j] = queue[prevIndex(j)]; 
    			j = prevIndex(j); 
    		}
    		tailIndex = nextIndex(tailIndex); 
    		queue[i] = elem; //Set new element
    	}
    	
    	//If full, double array size. 
    	if(tailIndex == headIndex)
    		doubleArray();
        
    	return elem; 
    }
    
    private void doubleArray() { 
    	int[] newArray = new int[queue.length*2]; 
    	int i = 0; 
    	int j = headIndex; 
    	while(i < queue.length) { 
    		newArray[i] = queue[j]; 
    		j = nextIndex(j); 
    		i++; 
    	}
    	headIndex = 0; 
    	tailIndex = i; 
    	queue = newArray; 
    }
   
    private int nextIndex(int i) {   
    	return (i + 1) % queue.length; 
    }
    
    private int prevIndex(int i) { 
     	if(i-- == -1)
    		return queue.length - 1; 
    	return i; 
    }
    
    public void print() { 
    	for(int i : queue) { 
    		System.out.println(i);
    	}
    	System.out.println("\n");
    }
}
