/*
 * File: EJQIndexedList.java
 */

package ejqstructures;

import java.util.Iterator;
import zhstructures.*;

/**
 * Interface for a list accessed by element index (0 .. size-1). 
 * Represents a simplified ArrayList
 * 
 * @author  Erin Queme
 * @version March 20, 2017
 * 
 * @param   ElementType the type of elements in this list
 */
public class EJQLinkedIndexedList<ElementType>
  implements ZHIndexedList<ElementType> 
{
  
  /**
   * The number of elements in this stack.
   */
  protected int size;
  
  /**
   * A reference to the first node of the list.
   */
  protected ListNode firstNode;
  
  public EJQLinkedIndexedList()
  {
    this.size = 0;
    this.firstNode = new ListNode();
  }
  
  /* 
   * Returns <code>true</code> if this collection contains no elements.
   * 
   * @return <code>true</code> if this collection contains no elements
   */
  public boolean isEmpty()
  {
    if(this.size == 0)
      return true;
    return false;
  }
  
  /* 
   * Returns <code>true</code> if this collection contains the specified
   * element, that is, if it contains an element equal to the specified
   * element under the <code>equals</code> method or <code>null</code>
   * if the specified element is <code>null</code>.
   * Note that unlike the Java Collection interface, only elements
   * matching the template type may be tested.
   * 
   * @param  element the object to test for presence in this collection
   * @return true if this collection contains the specified element
   */
  public boolean contains(ElementType element)
  {
    if(this.firstNode.contains(element))
    {
      return true;
    }
    return false;
  }
  
  /* 
   * Returns an Iterator over the elements of this collection.
   * The Iterator must be defined to return each element in the
   * collection exactly once.
   * 
   * @return an Iterator over the elements of this collection
   */
  public Iterator<ElementType> iterator()
  {
    return this.firstNode.iterator();
  }
  
  /**
   * Returns the number of elements in this list.
   * 
   * @return the number of elements in this list
   */
  public int size()
  {
    return this.size;
  }
  
  
  /**
   * Gets the element at the specified index in the list (0 .. size-1).
   * 
   * @param  index the position to get the element from (0 .. size-1)
   * @return the element at the specified index
   * @throws IndexOutOfBoundsException if <code>index &lt; 0</code> or
   *                                      <code>index &ge; this.size()</code>
   */
  public ElementType get(int index)
  {
    if(index < 0 || index >= this.size())
    {
      throw new IndexOutOfBoundsException("Index is either less than 0 or index is greater than size.");
    }
    return this.firstNode.get(index);
  }
  
  /**
   * Sets the element at the specified index in the list (0 .. size-1)
   * to the specified new value and returns the previous value.
   *
   * @param  index    the position to set the element from (0 .. size-1)
   * @param  newValue the new value to put at the specified position
   * @return the old value at the specified position
   * @throws IndexOutOfBoundsException if <code>index &lt; 0</code> or
   *                                      <code>index &ge; this.size()</code>
   */
  public ElementType set(int index, ElementType newValue)
  {
    if(index < 0 || index >= this.size())
    {
      throw new IndexOutOfBoundsException("Index is either less than 0 or index is greater than size.");
    }
    return this.firstNode.set(index,newValue);
  }
  
  /**
   * Inserts the specified element at the specified index (0 .. size)
   * and increments the indices of any remaining elements. An index of 0
   * inserts the element at the beginning of the list; an index of size
   * appends the element to the list.
   * 
   * @param  index   the position at which to insert the element (0 .. size)
   * @param  element the element to be inserted
   * @throws IndexOutOfBoundsException if <code>index &lt; 0</code> or
   *                                      <code>index &gt; this.size()</code>
   */
  public void addElementAt(int index, ElementType element)
  {
    if(index < 0 || index > this.size())
    {
      throw new IndexOutOfBoundsException("Index is either less than 0 or index is greater than size.");
    }
    this.firstNode.addElementAt(index,element);
  }
  
  /**
   * Removes and returns the element at the specified index (0 .. size-1)
   * in the list and decrements the index of any following elements.
   * 
   * @param  index the position from which to remove the element
   *               (0 .. size-1)
   * @return the element removed from the specified position
   * @throws IndexOutOfBoundsException if <code>index &lt; 0</code> or
   *                                      <code>index &ge; this.size()</code>
   */
  public ElementType removeElementAt(int index)
  {
    if(index < 0 || index >= this.size())
    {
      throw new IndexOutOfBoundsException("Index is either less than 0 or index is greater than size.");
    }
    return this.firstNode.removeElementAt(index);
  }
  
  /**
   * Returns the lowest index at which the specified element is found
   * in the list (0 .. size-1) or -1 if the element is not present. 
   * Same as indexOf method in class ArrayList
   * 
   * @param  element the element to be searched for
   * @return the lowest index at which the specified element is found
   *         in the list (0 .. size-1) or -1 if the element is not present
   */
  public int indexOf(ElementType element)
  {
    return firstNode.indexOf(0, element);
  }
  
  /**
   * Returns the highest (i.e. last) index at which the specified element
   * is found in the list (0 .. size-1) or -1 if the element is not present.
   * 
   * @param  element the element to be searched for
   * @return the highest index at which the specified element is found
   *         in the list (0 .. size-1) or -1 if the element is not present
   */ 
  public int lastIndexOf(ElementType element)
  {
    return firstNode.lastIndexOf(0, -1, element);
  }
  
  /** 
   * Returns a list containing the portion of this list between
   * the specified <code>fromIndex</code>, inclusive,
   * and <code>toIndex</code>, exclusive.
   * That is, it copies the elements start at position <code>fromIndex</code>
   * and ending at position <code>toIndex - 1</code> into a new list.
   * (If <code>fromIndex</code> and <code>toIndex</code> are equal,
   * the returned list is empty.)
   * 
   * Pre: fromIndex &gte; 0  and fromIndex &le; toIndex and toIndex &le; size
   * 
   * @param  fromIndex low endpoint (inclusive) of the subList
   * @param  toIndex   high endpoint (exclusive) of the subList
   * @return an indexed list containing the elements in the specified range
   *         from within this list
   * @throws IndexOutOfBoundsException if precondition is false
   */
  public EJQLinkedIndexedList<ElementType> subList(int fromIndex, int toIndex)
  {
    EJQLinkedIndexedList<ElementType> returnList = new EJQLinkedIndexedList<ElementType>();
    if (fromIndex < 0 || fromIndex > toIndex || toIndex > size)
      throw new IndexOutOfBoundsException("Invalid indexes");
    for (int i = fromIndex; i < toIndex; i++)
      returnList.addElementAt(i-fromIndex,this.get(i));
    return returnList;
  }
  
  /*
   * Inner Class List Node
   */
  protected class ListNode extends ZHOneWayListNode<ElementType, ListNode> 
  {
    
    /**
     * Creates a new empty node.
     */
    protected ListNode() {
      super();
    }
    
    /**
     * Creates a new node with the specified data element and next node.
     * 
     * @param element the data element for the new node
     * @param next the next node for the new node
     */
    protected ListNode(ElementType element, ListNode next) {
      super(element, next);
    }
    
    /**
     * Gets the specific element from a node at the desired index
     * 
     * @param index the position of the element
     * @return ElementType the specific element in the node.
     */
    protected ElementType get(int index) 
    {
      if(index == 0)
      {
        return this.getElement();
      }
      return this.getNext().get(index-1);
    }
    
    /**
     * Sets the element at the specified index in the list (0 .. size-1)
     * to the specified new value and returns the previous value.
     *
     * @param  index    the position to set the element from (0 .. size-1)
     * @param  newValue the new value to put at the specified position
     * @return the old value at the specified position
     */
    protected ElementType set(int index, ElementType newValue)
    {
      if(index == 0)
      {
        ElementType temp = this.getElement();
        this.setElement(newValue);
        return temp;
      }
      return this.getNext().set(index-1,newValue);
    }
    
    /**
     * Inserts the specified element at the specified index (0 .. size)
     * and increments the indices of any remaining elements. An index of 0
     * inserts the element at the beginning of the list; an index of size
     * appends the element to the list.
     * 
     * @param  index   the position at which to insert the element (0 .. size)
     * @param  element the element to be inserted
     */
    protected void addElementAt(int index, ElementType element)
    {
      if(index==0)
      {
//        System.out.println("Current Element of the node: "+this.getElement());
//        System.out.println("Current Next Node: "+this.getNext());
//        System.out.println("*************************************************************************");
        
        ListNode newNode = new ListNode(this.getElement(),this.getNext());
        
//        System.out.println("New Node element: " + newNode.getElement());
//        System.out.println("New Node's next Node: " + newNode.getNext());
//        System.out.println("*************************************************************************");
        
        this.setElement(element);
        this.setNext(newNode);
        
//        System.out.println("Current Node's Element should be changed from null to 10: "+this.getElement());
//        System.out.println("Current Next Node should change: "+this.getNext());
//        
//        System.out.println("*************************************************************************");
        
        size++;
      }
      else
      {
        this.getNext().addElementAt(index-1,element);
      }
    }
    
    /**
     * Removes and returns the element at the specified index (0 .. size-1)
     * in the list and decrements the index of any following elements.
     * 
     * @param  index the position from which to remove the element
     *               (0 .. size-1)
     * @return the element removed from the specified position
     */
    protected ElementType removeElementAt(int index)
    {
      if(index==0)
      {
        ElementType temp = this.getElement();
        this.setElement(this.getNext().getElement());
        this.setNext(this.getNext().getNext());
        size--;
        return temp;
      }
      else if(index==1)
      {
        ElementType temp = this.getNext().getElement();
        this.setNext(this.getNext().getNext());
        size--;
        return temp;
      }
      return this.getNext().removeElementAt(index-1);
    }
    
    /**
     * Searches for parameter element starting at a given index in the
     * list and returns index of first match or -1 if no match is found.
     *
     * @param index to identify where to start the search, which is the current location in the list
     * @param element what we’re searching for
     * @return index of first occurrence of the element searched for or -1 if the element is not in list
     */
    protected int indexOf(int index, ElementType element)
    {
      if(index == size)
      {
        return -1;
      }
      else if(this.getElement().equals(element))
      {
        return index;
      }
      else
      {
        return this.getNext().indexOf(index+1, element);
      }
    }
    
    /**
     * Searches for parameter element starting at a given index in the
     * list and returns index of last match or -1 if no match is found.
     *
     * @param index to identify where to start the search, which is the current location in the list
     * @param indexOfLastMatch the last position where we found a match or -1 if we haven’t found a match yet
     * @param element what we’re searching for
     * @return index of last occurrence of the element searched for or -1 if the element is not in list
     */
    protected int lastIndexOf(int index, int indexOfLastMatch, ElementType element)
    {
      if (index == size)
        return indexOfLastMatch;
      else if (this.getElement().equals(element))
        indexOfLastMatch = index;
      return this.getNext().lastIndexOf(index+1,indexOfLastMatch,element);
    }
    
  }
}
