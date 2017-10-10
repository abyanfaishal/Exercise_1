package no2539;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularList implements ExtendedLinearList
{
   protected ChainNode lastNode;
   protected int size;


   public CircularList(int initialCapacity){}

   public CircularList()
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

      ChainNode currentNode = lastNode.next;
      for (int i = 0; i < index; i++)
         currentNode = currentNode.next;

      return currentNode.element;
   }
   
   public int indexOf(Object elem)
   {
      if (size == 0)
         return -1;  

      ChainNode currentNode = lastNode.next;
      int index = 0;  
      while (currentNode != lastNode &&
             !currentNode.element.equals(elem))
      {
         currentNode = currentNode.next;
         index++;
      }

      if (currentNode.element.equals(elem))
         return index;
      else
         return -1;
   }
   
   public Object remove(int index)
   {
      checkIndex(index);

      Object removedElement;
      if (size == 1)
      {
         removedElement = lastNode.element;
         lastNode = null;
      }
      else
      {
         ChainNode q = lastNode;
         for (int i = 0; i < index; i++)
            q = q.next;

         if (q.next == lastNode)
            lastNode = q;

         removedElement = q.next.element;
         q.next = q.next.next;
      }
      size--;
      return removedElement;
   }
   
   public void add(int index, Object theElement)
   {
      if (index < 0 || index > size)
         throw new IndexOutOfBoundsException
                   ("index = " + index + "  size = " + size);

      if (size == 0)
      {
         lastNode = new ChainNode(theElement);
         lastNode.next = lastNode;
      }
      else
         if (index == size)
         {
            ChainNode newNode = new ChainNode(theElement, lastNode.next);
            lastNode.next = newNode;
            lastNode = newNode;
         }
         else
         {
             ChainNode p = lastNode;
             for (int i = 0; i < index; i++)
                p = p.next;
   
          
             p.next = new ChainNode(theElement, p.next);
         }
      size++;
   }
   
   public String toString()
   {
      StringBuffer s = new StringBuffer("["); 
      if (lastNode != null)
      {
         ChainNode firstNode = lastNode.next;
         s.append(firstNode.element.toString());

         ChainNode currentNode = firstNode.next;
         while(currentNode != firstNode)
         {
            s.append(", " + currentNode.element.toString());
            currentNode = currentNode.next;
         }
      }
      s.append("]");

      return new String(s);
   }

   public Iterator iterator()
      {return new CircularListIterator();}

   private class CircularListIterator implements Iterator
   {
      private ChainNode nextNode;
   
      public CircularListIterator()
      {
         if (lastNode == null)
            nextNode = null;
         else 
            nextNode = lastNode.next;
      }
   
      public boolean hasNext()
         {return nextNode != null;}
   
      public Object next()
      {
         if (nextNode != null)
         {
            Object elementToReturn = nextNode.element;
            if (nextNode == lastNode)
               nextNode = null;
            else
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
      lastNode = null;
      size = 0;
   }

   public void add(Object theElement)
   {
      ChainNode y = new ChainNode(theElement);
      if (size == 0)
         lastNode = y.next = y;
      else
      {
         y.next = lastNode.next;
         lastNode.next = y;
         lastNode = y;
      }
      size++;
   }
}