package com.batch.steps;

import com.batch.entities.Person;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person person) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        person.setCreatedAt(formatter.format(date));

        return person;
    }
}
