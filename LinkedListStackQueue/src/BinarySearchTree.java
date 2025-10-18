public class BinarySearchTree <T extends Comparable>{
    private TNode<T> root;
    public void insert(T val){
        TNode<T> newNode = new TNode<>(val);
        if(root == null)
            root = newNode;
        else{
            TNode<T> iterator = root;
            while(iterator != null){
                if(iterator.value.compareTo(val)==1){
                    if(iterator.left!=null)
                        iterator=iterator.left;
                    else {
                        iterator.left = newNode;
                        return;
                    }
                }else if(iterator.value.compareTo(val)==-1){
                    if(iterator.right!=null)
                        iterator=iterator.right;
                    else {
                        iterator.right = newNode;
                        return;
                    }
                }else{
                    iterator.right = newNode;
                    return;
                }

            }
        }

    }
    public void inOrder(){
        inOrder(root);
    }
    public void inOrder(TNode<T> root){
        if(root!=null){
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }

    }
    public void postOrder(){
        postOrder(root);
    }
    public void postOrder(TNode<T> root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root);
        }

    }
    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(TNode<T> root){
        if(root!=null){
            System.out.println(root);
            preOrder(root.left);
            preOrder(root.right);
        }

    }

    public static void bubble(int[] values){
        boolean sorted = true;
        for(int i = 0;i<values.length-1;i++){
            for(int j = 0;j<values.length-1-i;j++){
                if(values[j]>values[j+1]){
                    int temp = values[j];
                    values[j]= values[j+1];
                    values[j+1]=temp;
                    sorted = false;
                }
            }
            if(sorted)return;
            sorted=true;
        }
    }
    public boolean search(T val){
        return search(root, val);
    }
    public boolean search(TNode<T> tempRoot, T val){
        if(tempRoot== null)
            return false;
        else if (val.compareTo(tempRoot.value)==-1)
            return search(tempRoot.left, val);
        else if (val.compareTo(tempRoot.value)==1)
            return search(tempRoot.right, val);
        else
            return true;
    }

    public boolean NormalSearch(T val){
        TNode<T> node = root;
        while(node != null){
            if(node.value.compareTo(val)==0)
                return true;
            else if (node.value.compareTo(val)==-1)
                node = node.right;
            else
                node = node.left;
        }
        return false;
    }
    public TNode<T> findNode(T val){
        return findNode(root, val);
    }
    public TNode<T> findNode(TNode<T> tempRoot, T val){
        if(tempRoot== null)
            return null;
        else if (val.compareTo(tempRoot.value)==-1)
            return findNode(tempRoot.left, val);
        else if (val.compareTo(tempRoot.value)==1)
            return findNode(tempRoot.right, val);
        else
            return tempRoot;
    }
    public TNode<T> findParent(T val){
        if(search(val) == false || root.value.compareTo(val)==0)
            return null;
        else{
            TNode<T> parent=root, iterator=root;
            while(iterator.value.compareTo(val)!=0){
                parent=iterator;
                if(val.compareTo(iterator.value)==-1)
                    iterator=iterator.left;
                else
                    iterator=iterator.right;
            }
            return parent;
        }
    }
    public TNode<T> inorderSuccessor(T val){
        TNode<T> current= findNode(val);
        if(current==null)
            return null;
        else if(current.right!=null){
            TNode<T> iterator=current.right;
            while(iterator.left!=null)
                iterator=iterator.left;
            return iterator;

        }else if (current==root && root.right==null){
            return null;
        }else if(current.right==null){
            TNode<T> parent=findParent(val);
            if(parent.left==current)
                return parent;
            else{
                TNode<T> grandParent=findParent(parent.value);
                while(grandParent!= null && grandParent.left!=parent){
                    parent=grandParent;
                    grandParent=findParent(parent.value);
                }
                if(grandParent==null)
                    return null;
                return grandParent;
            }
        }
        return null;
    }
    public boolean isLeaf(T val){
        TNode<T> current=findNode(val);
        return(current.left==null && current.right==null);
    }
    public void delete (T val){
        if(isLeaf(val)){
            TNode<T> parent=findParent(val);
            if(parent.left.value.compareTo(val)==0)
                parent.left=null;
            else
                parent.right=null;
        }else{
            TNode<T> current=findNode(val);
            TNode<T> parent=findParent(val);
            if(current.left==null && current.right!=null){
                if(parent.left==current)
                    parent.left=current.right;
                else
                    parent.right=current.right;
            }else if (current.right==null && current.left!=null){
                if(parent.left==current)
                    parent.left=current.left;
                else
                    parent.right=current.left;
            }else{
                TNode<T> inorder=inorderSuccessor(val);
                delete(inorder.value);
                current.value=inorder.value;
            }

        }

    }
    public int findHeight(){
        return findHeight(root);
    }
    public int findHeight(TNode<T> node){
        if(node == null)
            return -1;
        else{
            int leftSub = findHeight(node.left);
            int rightSub = findHeight(node.right);

            if(leftSub > rightSub)
                return leftSub+1;
            else
                return rightSub+1;

        }
    }

    public int countNodes(){
        return countNodes(root);
    }
    public int countNodes(TNode<T> node){
        if (node == null)
            return 0;
        else{
            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);

            return leftCount+rightCount+1;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> myTree = new BinarySearchTree<>();
        myTree.insert(10);
        myTree.insert(5);
        myTree.insert(2);
        myTree.insert(7);
        myTree.insert(8);
        myTree.insert(15);
        myTree.insert(13);
        myTree.insert(11);
        myTree.insert(14);
        myTree.insert(17);

        myTree.inOrder();
        System.out.println("inorder successor of: "+ myTree.inorderSuccessor(8));
        System.out.println("height: "+ myTree.findHeight());
        System.out.println("is exist: "+ myTree.NormalSearch(20));
    }
}
