//Author: Or Brener
//Date Created: May 13th 2020
//Date Last Modified: May 14th 2020


package comscifst;

public class LinearInsertion extends Utility{

    private static long startTime;
    private static long endTime;

    //returns sorted Array
    public static int[] sort(int[] list){
        int i; // outer loop
        int j; // inner loop
        int key; // the value being compared with
        int temp; //temporary value to do the swaps with

        startTime = Utility.startTime();

        for (i = 1; i < list.length; i++){//start at the first indice and
                                      // not zero because the first value is already sorted
            key = list[i];
            j = i-1; //counts down form the key all the way to the last indice
            while (j >= 0 && key < list[j]){//until j reaches the end of the list OR the key is greater than the value of list[j]
                //swap
                Utility.swap(list,j,j+1);

                j--;
            }
        }
        endTime = Utility.endTime();

        return list;
    }

    //OLD METHOD returns sorted Array in string format
//    public static String outputDataString(String fileName)throws Exception{
//        int[] input = Utility.getData(fileName);
//        return Arrays.toString(sort(input));
//    }

    //outputs the sorted array in string format
    public static String outputDataString(String fileName)throws Exception{
        return Utility.outputDataString(sort(Utility.getData(fileName)));
    }

    //returns the computing time
    public static long getComputeTime(){
        return Utility.computeTime(startTime,endTime);
    }

}
