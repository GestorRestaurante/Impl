package gestorgrego.insumo.controller;

import gestorgrego.insumo.model.Insumo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("insumoService")
@Repository
public class JpaInsumoService implements InsumoService, Serializable {
    
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
            this.em = em;
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<Insumo> findInsumos(SearchCriteria criteria, int firstResult, String orderBy, boolean ascending) {
        String pattern = getSearchPattern(criteria);
        orderBy = (orderBy != null) ? orderBy : "descricao";
        String orderDirection = (ascending) ? " ASC" : " DESC";
        return em
                .createQuery(
                            "select i from Insumo i where lower(i.descricao) like :pattern or lower(i.estoque) like :pattern "
                                                    + "order by i."
                                                    + orderBy + orderDirection).setParameter("pattern", pattern)
                                                    .setMaxResults(criteria.getPageSize()).setFirstResult(firstResult).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public int getNumberOfInsumos(SearchCriteria criteria) {
        String pattern = getSearchPattern(criteria);
        Long count = (Long) em
                    .createQuery(
                                "select count(i.id) from Insumo i where lower(i.descricao) like :pattern or lower(i.estoque) like :pattern")
                                            .setParameter("pattern", pattern).getSingleResult();
        return count.intValue();
    }
    
    private String getSearchPattern(SearchCriteria criteria) {
		if (StringUtils.hasText(criteria.getSearchString())) {
			return "%" + criteria.getSearchString().toLowerCase().replace('*', '%') + "%";
		} else {
			return "%";
		}
	}

    @Override
    @Transactional
    public void salvarInsumo(Insumo insumo) {
        em.persist(insumo);
    }
    
    @Override
    @Transactional
    public void atualizarInsumo(Insumo insumo) {
        em.merge(insumo);
    }

    @Override
    public Insumo criarInsumo() {
        return new Insumo();
    }

    @Override
    @Transactional
    public void excluirInsumo(Insumo insumo) {
        em.remove(em.merge(insumo));
    }
    
}
