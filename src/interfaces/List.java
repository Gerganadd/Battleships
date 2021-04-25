package interfaces;

public interface List<T> 
{
	public void add(T element); 
	public T getAtIndex(int index); 
	public void delete(T element); 
	public void deleteAtIndex(int index); 
	public void clear(); 
	public boolean isEmpty();
	public int lenght();
	public boolean contains(T element); 
	
}
