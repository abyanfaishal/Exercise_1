/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no3;


import java.lang.reflect.Array;
public class ChangeArrayLength {
    public static Object[][] changeLength2D(Object [][] a, int n, int m, int newLength, int newLength2){
        
        if (n> newLength){
            throw new IllegalArgumentException("Too Small");
        }
        if(m>newLength2){
            throw new IllegalArgumentException("Too Small");
        }

        Object [][] newArray = (Object [][]) Array.newInstance(a.getClass().getComponentType(), newLength, newLength2);

        newArray = (Object[][])a.clone(); 
        
        return newArray;
    }
    
    public static Object [][] changeLength2D(Object[][] a, int newLength, int newLength2){
        return changeLength2D(a, a.length, a[0].length, newLength, newLength2);
    }
}
