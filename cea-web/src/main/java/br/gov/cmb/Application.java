package br.gov.cmb;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.cmb.ldap.Person;
import br.gov.cmb.ldap.PersonRepository;

@SpringBootApplication
public class Application {

	private static Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired private PersonRepository personRepository;
    //@Autowired private GroupRepository groupRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void setup(){
        log.info("Spring LDAP CRUD Operations Binding and Unbinding Example");

        log.info("- - - - - - Managing persons");

        List<Person> persons = personRepository.findAll();
        log.info("persons: " + persons);

        Person john = personRepository.findOne("John Doe");
        john.setLastName("custom last name");
        personRepository.updateLastName(john);
        
        persons = personRepository.findAll();
        log.info("persons: " + persons);

		/*
		 * Person jahn = personRepository.findOne("jahn");
		 * jahn.setLastName("custom last name"); personRepository.update(jahn);
		 * 
		 * Person person = new Person("uid", "new", "person");
		 * personRepository.create(person);
		 * 
		 * Person jihn = personRepository.findOne("jihn");
		 * personRepository.delete(jihn);
		 * 
		 * persons = personRepository.findAll(); log.info("persons: " + persons);
		 * 
		 * log.info("- - - - - - Managing groups");
		 * 
		 * List<Group> groups = groupRepository.findAll(); log.info("groups: " +
		 * groups);
		 * 
		 * groupRepository.removeMemberFromGroup("developers", jihn);
		 * 
		 * groupRepository.addMemberToGroup("managers", jihn);
		 * 
		 * groups = groupRepository.findAll(); log.info("groups: " + groups);
		 */

        System.exit(-1);
    }


}
