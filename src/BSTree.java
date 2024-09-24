public class BSTree {

    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        public Node(int value)
        {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" +value;
        }
    }
    private Node root;
    private void insertIntoBST(int value){
        var node = new Node(value);
        if(root == null)
        {
            root = node;
            return;
        }
        var current = root;
        while(true)
        {
            if(value < current.value)
            {
                if(current.leftChild == null)
                {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else{
                if(current.rightChild==null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }

        }
    }
    public void arrayToBST(int[] array)
    {
        System.out.println("Creating a Binary Search Tree-------");
        for(int i=0;i<array.length;i++)
        {
            insertIntoBST(array[i]);
        }
        System.out.println("Binary Search Tree created-------");
    }
    public boolean searchInBSt(int key)
    {
        var current = root;
        while(current!=null){
            if(key < current.value)
                current = current.leftChild;
            else if(key > current.value)
                current = current.rightChild;
            else
                return true;
        }
    return false;
    }

}
