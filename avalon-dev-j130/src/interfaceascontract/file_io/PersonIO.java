/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceascontract.file_io;

import interfaceascontract.model.Person;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author kolosov
 */
public class PersonIO {
    private static final List<Person> PERSONS = new ArrayList<>();
    
    public void save(Person person) {
        System.out.println("saved to file!");
        PERSONS.add(person);
    }
    
    public Collection<Person> getAll() {
        System.out.println("read from file!");
        return new ArrayList<>(PERSONS);
    }
    
}
