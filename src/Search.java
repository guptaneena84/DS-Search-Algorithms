
public class Search {
    BSTree bsTree = new BSTree();
    RedBlackTree rbTree = new RedBlackTree();

    //Linear search Method
    public int linearSearch(int[] array, int itemToBeSearched)
    {
        for(int i=0; i<array.length ; i++)
        {
            if(array[i] == itemToBeSearched) {
                return i;
            }
        }
        return -1;
    }

    //Binary Search Method
    public int binarySearch(int[] array, int itemToBeSearched)
    {   var left =0;
        var right = array.length-1;
        while(left < right)
        {
            var middle = (left+right)/2;
            if(array[middle] == itemToBeSearched)
              return middle;

            if(itemToBeSearched<array[middle])
              right = middle-1;
           else
               left = middle+1;
        }
        return -1;
    }

    public boolean CreateNSearchBSTree(int[] array,int numberToSearch){
        bsTree.arrayToBST(array);
        boolean ifFound = bsTree.searchInBSt(numberToSearch);
        return ifFound;
    }


    public boolean CreateNSearchRBTree(int[] array,int numberToSearch){
        rbTree.arrayToRedBlackTree(array);
        boolean ifFound = rbTree.searchInRBT(numberToSearch);
        return ifFound;
    }
}
