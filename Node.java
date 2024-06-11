/**
 * @author Victor Partain
 * Professor: Ahn Nuzen
 * Class: Java 294
 * Assignment: PE_3.6.4
 * Represents a node in a doubly linked list.
 * @param <E> the type of element stored in the node
 */
class Node<E> {
    private E element;               // reference to the element stored at this node
    private Node<E> next;            // reference to the subsequent node in the list
    private Node<E> prev;            // reference to the previous node in the list

    /**
     * Constructs a node with the given element, next node, and previous node.
     * @param e the element to store in the node
     * @param n the next node in the list
     * @param p the previous node in the list
     */
    public Node(E e, Node<E> n, Node<E> p) {
        this.element = e;
        this.next = n;
        this.prev = p;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setNext(Node<E> n) {
        this.next = n;
    }

    public void setPrev(Node<E> p) {
        this.prev = p;
    }
}