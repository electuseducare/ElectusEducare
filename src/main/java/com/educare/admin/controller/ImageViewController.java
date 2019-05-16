package com.educare.admin.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class ImageViewController {


	@RequestMapping(value = "/ViewImage", method = RequestMethod.GET)
	public void viewImage(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String imageName = request.getParameter("imageID");
		File file = null;
		String rootPath = System.getProperty("catalina.home");
		File dir = new File(rootPath + File.separator + "Organizationlogo");
		file = new File(dir+file.separator + imageName);
		if (!file.exists()) {
			if(!file.exists())
			{
			String errorMessage = "No Image";
			
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
			}
			
			}
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
	
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}

		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
		response.setContentLength((int) file.length());
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	
	
	@RequestMapping(value = "/load-viewBarcodeImage", method = RequestMethod.GET)
	public void viewBarcodeImage(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String imageName = request.getParameter("barcodeimageID");
		File file = null;
		String rootPath = System.getProperty("catalina.home");
		File dir = new File(rootPath + File.separator + "barcode");
		file = new File(dir+file.separator + imageName);
		if (!file.exists()) {
			if(!file.exists())
			{
				String errorMessage = "No Image";
				
				OutputStream outputStream = response.getOutputStream();
				outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
				outputStream.close();
				return;
			}
			
		}
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
		response.setContentLength((int) file.length());
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	
}