package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static principal.Factura.transformarAObjeto;

public class GestionFichero {
    /**
     * Metodo que devuelve en una lista todos los pedidos no repetidos, a traves de compararlos con el metodo facturaRepetida en un for
     * que recorre toda la List facturaList
     *
     * @param fichero
     * @param facturaList
     * @return
     */
    public static List<Factura> depurarFichero(File fichero, List<Factura> facturaList) {
        Scanner sc = null;
        String registro;
        try {
            sc = new Scanner(fichero);
            while (sc.hasNext()) {
                registro = sc.nextLine();
                Factura factura = transformarAObjeto(registro);
                if (!facturaList.contains(factura)){
                    facturaList.add(factura);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return facturaList;
    }

    /**
     * Metodo que ordena y inserta la lista en un fichero, cada objeto de la lista es insertado a través de un bufferwriter y un for que reccore
     * toda la lista
     *
     * @param fichero
     * @param facturaList
     */
    public static void montarFichero(File fichero, List<Factura> facturaList) {
        Collections.sort(facturaList);
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fichero));
            for (int i = 0; i < facturaList.size(); i++) {
                bw.write(facturaList.get(i).toString());
            }
        } catch (Exception e) {

        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (Exception e) {
                    System.out.println("Error total");
                }
            }
        }
        for (int i = 0; i < facturaList.size(); i++) {
        }
    }

    /**
     * Metodo simple que lee el fichero
     * @param fichero
     */
    public static void leerFichero(File fichero) {
        Scanner sc = null;
        try {
            sc = new Scanner(fichero);
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
