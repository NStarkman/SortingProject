//Author: Or Brener
//Date Created: May 14th 2020
//Date Last Modified: May 14th 2020

package comscifst;


public class ShellSort extends Utility {

    private static long startTime;
    private static long endTime;

    //returns sorted Array
    public static int[] sort(int[] list) {
        int n = list.length;

        startTime = Utility.startTime();

        for (int gap = n / 2; gap > 0; gap /= 2) {//initializes a gap
            for (int i = gap; i < n; i += 1) {//goes through the loop n-gap number of times
                int temp = list[i];//for swapping purposes
                int j;
                for (j = i; j >= gap && list[j - gap] > temp; j -= gap) {

                    list[j] = list[j - gap];
                }
                list[j] = temp;
            }
        }
        endTime = Utility.endTime();

        return list;
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
