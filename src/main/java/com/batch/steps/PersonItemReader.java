package com.batch.steps;

import com.batch.entities.Person;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;

public class PersonItemReader extends FlatFileItemReader<Person> {

    public PersonItemReader(){

        setName("readPersons");
        setResource(new ClassPathResource("persons.csv"));
        setLinesToSkip(1);
        setEncoding(StandardCharsets.UTF_8.name());
        setLineMapper(getLineMapper());
    }

    public LineMapper<Person> getLineMapper() {
        DefaultLineMapper lineMapper = new DefaultLineMapper();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        String[] columns = new String[]{"name", "lastName", "age", "email", "phone"};
        int[] indexFields = new int[]{0, 1, 2, 3, 4};

        lineTokenizer.setNames(columns);
        lineTokenizer.setIncludedFields(indexFields);
        lineTokenizer.setDelimiter(",");

        BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Person.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;

    }
}
