/**
   A class of bags whose entries are stored in a chain of linked nodes.
	The bag is never full.
*/

public class LinkedBag<T> implements BagInterface<T>{



	private class Node 
	{
		private T    data; // Entry in bag
		private Node next; // Link to next node
	
		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
	} // end Node

	
	private Node firstNode;       // Reference to first node
	private int numberOfEntries;

	// Default constructor
	public LinkedBag() 
	{
		firstNode = null;
        numberOfEntries = 0;
		
	} // end default constructor
	
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		  return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode; 
        numberOfEntries++;
        return true;
	}

	@Override
	public T remove() {
		T result = null;
        if(numberOfEntries==0) {
        	return result;
        }
        	return result;
	}

 	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry)
	{
		Node currentNode; 
		
		for (currentNode = firstNode;currentNode != null; currentNode = currentNode.next)
		{
			if (anEntry==currentNode.data)
				return currentNode;
		} // end while
		return currentNode;
	} // end getReferenceTo

	@Override
	public boolean remove(T anEntry) {
		 boolean result = false;
	        Node nodeN = getReferenceTo(anEntry);
	        if (nodeN != null) {
	            nodeN.data = firstNode.data;
	             
	            firstNode = firstNode.next; 
	            numberOfEntries--;
	            result = true;
	        }
	        return result;
	}

	@Override
	public void clear() {
		while (!isEmpty()) {
            remove();
        }
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
        int x = 0;
        Node currentNode = firstNode;
        while ((x< numberOfEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                frequency++;
            }
            x++;
            currentNode = currentNode.next;
        } 
        return frequency;
	}

	@Override
	public boolean contains(T anEntry) {
		 boolean found = false;
	        Node currentNode = firstNode;
	        while (!found && (currentNode != null)) {
	            if (anEntry.equals(currentNode.data)) 
	                found = true;
	             else 
	                currentNode = currentNode.next;
	        } 
	        return found;
	}

	@Override
	public T[] toArray() {
		  T[] result = (T[]) new Object[numberOfEntries]; 
	        int index = 0;
	        Node currentNode = firstNode;
	        while ((index < numberOfEntries) && (currentNode != null)) {
	            result[index] = currentNode.data;
	            index++;
	            currentNode = currentNode.next;
	        } 
	        return result;
	}
	
}