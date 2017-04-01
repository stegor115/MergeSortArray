//Stephen Gordon

public class Main {
	public static void main(String args[]){
		int[] myArray = {5,321,42,532,5324,132,562,631,412,321};
		System.out.println("Unsorted:");
		print(myArray);
		System.out.println();
		//sort(myArray);
		int[] newArray = sort(myArray); //Must be done to set the result to something
 		System.out.println();
		System.out.println("Sorted via merge sort");
		print(newArray);
} //end main method
	
	public static void print(int[] array){
		int count = 0;
		while(count != array.length){
			System.out.print(array[count] + " ");
			count++;
		} //end while
	} //end method	
	
	public static int[] sort(int[] happyArray){
		if(happyArray.length < 2){ //Less than 2 because if the array were 1 cell big, StackOverflow
			return happyArray; // Stops the recursion because arrays cannot be split any further
		} //end base case
		//Declarations
		int midpoint = happyArray.length/2;
		int[] left = new int[midpoint]; //Makes empty array as big as the midpoint
		int[] right = new int[happyArray.length-midpoint]; //Makes empty array as big as the remaining length after midpoint
		int[] result = new int[happyArray.length]; // Makes empty array as big as initial array
		//Left Array
		for(int i = 0; i<midpoint; i++){
			left[i] = happyArray[i];
		} //end for
		//Right Array
		int x = 0;
		for(int j = midpoint; j<happyArray.length; j++){
			if(x < right.length){
			right[x] = happyArray[j];
			x++;
			} //end if
		} //end for
		
		//Recursion
		left = sort(left);
		right = sort(right);
		//End result
		result = merge(left, right);
		return result;
	} //end method
	
	public static int[] merge(int[] left, int[] right){
		//Declarations
		int[] result = new int[left.length+right.length];
		int indexL = 0; //Position in left array
		int indexR = 0; //Position in right array
		int indexRes = 0; //Position in end result array
		
		while(indexL < left.length || indexR < right.length){ //While index is less then their lengths
			if(indexL < left.length && indexR < right.length){ //While both indexes are less than their lengths
				if(left[indexL] <= right[indexR]){ //If left is less than than right
					result[indexRes] = left[indexL];
					indexRes++;
					indexL++;
				} else{ //If right is less than left
					result[indexRes] = right[indexR];
					indexRes++;
					indexR++;
				} //end if
			} //end if
			else if(indexL < left.length){ //If just the left index is smaller than length
				result[indexRes] = left[indexL];
				indexL++;
				indexRes++;
			} //end else if
			else if(indexR < right.length){ //If just the right index is smaller than length
				result[indexRes] = right[indexR];
				indexR++;
				indexRes++;
			} //end else if
		} //end while
		return result; //Congrats we made it
	}//end method
} //end class