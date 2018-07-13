package com.epam.onlineshop.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageWriter {

    public static ModelAndView writeImage(ModelAndView catalog, MultipartFile file, String name) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Path currentRelativePath = Paths.get("");
                String s = currentRelativePath.toAbsolutePath().toString();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(s + "/src/main/resources/static/images/products/" + name + ".jpg")));
                stream.write(bytes);
                stream.close();

                BufferedOutputStream streamToTarget =
                        new BufferedOutputStream(new FileOutputStream(new File(s + "/target/classes/static/images/products/" + name + ".jpg")));
                streamToTarget.write(bytes);
                streamToTarget.close();
                catalog.setViewName("redirect:/catalog");
            } catch (Exception e) {
                catalog.setViewName("redirect:/error");
            }
        } else {
            catalog.setViewName("redirect:/error");
        }
        return catalog;
    }
}
