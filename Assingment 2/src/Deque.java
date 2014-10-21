import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node last;
    private class Node {
           private Item item;
           private Node next;
           private Node prev;
    }
    public Deque() {  // construct an empty deque
        first = null;
        last = null;
        N = 0;
    }
    public boolean isEmpty() { // is the deque empty?
           if (first == null) {
               return true;
           }
           return false;
   }
       public int size() { // return the number of items on the deque
           return N;
       }
       public void addFirst(Item item) { // insert the item at the front
           if (item ==  null) {
               throw new NullPointerException();
           }
           Node newfirst = new Node();
           newfirst.item = item;
           newfirst.prev = null;
           newfirst.next = first;
           if (!isEmpty()) {
               first.prev = newfirst;
           }
           else {
               last = newfirst;
           }
           first = newfirst;
           N++;
       }
       public void addLast(Item item)  { // insert the item at the end
           if (item ==  null) {
               throw new NullPointerException();
           }
           Node oldlast = last;
           last = new Node();
           last.item = item;
           last.next = null;
           last.prev = oldlast;
           if (isEmpty()) {
               first = last;
           }
           else if (oldlast != null) {
              oldlast.next = last;
           }
           N++;
       }
       public Item removeFirst() { // delete and return the item at the front
           if (isEmpty()) {
               throw new NoSuchElementException("Deck underflow");
           }
           Item item = first.item;
           first = first.next;
           N--;
           if (isEmpty()) {
               last = null; //avoid loitering
           }
           else {
               first.prev = null;
           }
           return item;
       }
       public Item removeLast() { // delete and return the item at the end
           if (isEmpty()) {
            throw new NoSuchElementException("Deck underflow");
           }
           Node oldlast = last;
           Item item = last.item;
           last = oldlast.prev;
           if (last != null) {
               last.next = null;
           }
           oldlast.prev = null;
           oldlast.item = null;
           if (last == null) {
               first = null;
           }
           N--;
           return item;
       }
       public Iterator<Item> iterator() { // return an iterator over items in order from front to end //FIFO
           return new ListIterator<Item>(first);
       }
       private class ListIterator<Item> implements Iterator<Item> {
           private Node current;
           
           public ListIterator(Node first) {
               current = first;
           }
           public boolean hasNext() {
               if (current != null) {
                   return true;
               }
               return false;
           }
           public Item next() {
               if (!hasNext()) {
                   throw new NoSuchElementException();
               }
               Item item = (Item) current.item;
               current = current.next;
               return item;
           }
           public void remove() {
               throw new UnsupportedOperationException();
           }
       }
}
