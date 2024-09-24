import java.awt.*;

public class RedBlackTree {
    private class RedBlackNode{
        private int value;
        private RedBlackNode parent;
        private RedBlackNode leftChild;
        private RedBlackNode rightChild;
        private Color color;
        public RedBlackNode(int value){
            this.value = value;
        }
        @Override
        public String toString() {
            return "Value=" +this.value;
        }
    }
    private RedBlackNode root;
    private RedBlackNode grandGrantParent;
    private RedBlackNode uncle ;//parent's sibling
    private RedBlackNode grandParent;
    public void insert(int value){
        var node = new RedBlackNode(value);
        setColor(node,Color.red);
        if(root == null)
        {
            root = node;
           // if(root.parent ==null )
            setColor(root,Color.black);
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
                    (current.leftChild).parent = current;
                    adjustAfterInsert(current.leftChild);
                    break;
                }
                current = current.leftChild;
            }
            else{
                if(current.rightChild==null) {
                    current.rightChild = node;
                    (current.rightChild).parent = current;
                    //setColor(current.leftChild,Color.red);
                    adjustAfterInsert(current.rightChild);
                    break;
                }
                current = current.rightChild;
            }

        }

    }
    private void adjustAfterInsert(RedBlackNode node){
        setColor(node,Color.red);

        if (node != null && node != root && isRed(node.parent)) {
            uncle = findSibling(node.parent);
            grandParent = findGrandParent(node);
            if(uncle != null && isRed(uncle))
            {
                setColor(node.parent,Color.black);
                setColor(uncle,Color.black);
                if(grandParent != root)
                {
                    adjustAfterInsert(grandParent);
                }

            }
            else if(uncle == null || isBlack(uncle))
            {
                //Left- Right rotation followed by right rotation
                if( node.parent == ((node.parent).parent).leftChild)
                {
                    if(node == (node.parent).rightChild)
                    ((node.parent).parent).leftChild = rotateLeft(node=node.parent);

                    grandGrantParent = findGrandGrandParent(node);
                    var newNode = rotateRight((node.parent).parent);
                    if(grandGrantParent != null ){

                        if(newNode.value > grandGrantParent.value) {
                            grandGrantParent.rightChild = newNode;
                            setColor(node, Color.black);
                            setColor((node.parent).rightChild, Color.black);
                        }
                    else {
                            grandGrantParent.leftChild = newNode;
                            setColor(node.parent, Color.red
                            );
                            setColor((node.parent).rightChild, Color.red);
                        }
                    }


                }
                else if(node.parent == ((node.parent).parent).rightChild)
                {
                    if(node == (node.parent).leftChild)
                    ((node.parent).parent).rightChild = rotateRight(node=node.parent);
                    if(((node.parent).parent).parent !=null && (node.parent).parent != root)
                    (((node.parent).parent).parent).rightChild = rotateLeft((node.parent).parent);
                   else{
                       root = rotateLeft((node.parent).parent);
                    }
                    setColor(node.parent,Color.black);
                    setColor((node.parent).leftChild,Color.red);
                }
            }
        }
    }

    private RedBlackNode findGrandParent(RedBlackNode node) {
        return (node.parent !=null && (node.parent).parent != null ) ? (node.parent).parent : null;

    }
    private RedBlackNode findGrandGrandParent(RedBlackNode node) {
        return (node.parent !=null && (node.parent).parent != null && ((node.parent).parent).parent != null ) ? ((node.parent).parent).parent  : null;

    }
    private RedBlackNode rotateLeft(RedBlackNode node){
        var newNode = node.rightChild;
        if(node.parent !=null)
        newNode.parent = node.parent;
        node.parent = newNode;
        node.rightChild = newNode.leftChild;
        newNode.leftChild = node;
        return newNode;
    }
    private RedBlackNode rotateRight(RedBlackNode node){
        var newNode = node.leftChild;
        if(node.parent !=null)
        newNode.parent = node.parent;
        node.parent = newNode;
        node.leftChild = newNode.rightChild;
        newNode.rightChild = node;
        return newNode;
    }
    private Color checkColor(RedBlackNode node){
        return (node==null)? Color.black : node.color;
    }
    private void setColor(RedBlackNode node, Color c) {
        if (node != null)
            node.color = c;
    }

    private boolean isRed(RedBlackNode node){
        return (node!=null && node.color == Color.red)? true:false;
    }
    private boolean isBlack(RedBlackNode node){
        return (node!=null && node.color == Color.BLACK)? true:false;
    }
    private RedBlackNode findSibling(RedBlackNode node){

        if(node != null)
        {
            if(node == (node.parent).leftChild)
                return (node.parent).rightChild;
           else
               return (node.parent).leftChild;

        }
        return null;
    }
    public void arrayToRedBlackTree(int[] array)
    {
        System.out.println("Creating a Red Black Tree-------");
        for(int i=0;i<array.length;i++)
        {
            insert(array[i]);
        }
        System.out.println("Red Black Tree created-------");
    }
    public boolean searchInRBT(int numberToSearch){
        var current = root;
        while(current!=null){
            if(numberToSearch < current.value)
                current = current.leftChild;
            else if(numberToSearch > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }
}
