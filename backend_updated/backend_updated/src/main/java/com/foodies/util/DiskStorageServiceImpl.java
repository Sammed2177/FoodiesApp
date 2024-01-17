package com.foodies.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class DiskStorageServiceImpl implements StorageService {
	@Value("${disk.upload.basepath}")
	private String BASEPATH;

	
	@Override
	public List<String> loadAll() {
		File dirPath = new File(BASEPATH);
		
		List<String> list=new ArrayList<>();
		for(String file:dirPath.list()) {
			list.add(file);
		}
		
		return list;
	}


	/*
	 * public String store(MultipartFile file) { String fileName =
	 * UUID.randomUUID().toString().replaceAll("-", ""); File filePath = new
	 * File(BASEPATH, fileName); try(FileOutputStream out = new
	 * FileOutputStream(filePath)) { FileCopyUtils.copy(file.getInputStream(), out);
	 * return fileName; } catch (Exception e) { e.printStackTrace(); } return null;
	 * }
	 */
	@Override
	public void saveFile(String uploadDir, String fileName,
            MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
         
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
         
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }      
    }

	@Override
	public Resource load(String fileName) {
		File filePath = new File(BASEPATH, fileName);
		if(filePath.exists())
			return new FileSystemResource(filePath);
		return null;
	}

	@Override
	public void delete(String fileName) {
		File filePath = new File(BASEPATH, fileName);
		if(filePath.exists())
			filePath.delete();
	}


	@Override
	public String store(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

}
