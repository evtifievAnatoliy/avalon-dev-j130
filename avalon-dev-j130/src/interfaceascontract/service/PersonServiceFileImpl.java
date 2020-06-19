/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceascontract.service;

import interfaceascontract.file_io.PersonIO;
import interfaceascontract.model.Person;
import java.util.Collection;

/**
 *
 * @author kolosov
 */
public class PersonServiceFileImpl implements PersonService {
    
    @Override
    public void save(Person person) {
        PersonIO personIO = new PersonIO();
        personIO.save(person);
    }

    @Override
    public Collection<Person> getAll() {
        PersonIO personIO = new PersonIO();
        return personIO.getAll();
    }
    
}
