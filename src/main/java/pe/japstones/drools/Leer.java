package pe.japstones.drools;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Joel on 06/04/2017.
 */
public class Leer {
    public List<Compra> getCompra(String pathTxt) throws URISyntaxException, IOException {
        Path p = Paths.get(ClassLoader.getSystemResource(pathTxt).toURI());
        return Files.readAllLines(p).stream().skip(1).map(line -> line.split("\t"))
                .map(this::getCompra).collect(Collectors.toList());
    }

    private Compra getCompra(String ... dato){
        Compra c = new Compra();
        c.setNombre(dato[0]);
        c.setSexo(dato[1]);
        c.setEdad(Integer.parseInt(dato[2]));
        c.setImporteCompra(Integer.parseInt(dato[3]));
        return c;
    }

}
