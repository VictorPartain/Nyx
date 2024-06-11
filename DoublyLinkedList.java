/**
 * @author Victor Partain
 * Professor: Ahn Nuzen
 * Class: Java 294
 * Assignment: PE 3.6.4
 * Represents a doubly linked list.
 *
 * @param <E> the type of elements in the list
 */
/**
 * Represents a doubly linked list.s
 * @param <E> the type of elements in the list
 */
public class DoublyLinkedList<E> {

    // Instance variables of DoublyLinkedList
    private Node<E> head = null;                // head node of the list (or null if empty)
    private Node<E> tail = null;                // last node of the list (or null if empty)
    private int size = 0;                       // number of nodes in the list

    /**
     * Constructs an initially empty list.
     */
    public DoublyLinkedList() {

    }

    /**
     * Returns the number of nodes in the list.
     *
     * @return the number of nodes in the list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the first element in the list without removing it.
     *
     * @return the first element in the list, or null if the list is empty
     */
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    /**
     * Returns the last element in the list without removing it.
     *
     * @return the last element in the list, or null if the list is empty
     */
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param e the element to add
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, head, null);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.setPrev(newNode);
        }
        head = newNode;
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the element to add
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, null, tail);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    /**
     * Removes and returns the first element in the list.
     *
     * @return the first element in the list, or null if the list is empty
     */
    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }
        size--;
        return answer;
    }

    /**
     * Adds an element after a specified element in the list.
     *
     * @param elementToInsertAfter the element after which the new element will be inserted
     * @param elementToInsert the element to insert
     */
    public void addAfter(E elementToInsertAfter, E elementToInsert) {
        Node<E> current = head;
        while (current != null && !current.getElement().equals(elementToInsertAfter)) {
            current = current.getNext();
        }

        if (current != null) {
            Node<E> newNode = new Node<>(elementToInsert, current.getNext(), current);
            if (current.getNext() != null) {
                current.getNext().setPrev(newNode);
            } else {
                tail = newNode;
            }
            current.setNext(newNode);
            size++;
        }
    }

    /**
     * Returns a string representation of the linked list.
     *
     * @return a string representation of the linked list
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            result.append(current.getElement());
            if (current.getNext() != null) {
                result.append(", ");
            }
            current = current.getNext();
        }
        result.append("]");
        return result.toString();
    }
}