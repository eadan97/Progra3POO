package Model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "lote")
public class Lote extends Bien {

    public Lote() {
    }

    public Lote(double areaT, String dir, String modalidad, double valor) {
        this.setAreaTerreno(areaT);
        this.setDireccion(dir);
        this.setEstado(modalidad);
        this.setValorFiscal(valor);
        this.setValorMetroCuadrado(valor/areaT);
        this.setInteresados(new ArrayList<>());
    }
    
    public String toString(){
        return "Tipo: Lote \n";
    }//Todo: mas info

}