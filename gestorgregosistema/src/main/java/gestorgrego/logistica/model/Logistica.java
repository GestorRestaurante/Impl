/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorgrego.logistica.model;

import gestorgrego.pedido.model.Pedido;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Logistica {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String empresa;
 
    @OneToMany
    private List<Pedido> pedido; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

}
