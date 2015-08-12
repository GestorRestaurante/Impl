package gestorgrego.insumo.controller;

import gestorgrego.insumo.model.Insumo;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

public class InsumoLazyDataModel extends LazyDataModel<Insumo> {
    
    private SearchCriteria searchCriteria;
    
    private List<Insumo> insumos;
    
    private InsumoService insumoService;
    
    private Insumo selected;
    
    @Autowired
    public void setInsumoService(InsumoService insumoService) {
            this.insumoService = insumoService;
    }

    @Override
    public List<Insumo> load(int first, int pageSize, String sortField, SortOrder order, Map<String, Object> filters) {
        this.searchCriteria.setCurrentPage(first / pageSize + 1);
        insumos = insumoService.findInsumos(searchCriteria, first, sortField, order.equals(SortOrder.ASCENDING));
        return insumos;
    }
    
    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Insumo getRowData(String rowKey) {
        for (Insumo insumo : this.insumos){
            if (insumo.getId().equals(rowKey)) {
                return insumo;
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(Insumo hotel) {
        return hotel.getId();
    }

    @Override
    public int getRowCount() {
        return insumoService.getNumberOfInsumos(searchCriteria);
    }

    public Insumo getSelected() {
        return selected;
    }

    public void setSelected(Insumo selected) {
        this.selected = selected;
    }

    public int getCurrentPage() {
        return this.searchCriteria.getCurrentPage();
    }

    @Override
    public int getPageSize() {
        return this.searchCriteria.getPageSize();
    }

}
