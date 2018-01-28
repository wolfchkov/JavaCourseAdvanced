/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.executors.Iimgloader;

/**
 * Данные картинки
 * @author Andrey
 */
public class ImageFile {
    
    /**
     * Имя файла 
     */
    private final String fileName;
    
    /**
     * Контент файла
     */
    private final byte[] content;

    public ImageFile(String fileName, byte[] content) {
        this.fileName = fileName;
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "ImageFile{" + "fileName=" + fileName + ", content=" + content.length + '}';
    }
    
    
    
}
