package gestorgrego.insumo.controller;

import gestorgrego.SearchCriteria;
import gestorgrego.insumo.model.Insumo;
import java.util.List;

public interface InsumoService {
    
    public List<Insumo> findInsumos(SearchCriteria searchCriteria, int firstResult, String orderBy, boolean ascending);

    public int getNumberOfInsumos(SearchCriteria searchCriteria);
    
    public void salvarInsumo(Insumo insumo);
    
    public void atualizarInsumo(Insumo insumo);
    
    public Insumo criarInsumo();
    
    public void excluirInsumo(Insumo insumo);
    
}
