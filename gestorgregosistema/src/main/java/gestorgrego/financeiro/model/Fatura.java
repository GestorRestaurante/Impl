/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorgrego.financeiro.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fatura {
    
    @Id
    @GeneratedValue
    private Long id;
        
    @Column
    private String cliente;
    
    @Column
    private Date dataEmissao;
    
    @Column
    private SituacaoFatura situacao;
    
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
    
    public Date getDataEmissao(){
        return dataEmissao;
    }
    
    public void setDataEmissao(Date dataEmissao){
        this.dataEmissao = dataEmissao;
    }
    
    public SituacaoFatura getSituacao(){
        return this.situacao;
    }
    
    public void setSituacao(SituacaoFatura situacao){
        this.situacao = situacao;
    }
    
    @Override
    public String toString() {
        return "Fatura [id=" + id + ", cliente=" + cliente + ", data=" + dataEmissao + ", situacao=" + situacao + "]";
    }    
}
