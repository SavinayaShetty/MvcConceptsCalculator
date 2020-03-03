package com.allservices;

public class Calculator {
	public int add(int i,int j)
	{
		return i+j;
	}
	public int sub(int i,int j)
	{
		return i-j;
	}
	public int mul(int i,int j)
	{
		return i*j;
	}
	public int div(int i,int j)
	{
		if(j!=0)
			return i/j;
		else
			return -1;
	}

}
