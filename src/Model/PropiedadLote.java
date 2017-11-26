package Model;

import java.util.ArrayList;

public class PropiedadLote extends Bien {

    public PropiedadLote(double areaT, String dir, String modalidad, double valor) {
        this.setAreaTerreno(areaT);
        this.setDireccion(dir);
        this.setEstado(modalidad);
        this.setValorFiscal(valor);
        this.setValorMetroCuadrado(valor/areaT);
        this.setInteresados(new ArrayList<>());
    }
    
    public String printo(){
        return "Tipo: Lote \n";
    }

}