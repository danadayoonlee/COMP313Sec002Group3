package com.curahealthyme.s3utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@Component
public class S3Util {

	private static final String bucketName = "yourbucketname";

	private AmazonS3 s3Client;

	@Value("${awsAccessKey}")
	private String accessKey;

	@Value("${awsSecretKey}")
	private String secretKey;

	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_2).build();

	}

	public void uploadFile(String key, File file) {
		this.s3Client.putObject(bucketName, key, file);
	}

	public byte[] downloadFile(String key) {

		S3Object s3object = this.s3Client.getObject(bucketName, key);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		byte[] byteArray = null;
		try {
			byteArray = IOUtils.toByteArray(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return byteArray;
	}

	public void deleteFile(String key) {
		this.s3Client.deleteObject(bucketName, key);
		
	}
	
	public String getFIleUrl(String key) {
		return s3Client.getUrl(bucketName, key).toString();

	}
}

