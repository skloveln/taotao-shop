package com.taotao.service.impl;

import java.io.IOException;
import java.util.UUID;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;

/**
 * 上传图片处理服务实现类
 * <p>Title: PictureService</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年8月15日下午2:59:38
 * @version 1.0
 */
@Service
public class PictureServiceImpl implements PictureService {
	
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USER_NAME}")
	private String FTP_USER_NAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	

	@Override
	public PictureResult uploadPicture(MultipartFile uploadFile) {
		//判断上传图片是否为空
		if (null == uploadFile || uploadFile.isEmpty()) {
			return PictureResult.error("上传图片为空");
		}
		
		String url = "";
		
		// 取文件扩展名
		String originalFilename = uploadFile.getOriginalFilename();
		// 取后缀类型名
		String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
		
		try{
		//初始化全局配置。加载一个配置文件
		ClientGlobal.init("E:\\Eclipse Java EE Workspace\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\fdfs_client.conf");
		//创建一个TrackerClient对象。
		TrackerClient trackerClient = new TrackerClient();
		//创建一个TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//声明一个StorageServer对象
		StorageServer storageServer = null;
		//获得StorageClient对象
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//直接调用StorageClient对象方法上传文件
		String[] strings = storageClient.upload_file(uploadFile.getBytes(), extName, null);
		
		
			for(String string : strings){
				url += string+"/";
			}
		
		}catch(Exception e){
			System.out.println("ex:"+e);
		}
		url = url.substring(0, url.length()-1);
		System.out.println("url:"+ IMAGE_BASE_URL + url);
		return PictureResult.ok(IMAGE_BASE_URL + url);
/*		
		//取文件扩展名
		String originalFilename = uploadFile.getOriginalFilename();
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新文件名
		//可以使用uuid生成新文件名。
		//UUID.randomUUID()
		//可以是时间+随机数生成文件名
		String imageName = IDUtils.genImageName();
		//把图片上传到ftp服务器（图片服务器）
		//需要把ftp的参数配置到配置文件中
		//文件在服务器的存放路径，应该使用日期分隔的目录结构
		DateTime dateTime = new DateTime();
		String filePath = dateTime.toString("/yyyy/MM/dd");
		try {
			FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, 
					FTP_BASE_PATH, filePath, imageName + ext, uploadFile.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			return PictureResult.error(ExceptionUtil.getStackTrace(e));
		}
		//返回结果，生成一个可以访问到图片的url返回
		return PictureResult.ok(IMAGE_BASE_URL + filePath + "/" + imageName + ext);
*/	
	}

}
