/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no3;


public class Main {
    public static void main(String[] args) {
        
        Object [][] data ={
            {"Abyan"  ,"1998" ,"Laki"     }, // baris ke-0
            {"Devi"   ,"2009" ,"Perempuan"     }, // baris ke-1
            {"Bella"  ,"2002" ,"Laki"     }, // baris ke-2
            {"Ary"    ,"1995" ,"Laki"     }, // baris ke-3
        };
        
        Object[][] ganti = ChangeArrayLength.changeLength2D(data, 9, 3);
        
        System.out.println("Length 1 : "+ganti.length);
        System.out.println("Length 2 : "+ganti[0].length);
        System.out.println("");
        
        for(Object[] ganti2 : ganti){
            for(int i = 0; i<ganti[0].length; i++){
                System.out.println(ganti2[i]);
            }
            System.out.println();
        }
    }
}

