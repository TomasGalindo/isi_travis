package org.urjc.isi.travis;
// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 3; page ??
// See MinTest.java for JUnit tests.
// See DataDrivenMinTest.java for JUnit tests. (Instructor only)

import java.util.*;

public class Min
{
  /**
    * Returns the mininum element in a list
    * @param list Comparable list of elements to search
    * @return the minimum element in the list
    * @throws NullPointerException if list is null or
    *         if any list elements are null
    * @throws ClassCastException if list elements are not mutually comparable
    * @throws IllegalArgumentException if list is empty
    */

    //funcion min, argumento list que sea una lista que extienda T o cualquiera de sus clases heredadas
    //T extiende la interfaz comparable, <? super T>> esto hace que fuerce que lo que devuelva sea una lista que exienda la interfaz comparable y sea T o venga de T
    public static <T extends Comparable<? super T>> T min (List<? extends T> list)
    {
       if (list.size() == 0)
       {
          throw new IllegalArgumentException ("Min.min");
       }

       Iterator<? extends T> itr = list.iterator();
       T result = itr.next();

       if(result == null) // Modificacion para que el Test testForSoloNullElement no detecte fallo en codigo
       {
         throw new NullPointerException ("Min.min");
       }

       while (itr.hasNext())
       {
           T comp = itr.next();
           if (comp.compareTo (result) < 0)  // throws NPE, CCE as needed
           {
               result = comp;
           }
       }
       return result;
    }
}