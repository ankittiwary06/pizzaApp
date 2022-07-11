package com.vikasietum.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikasietum.model.Contact;
import com.vikasietum.utility.Constants;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ContactService {

    public void addContact(Contact contact) {

        String contact_file;
        String fileName;


        fileName = contact.getName() + "_" + contact.getSurname();
        ObjectMapper obj = new ObjectMapper();
        try {
            // Converting the Java object into a JSON string
            String jsonStr = obj.writeValueAsString(contact);
            // file path in constants class

            contact_file = Constants.filePath + fileName;
            FileWriter file = new FileWriter(contact_file);
            file.write(jsonStr);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void displayAll() {
        List<File> filesInFolder = null;
        List<Contact> contacts = new ArrayList<>();
        Contact contact;
        ObjectMapper obj = new ObjectMapper();
        String contactJsonString = null;
        File contactFile = null;
        try {
            filesInFolder = Files.walk(Paths.get(Constants.filePath))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("could not locate contact_files");
            throw new RuntimeException(e);
        }

        Iterator<File> it = filesInFolder.iterator();
        while (it.hasNext()) {
            try {

                // Defining the Reader Object with File argument
                contactFile = it.next();


                contactJsonString = new String(Files.readAllBytes(contactFile.toPath()));
                // System.out.println(contactJsonString);
                contact = obj.readValue(contactJsonString, Contact.class);
                contacts.add(contact);


            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (contacts.isEmpty()) {
            System.out.println("No Contacts Found!");
            return;
        }
        Collections.sort(contacts);

        for (Contact e : contacts
        ) {
            System.out.println(e);
        }


    }

    public void edit() {

    }

    public void remove() {

    }


}
