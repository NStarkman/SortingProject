//Author: Or Brener
//Date Created: May 13th 2020
//Date Last Modified: May 14th 2020


package comscifst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;


public class Utility extends Object {
    static File sortedFile = new File("fileOutput.txt");
    private static long computeTime;
    

    //converts a txt file into an array
    public static int[] getData(String fileName) throws Exception{


        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        line = br.readLine();//first line (indicates how many items in the file)
        int size = Integer.parseInt(line);
        int inputArray[] = new int [size];

        //input the line from the file into the array
        for (int i = 0; i<inputArray.length; i++) {
            line = br.readLine();
            if (line != null) {
                inputArray[i] = Integer.parseInt(line);
            }         
        }
        //prints the array
//        for (int i = 0; i<inputArray.length; i++) {
//            System.out.println(inputArray[i]);
//        }

        return inputArray;
    }

    //swaps two items within a list
    public static void swap(int[] list, int index1, int index2){
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    //returns random index for pivot between low and high inclusive
    public static int getPivot(int low, int high){
        Random rand = new Random();
        return rand.nextInt((high-low) +1 ) + low;
    }

    //sout's an array as a string
    public static String outputDataString(int[] sortMethod)throws Exception{
        return(Arrays.toString(sortMethod));
    }


    public static long startTime(){
        //startTime = 0;
        return System.nanoTime();
    }

    public static long endTime(){
        //endTime = 0;
        return System.nanoTime();
    }

    public static long computeTime(long start, long end){
        //computeTime = 0;
        return computeTime = end - start;//nanoseconds
    }
    public static void sortedFile (int[] sortList) throws Exception{
        if (sortedFile.exists() && sortedFile.isFile()){
            int x=1;
            do{
                sortedFile = new File("FileOutput"+x+".txt");
                x++;
            }while(sortedFile.exists());
        }
        FileWriter fw = new FileWriter (sortedFile, true);
        PrintWriter pw= new PrintWriter(fw);

     
        
        String length = Integer.toString(sortList[0]);
        pw.println(length);
       
         for(int i =1; i<sortList.length; i++){
             String value = Integer.toString(sortList[i]);
             pw.println(value);
        }  
        pw.close();//needed to avoid empty file
    }
}

