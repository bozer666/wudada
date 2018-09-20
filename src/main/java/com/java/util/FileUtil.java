/**    
 * @Package: com.java.util 
 * @author: wujb   
 * @date: 2018年6月27日 下午4:53:01 
 */
package com.java.util;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: FileUtil
 * @Description: TODO
 * @author: wu
 * @date: 2018年6月27日 下午4:53:01
 */
public class FileUtil {

	/**
	 * 写入文件,末尾自动添加\r\n utf-8 追加
	 * 
	 * @param path
	 * @param str
	 */
	public static void writeLog(String path, String str) {
		try {
			File file = new File(path);
			if (!file.exists())
				file.createNewFile();
			FileOutputStream out = new FileOutputStream(file); // true表示追加
			StringBuffer sb = new StringBuffer();
			sb.append(str + "\r\n");
			out.write(sb.toString().getBytes("utf-8"));//
			out.close();
		} catch (IOException ex) {
			System.out.println(ex.getStackTrace());
		}
	}

	/**
	 * 写入文件,末尾自动添加\r\n
	 * 
	 * @param path
	 * @param str
	 */
	public static void writeLog(String path, String str, boolean is_append, String encode) {
		try {
			File file = new File(path);
			if (!file.exists())
				file.createNewFile();
			FileOutputStream out = new FileOutputStream(file, is_append); // true表示追加
			StringBuffer sb = new StringBuffer();
			sb.append(str + "\r\n");
			out.write(sb.toString().getBytes(encode));//
			out.close();
		} catch (IOException ex) {
			System.out.println(ex.getStackTrace());
		}
	}

	/**
	 * 
	 * @Title: readLineFile 
	 * @Description: 按行读取文件,返回string,默认格式UTF-8
	 * @param path 文件路径
	 * @return String 返回文件内容
	 * @author wujb
	 * @date 2018年6月27日下午6:36:33
	 */
	public static String readLineFile(String path) {
		return readLineFile(path,"utf-8");
	}

	/**
	 * 
	 * @Title: readLineFile 
	 * @Description: 按行读取文件,返回string
	 * @param path 文件路径
	 * @param encode 编码格式
	 * @return String 返回文件内容
	 * @author wujb
	 * @date 2018年6月27日下午6:35:15
	 */
	public static String readLineFile(String path, String encode) {
		StringBuffer sb = new StringBuffer();
		String tempstr = null;
		try {
			File file = new File(path);
			if (!file.exists())
				throw new FileNotFoundException();
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis, encode));
			while ((tempstr = br.readLine()) != null) {
				sb.append(tempstr + "\r\n");
			}
		} catch (IOException ex) {
			System.out.println(ex.getStackTrace());
		}
		return sb.toString();
	}

	/**
	 * 
	 * @Title: readFileToList 
	 * @Description: 按行读取文件，以list<String>的形式返回
	 * @param path	文件路径
	 * @return List<String>
	 * @author wujb
	 * @date 2018年6月27日下午6:34:18
	 */
	public static List<String> readFileToList(String path) {
		List<String> lines = new ArrayList<String>();
		String tempstr = null;
		try {
			File file = new File(path);
			if (!file.exists()) {
				throw new FileNotFoundException();
			}
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf-8"));
			while ((tempstr = br.readLine()) != null) {
				lines.add(tempstr.toString());
			}
		} catch (IOException ex) {
			System.out.println(ex.getStackTrace());
		}
		return lines;
	}

	/**
	 * 创建目录
	 * 
	 * @param dir_path
	 */
	public static void mkDir(String dir_path) {
		File myFolderPath = new File(dir_path);
		try {
			if (!myFolderPath.exists()) {
				myFolderPath.mkdir();
			}
		} catch (Exception e) {
			System.err.println("新建目录操作出错");
			e.printStackTrace();
		}
	}

	/**
	 * 创建文件
	 * 
	 * @param file_path
	 */
	public static void createNewFile(String file_path) {
		File myFilePath = new File(file_path);
		try {
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
		} catch (Exception e) {
			System.err.println("新建文件操作出错");
			e.printStackTrace();
		}
	}

	/**
	 * 递归删除文件或者目录
	 * 
	 * @param file_path
	 */
	public static void deleteEveryThing(String file_path) {
		try {
			File file = new File(file_path);
			if (!file.exists()) {
				return;
			}
			if (file.isFile()) {
				file.delete();
			} else {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					String root = files[i].getAbsolutePath();// 得到子文件或文件夹的绝对路径
					deleteEveryThing(root);
				}
				file.delete();
			}
		} catch (Exception e) {
			System.err.println("删除文件失败");
		}
	}

	/**
	 * 
	 * @Title: getAllFileNameInFold
	 * @Description: 得到一个文件夹下所有文件
	 * @param fold_path
	 * @return List<String>
	 * @author wujb
	 * @date 2018年6月27日下午6:01:04
	 */
	public static List<String> getAllFileNameInFold(String fold_path) {
		List<String> file_paths = new ArrayList<String>();

		LinkedList<String> folderList = new LinkedList<String>();
		folderList.add(fold_path);
		while (folderList.size() > 0) {
			File file = new File(folderList.peekLast());
			folderList.removeLast();
			File[] files = file.listFiles();
			ArrayList<File> fileList = new ArrayList<File>();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					folderList.add(files[i].getPath());
				} else {
					fileList.add(files[i]);
				}
			}
			for (File f : fileList) {
				file_paths.add(f.getAbsoluteFile().getPath());
			}
		}
		return file_paths;
	}

	/**
	 * 
	 * @Title: copy
	 * @Description: 复制文件，支持把源文件内容追加到目标文件末尾
	 * @param src
	 * @param dst
	 * @param append
	 * @throws Exception
	 *             void
	 * @author wujb
	 * @date 2018年6月27日下午6:04:30
	 */
	public static void copy(File src, File dst, boolean append) throws Exception {
		int BUFFER_SIZE = 4096;
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst, append), BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				out = null;
			}
		}
	}

	public static boolean IsExist(String path) {
		boolean Is;
		File file = new File(path);
		Is = file.exists();
		return Is;
	}

	/**
	 * @方法名称 :wrieteFile
	 * @功能描述 :写文件操作
	 * @返回值类型 :void
	 * @param path
	 *            文件路径 ，content 写的内容
	 */
	public static void wrieteFile(String path, String content) {

		if (IsExist(path)) {
			OutputStream out;
			try {
				out = new BufferedOutputStream(new FileOutputStream(path));
				byte[] time = content.getBytes();
				out.write(time);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}

	
	
	/**
	 * 
	 * @Title: writeLineFile 
	 * @Description: 一行一行写文件
	 * @param filename 文件名
	 * @param content 写的内容
	 * @author wujb
	 * @date 2018年6月27日下午6:17:32
	 */
	public static void writeLineFile(String filename, String[] content) {
		writeLineFile(filename,content,true);
	}

	/**
	 * @方法名称 :writeLineFile
	 * @功能描述 :一行一行写文件
	 * @返回值类型 :void
	 * @param filename
	 *            文件名，content 写的内容
	 */
	public static void writeLineFile(String filename, String[] content,boolean isAppend) {

		if (IsExist(filename)) {
			try {
				FileOutputStream out = new FileOutputStream(filename,isAppend);
				OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
				BufferedWriter bufWrite = new BufferedWriter(outWriter);
				for (int i = 0; i < content.length; i++) {
					bufWrite.write(content[i] + "\r\n");
				}
				bufWrite.close();
				outWriter.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("读取" + filename + "出错！");
			}
		}
	}
	/**
	 * 
	 * @Title: writeLineFile 
	 * @Description: TODO 
	 * @param filename 文件名
	 * @param content 追加内容
	 * @author wujb
	 * @date 2018年6月27日下午6:13:51
	 */
	public static void writeLineFile(String filename, String content) {
		writeLineFile(filename,content,true);
	}
	/**
	 * @方法名称 :writeLineFile
	 * @功能描述 :一行一行写文件 
	 * @返回值类型 :void
	 * @param filename 文件名，content 写的内容,isAppend 是否追加
	 */
	public static void writeLineFile(String filename, String content,boolean isAppend) {
		try {
			FileOutputStream out = new FileOutputStream(filename, isAppend);
			OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
			BufferedWriter bufWrite = new BufferedWriter(outWriter);
			bufWrite.write(content + "\r\n");
			bufWrite.close();
			outWriter.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("读取" + filename + "出错！");
		}
	}
	
	
}
