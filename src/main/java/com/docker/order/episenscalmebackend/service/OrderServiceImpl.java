package com.docker.order.episenscalmebackend.service;

        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public ResponseEntity<String> getStringResponseEntity(String text) {
        try {
            File file = new File(/*"/home/docker/project/data/order.txt"*/"../order.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("Error during insert");
            return new ResponseEntity<>("ERREUR: Le texte '" + text + "' n'a pas été ajouté fichier order.", HttpStatus.EXPECTATION_FAILED);

        }
        logger.info("Insert in txt is ok ");
        return new ResponseEntity<>("Le texte '" + text + "' a bien été ajouté au fichier order.", HttpStatus.OK);
    }
}
