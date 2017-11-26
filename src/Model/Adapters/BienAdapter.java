package Model.Adapters;

import Model.Bien;
import Model.Lote;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BienAdapter
            extends XmlAdapter<Lote, Bien> {


    @Override
    public Bien unmarshal(Lote v) throws Exception {
        return null;
    }

    @Override
    public Lote marshal(Bien v) throws Exception {
        return null;
    }
}
