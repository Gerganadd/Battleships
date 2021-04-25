package test;

import data_structures.LinkedList;

public class TestDataStructures 
{
	public static void main(String[] args)
	{
		LinkedList<Integer> a = new LinkedList();
		a.add(11);
		a.add(13);
		a.add(15);
		
		//System.out.println(a.contains(17));
		//a.delete(17);
		//System.out.println(a.getAtIndex(0));
		a.deleteAtIndex(0);
		a.print();
	}
}
