package gestorgrego.pessoa.controller;

import gestorgrego.pessoa.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class PessoaController {
     
    //private PersonService personService;
     
    @Autowired(required=true)
    @Qualifier(value="personService")
    //public void setPersonService(PersonService ps){
    //    this.personService = ps;
    //}
     
    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("pessoa", new Pessoa());
       // model.addAttribute("listPersons", this.personService.listPersons());
        return "pessoa";
    }
     
    //For add and update person both
    @RequestMapping(value= "/pessoa/add", method = RequestMethod.POST)
    public String addPessoa(@ModelAttribute("pessoa") Pessoa p){
         
        if(p.getId() == 0){
            //new person, add it
            //this.personService.addPerson(p);
        }else{
            //existing person, call update
            //this.personService.updatePerson(p);
        }
         
        return "redirect:/pessoa";
         
    }
     
    @RequestMapping("/remove/{id}")
    public String removePessoa(@PathVariable("id") int id){
         
        //this.personService.removePerson(id);
        return "redirect:/pessoa";
    }
  
    @RequestMapping("/edit/{id}")
    public String editPessoa(@PathVariable("id") int id, Model model){
        //model.addAttribute("pessoa", this.personService.getPersonById(id));
        //model.addAttribute("listPersons", this.personService.listPersons());
        return "pessoa";
    }
     
}
