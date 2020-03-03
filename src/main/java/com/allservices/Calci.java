package com.allservices;

public class Calci implements MathOperations{
	
	public int add(int i,int j) {
			return i+j;
	}
	
	public int sub(int i,int j) {
		return i-j;
	}
	
	public int mul(int i,int j) {
		return i*j;
	}
	
	public int div(int i,int j) {
		return i/j;
	}

	@Override
	public MathResult all(int i, int j) {
		int sum = add(i,j);
		int diff = sub(i,j);
		int product = mul(i,j);
		int quotient =  div(i,j);
		MathResult m = new MathResult(sum,diff,product,quotient);
		return m;
	}
	
}
