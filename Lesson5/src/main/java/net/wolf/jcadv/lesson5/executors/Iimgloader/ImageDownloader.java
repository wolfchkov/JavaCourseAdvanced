/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.executors.Iimgloader;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Загружает картинку по указанному URL'У
 * @author Andrey
 */
public class ImageDownloader implements Runnable{
    
    private final URL url;
    private final String pathToSave;
    private final ExecutorService executorService;

    public ImageDownloader(URL url, String pathToSave, ExecutorService executorService) {
        this.url = url;
        this.pathToSave = pathToSave;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        
        String name = url.getPath();
        //получим имя файла, вс что за последним '/'
        if (name.lastIndexOf('/') >= 0) {
            name = name.substring(name.lastIndexOf('/')+1);
            if (name.trim().equals("")) {
                name = UUID.randomUUID().toString();
            }
        }

        System.out.println(Thread.currentThread().getName() + " - " + "загружаю картинку " + name);
        //откроем InputStream и прочитаем все байты картинки в память 
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();        
        byte[] bb = new byte[4 * 1024];
        try (InputStream is = url.openStream();) {
            while (true) {
                int readed = is.read(bb);
                if (readed == -1) {
                    break;
                }
                buffer.write(bb, 0, readed);
            }
        } catch (IOException ex) {
            System.err.println(Thread.currentThread().getName() + " - " + " ошибка загрузки картинки " + name
                                + "; " + ex);
        }
        ImageFile imageFile = new ImageFile(name, buffer.toByteArray());
        //создадим и отправим задачу по загрузки файла на диск
        executorService.submit(new ImageFileCreator(pathToSave, imageFile));
    }
 
    
}
