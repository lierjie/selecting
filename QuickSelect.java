/** 
  * This is a test class of Quick Select.
  * This chooses the Kth smallest number from an array;
  * The average running time is O(n); The worst-case running time is O(n*n)
  **/
import java.util.Arrays;
import java.io.*;
public class QuickSelect {
	public static void main(String[] args) {
		int k =7;
		int len = 0;
		try {
			String input = InputHelper.getInput("please input the number of your Doubles:");
			len = Integer.parseInt(input);
		} catch (Exception e){
			e.printStackTrace();
		}
		Double [] m = new Double[len];
		for (int i = 0; i < len; i++) {
			m[i] = new Double(Math.random() * 100);
		}
		System.out.println(" ");
		System.out.println("The Doubles are:");
		System.out.println(Arrays.toString(m));
		Comparable output = findKthSmallest(m, k);
		System.out.println(" ");
		System.out.println("The " + k + "th number is :" + output);
        
		quickSort(m);
		System.out.println(" ");
        System.out.println("After InsertionSort, the Doubles are:");
	    System.out.println(Arrays.toString(m));
		
	}





	public static Comparable findKthSmallest(Comparable [] data, int k) {
		int i = 0;
		int j = data.length - 1;
		
		while (i <= j) {
			int pivotPosition = subQuickSortCore(data, i, j);
			if (k - 1 == pivotPosition) {
				return data[pivotPosition];
			}
			else if (k -1 < pivotPosition) {
				j = pivotPosition - 1;
			}
			else {
				i = pivotPosition + 1;
			}
		}
		return Integer.MAX_VALUE; 
	}

    public static void quickSort(Comparable [] data) {
		subQuickSort(data, 0, data.length - 1);
	}



	public static void subQuickSort(Comparable [] data, int low, int high) {
		if (low < high) {
			int pivotPosition = subQuickSortCore(data, low, high);
			subQuickSort(data, low, pivotPosition - 1);
			subQuickSort(data, pivotPosition + 1, high);
		}
	}

	private static int subQuickSortCore(Comparable [] data, int low, int high) {
		Comparable pivotKey = data[low];
		while (low < high) {
			while (low < high && (pivotKey.compareTo(data[high]) != 1)) {
				high--;
			}
			data[low] = data[high];
			

			while (low < high && data[low].compareTo(pivotKey) != 1) {
				low++;
			}
			data[high] = data[low];
			
		}
		data[low] = pivotKey;
		return low;
	}
}

class InputHelper {
	  public static String getInput(String mes) throws IOException{
	  System.out.println(mes);
	  BufferedReader keybd = new BufferedReader(new InputStreamReader(System.in));
	  String input = keybd.readLine();
	  return input;
	  }
  }
