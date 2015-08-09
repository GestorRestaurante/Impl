package gestorgrego.pessoa.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Fernanda Tamy Ishii
 */
@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String logradouro;
    
    @Column
    private String numero;
    
    @Column
    private String complemento;
    
    @Column
    private String bairro;
    
    @Column
    private String cidade;
    
    @Column
    private String estado;
    
    @Column
    private String tipoendereco;
    
    @ManyToMany
    private List<Pessoa> pessoa;

    public Endereco() {
    }

    public String getTipoendereco() {
        return tipoendereco;
    }

    public void setTipoendereco(String tipoendereco) {
        this.tipoendereco = tipoendereco;
    }
    
    

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

}
