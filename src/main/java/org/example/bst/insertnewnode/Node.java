package org.example.bst.insertnewnode;

public class Node {
     Node left;
     Node right;
     int data;

    public Node(int data){
        this.data = data;
    }

    public void insert(int value){
        if(value <= data){
            if(left == null){
                left = new Node(value);
            }else{
                insert(value);
            }
        }else{
            if(right == null){
                right = new Node(value);
            }else{
                insert(value);
            }
        }
    }

    public boolean contains(int value){
        if(value == data){
            return true;
        }else if(value < data){
            if(left == null){
                return false;
            }else{
                return left.contains(value);
            }
        }else{
            if(right == null){
                return false;
            }else{
                return right.contains(value);
            }
        }
    }

    //In order traversal left -> curr -> right

    public void printInOrder(){
        if(left != null){
            left.printInOrder();
        }
        System.out.println(data);
        if(right != null){
            right.printInOrder();
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.insert(2);
        System.out.println(node.contains(2));
        node.printInOrder();
    }
}


