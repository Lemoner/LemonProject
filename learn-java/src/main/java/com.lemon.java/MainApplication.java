package com.lemon.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.File;

/**
 * @author lemon
 * @since 2021-05-07
 */
@SpringBootApplication
@EnableAsync
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MainApplication.class);
        File pidFile = new File("app.pid");
        pidFile.setWritable(true, true);
        pidFile.setExecutable(false);
        pidFile.setReadable(true);
        application.addListeners(new ApplicationPidFileWriter(pidFile));
        application.setRegisterShutdownHook(true);
        application.run(args);
    }
}
