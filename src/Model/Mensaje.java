package Model;

import Util.TipoMensaje;

public class Mensaje {
    TipoMensaje tipoMensaje;
    String mensaje;

    public Mensaje(TipoMensaje tipoMensaje, String mensaje) {
        setTipoMensaje(tipoMensaje);
        setMensaje(mensaje);
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String pMensaje) {
        mensaje = pMensaje;
    }

    public TipoMensaje getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(TipoMensaje pTipoMensaje) {
        tipoMensaje = pTipoMensaje;
    }
}
