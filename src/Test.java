import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test {
    Search search = new Search();
    BSTree bsTree = new BSTree();
    RedBlackTree rbTree = new RedBlackTree();
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    int numberToSearch;
    private int getDataSize()
    {
        System.out.println("Enter the required size to list to search in (Supported 100 <= N <= 10000000)-->  ");
        int dataSize = sc.nextInt();
        try {
            if (dataSize > 99 && dataSize < 10000001)
                return dataSize;
            else
                return -1;
        }
        catch (IllegalArgumentException exception)
        {
            System.out.println(exception);
        }
    return -1;
    }
    private int[] GenerateTestData(int listSize)
    {

        int[] randomNumberArray = random.ints(listSize+1, 0, (listSize*10)+1).toArray();
        numberToSearch = random.ints(1, 0, listSize+1).findFirst().getAsInt();
        //System.out.println("array length ="+randomNumberArray.length);
       /* for (int i = 0; i < randomNumberArray.length; i++) {
            System.out.println("array before deleting number = " + randomNumberArray[i]);
        }*/
        randomNumberArray= removeRandomNumber(randomNumberArray, numberToSearch);
        System.out.println("Running test for Linear Search...");
        return randomNumberArray;
    }
    public void testLinearSearch()
    {
        int N = getDataSize();
        if(N  ==-1) {
            System.out.println("Entered value is invalid. Valid values are 100 to 10000000. Exiting test...");
            return;
        }
        System.out.println("Running test for Linear Search...");
        System.out.println("Creating a test list that contains (N)="+ N + "random numbers from sample size of (N * 10)=" +(N * 10));

        int[] numArray = GenerateTestData(N);
        /*for (int i = 0; i < numArray.length; i++) {
            System.out.println("array = " + numArray[i]);
        }
        System.out.println("search Number = " + numberToSearch);*/
        System.out.println("Finished creating the list...");
        System.out.println("Starting test");
        double worstTime = 0;
        double startTime = System.nanoTime();
        for (int i = 1; i < 101; i++) {
            search.linearSearch(numArray,numberToSearch);
        }
        worstTime = (System.nanoTime() - startTime) * 10;
        System.out.println("Average time for 100 itterations: "+worstTime/1000000+"ms");

    }
    public  void testBinarySearch(){
        int N = getDataSize();
        if(N  ==-1) {
            System.out.println("Entered value is invalid. Valid values are 100 to 10000000. Exiting test...");
            return;
        }
        System.out.println("Running test for Binary Search...");
        System.out.println("Creating a test list that contains numbers from 0 to "+ N);
        int[] randomNumberArray = random.ints(N+1, 0, N).toArray();
        Arrays.sort(randomNumberArray);
        numberToSearch = N + 2;
        System.out.println("Finished creating the list...");

        System.out.println("Starting test");
        double worstTime = 0;
        double startTime = System.nanoTime();
        for (int i = 1; i < 101; i++) {
            search.binarySearch(randomNumberArray,numberToSearch);
        }
        worstTime = (System.nanoTime() - startTime) * 10;
        System.out.println("Average time for 100 itterations: "+worstTime/1000000+"ms");
    }
    private int[] removeRandomNumber(int[] intArr,int elem){
        for(int i = 0; i < intArr.length; i++){
            if(intArr[i] == elem){
                System.out.println("Deleted Number ="+elem);
                // shifting elements
                for(int j = i; j < intArr.length - 1; j++){
                    intArr[j] = intArr[j+1];
                }
                break;
            }
       }
        return intArr;
    }
    public void testBSTree()
    {
        int N = getDataSize();
        if(N  ==-1) {
            System.out.println("Entered value is invalid. Valid values are 100 to 10000000. Exiting test...");
            return;
        }
            System.out.println("Running test for Binary Search Tree...");
            System.out.println("Running test for Linear Search...");
            System.out.println("Creating a test list that contains (N)="+ N + "random numbers from sample size of (N * 10)=" +(N * 10));

            int[] numArray = GenerateTestData(N);
            bsTree.arrayToBST(numArray);
            System.out.println("Finished creating the Binary Search Tree...");

            System.out.println("Starting test");
            double worstTime = 0;
            double startTime = System.nanoTime();
            for (int i = 1; i < 10001; i++) {
                bsTree.searchInBSt(numberToSearch);
            }
            worstTime = (System.nanoTime() - startTime) / 10;
            System.out.println("Average time for 100 itterations: "+worstTime/1000000+"ms");
        }
        public void TestRedBlackTree()
        {
            int N = getDataSize();
            if(N  ==-1) {
                System.out.println("Entered value is invalid. Valid values are 100 to 10000000. Exiting test...");
                return;
            }
            System.out.println("Running test for Binary Search Tree...");
            System.out.println("Running test for Linear Search...");
            System.out.println("Creating a test list that contains (N)="+ N + "random numbers from sample size of (N * 10)=" +(N * 10));

            int[] numArray = GenerateTestData(N);
            rbTree.arrayToRedBlackTree(numArray);
            System.out.println("Finished creating the Binary Search Tree...");

            System.out.println("Starting test");
            double worstTime = 0;
            double startTime = System.nanoTime();
            for (int i = 1; i < 10001; i++) {
                rbTree.searchInRBT(numberToSearch);
            }
            worstTime = (System.nanoTime() - startTime) / 10;
            System.out.println("Average time for 100 itterations: "+worstTime/1000000+"ms");
        }
    }


