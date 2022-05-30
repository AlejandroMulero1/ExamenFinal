package principal;

import java.util.Arrays;
import java.util.Objects;

public class Factura implements Comparable<Factura> {
    private String cif;
    private String nombreEmp;
    private String fechaEnvio;
    private String codEnvio;
    private String[] conceptosFactura= new String[3]; /*Al ser un registro de este array mezcla de cadena y enteros, declararemos este array
                                        como un array de cadenas y castearemos a enteros cuando necesitemos el valor numerico de algun registro
                                        */

    /**
     * Este constructor llamara a los setters en vez de asignar directamente un valor para asegurarnos de que se cumplen las restricciones en las variables
     * impuestas por el hospital
     * @param cif
     * @param nombreEmp
     * @param fechaEnvio
     * @param codEnvio
     * @param conceptosFactura
     */
    public Factura(String cif, String nombreEmp, String fechaEnvio, String codEnvio, String[] conceptosFactura){
        setCif(cif);
        this.nombreEmp=nombreEmp;
        setFechaEnvio(fechaEnvio);
        setCodEnvio(codEnvio);
        setConceptosFactura(conceptosFactura);
    }

    /**
     * Metodo que identificara si dos facturas son identicas a traves de un if que compare sus atributos principales
     * @param that
     * @return
     */
    public boolean facturaRepetida(Factura that){
        boolean estaRepetida=false;
        if (this.cif.equals(that.cif) && this.fechaEnvio.equals(that.fechaEnvio) && this.codEnvio.equals(that.codEnvio))
            estaRepetida=true;

        return estaRepetida;
    }

    /**
     * Metodo que leera un registro del fichero y lo transformara en un objeto Factura a través del split de este registro, la estructura de este metodo
     * esta estrictamente ligada a la estructura de los datos del fichero de entrada, debido a eso, si se modifica el formato de insercion en el fichero de entrada
     * el metodo no insertara correctamente
     * @param registro
     * @return
     */
    public static Factura transformarAObjeto(String registro){
        String [] parte=registro.split(",");
        Factura factura=new Factura(parte[0], parte[1], parte[2], parte[3], new String[]{parte[4], parte[5], parte[6]});
    return factura;
    }

    /**
     * Overray al compareTo de java para que al comparar dos facturas solamente las compare por el cif
     * @param that
     * @return
     */
    @Override
    public int compareTo(Factura that) {
        int valor=-1;

        if (this.cif.equals(that.cif) && this.codEnvio.equals(that.codEnvio) && this.fechaEnvio.equals(that.fechaEnvio))
            valor=0;

        if (this.cif.compareTo(that.cif)>0 && this.codEnvio.compareTo(that.codEnvio)>0 && this.fechaEnvio.compareTo(that.fechaEnvio)>0)
            valor=1;

        return valor;
    }


    /**
     * Como el tamaño maximo del CIF es 9, este set regulara a traves de un truncamiento que el cif que se introduzca en el objeto no
     * sobrepase el tamaño maximo a traves del metodo substring, el cual si llega a ser llamado seleccionara la parte del CIF que va desde la
     * posicion 0 a la 8 (tamaño 9)
     * @param cif
     */
    public void setCif(String cif) {
        if (cif.length()>9)
            cif=cif.substring(0,8);
        this.cif = cif;
    }

    /**
     * Como el tamaño maximo de la fechaEnvio es 8, este set regulara a traves de un truncamiento que la fechaEnvio que se introduzca en el objeto no
     * sobrepase el tamaño maximo a traves del metodo substring, el cual si llega a ser llamado seleccionara la parte de la fechaEnvio que va desde la
     * posicion 0 a la 7 (tamaño 8)
     * @param fechaEnvio
     */
    public void setFechaEnvio(String fechaEnvio) {
        if(fechaEnvio.length()>8)
            fechaEnvio=fechaEnvio.substring(0,7);
        this.fechaEnvio = fechaEnvio;
    }

    /**
     * Como el tamaño maximo del codEnvio es 8, este set regulara a traves de un truncamiento que el codEnvio que se introduzca en el objeto no
     * sobrepase el tamaño maximo a traves del metodo substring, el cual si llega a ser llamado seleccionara la parte del codEnvio que va desde la
     * posicion 0 a la 7 (tamaño 8)
     * @param codEnvio
     */
    public void setCodEnvio(String codEnvio) {
        if (codEnvio.length()>8)
            codEnvio=codEnvio.substring(0,7);
        this.codEnvio = codEnvio;
    }

    /**
     * Como el tamaño maximo del dato insertado en la primera posicion del array es 11, regularemos que no se pase de ese tamaño con el if y el substring
     * ademas que insertaremos el resto de valores en un for
     * @param conceptosFactura
     */
    public void setConceptosFactura(String[] conceptosFactura) {
        for (int i=0; i<this.conceptosFactura.length; i++){
            if (i==1){
                if (conceptosFactura[0].length()>11)
                    conceptosFactura[0]=conceptosFactura[0].substring(0,10);
            }
                    this.conceptosFactura[i] = conceptosFactura[i];
                }
        }

    @Override
    public boolean equals(Object o) {
        boolean esRepetida;
        if (this == o)
            esRepetida = true;
        else if (o == null || getClass() != o.getClass())
            esRepetida = false;
        else {
            Factura that = (Factura) o;
            esRepetida = cif.equals(that.cif) && fechaEnvio.equals(that.fechaEnvio) && codEnvio.equals(that.codEnvio);
        }
        return esRepetida;
    }

    /**
     * Overray al toString de java para poder escribir objetos que coincidan con el formato del fichero llamando solamente al toString
     * @return
     */
    @Override
    public String toString(){
        return cif +","+ nombreEmp +","+ fechaEnvio +","+ codEnvio +","+ conceptosFactura[0] +","+ conceptosFactura[1] +","+ conceptosFactura[2] + "\n";
    }
}
