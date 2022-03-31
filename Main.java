import java.util.ArrayList;

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
        return null;
    }
    

    /**
     * metodo que cree un Tree, recibe la lista de arrays con 3 strings que van 
     * a estar [ingles, espanol, frances], entonces tambien recibe el int que le dice
     * de que idioma va a ser el diccionario, o sea cual va a ser la Key de las ComparableAssociation.
     * El tree es de ComparableAssociations entonces tiene la llave del idioma que se escoge asociado
     * al array con las 3 palabras.
     */
    private static BinarySearchTree<ComparableAssociation<String, String[]>> construirDict(ArrayList<String[]> strings, int lengua) {
        
	    // for palabra in strings
        //    hacer un new ComparableAssociation<palabra[lengua], palabra>
        //    y meter este ComparableAssociation al BST con add
        
        return null;   
    }
    
    /**
     * recorrer el tree in-order eso sí no sé como se hace, toca averiguarlo
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
        // recibe archivo txt = texto
        // pregunta idioma de origen (escoge diccionario dict)
        // pregunta idioma de destino (escoge numero del array i)

        // string traducido
        // for s in texto:
        //     busca s en dict
        //         if encuentra s: append dict-s[i]
        //         else: append "*"+s+"*" 
        return null;
    }

}
