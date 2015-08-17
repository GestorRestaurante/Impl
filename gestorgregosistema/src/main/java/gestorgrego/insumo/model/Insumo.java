package gestorgrego.insumo.model;

import gestorgrego.pessoa.model.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Insumo implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    @NotEmpty
    private String descricao;
    
    @ManyToMany
    private List<Pessoa> fornecedor;
    
    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoInsumo tipoInsumo;
    
    @Column
    @NotNull
    private Float estoque;

    public Float getEstoque() {
        return estoque;
    }

    public void setEstoque(Float estoque) {
        this.estoque = estoque;
    }

    public TipoInsumo getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(TipoInsumo tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
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
