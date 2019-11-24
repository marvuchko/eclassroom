package com.elfak.eclassroom.service.file;

import com.elfak.eclassroom.dto.file.FileInfo;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.io.*;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

public class FileUploadService {

    private static final Logger LOGGER = Logger.getLogger(FileUploadService.class.getName());

    private static final String UPLOAD_DIR = "/home/wizard-of-tomorrow/eclassroom";

    public FileInfo saveFile(InputStream inputStream, FormDataContentDisposition fileMeta, String serverPath) {

        String extension = fileMeta.getFileName().split("[.]")[1];
        String fileName = UUID.randomUUID().toString() + "." + extension;
        String uploadDir = Optional.ofNullable(System.getenv("UPLOAD_DIR")).orElse(UPLOAD_DIR);

        FileInfo fileInfo = new FileInfo();

        try  {
            File file = new File(uploadDir + "/" + fileName);
            file.createNewFile();
            OutputStream out = new FileOutputStream(file);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            fileInfo.setFileName(fileName);
            fileInfo.setFileUrl(serverPath + "/" + fileName);
            fileInfo.setFileType(fileMeta.getType());

            out.flush();
            out.close();
            return fileInfo;
        } catch (IOException e) {
            LOGGER.warning("Error while uploading file. Please try again !!");
        }

        return null;
    }

}
