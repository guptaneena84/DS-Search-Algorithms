import java.util.Arrays;
import java.util.Scanner;

public class InputOutputData {
    private int arrayLength = 0;
    private int[] numbers ;
    int numberToSearch ;
    Scanner s = new Scanner(System.in);
    Search search = new Search();
    private void getInputData()
    {
        System.out.println("Enter the size of array = ");
        arrayLength=s.nextInt();
        numbers = new int[arrayLength];
        System.out.println("Enter the elements of array = ");
        for (int i=0;i<arrayLength;i++)
        {
            numbers[i]=s.nextInt();
        }
        System.out.println("Enter the element you want to search = ");
        numberToSearch = s.nextInt();
    }
    public void searchOperations()
    {
        getInputData();
        System.out.println("""
           To search                 Enter
        Linear Search ------------  1
        Binary Search ------------  2
        Binary Search Tree -------  3
        Red Black Tree -----------  4
        To EXIT ------------------  0\n""");
       int searchOperation = s.nextInt();
       if(searchOperation == 1){
           int index = search.linearSearch(numbers ,numberToSearch);
           printLinearBinarySearchResults(index);
       }
       else if (searchOperation == 2)
       {
           //Arrays.sort(numbers);
          // System.out.println("Sorted List " + numbers.toString());
           int index = search.binarySearch(numbers ,numberToSearch);
           printLinearBinarySearchResults(index);
       }
       else if (searchOperation == 3)
       {
           boolean ifFound = search.CreateNSearchBSTree(numbers ,numberToSearch);
           printBSTreeRBTreeResults(ifFound);

       }
       else if (searchOperation == 4)
       {
           boolean ifFound = search.CreateNSearchRBTree(numbers ,numberToSearch);
           printBSTreeRBTreeResults(ifFound);

       }
    }
   /* private void callLinearSearch()
    {
        getInputData();
        int index = search.linearSearch(numbers ,numberToSearch);
        if(index == -1)
        {
            System.out.println("Element you are looking for is not present in array");
        }
        else
        {
            System.out.println("Element you are looking for is present at index "+index );
        }
    }*/
    private void printLinearBinarySearchResults(int index)
    {
        if(index == -1)
            System.out.println("Element you are looking for is not present in array");
        else
            System.out.println("Element you are looking for is present at index "+index );
        nextStep();

    }

    private void printBSTreeRBTreeResults(boolean ifFound)
    {
        if(ifFound)
            System.out.println("Element you are looking for is present in the Tree");
        else
            System.out.println("Element you are looking for is not present in the Tree");
        nextStep();
    }

    private void nextStep()
    {
        System.out.println(" Linear Search Enter ------------  1\n" +
                " Binary Search Enter------------  2" );
        int option = s.nextInt();
        System.out.println("----" + option);
        if (option == 1)
            searchOperations();
        else
            System.out.println("You have exited the program");
    }
   /* private void callBSTSearch()
    {
        getInputData();

        if(ifFound)
            System.out.println("Element you are looking for is present in the Tree");
        else
            System.out.println("Element you are looking for is not present in the Tree");
    }
    private void callRedBlackSearch()
    {
        getInputData();
        rbTree.arrayToRedBlackTree(numbers);
        boolean ifFound = rbTree.searchInRBT(numberToSearch);
        if(ifFound)
            System.out.println("Element you are looking for is present in the Tree");
        else
            System.out.println("Element you are looking for is not present in the Tree");
    }*/

}
