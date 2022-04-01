import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import java.io.*;


public class Main {

    public static void main(String[] args) {
        try{    
            Scanner scan = new Scanner(System.in);
            System.out.println("ENTER PARA LEER: \"diccionario.txt\"");
            ArrayList<String[]> strings = leer("diccionario.txt");
            BinarySearchTree<ComparableAssociation<String, String[]>> dictEN = construirDict(strings, 0);
            BinarySearchTree<ComparableAssociation<String, String[]>> dictES = construirDict(strings, 1);
            BinarySearchTree<ComparableAssociation<String, String[]>> dictFR = construirDict(strings, 2);
            System.out.println("ENTER PARA RECORRER IN-ORDER");
            scan.nextLine();

            recorrer(dictEN);
            
            String texto = "";
            ArrayList<String[]> text = new ArrayList<String[]>();
            String cadena;
            BinarySearchTree<ComparableAssociation<String, String[]>> DicOrigen = new BinarySearchTree<ComparableAssociation<String, String[]>>();
            int LenDestino = 0;

            System.out.println("\n\n\nBienvenido al traductor\n");
            System.out.println("Ingrese el nombre exacto del archivo de texto que desea traducir\n");
            texto =scan.nextLine();

            FileReader f = new FileReader(texto); //abre el archivo
            BufferedReader b = new BufferedReader(f); // lee el archivo
            while((cadena = b.readLine())!=null) { // Para separar con espacios
                String[] parts = cadena.split(" ");
                text.add(parts);
            }
            b.close();
            
            System.out.println("Ingrese el número que indica el idioma de origen de su archivo\n ");
            int opcion = 4;
            while (opcion > 3){
            	System.out.println("1. Ingles");
            	System.out.println("2. Español");
            	System.out.println("3. Francés");
                scan = new Scanner(System.in);
            	try{opcion = scan.nextInt();}
            	catch(Exception e){System.out.println("INVALIDO");}

            	if (opcion == 1){DicOrigen = dictEN;}
            	else if (opcion == 2){DicOrigen = dictES;} 
            	else if (opcion == 3){DicOrigen = dictFR;}
                else{ System.out.println("Agregue una entrada valida del menu");}
            }

            System.out.println("Ingrese el número que indica el idioma al que desea traducir su archivo\n ");
            int opcion2 = 4;
            while (opcion2 > 3){
            	System.out.println("1. Ingles");
            	System.out.println("2. Español");
            	System.out.println("3. Francés");
                scan = new Scanner(System.in);
            	try{opcion2 = scan.nextInt();}
            	catch(Exception e){System.out.println("INVALIDO");}

            	if (opcion2 == 1){LenDestino = 0;}
            	else if (opcion2 == 2){LenDestino = 1;} 
            	else if (opcion2 == 3){LenDestino = 2;}
                else{ System.out.println("Agregue una entrada valida del menu");}
            }

            for (String[] linea : text) {
                String trad = "";
                for (String s : linea) {
                    ComparableAssociation<String, String[]> encontrado;
                    encontrado = DicOrigen.get(new ComparableAssociation<String,String[]>(s));
                    if (Objects.isNull(encontrado)) {
                        trad = trad.concat("*"+s+"* ");
                    } else{
                        String[] valor = encontrado.getValue();
                        String t = valor[LenDestino];
                        trad = trad.concat(t+" ");
                    }
                }
                System.out.println(trad);
            }


            
            // string traducido
            // for s in texto:
            //     busca s en dict
            //         if encuentra s: concat dict-s[i]
            //         else: append "*"+s+"*" 


        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * metodo para leer diccionario.txt dict
     * para leer archivos de txt yo solo sé usar con una que se llama buffered reader
     * pero he visto que hay varias formas, lo devuelve en una lista de Strings
     * y después para cada lista hacer un split con separador de comas, para tener
     * una lista de arrays de 3 strings.
     * @throws IOException
     */
    private static ArrayList<String[]> leer(String archivo) throws IOException {
        String cadena;
        FileReader f = new FileReader(archivo); //abre el archivo
        BufferedReader b = new BufferedReader(f); // lee el archivo
        ArrayList<String[]> dic = new ArrayList<String[]>();
    
        while((cadena = b.readLine())!=null) { // Para separar en comas
            String[] parts = cadena.split(",");
            dic.add(parts);
        }
        b.close();

        return dic;
    }

    /**
     * metodo que cree un Tree, recibe la lista de arrays con 3 strings que van 
     * a estar [ingles, espanol, frances], entonces tambien recibe el int que le dice
     * de que idioma va a ser el diccionario, o sea cual va a ser la Key de las ComparableAssociation.
     * El tree es de ComparableAssociations entonces tiene la llave del idioma que se escoge asociado
     * al array con las 3 palabras.
     */
    private static BinarySearchTree<ComparableAssociation<String, String[]>> construirDict(ArrayList<String[]> strings, int lengua) {
        BinarySearchTree<ComparableAssociation<String, String[]>> bst;
        bst = new BinarySearchTree<ComparableAssociation<String, String[]>>();
        for (String[] p : strings) {
            ComparableAssociation<String, String[]> a;
            a = new ComparableAssociation<String, String[]>(p[lengua],p);
            bst.add(a);
         }         
        return bst;   
    }
    
    /**
     * recorrer el tree in-order eso sí no sé como se hace, toca averiguarlo
     */
    private static void recorrer(BinarySearchTree<ComparableAssociation<String, String[]>> dict) {
        dict.printInorder();
    }
}
