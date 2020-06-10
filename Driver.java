package comscifst;

//FOR TESTING PURPOSES//
public class Driver {
    public static void main(String[] args)throws Exception {
        String file = "FSTTest1.txt";
//        QuickSort.outputDataString(file);
//        ShellSort.outputDataString(file);
//        LinearInsertion.outputDataString(file);

        LinearInsertion.sort(Utility.getData(file));
        ShellSort.sort(Utility.getData(file));
        QuickSort.sort(Utility.getData(file));
        String shellSort = ShellSort.outputDataString(file);
        System.out.println(shellSort);

        System.out.println("Linear: " + LinearInsertion.getComputeTime());
        System.out.println("Shell: " + ShellSort.getComputeTime());
        System.out.println("Quick: " + QuickSort.getComputeTime());
        System.out.println("Difference: " + (LinearInsertion.getComputeTime() - QuickSort.getComputeTime()));

        System.out.println(QuickSort.sort(Utility.getData(file)));
        
    }
}
