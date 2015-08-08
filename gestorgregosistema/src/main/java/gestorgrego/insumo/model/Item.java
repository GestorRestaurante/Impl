package gestorgrego.insumo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Item {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String nome;
    
    @Column
    private TipoItem tipoitem;
    
    @Column
    private Long quantidade;

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public TipoItem getTipoitem() {
        return tipoitem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoitem(TipoItem tipoitem) {
        this.tipoitem = tipoitem;
    }
    
}
