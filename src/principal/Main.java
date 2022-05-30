package principal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static principal.GestionFichero.*;

public class Main {

    public static void main(String[] args) {
	List<Factura> listaFactura=new ArrayList<>();
    File Facturas=new File("facturasMezcladas.txt");
    listaFactura=depurarFichero(Facturas,listaFactura);
     File FacturasSalida=new File("facturasParaPagar.bin");
     montarFichero(FacturasSalida, listaFactura);
     leerFichero(FacturasSalida);

    }
}
