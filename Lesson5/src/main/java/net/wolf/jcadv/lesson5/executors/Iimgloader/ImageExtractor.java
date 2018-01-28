/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.executors.Iimgloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 *
 * @author Andrey
 */
public class ImageExtractor implements Runnable {

    private static final String IMG_TAG_START = "<img";
    private static final String IMG_SRC_START = "src=\"";

    private final URL url;
    private final String pathToSave;
    private final ExecutorService executorService;

    public ImageExtractor(URL url, String pathToSave, ExecutorService executorService) {
        this.url = url;
        this.pathToSave = pathToSave;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));) {
            List<String> urlStings = br.lines()
                    .collect(Collectors.toList());

            urlStings.stream()
                    .map(this::imageSourceURL)
                    .filter(Objects::nonNull)
                    .map((imgUrl) -> new ImageDownloader(imgUrl, pathToSave, executorService))
                    .forEach(executorService::submit);
        } catch (IOException ex) {
            System.err.println("Ошибка ввода/вывода " + ex + " при загрузке картинок URL'у " + url);
        }
    }

    public URL imageSourceURL(String line) {
        int imgIndex = line.indexOf(IMG_TAG_START);
        if (imgIndex >= 0) {
            int srcIndex = line.indexOf(IMG_SRC_START, imgIndex);
            if (srcIndex >= 0) {
                int srcBegin = srcIndex + IMG_SRC_START.length();
                int srcEnd = line.indexOf("\"", srcBegin);
                String imgUrl = line.substring(srcBegin, srcEnd);

                if (!imgUrl.startsWith("http")) {

                    if (imgUrl.startsWith("//")) {
                        imgUrl = url.getProtocol() + ":" + imgUrl;
                    } else {
                        imgUrl = url.getProtocol() + "://"
                                + url.getHost() + imgUrl;
                    }
                }
                try {
                    return new URL(imgUrl);
                } catch (MalformedURLException ex) {
                    System.out.println("Ссылка на картинку будет проигнорированна " + imgUrl);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws MalformedURLException, Exception {

        //ExecutorService executorService = Executors.newFixedThreadPool(50);
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(30, 50, 1, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>());

        ImageExtractor imageExtractor = new ImageExtractor(new URL("https://habrahabr.ru/article/329364/"),
                "D:\\IMG\\", executorService);
        imageExtractor
                .run();

        while (executorService.getActiveCount() != 0) {
            Thread.yield();
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Пул потоков не остановлено!!!");
                }
            }
        } catch (InterruptedException ie) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

    }

}
