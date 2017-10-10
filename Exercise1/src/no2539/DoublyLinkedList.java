package no2539;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList implements ExtendedLinearList
{
   protected DoubleNode firstNode;
   protected DoubleNode lastNode;
   protected int size;

   public DoublyLinkedList(int initialCapacity){}

   public DoublyLinkedList()
      {this(0);}

   public boolean isEmpty()
       {return size == 0;}

   public int size()
      {return size;}

   void checkIndex(int index)
   {
      if (index < 0 || index >= size)
         throw new IndexOutOfBoundsException
             ("index = " + index + "  size = " + size);
   }

   public Object get(int index)
   {
      checkIndex(index);

      DoubleNode currentNode;

      if (index < size / 2)
      {
         currentNode = firstNode;
         for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
      }
      else
      {
         currentNode = lastNode;
         int numberToMove = size - index - 1;
         for (int i = 0; i < numberToMove; i++)
            currentNode = currentNode.previous;
      }

      return currentNode.element;
   }
   
   public int indexOf(Object elem)
   {
      DoubleNode currentNode = firstNode;
      int index = 0;  
      while (currentNode != null &&
             !currentNode.element.equals(elem))
      {
         currentNode = currentNode.next;
         index++;
      }

      if (currentNode == null)
         return -1;
      else
         return index;
   }
   
   public Object remove(int index)
   {
      checkIndex(index);

      DoubleNode currentNode;  
      
      if (index < size / 2)
      {
         currentNode = firstNode;
         for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
      }
      else
      {
         currentNode = lastNode;
         int numberToMove = size - index - 1;
         for (int i = 0; i < numberToMove; i++)
            currentNode = currentNode.previous;
      }

      if (size == 1)  
         firstNode = null;
      else            
         if (index == 0)
         {
            firstNode = firstNode.next;
            firstNode.previous = null;
         }
         else
            if (index == size - 1)
            {
               lastNode = lastNode.previous;
               lastNode.next = null;
            }
            else
            {
               currentNode.previous.next = currentNode.next;
               currentNode.next.previous = currentNode.previous;
            }
      size--;
      return currentNode.element;
   }
   
   public void add(int index, Object theElement)
   {
      if (index < 0 || index > size)   
         throw new IndexOutOfBoundsException
                   ("index = " + index + "  size = " + size);

      if (index == 0)
      {
         firstNode = new DoubleNode(theElement, null, firstNode);
         if (firstNode.next == null)       
            lastNode = firstNode;
         else
            firstNode.next.previous = firstNode;
      }
      else
         if (index == size)
         {
            lastNode.next = new DoubleNode(theElement, lastNode, null);
            lastNode = lastNode.next;
         }
         else
         {
            DoubleNode currentNode;
            if (index <= size / 2)
            {
               currentNode = firstNode;
               for (int i = 0; i < index - 1; i++)
                  currentNode = currentNode.next;
            }
            else
            {
               currentNode = lastNode;
               int numberToMove = size - index;
               for (int i = 0; i < numberToMove; i++)
                  currentNode = currentNode.previous;
            }

            currentNode.next =
                   new DoubleNode(theElement, currentNode, currentNode.next);
            currentNode.next.next.previous = currentNode.next;
      }
      size++;
   }
   
   public String toString()
   {
      StringBuffer s = new StringBuffer("["); 
      if (size != 0)
      {
         s.append(firstNode.element.toString());
         DoubleNode currentNode = firstNode.next;
         while (currentNode != null)
         {
            s.append(", " + currentNode.element.toString());
            currentNode = currentNode.next;
         }
      }
      s.append("]");

      return new String(s);
   }

   public Iterator iterator()
      {return new DoubleIterator();}

   private class DoubleIterator implements Iterator
   {
      private DoubleNode nextNode;
   
      public DoubleIterator()
         {nextNode = firstNode;}
   
      public boolean hasNext()
         {return nextNode != null;}
   
      public Object next()
      {
         if (nextNode != null)
         {
            Object elementToReturn = nextNode.element;
            nextNode = nextNode.next;
            return elementToReturn;
         }
         else throw new NoSuchElementException("No next element");
      }

      public void remove()
      {
         throw new UnsupportedOperationException
                   ("remove not supported");
      }   
   }
   
   public void clear()
   {
      firstNode = null;
      size = 0;
   }

   public void add(Object theElement)
   {
      DoubleNode newNode = new DoubleNode(theElement, lastNode, null);
      if (size == 0)
      {
         firstNode = lastNode = newNode;
         firstNode.previous = null;
      }
      else
      {
          lastNode.next = newNode;
          newNode.previous = lastNode;
          lastNode = newNode;
      }
      size++;
   }
}