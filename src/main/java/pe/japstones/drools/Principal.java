package pe.japstones.drools;

import java.io.IOException;
import java.net.URISyntaxException;

import java.util.List;

/**
 * Created by Joel on 06/04/2017.
 */
public class Principal {
    public static void main(String ... arg) throws IOException, URISyntaxException {
        Leer leer = new Leer();
        Regalo regalo = new Regalo();

        List<Compra> c = leer.getCompra("compras.txt");
        regalo.aplicarRegla(c);
    }
}
