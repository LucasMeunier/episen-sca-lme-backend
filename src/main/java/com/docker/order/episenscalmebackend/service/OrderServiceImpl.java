package com.docker.order.episenscalmebackend.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public ResponseEntity<String> getStringResponseEntity(String text) {
        try {
            File file = new File(/*"/home/docker/project/data/order.txt"*/"/order.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("ERREUR: Le texte '"+text+"' n'a pas été ajouté fichier order.", HttpStatus.EXPECTATION_FAILED);

        }
        return new ResponseEntity<String>("Le texte '"+text+"' a bien été ajouté au fichier order.", HttpStatus.OK);
    }
}
