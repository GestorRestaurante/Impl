package gestorgrego.insumo.controller;

import static com.google.common.collect.Lists.newArrayList;
import gestorgrego.insumo.model.TipoInsumo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;

@Controller
public class InsumoController implements Serializable {
    
    private final List<InsumoLazyDataModel> listTipoInsumo = newArrayList();

    @PostConstruct
    public void init() {
        for (TipoInsumo tipoInsumo : TipoInsumo.values()) {
            listTipoInsumo.add(new InsumoLazyDataModel(tipoInsumo));
        }
    }

    public List<InsumoLazyDataModel> getListTipoInsumo() {
        return listTipoInsumo;
    }
    
}
