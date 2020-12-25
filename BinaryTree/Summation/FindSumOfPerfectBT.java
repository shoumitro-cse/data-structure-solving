//find sum of all nodes of the given perfect binary tree 

//javac -d classes FindSumOfPerfectBT.java  && cd classes && java FindSumOfPerfectBT && cd ..

import java.io.*; 
import java.lang.Math; 

class FindSumOfPerfectBT { 
	
	// function to find sum of all of the nodes of given perfect binary tree 
	static double sumNodes(int level) { 
		// no of leaf nodes 
		double leafNodeCount = Math.pow(2, level-1); 
		double sumLastLevel = 0; 
		// sum of nodes at last level 
		sumLastLevel = (leafNodeCount * (leafNodeCount+1)) / 2; 
		// sum of all nodes 
		double sum = sumLastLevel * level; 
	  return sum; 
	} 
	
	public static void main (String[] args) { 
		int level = 3; 
		System.out.println(sumNodes(level)); 
	} 
} 


/*
Find sum of all nodes of the given perfect binary tree

Given a positive integer L which represents the number of levels in a perfect binary tree. 
Given that the leaf nodes in this perfect binary tree are numbered starting from 1 to n, 
where n is the number of leaf nodes. And the parent node is the sum of the two child nodes. 
Our task is to write a program to print the sum of all of the nodes of this perfect binary tree.

Examples:

Input : L = 3
Output : 30
Explanation : Tree will be - 

     10
    /   \
   3     7
  /  \  /  \
 1   2  3   4

Input : L = 2
Output : 6
Explanation : Tree will be -  

      3
    /   \
   1     2

*/