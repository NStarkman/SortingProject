//Author: Or Brener
//Date Created: May 14th 2020
//Date Last Modified: May 14th 2020

package comscifst;

public class QuickSort extends Utility {

    private static long startTime;
    private static long endTime;
    private static int computeTimeCounter = 1;//to make sure the start and end time only go once (in a recursive method)

    //calls the quickSort recursive method
    //returns sorted Array
    public static int[] sort(int[] list)throws Exception {
        return quickSortRecursive(list, 0, list.length-1);


    }

    //recursive method to sort the array
    private static int[] quickSortRecursive(int[] list, int low, int high){
        if (computeTimeCounter == 1){//so that it only gets called once (it's in a recursive method)
            startTime = Utility.startTime();
        }

        if (low < high+1){
            int p = partition(list, low, high);//new pivot value
            quickSortRecursive(list, low, p-1);//calls recursive method on right of partition
            quickSortRecursive(list, p+1, high);//calls recursive method on left of partition
        }

        if (computeTimeCounter == 1) {//so that it only gets called once (it's in a recursive method)
            endTime = Utility.startTime();
        }
        computeTimeCounter ++;
        return list;
    }

    //goes through each value, compares to pivot value, swaps items as needed
    private static int partition(int[] list, int low, int high){
        Utility.swap(list,low, Utility.getPivot(low,high));//swaps pivot value into left most position
        int border = low + 1;//left pointer--just right of pivot location
        for (int i = border; i <= high; i++){//every item within partition, comparing to the pivot (list[low])
            if (list[i] < list[low]){
                Utility.swap(list, i, border++);
            }
        }
        Utility.swap(list, low, border-1);//swap pivot value back into position
        return border -1; //returns index of pivot value
    }

    //outputs the sorted array in string format
    public static String outputDataString(String fileName)throws Exception{
        return Utility.outputDataString(sort(Utility.getData(fileName)));
    }

    //returns the computing time
    public static long getComputeTime(){
        return Utility.computeTime(startTime, endTime);
    }

}
