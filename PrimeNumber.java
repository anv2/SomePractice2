/**
 * The following code does two things:
 * (1) Method1: counts the occurrence of prime numbers up to the number of 
 * interest that is the parameter
 * (2) Method2 sorts an array of three positive integers. This code could 
 * easily be modified to accept any number of integers. 
 * 
 * More code samples could be found on my GitHub page, https://github.com/anv2
 * 
 *
 * @author Vithia An
 * @since Apr 3, 2018
 * */

public class PrimeNumber {

/**method1***************************************/
/************************************************/
	//method to check if number is prime
	//@param number to be checked if it is prime
	//@return true if prime number, false otherwise
	public static boolean isPrime(int n){

		boolean isPrime =true;
		if(n == 2|| n==3){
			return isPrime;
		}
		if(n%2==0|| n%3 == 0){
			isPrime = false;
			return isPrime;
		}

		return isPrime;
	}
	//method to count occurrences of prime numbers
	//@param the number up to which prime numbers span
	//@return count the occurrence of prime numbers
	public static int method1(int n){

		int count=0;
		for(int i=2; i<=n; i++){
			if (isPrime(i) == true){
				count++;
			}
		}
		return count;
	}
		

/**method2***************************************/
/************************************************/
	//given 3 int. sort from lowest to highest integer. return sorted list.
	//@param array of three numbers
	//@return sorted list
	public static int[] method2(int[] arr){

		int temp=0;
		
		//feed in array
		for(int i=0; i< arr.length-1; i++){
			for(int j =0; j<arr.length-i-1; j++){
				if(arr[i]>arr[i+1]){
					temp =arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}

		return arr;
	}
	//method to print array 
	//@param array to be sorted
	public static void printMethod(int[] a){
		System.out.println("The sorted array in increasing order");
		for(int i=0; i<a.length; i++){
			
			System.out.print(a[i]+ " ");
		}
	}

/**main method***********************************/
/************************************************/
	public static void main(String[] args){
		//first method
		int firstMethod = 7;
		System.out.println( "The number of prime numbers: "+method1(firstMethod) );		//prints the number of prime numbers 
		
		
		//second method
		int[] arr = {2,43,5};
		printMethod( method2(arr) );
	}
}

