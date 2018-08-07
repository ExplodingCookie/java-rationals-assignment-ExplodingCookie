package com.cooksys.ftd.assignments.objects;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedRational implements IRational {
	
	int numerator = 0;
	int denominator = 0;
    /**
     * Determines the greatest common denominator for the given values
     *
     * @param a the first value to consider
     * @param b the second value to consider
     * @return the greatest common denominator, or shared factor, of `a` and `b`
     * @throws IllegalArgumentException if a <= 0 or b < 0
     */
    public static int gcd(int a, int b) throws IllegalArgumentException {
    	
        if(a <= 0 || b < 0) {
        	throw new IllegalArgumentException();
        } else {
        	/*
        	List<Integer> factorsOfA = new ArrayList<Integer>();
        	List<Integer> factorsOfB = new ArrayList<Integer>();
        	
        	for(int i = 1; i <= a; i++) {
        		if(a % i == 0) {
        			factorsOfA.add(i);
        		}
        	}
        	
        	for(int i = 0; i <= b; i++) {
        		if(i == 0) {
        			factorsOfB.add(1);
        		} else {
	        		if(b % i == 0) {
	        			factorsOfB.add(i);
	        		}
        		}
        	}
        	*/
        	
        	int gcd = 1;
        	
        	int prime = a;
        	int secon = b;
        	int trade = 0;
        	
        	
        	while (prime != 0) {
        		trade = prime;
        		prime = secon % prime;
        		secon = trade;
        	}
        	
        	gcd = secon;
        	
        	return gcd;
        }
    }

    /**
     * Simplifies the numerator and denominator of a rational value.
     * <p>
     * For example:
     * `simplify(10, 100) = [1, 10]`
     * or:
     * `simplify(0, 10) = [0, 1]`
     *
     * @param numerator   the numerator of the rational value to simplify
     * @param denominator the denominator of the rational value to simplify
     * @return a two element array representation of the simplified numerator and denominator
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public static int[] simplify(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0) {
        	throw new IllegalArgumentException();
        } else {
        	int num = numerator;
        	int den = denominator;
        	
        	if(num < 0) {
        		num *= -1;
        	}
        	
        	if(den < 0) {
        		den *= -1;
        	}
        	
        	int gcf = gcd(den, num);

        	int[] ret = new int[2];
        	
        	ret[0] = (numerator / gcf);
        	ret[1] = (denominator / gcf);
        	
        	return ret;
        }
    }

    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * Simplification of numerator/denominator pair should occur in this method.
     * If the numerator is zero, no further simplification can be performed
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {
    	if(denominator == 0) {
        	throw new IllegalArgumentException();
        } else {
        	int num = numerator;
        	int den = denominator;
        	
        	int[] newStuff = simplify(num, den);
        	
        	this.numerator = newStuff[0];
        	this.denominator = newStuff[1];
        }
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
        return numerator;
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
        return denominator;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator   the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value (specifically, a SimplifiedRational value)
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException {
    	if(denominator == 0) {
    		throw new IllegalArgumentException();
    	} else {
    		SimplifiedRational simRat = new SimplifiedRational(numerator, denominator);
    		
    		return simRat;
    	}
    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
    	if(obj == null) 
        	return false;
        
        if(obj.getClass() == this.getClass()) {
        	SimplifiedRational rat = (SimplifiedRational) obj;
        	
        	if(rat.numerator == this.numerator && rat.denominator == this.denominator) {
        		return true;
        	} else {
        		return false;
        	}
    	} else {
    		return false;
    	}
    }

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override
    public String toString() {
    	int num = numerator;
    	int dem = denominator;
    	
    	if(dem < 0) {
    		num *= -1;
    		dem *= -1;
    	}
    	
    	return Integer.toString(num) + "/" + Integer.toString(dem);
    }
}
