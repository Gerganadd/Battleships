package data_structures;

import interfaces.List;

public class LinkedList<T extends Comparable<T>> implements List
{
	Node<T> list;

	@Override
	public void add(Object element) 
	{
		if (isEmpty())
		{
			this.list = new Node<T>((T)element);
		}
		else
		{
			Node<T> current = this.list;
			
			while(current.next != null)
			{
				current = current.next;
			}
			
			current.next = new Node<T>((T)element);
		}
	}

	@Override
	public Object getAtIndex(int index) 
	{
		// indexing starts at 0
		checkIndex(index);
		
		Node<T> current = list;
		
		for(int i = 0; i < index; i++)
		{
			current = current.next;
		}
		
		return current.data;
	}

	@Override
	public void delete(Object element) 
	{
		Node<T> current = list;
		
		while(current != null && current.next != null)
		{
			//checks if first element is wanted
			if (current.data.compareTo((T)element) == 0) 
			{
				list = list.next;
				break;
			}
			
			//checks if next Node.data is wanted
			if (current.next.data.compareTo((T)element) == 0) 
			{
				current.next = current.next.next; 
				break;
			}
			
			current = current.next;
		}
	}

	@Override
	public void deleteAtIndex(int index) 
	{
		// indexing starts at 0
		checkIndex(index);
		
		Node<T> previous = list;
		
		for(int i = 0; i < index - 1; i++)
		{
			previous = previous.next;
		}
		
		if (index == 0)
		{
			list = list.next;
			return;
		}
		
		previous.next = previous.next.next;
	}

	@Override
	public void clear() 
	{
		this.list = null;
	}

	@Override
	public boolean isEmpty() 
	{
		return list == null;
	}

	@Override
	public int lenght()
	{
		Node<T> current = this.list;
		int counter = 0;
		
		while(current != null)
		{
			counter++;
			current = current.next;
		}
		
		return counter;
	}

	@Override
	public boolean contains(Object element) 
	{
		Node<T> current = this.list;
		
		while(current != null)
		{
			if (current.data.compareTo((T)element) == 0)
			{
				return true;
			}
			
			current = current.next;
		}
		
		return false;
	}
	
	public void print()
	{
		Node<T> current = list;
		
		while(current != null)
		{
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	private void checkIndex(int index)
	{
		// indexing starts at 0
		int lenght = lenght();
		
		if (index >= lenght) 
		{
			throw new IllegalArgumentException("Index must be less than the lenght of list!");
		}
		
		if (index < 0)
		{
			throw new IllegalArgumentException("Index must be greater than 0!");
		}
		
	}

}
