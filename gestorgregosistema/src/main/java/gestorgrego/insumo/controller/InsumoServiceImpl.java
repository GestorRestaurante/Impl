package gestorgrego.insumo.controller;

import gestorgrego.insumo.model.Insumo;
import gestorgrego.insumo.model.TipoInsumo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("insumoService")
@Repository
class InsumoServiceImpl implements InsumoService, Serializable {
    
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
            this.em = em;
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<Insumo> findInsumos(TipoInsumo tipoInsumo, int firstResult, String orderBy, boolean ascending) {
            orderBy = (orderBy != null) ? orderBy : "descricao";
            String orderDirection = (ascending) ? " ASC" : " DESC";
            return em.createQuery(
                                    "select i from insumo i where i.tipoInsumo like :iTipoInsumo "
                                    + "order by i." + orderBy + orderDirection)
                                        .setFirstResult(firstResult)
                                        .getResultList();
    }
    
}
