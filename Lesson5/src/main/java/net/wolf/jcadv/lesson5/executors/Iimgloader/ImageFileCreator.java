/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.executors.Iimgloader;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Сохраняет картинку на диск
 * @author Andrey
 */
public class ImageFileCreator implements Runnable {
    
    private final String dirToSave;
    private final ImageFile imageFile;

    public ImageFileCreator(String dirToSave, ImageFile imageFile) {
        this.dirToSave = dirToSave;
        this.imageFile = imageFile;
    }

    @Override
    public void run() {
        Path path = Paths.get(dirToSave, imageFile.getFileName());
        System.out.println(Thread.currentThread().getName() + " - " + " сохраняю картинку на диск " + path);        
        try (OutputStream os = Files.newOutputStream(path, StandardOpenOption.CREATE);) {
            os.write(imageFile.getContent());
        } catch (IOException ex) {
            Logger.getLogger(Thread.currentThread().getName() + " - " + " ошибка сохранения файла на диск " + path);
        }
    }
    
    
    
}
