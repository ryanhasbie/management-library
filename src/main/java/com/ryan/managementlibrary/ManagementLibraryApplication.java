package com.ryan.managementlibrary;

import com.ryan.managementlibrary.controllers.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ManagementLibraryApplication {

    public static void main(String[] args) {
         ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ManagementLibraryApplication.class, args);
        MainController mainController = configurableApplicationContext.getBean(MainController.class);
        mainController.run();
    }

}
