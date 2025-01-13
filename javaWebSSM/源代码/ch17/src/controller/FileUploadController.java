package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import pojo.FileDomain;
import pojo.MultiFileDomain;
@Controller
public class FileUploadController {
	// 得到一个用来记录日志的对象，这样打印信息的时候能够标记打印的是那个类的信息
	private static final Log logger = LogFactory.getLog(FileUploadController.class);
	/**
	 * 单文件上传
	 */
	@RequestMapping("/onefile")
	public String oneFileUpload(@ModelAttribute FileDomain fileDomain, HttpServletRequest request){
		/*上传文件的保存位置"/uploadfiles"，该位置是指
		workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps，
		发布后使用*/
		String realpath = request.getServletContext().getRealPath("uploadfiles");
		String fileName = fileDomain.getMyfile().getOriginalFilename(); 
		File targetFile = new File(realpath, fileName); 
		if(!targetFile.exists()){  
            targetFile.mkdirs();  
        } 
		//上传 
        try {   
        	fileDomain.getMyfile().transferTo(targetFile);
        	logger.info("成功");
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        /*
      		@ModelAttribute FileDomain fileDomain这就话有这样一个功能：
      		model.addAttribute("fileDomain",fileDomain)所以此处不需要
         */
		return "showOne";
	}
	/**
	 * 多文件上传
	 */
	@RequestMapping("/multifile")
	public String multiFileUpload(@ModelAttribute MultiFileDomain multiFileDomain, HttpServletRequest request){
		String realpath = request.getServletContext().getRealPath("uploadfiles");
		//String realpath = "D:/spring mvc workspace/ch7/WebContent/uploadfiles";  
		File targetDir = new File(realpath); 
		if(!targetDir.exists()){  
			targetDir.mkdirs();  
        } 
		List<MultipartFile> files = multiFileDomain.getMyfile();
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			String fileName = file.getOriginalFilename();
			File targetFile = new File(realpath,fileName);
			//上传 
	        try {  
	        	file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		}
		logger.info("成功");
		return "showMulti";
	}
}
