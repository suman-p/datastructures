package com.physical.datastructures;

public class SingleLinkedList<T> {

    private SingleNode<T> head;
    private SingleNode<T> tail;
    private int size;

    public SingleNode<T> getHead() {
        return head;
    }

    public void setHead(SingleNode<T> head) {
        this.head = head;
    }

    public SingleNode<T> getTail() {
        return tail;
    }

    public void setTail(SingleNode<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean linkedListExists(){
        return head != null;
    }

    public void insert(T nodeValue, int location){
        SingleNode<T> node = new SingleNode<>();
        node.setValue(nodeValue);
        if(!linkedListExists()){
            node.setValue(nodeValue);
            node.setNext(null);
            head = node;
            tail = node;
        }
        else if (location == 0){
            //insert at first position
            node.setNext(head);
            head = node;
        }
        else if (location >= size){
            //insert at last position
            node.setNext(null);
            tail.setNext(node);
            tail=node;
        }
        else{
            //insert at specified location
            SingleNode<T> tempNode = head;
            int index = 0;
            while (index < location - 1) {
                // loop till we reach specified node
                tempNode = tempNode.getNext();
                index++;
            }//tempNode currently references to node after which we should insert new node
            SingleNode<T> nextNode = tempNode.getNext(); //this is the immediate next node after new node
            tempNode.setNext(node);//update reference of tempNode to reference to new node
            node.setNext(nextNode);//update newly added nodes' next
        }
        setSize(getSize() + 1);
    }

    public void deleteLinkedList(){
        head=null;
        tail=null;
    }

    public void delete(int location){
        if (!linkedListExists()) {
            System.out.println("Linked list does not exist!!");// Linked List does not exists
        } else if (location == 0) { // we want to delete first element
            head = head.getNext();
            setSize(getSize()-1);
            if(getSize() == 0) { // if there are no more nodes in this list
                tail = null;
            }
        }else if (location >= getSize()){ //If location is not in range or equal, then delete last node
            SingleNode<T> tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.getNext(); //temp node points to 2nd last node
            }
            if (tempNode == head) { //if this is the only element in the list
                tail = head = null;
                setSize(getSize()-1);
                return;
            }
            tempNode.setNext(null);
            tail= tempNode;
            setSize(getSize()-1);
        }else { //if any inside node is to be deleted
            SingleNode<T> tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext(); // we need to traverse till we find the location
            }
            tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
            setSize(getSize()-1);
        }//end of else
    }

    //Searches a node with given value
    public boolean searchNode(T nodeValue) {
        if(linkedListExists()){
            SingleNode<T> tempNode = head;
            for(int i=0;i<getSize();i++){
                if (tempNode.getValue() == nodeValue)
                    return true;
                else
                    tempNode = tempNode.getNext();
            }
        }
        return false;
    }

    //Traverse through Linked List
    public void traverseLinkedList() {
        if (linkedListExists()) {
            SingleNode<T> tempNode = head;
            for(int i=0;i<getSize();i++){
                System.out.println(tempNode.getValue());
                tempNode = tempNode.getNext();
            }
        }
        else{
            System.out.println("Linked List does not exist");
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Object> list = new SingleLinkedList<Object>();
        list.insert("Jack", 0);
        list.insert("Jill", 1);
        list.traverseLinkedList();

        list.insert(10, 1);
        list.traverseLinkedList();

        list.insert(20, 2);
        list.traverseLinkedList();

        list.insert(30, 2);
        list.traverseLinkedList();

        list.insert(40, 1);
        list.traverseLinkedList();

        list.traverseLinkedList();

        list.searchNode(40);

        System.out.println("\nSearching the node having value 500...");
        list.searchNode(500);


        System.out.println("\n\nDeleting the node having location = 0: ");
        System.out.println("Before Deletion:");
        list.traverseLinkedList();
        list.delete(0);
        System.out.println("After Deletion:");
        list.traverseLinkedList();
        System.out.println();

        System.out.println("\n\nDeleting the node having location = 2: ");
        System.out.println("Before Deletion:");
        list.traverseLinkedList();
        list.delete(2);
        System.out.println("After Deletion:");
        list.traverseLinkedList();
        System.out.println();


        System.out.println("\n\nDeleting the node having location = 100: ");
        System.out.println("Before Deletion:");
        list.traverseLinkedList();
        list.delete(100);
        System.out.println("After Deletion:");
        list.traverseLinkedList();
        System.out.println();


        list.deleteLinkedList();
        list.traverseLinkedList();

    }
}

