package com.purpleAdmin.qa.testcases;
import java.io.File;
import java.io.FileInputStream;

import org.testng.annotations.Test;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.purpleAdmin.qa.util.TestUtil;


public class WebFileUploadTestCase {
	 static String path = System.getProperty("user.dir");
	@Test()
	public void SendReportToBlob(){
		try
		{   
			String fileDateSuffix = TestUtil.getFileDateAsSufix();
			CloudStorageAccount account = CloudStorageAccount.parse("DefaultEndpointsProtocol=http;AccountName=ljimageblob;AccountKey=bxy7jjJXvF6QWkUPaDyaNjAn9EqaLPG9/7XEnhKgcY1lcme03/RsoZdN8zmD/EI2tL1Aula3qlfU01eTsSQ96g==");
			CloudBlobClient client = account.createCloudBlobClient();
			CloudBlobContainer container = client.getContainerReference("wayfinder-blob-dev");
			CloudBlockBlob blob = container.getBlockBlobReference("webautomation/WebLogin.html"+"_"+fileDateSuffix); 
			File sourceFile = new File(path+"/src/main/resources/reports/WebLogin.html");
			FileInputStream inputStream = new FileInputStream(sourceFile);
			blob.getProperties().setContentType("text/html");
			blob.upload(inputStream, sourceFile.length());
			System.out.print("Successfully uploaded");
		}catch (Exception e) {
			e.printStackTrace();

		}
		
	}
}
