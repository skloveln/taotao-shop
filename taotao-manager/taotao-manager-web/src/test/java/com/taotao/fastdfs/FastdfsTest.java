package com.taotao.fastdfs;


import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastdfsTest {
	
	@Test
	public void testUpload() throws Exception{
		/*
		1、把FastDFS提供的jar包添加到工程中
		2、初始化全局配置。加载一个配置文件。
		3、创建一个TrackerClient对象。
		4、创建一个TrackerServer对象。
		5、声明一个StorageServer对象，null。
		6、获得StorageClient对象。
		7、直接调用StorageClient对象方法上传文件即可。
		*/
		
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
		String[] strings = storageClient.upload_file("C:\\Users\\KaKa\\Pictures\\Saved Pictures\\kobe bryant.jpg", "jpg", null);
		for(String string : strings){
			System.out.println(string);
		}
		
		
	}
	
	
	
}
