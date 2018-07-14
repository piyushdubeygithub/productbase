package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Scanner;

public class TestPdfController {
	public static void main(String[] args) {
		
		
		Integer[] i = {1,2,3,45,6,7};
		Character[] c = {'a','b','c','d'};
		
		int in=printData(1,54,89);
		System.out.println(in);
		String ch = printData("cghh","rdjtydyt","kjjhfr");
		System.out.println(ch);
		/*
		//List scores = (List) new ArrayList<CrickScore>();
		ArrayList<CrickScore> scores =  new ArrayList<CrickScore>();
	    scores.add(new CrickScore("a", 3));
	    scores.add(new CrickScore("b", 15));
	    scores.add(new CrickScore("c", 6));
	    scores.add(new CrickScore("a", 8));
	    scores.add(new CrickScore("b", 7));
	    scores.add(new CrickScore("a", 10));
	    scores.add(new CrickScore("b", 7));
	    scores.add(new CrickScore("c", 8));
	    scores.add(new CrickScore("c", 3));
	    scores.add(new CrickScore("a", 9));
	    scores.add(new CrickScore("c", 4));
	    Collections.sort(scores, new Comparator<CrickScore>() {

			@Override
			public int compare(CrickScore o1, CrickScore o2) {
				if(o1.getScore() == o2.getScore()) {
					return o1.getPlayer().compareTo(o2.getPlayer());
				}else {
					return o1.getScore() - o2.getScore();
				}
				
			}
		});
	    System.out.println(scores);
    */
	//**********************************************************************
	/*	 Scanner sc = new Scanner(System.in);
		    int n = sc.nextInt();
		    int cases = 0;
		    while(n>0){
		        cases++;
		        List<String> treeset = new ArrayList<String>();
		        int m = sc.nextInt();
		        for(int i =0;i<m;i++){
		            String word = sc.next();
		            treeset.add(word);
		        }
		        Collections.sort(treeset, new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						return (o1+o2).compareTo(o2+o1);
					}
				});
		        String ans = "";
		        for(String word : treeset){
		            ans = ans+word;
		        }
		        System.out.println("Case #"+cases+":"+ans);
		        n--;
	}*/
	//**************************************************************************
		/*   Scanner sc = new Scanner(System.in);
		    int n = sc.nextInt();
		    sc.nextLine();
		    String toSearch = "HACKERCUP";
		    int cases = 0;
		    while(n>0){
		    	cases++;
		        String string = sc.nextLine();
		        string = string.replace(" ", "");
		        int length = string.length();
		        int countMin = Integer.MAX_VALUE;
		        boolean isChecked = false;
		        for(int i=0;i<toSearch.length();i++) {
		        	  int count = 0;
		        	Character c = toSearch.charAt(i);
		        	System.out.println(string);
		        	 string = string.replaceAll(c.toString(), "");
				         count = length - string.length();
				         length = string.length();
				        //	System.out.println(c+"========="+count);
				        if(c.compareTo('C')==0) {
				        	if(isChecked) {
				        		continue;
				        	}else {
				        		isChecked = true;
				        	}
				        	count = count/2;
				        //	System.out.println("Hii");
				        }
			        	//System.out.println(c+"========="+count);
				        if(count<countMin) {
				        	countMin = count;
				        }
				     //   break;
		        }
		        System.out.println("Case #"+cases+": "+countMin);
		        n--;
		    }*/
	/*	Display d = new Display();
		MyThread t1 = new MyThread(d, "Riya");
		MyThread t2 = new MyThread(d, "Piyush");
		t1.start();
		t2.start();*/
		//*********************************************************************************
        /*Scanner sc = new Scanner(System.in);		
        int t = sc.nextInt();
        int cases =0;
        while(t>0) {
        	t--;
        	cases++;
        	long n = sc.nextLong();
        	long k = sc.nextLong();
        	long v = sc.nextLong();
        	sc.nextLine();
        	int attSeen = 0;
        	ArrayList<String> list = new ArrayList<>();
        	for(int i=0;i<n;i++) {
        		list.add(sc.nextLine());
        	}
        	long index = ((v-1)*k)%n;
        	System.out.print("Case #"+cases+": ");
        	long length = n-index;
        
        	for(long i=index;i<n;i++) {
        		if(attSeen==k) {
        			break;
        		}
        		System.out.print(list.get((int) i)+" ");
        		attSeen++;
        	}
        	
        	System.out.println();
        }*/
	}

	private static <T extends Comparable<T>> T printData(T a,T b, T c) {
		T max =a;
		if(b.compareTo(a)>0) {
			max = b;
		}
		if(c.compareTo(max)>0) {
			max=c;
		}
		return max;
	}
}
