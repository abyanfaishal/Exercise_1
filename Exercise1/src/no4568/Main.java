/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no4568;



public class Main {
    public static void main(String[] args) {
        ArrayLinearList x = new ArrayLinearList(16);
        Object[] b = new Object[20];
        
        
        System.out.println("Ukuran awal Array   : " +x.element.length);
        System.out.println("isEmpty : " +x.isEmpty());
        
        x.add(0, "a");
        x.add(1, "b");
        x.add(2, "c");
        x.add(3, 1);
        x.add(4, 2);
        x.add(5, 3);
        x.add(6, "g");
        x.add(7, "h");
        
        System.out.println("\nIsi awal Array      : " +x.toString());
        System.out.println("Array yang terisi     : " +x.size());
        System.out.println("Element di index ke-3: " +x.get(3));
        System.out.println("Index element c   : " +x.indexOf("c"));
        x.remove(2);
        System.out.println("\nIsi setelah index ke-2 dihapus    : " +x.toString());
        System.out.println("Isi index ke-2 setelah dihapus    : " +x.get(2));
        x.add(2, "f");
        System.out.println("Isi index ke-2 setelah ditambah   : " +x.get(2));
        System.out.println("Isi setelah index ke-2 ditambah   : " +x.toString());
        
        x.add(8, 4);
        x.add(9, 5);
        x.add(10, 6);
        
        System.out.println("\nIsi setelah ditambah 3 Array baru : " +x.toString());
        
        System.out.println("Setelah di clone ke Object F   : " +x.clone(b));
        //System.out.println(x.size);
        x.removeRange(1, 3);
        System.out.println("\nIsi setelah element 1 - 3 dihapus : " +x.toString());
        System.out.println("Jumlah Array sebelum dipotong     : " +x.element.length);
        x.trimToSize();
        System.out.println("Jumlah Array setelah dipotong     : " +x.element.length);
        x.setSize(5);
        System.out.println("Isi Array setelah di setSize 5    : " +x.toString());
        x.clear();
        System.out.println("Isi Array setelah di clear        : " +x.toString());
        
        
    }
}
