package gestorgrego.pessoa.controller;
 
import gestorgrego.pessoa.model.Pessoa;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import org.springframework.stereotype.Controller;

@Controller
public class PessoaController implements Serializable {
 
    private Pessoa pessoa = new Pessoa();
     
    private boolean skip;
     
    public Pessoa getPessoa() {
        return pessoa;
    }
 
    public void setUser(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
     
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + pessoa.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}