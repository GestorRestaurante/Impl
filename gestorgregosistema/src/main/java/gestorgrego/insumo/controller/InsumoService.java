package gestorgrego.insumo.controller;

import gestorgrego.insumo.model.Insumo;
import gestorgrego.insumo.model.TipoInsumo;
import java.util.List;

public interface InsumoService {
    
    public List<Insumo> findInsumos(TipoInsumo tipoInsumo, int firstResult, String orderBy, boolean ascending);
    
}
