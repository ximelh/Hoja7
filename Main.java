import java.util.ArrayList;
import java.io.*;
import java.io.FileReader;
import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) {
        System.out.println("LEER ARCHIVO");
        ArrayList<String[]> strings = leer("diccionario.txt");
        System.out.println("CONSTRUIR LOS DICCIONARIOS");
        BinarySearchTree<ComparableAssociation<String, String[]>> dictEN = construirDict(strings, 0);
        BinarySearchTree<ComparableAssociation<String, String[]>> dictES = construirDict(strings, 1);
        BinarySearchTree<ComparableAssociation<String, String[]>> dictFR = construirDict(strings, 2);
        System.out.println("RECORRER IN-ORDER");
        recorrer(dictEN);
    }

    /**
     * metodo para leer diccionario.txt dict
     * para leer archivos de txt yo solo sé usar con una que se llama buffered reader
     * pero he visto que hay varias formas, lo devuelve en una lista de Strings
     * y después para cada lista hacer un split con separador de comas, para tener
     * una lista de arrays de 3 strings.
     */
    private static ArrayList<String[]> leer(String archivo) {
        String cadena;
        FileReader f = new FileReader("diccionario.txt"); //abre el archivo
        BufferedReader b = new BufferedReader(f); // lee el archivo
    
        while((cadena = b.readLine())!=null) { // Para separar en comas
            String[] parts = cadena.split(",");
            Ingrediente ing = new Ingrediente(); // Crea arraylist???
            ing.setCantidadNutrientes(Double.parseDouble(parts[0]));
            ing.setCoste(Double.parseDouble(parts[1]));
        }
        b.close();
    }
    

    /**
     * metodo que cree un Tree, recibe la lista de arrays con 3 strings que van 
     * a estar [ingles, espanol, frances], entonces tambien recibe el int que le dice
     * de que idioma va a ser el diccionario, o sea cual va a ser la Key de las ComparableAssociation.
     * El tree es de ComparableAssociations entonces tiene la llave del idioma que se escoge asociado
     * al array con las 3 palabras.
     * 
     * NO SE
     */
    private static BinarySearchTree<ComparableAssociation<String, String[]>> construirDict(ArrayList<String[]> strings, int lengua) {
        
	    // for palabra in strings
        //    hacer un new ComparableAssociation<palabra[lengua], palabra>
        //    y meter este ComparableAssociation al BST con add
        
        return null;   
    }
    
    /**
     * recorrer el tree in-order eso sí no sé como se hace, toca averiguarlo
     * 
     * NO SE
     */
    private static void recorrer(BinarySearchTree<ComparableAssociation<String, String[]>> dict) {
        
    }

    /**
     * Devuelve el string traducido, recibe como parametros el archivo de texto (o el texto),
     * el diccionario que va a usar segun idioma de origen, y int de idioma de destino para 
     * sacar de los arrays.
     * 
     */
    private static String traducir() { 
        // recibe archivo txt = texto (No se como)



        System.out.println("Bienvenido a la calculadora infix\n");
        //iniciar variables de apoyo
        boolean valida1 = false;
        String tipoStack = "";
        String tipoList = "";

        //obtener el tipo de stack, y si es list el tipo de list
        while(!valida1){
            System.out.println("Escriba el tipo de stack que quiere:\n1. Escriba AL si quiere con arraylist\n2. Escriba VE si quiere con vector\n3. Escriba LI si quiere con lista\n");
            tipoStack=scan.nextLine();
            if (tipoStack.equalsIgnoreCase("Al")){
                valida1=true;
            } else if (tipoStack.equalsIgnoreCase("VE")){
                valida1=true;
            } else if (tipoStack.equalsIgnoreCase("LI")){
                boolean valida2 = false;
                while(!valida2){
                    System.out.println("Escriba el tipo de lista que quiere:\n1. Escriba S si quiere simple\n2. Escriba D si quiere doble\n");
                    tipoList=scan.nextLine();
                    if (tipoList.equalsIgnoreCase("S")){
                        valida2=true;
                    } else if (tipoList.equalsIgnoreCase("D")){
                        valida2=true;
                    } else{
                        System.out.println("\nIngrese una opcion valida\n");
                    }
                }
                valida1=true;
            } else{
                System.out.println("\nIngrese una opcion valida\n");
            }

            
        // pregunta idioma de origen (escoge diccionario dict)
        // pregunta idioma de destino (escoge numero del array i)

        // string traducido (No se)
        // for s in texto:
        //     busca s en dict
        //         if encuentra s: append dict-s[i]
        //         else: append "*"+s+"*" 
        return null;
    }

}
