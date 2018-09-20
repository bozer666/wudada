/**    
 * @Package: com.java.controller 
 * @author: wujb   
 * @date: 2018年6月28日 上午10:13:53 
 */
package com.java.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @ClassName: FileUploadController
 * @Description: TODO
 * @author: wujb
 * @date: 2018年6月28日 上午10:13:53
 */
@Controller
public class FileUploadController {

	/**
	 * 实现文件上传
	 */
	@RequestMapping("fileUpload")
	@ResponseBody
	public String fileUpload(@RequestParam("fileName") MultipartFile file) {
		if (file.isEmpty()) {
			return "false";
		}
		String fileName = file.getOriginalFilename();
		int size = (int) file.getSize();
		System.out.println(fileName + "-->" + size);

		String path = "E:/test";
		File dest = new File(path + "/" + fileName);
		if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
			dest.getParentFile().mkdir();
		}
		try {
			file.transferTo(dest); // 保存文件
			return "true";
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return "false";
		} catch (IOException e) {
			e.printStackTrace();
			return "false";
		}
	}

	/**
	 * 实现多文件上传
	 */
	@RequestMapping(value = "multifileUpload", method = RequestMethod.POST)
	public @ResponseBody String multifileUpload(HttpServletRequest request) {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");
		if (files.isEmpty()) {
			return "false";
		}
		String path = "E:/test";
		for (MultipartFile file : files) {
			String fileName = file.getOriginalFilename();
			int size = (int) file.getSize();
			System.out.println(fileName + "-->" + size);
			if (file.isEmpty()) {
				return "false";
			} else {
				File dest = new File(path + "/" + fileName);
				if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
					dest.getParentFile().mkdir();
				}
				try {
					file.transferTo(dest);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "false";
				}
			}
		}
		return "true";
	}

	/**
	 * 
	 * @Title: mp3Download 
	 * @Description: 网易云音乐下载
	 * @param mp3Id
	 * @param mp3Name
	 * @param res
	 * @throws IOException void
	 * @author wujb
	 * @date 2018年6月28日上午11:39:27
	 */
	@RequestMapping(value = "/mp3Download")
	public void mp3Download(String mp3Id,String mp3Name, HttpServletResponse res) throws IOException  {
		//res.setHeader("content-type", "application/octet-stream");
		res.setContentType("multipart/form-data");
		res.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(mp3Name+".mp3", "UTF-8"));
		URL url = new URL("http://music.163.com/song/media/outer/url?id=" + mp3Id + ".mp3");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置超时间为10秒
		conn.setConnectTimeout(10 * 1000);
		// 防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		// 得到输入流
		BufferedInputStream inputStream = new BufferedInputStream(conn.getInputStream());
		res.setHeader("Content-Length", ""+conn.getContentLengthLong());
		byte[] buff = new byte[1024];
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(res.getOutputStream());
			int len = 0;
			while ((len = inputStream.read(buff)) != -1) {
				bos.write(buff,0,len);
				bos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos!=null) {
					bos.close();
				}
				if (inputStream!=null) {
					inputStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		System.out.println("success");
	}
}
