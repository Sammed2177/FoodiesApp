package com.foodies.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.foodies.daos.MenuDao;
import com.foodies.daos.Menu_TypeDao;
import com.foodies.entity.Menu;
import com.foodies.entity.MenuType;
import com.foodies.model.MenuDto;
import com.foodies.util.StorageService;



@Transactional
@Service
public class MenuServiceImpl {
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private Menu_TypeDao menuTypeDao;
	
	@Value("${bucketName}")
    private String bucketName;
	
    private  final AmazonS3 s3;
    
    public MenuServiceImpl(AmazonS3 s3) {
        this.s3 = s3;
    }
 
	public List<Menu> findAll() {
			List<Menu> menuList = menuDao.findAll();
			return menuList;
		}
	 
	public String deleteMenu(int id) {
		menuDao.deleteById(id);
		return "Menu Deleted successfully";
	}
	 
	public Menu editMenu(MenuDto menuDto , int id) {
		Menu menu = menuDao.getById(id);
//		System.out.println(menu);
		menu.setDescription(menuDto.getDescription());
		menu.setPrice(menuDto.getPrice());
		return menuDao.save(menu);
		
//		return menu;
	}
	 
	/*
	 * public Menu saveMenu(Menu menu,String ,MultipartFile imageName) { String
	 * fileName = storageService.saveFile(fileName, fileName, imageName);
	 * menu.setImageName(fileName); return menuDao.save(menu); }
	 */
	
	public static void saveFile(String uploadDir, String fileName,
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
	 
	public Menu addMenu(Menu menu, MultipartFile file , int menuTypeid) {
		
		
		String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        try {
            File file1 = convertMultiPartToFile(file);        
            PutObjectResult putObjectResult = s3.putObject(bucketName, originalFilename, file1);
            putObjectResult.getContentMd5();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
        
		menu.setImageName(originalFilename);
		Optional<MenuType> menuType = menuTypeDao.findById(menuTypeid);
		if(menuType.isPresent()) {
			menuType.get().addMenu(menu);
			return menuDao.save(menu);
		}
		System.out.println("Saving Entity");
		return menuDao.save(menu);
	}

	public List<Menu> findAllByType(int menuTypeid) {
		List<Menu> list=menuDao.findAllByType(menuTypeid);
		return list;
	}
	
	private File convertMultiPartToFile(MultipartFile file ) throws IOException
    {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
    }

}
