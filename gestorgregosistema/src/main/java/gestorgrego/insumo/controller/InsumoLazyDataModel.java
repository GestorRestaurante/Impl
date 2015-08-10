package gestorgrego.insumo.controller;

import gestorgrego.insumo.model.Insumo;
import gestorgrego.insumo.model.TipoInsumo;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

class InsumoLazyDataModel extends LazyDataModel<Insumo> {
    
    private InsumoService insumoService;
    
    private final TipoInsumo tipoInsumo;
    
    private List<Insumo> insumos;

    @Autowired
    public void setInsumoService(InsumoService insumoService) {
        this.insumoService = insumoService;
    }
    
    public InsumoLazyDataModel(TipoInsumo tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

    @Override
    public List<Insumo> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        insumos = insumoService.findInsumos(tipoInsumo, first, sortField, true);
        return insumos;
    }

    @Override
    public String toString() {
        return tipoInsumo.toString();
    }

    
    
}
