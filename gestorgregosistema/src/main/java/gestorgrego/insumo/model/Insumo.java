package gestorgrego.insumo.model;

import gestorgrego.pessoa.model.Pessoa;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Insumo {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String descricao;
    
    @ManyToMany
    private List<Pessoa> fornecedor;
    
    private TipoInsumo tipoinsumo;
    
    @Column
    private Float estoque;

    public Float getEstoque() {
        return estoque;
    }

    public void setEstoque(Float estoque) {
        this.estoque = estoque;
    }

    public TipoInsumo getTipoinsumo() {
        return tipoinsumo;
    }

    public void setTipoinsumo(TipoInsumo tipoinsumo) {
        this.tipoinsumo = tipoinsumo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoa> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(List<Pessoa> fornecedor) {
        this.fornecedor = fornecedor;
    }

}
