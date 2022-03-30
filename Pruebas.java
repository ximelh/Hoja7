public class Pruebas {
    
    public static void main(String[] args) {
        ComparableAssociation<String,String> al;
        al = new ComparableAssociation<String,String>("key","aaa");
        ComparableAssociation<String,String> b = new ComparableAssociation<String,String>("key","asdf");
        System.out.println( al.equals(b));
    


        BinarySearchTree<ComparableAssociation<Double, String[]>> bst;
        bst = new BinarySearchTree<ComparableAssociation<Double, String[]>>();
        for (int i = 0; i < 10; i++) {
            Double st = Math.pow(-2, i);
            String[] sts = {"a"+(i*2),"b"+(i+2)};
            ComparableAssociation<Double, String[]> a;
            a = new ComparableAssociation<Double, String[]>(st,sts);
            bst.add(a);
        }
        
        bst.printInorder();
        ComparableAssociation<Double, String[]> ca = new ComparableAssociation<Double,String[]>(Math.pow(-2, 4), null);
        ComparableAssociation<Double, String[]> aaa = bst.get(ca);

        System.out.println(aaa.getValue()[0]+"  "+aaa.getValue()[1]);


        ComparableAssociation<Double, String[]> ca2 = new ComparableAssociation<Double,String[]>(21.0, null);
        ComparableAssociation<Double, String[]> anotF = bst.get(ca2);
        
        System.out.println("\n\n"+anotF+"qqq");

        BinarySearchTree<String> bst2 = new BinarySearchTree<String>();
        bst2.add("bota");
        bst2.add("zapato");
        bst2.add("concha");
        bst2.add("tiro");
        bst2.add("animal");
        bst2.add("aroldo");
        bst2.printInorder();
    }
}
