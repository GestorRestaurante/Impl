package gestorgrego.pedido.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue
    private Long id;
 
    @Column
    private String cliente;
    
    private SituacaoPedido situacao;

    public SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }
    
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getCliente() {
        return cliente;
    }
 
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", cliente=" + cliente + "]";
    }
    
}
