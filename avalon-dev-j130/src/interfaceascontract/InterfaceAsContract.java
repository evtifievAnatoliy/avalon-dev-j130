/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceascontract;

import interfaceascontract.model.Person;
import interfaceascontract.service.PersonService;
import interfaceascontract.service.PersonServiceDbImpl;
import interfaceascontract.service.PersonServiceFileImpl;

/**
 *
 * @author kolosov
 */
public class InterfaceAsContract {

    private final PersonService personService;

    private InterfaceAsContract(PersonService personService) {
        this.personService = personService;
    }
            
    private void run() {
        Person vanya = new Person("Ivan", "Ivanov");
        Person anya = new Person("Anna", "Anina");
        
        personService.save(vanya);
        personService.save(vanya);
        
        personService.getAll().forEach(System.out::println);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length > 0) {
            PersonService service = new PersonServiceDbImpl();
            new InterfaceAsContract(service).run();
        } else {
            PersonService service = new PersonServiceFileImpl();
            new InterfaceAsContract(service).run();
        }
    }
    
}
