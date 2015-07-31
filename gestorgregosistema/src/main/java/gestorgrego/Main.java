package gestorgrego;

import gestorgrego.pessoa.model.Pessoa;


public class Main {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setName("Ana");
        System.out.println("Hello World!");
        System.out.println(pessoa.getName());
    }
    
    
}
