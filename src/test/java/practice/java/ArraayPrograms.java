package practice.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class ArraayPrograms {
	@Test
	public void firstMaximumProg() {
		int arr[]= {7,4,2,9,6};
		int max= 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
			
		}
		System.out.println(max);
	}
	
	@Test
	public void thirdMaximumAnotherApporch() {
		int arr[]= {7,7,4,4,2,9,6,5};
		LinkedHashSet<Integer> s=new LinkedHashSet<Integer>();
		for (Integer i : arr) {
			s.add(i);
		}
		int a1[]=new int[s.size()];
		int index=0;
		for (int i : s) {
			a1[index++]=i;
			
		}
		System.out.println(s);
		for(int i=0; i<a1.length; i++) {
			for(int j=0; j<a1.length; j++) {
				if(a1[i]>a1[j]) {
					int temp=a1[i];
					a1[i]=a1[j];
					
					
					a1[j]=temp;
				}
			}
			
		}
		System.out.println(a1[2]);
	}
	
	@Test
	public void secondMaximumProg() {
		int arr[]= {7,4,2,9,6};
		int max= 0;
		int secondMax=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				if(arr[i]!=max) {
					
				}
				max=arr[i];
			}
		
		}
		System.out.println(max);
	}
	
	
	@Test                      
	public void missingNumber() {       // it will not work for if number start from 2 or more.
		int arr[]= {1,4,3,5};
		int sum=0;
		int max=0;
		for(int i=0; i<arr.length; i++) {
			sum=sum+arr[i];	
		}
		for(int j=0; j<arr.length; j++) {
		if(arr[j]>max) {
			max=arr[j];
		}
		}
		int a = (max*(max+1)/2)-sum;
		System.out.println(a); 
		}	
	
	/**
	 * 1+3+4+5=13
	 * 5*(5+1)/2=15
	 */
	
	@Test                      
	public void missingNumberProg() {      
		int arr[]= {1,4,3,5,10,7};
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			al.add(arr[i]);
		}
		for(int j=1; j<=10; j++) {
			if(!al.contains(j)) {
				System.out.println(j);
			}
		}
	}
	@Test
	public void thirdMaximumAnotherApporch1() {
		int arr[]= {7,7,4,4,2,9,6,5};
		TreeSet<Integer> s=new TreeSet<Integer>();
		for (Integer i : arr) {
			s.add(i);
		}
		System.out.println(s);
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.addAll(s);
		System.out.println(al);
		System.out.println(al.get(al.size()-1));
	}
	
	@Test
	public void concatArray() {
		int ary1[] = {1,2,3,4,5};
		int ary2[] = {6,7,8,9,10};
		
		int newArray[] = Arrays.copyOf(ary1, ary1.length+ary2.length);
		System.arraycopy(ary2, 0, newArray, ary1.length, ary2.length);
		
		System.out.println("Total Array : "+ Arrays.toString(newArray));			
	}
	
	@Test
	public void seconddmax() {
		int a[] = {3,9,4,15,13};
		TreeSet<Integer> al = new TreeSet<Integer>();
		for(int i=0; i<a.length; i++) {
			al.add(a[i]);
		}
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.addAll(al);
		System.out.println(l.get(l.size()-2));
		
	}

}
