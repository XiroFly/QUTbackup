package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class FileDownController {
	// 得到一个用来记录日志的对象，这样打印信息的时候能够标记打印的是那个类的信息
	private static final Log logger = LogFactory.getLog(FileDownController.class);
	/**
	 * 显示要下载的文件
	 */
	@RequestMapping("showDownFiles")
	public String show(HttpServletRequest request, Model model){
		//从workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\ch7\下载
		String realpath = request.getServletContext().getRealPath("uploadfiles");
		File dir = new File(realpath);
		File files[] = dir.listFiles();
		//获取该目录下的所有文件名
		ArrayList<String> fileName = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			fileName.add(files[i].getName());
		}
		model.addAttribute("files", fileName);
		return "showDownFiles";
	}
	/**
	 * 执行下载
	 */
	@RequestMapping("down")
	public String down(@RequestParam String filename, HttpServletRequest request, HttpServletResponse response){
		String aFilePath = null; //要下载的文件路径
		FileInputStream in = null; //输入流
		ServletOutputStream out = null; //输出流
		try {
			//从workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps下载
			aFilePath = request.getServletContext().getRealPath("uploadfiles");
			//设置下载文件使用的报头
			response.setHeader("Content-Type", "application/x-msdownload" );
			response.setHeader("Content-Disposition", "attachment; filename="
					+ toUTF8String(filename));
			// 读入文件
			in = new FileInputStream(aFilePath + "\\"+ filename); 
			//得到响应对象的输出流，用于向客户端输出二进制数据
			out = response.getOutputStream();
			out.flush();
			int aRead = 0;
			byte b[] = new byte[1024];
			while ((aRead = in.read(b)) != -1 & in != null) {
				out.write(b,0,aRead);
			}
			out.flush();
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		logger.info("下载成功");
		return null;
	}
	/**
	 * 下载保存时中文文件名字符编码转换方法
	 */
	public  String toUTF8String(String str){
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		for(int i = 0; i < len; i++){
			//取出字符中的每个字符
			char c = str.charAt(i);
			//Unicode码值在0-255之间，不作处理
			if(c >= 0 && c <= 255){
				sb.append(c);
			}else{//转换UTF-8编码
				byte b[];
				try {
					b = Character.toString(c).getBytes("UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					b = null;
				}
				//转换为%HH的字符串形式
				for(int j = 0; j < b.length; j ++){
					int k = b[j];
					if(k < 0){
						k &= 255;
					}
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
}
