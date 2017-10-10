package no2539;

class DoubleNode
{
   Object element;
   DoubleNode next;
   DoubleNode previous;

   DoubleNode() {}
     
   DoubleNode(Object theElement)
      {element = theElement;}

   DoubleNode(Object theElement, DoubleNode thePrevious, DoubleNode theNext)
   {
       element = theElement;
       previous = thePrevious;
       next = theNext;
   }
}

