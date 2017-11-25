package Model;

import Util.TipoMensaje;

import java.io.Serializable;

public class Mensaje implements Serializable {
    TipoMensaje tipoMensaje;
    Object dato1;
    Object dato2;

    public Mensaje(TipoMensaje tipoMensaje, Object dato1, Object dato2) {
        this.tipoMensaje = tipoMensaje;
        this.dato1 = dato1;
        this.dato2 = dato2;
    }

    public Mensaje() {

    }

    public Object getDato2() {
        return dato2;
    }

    public void setDato2(Object pDato2) {
        dato2 = pDato2;
    }

    public Mensaje(TipoMensaje tipoMensaje, Object dato1) {
        setTipoMensaje(tipoMensaje);
        setDato1(dato1);
    }

    public Object getDato1() {
        return dato1;
    }

    public void setDato1(Object pMensaje) {
        dato1 = pMensaje;
    }

    public TipoMensaje getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(TipoMensaje pTipoMensaje) {
        tipoMensaje = pTipoMensaje;
    }
}
