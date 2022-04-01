import org.junit.Test;
import junit.framework.TestCase;


public class Pruebas extends TestCase{
    


    @Test
    //Prueba para demostrar que funcionan el compare to de Association
    public void testCompare(){
        ComparableAssociation<String,String> ca1;
        ca1 = new ComparableAssociation<String,String>("key","aaa");
        ComparableAssociation<String,String> ca2;
        ca2 = new ComparableAssociation<String,String>("key",null);
        assertEquals(0, ca1.compareTo(ca2));

        ca1 = new ComparableAssociation<String,String>("gato","aaa");
        assertEquals(true, ca1.compareTo(ca2)<0);

        ca1 = new ComparableAssociation<String,String>("gastar","aaa");
        assertEquals(false, ca1.compareTo(ca2)>0);
    }

    @Test
    public void testAddToBST(){
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        bst.add("bota");
        bst.add("zapato");
        bst.add("concha");
        bst.add("tiro");
        assertEquals(true, bst.contains("bota"));
        assertEquals(4, bst.size());
    }

    @Test
    public void testGetAssociation(){
        BinarySearchTree<ComparableAssociation<Double, String[]>> bst;
        bst = new BinarySearchTree<ComparableAssociation<Double, String[]>>();
        for (int i = 0; i < 10; i++) {
            Double st = Math.pow(-2, i);
            String[] sts = {"a"+(i*2),"b"+(i+2)};
            ComparableAssociation<Double, String[]> a;
            a = new ComparableAssociation<Double, String[]>(st,sts);
            bst.add(a);
        }
        ComparableAssociation<Double, String[]> ca1 = new ComparableAssociation<Double,String[]>(Math.pow(-2, 6), null);
        ComparableAssociation<Double, String[]> ca2 = bst.get(ca1); 
        
        assertEquals(64.0, ca2.getKey());
        assertEquals("a12", ca2.getValue()[0]);


    }

    @Test
    public void testA(){

    }
}


// class Pruebaas {
    
//     public static void main(String[] args) {
        
    


//         BinarySearchTree<ComparableAssociation<Double, String[]>> bst;
//         bst = new BinarySearchTree<ComparableAssociation<Double, String[]>>();
//         for (int i = 0; i < 10; i++) {
//             Double st = Math.pow(-2, i);
//             String[] sts = {"a"+(i*2),"b"+(i+2)};
//             ComparableAssociation<Double, String[]> a;
//             a = new ComparableAssociation<Double, String[]>(st,sts);
//             bst.add(a);
//         }
        
//         bst.printInorder();
//         ComparableAssociation<Double, String[]> ca = new ComparableAssociation<Double,String[]>(Math.pow(-2, 4), null);
//         ComparableAssociation<Double, String[]> aaa = bst.get(ca);

//         System.out.println(aaa.getValue()[0]+"  "+aaa.getValue()[1]);


//         ComparableAssociation<Double, String[]> ca2 = new ComparableAssociation<Double,String[]>(21.0, null);
//         ComparableAssociation<Double, String[]> anotF = bst.get(ca2);
        
//         System.out.println("\n\n"+anotF+"qqq");

//         BinarySearchTree<String> bst2 = new BinarySearchTree<String>();
//         bst2.add("bota");
//         bst2.add("zapato");
//         bst2.add("concha");
//         bst2.add("tiro");
//         bst2.add("animal");
//         bst2.add("aroldo");
//         bst2.printInorder();
//     }
// }
