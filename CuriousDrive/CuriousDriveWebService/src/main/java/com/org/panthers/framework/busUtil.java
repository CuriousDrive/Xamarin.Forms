package com.org.panthers.framework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.org.panthers.business.busConstant;

public class busUtil {

	public static SessionFactory iSessionFactory;
	private static final String PARAGRAPH_SPLIT_REGEX = "\\r?\\n";
	String result = "";
	InputStream inputStream;

	public static SessionFactory createSessionFactory() {

		SessionFactory sessionFactory;
		ServiceRegistry serviceRegistry;

		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static void loadSessionFactory() {

		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		iSessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static String getStackTrace(Exception ex) {

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		ex.printStackTrace(printWriter);
		return stringWriter.toString();
	}

	public String getStringFromFile(String fileName) {

		String result = "";

		ClassLoader classLoader = getClass().getClassLoader();
		try {
			result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String convertHTMLtoString(String astrHtml, int aintStringLength) {
		
		if(astrHtml != null)
		{
			String lstrFinalString;
			
			Document ldocument = Jsoup.parse(astrHtml);
			lstrFinalString = ldocument.body().text();
			if(lstrFinalString.length() > aintStringLength)
				lstrFinalString = StringUtils.substring(lstrFinalString, 0, aintStringLength) + "...";
			lstrFinalString = lstrFinalString.replaceAll("\u00A0", "");
			lstrFinalString.trim();
			
			return lstrFinalString;
		}
		else
			return "";
	}

	public void sendEmail(String astrToEmailAddress, String astrSubject,String astrHTMLTemplatePath, Object[] aobjTemplateParameters) throws IOException {
		// TODO Auto-generated method stub
		
		busMultithreadingEmail lbusMultithreadingEmail = new busMultithreadingEmail();
		lbusMultithreadingEmail.istrToEmailAddress = astrToEmailAddress;
		lbusMultithreadingEmail.istrSubject = astrSubject;
		lbusMultithreadingEmail.istrHTMLTemplatePath = astrHTMLTemplatePath;
		lbusMultithreadingEmail.iobjTemplateParameters = aobjTemplateParameters;
		
		lbusMultithreadingEmail.run();
		
	}
	
	public String getPropValues(String astrProperty) throws IOException {
		 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			// get the property value and print it out
			result = prop.getProperty(astrProperty);
		
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}

	public Response getResponse(Object aobjResponse){
		
		return Response.ok(aobjResponse, MediaType.APPLICATION_JSON).build();
	}
	
	public String shortenUrl(String longUrl){
	     
	    if (longUrl == null) {
	        return longUrl;
	    }else if(!longUrl.startsWith("http://") && !longUrl.startsWith("https://")){
	        longUrl = "http://"+longUrl;
	    }
	    try {
	        String json = "{\"longUrl\": \""+longUrl+"\"}";   
	        String apiURL = busConstant.GoogleUrlShortApi +"?key="+ busConstant.GoogleApiKey;
	         
	        HttpPost postRequest = new HttpPost(apiURL);
	        postRequest.setHeader("Content-Type", "application/json");
	        postRequest.setEntity(new StringEntity(json, "UTF-8"));
	 
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        HttpResponse response = httpClient.execute(postRequest);
	        String responseText = EntityUtils.toString(response.getEntity());           
	         
	        Gson gson = new Gson();
	        @SuppressWarnings("unchecked")
	        HashMap<String, String> res = gson.fromJson(responseText, HashMap.class);
	 
	        return res.get("id");            
	         
	    } catch (MalformedURLException e) {
	        return "error";
	    } catch (IOException e) {
	        return "error";
	    }
	 }

	public static String getTitleUrl(String astrTitle)
	{
		String lstrTitleUrl;
		
		lstrTitleUrl = astrTitle.toLowerCase();
		lstrTitleUrl = lstrTitleUrl.replaceAll("\\s+", "-");
		lstrTitleUrl = lstrTitleUrl.replace("?", "");
		lstrTitleUrl = lstrTitleUrl.replace("(", "");
		lstrTitleUrl = lstrTitleUrl.replace(")", "");
		lstrTitleUrl = lstrTitleUrl.replace(".", "");
		lstrTitleUrl = lstrTitleUrl.replace(":", "");
		
		return lstrTitleUrl;	
	}
}
