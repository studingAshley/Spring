package com.java.www.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.IncomeSelectDto;
import com.java.www.service.IncomeService;

@Controller
public class FController {

	@Autowired
	IncomeService serv;

	@GetMapping("/")
	public String main() {
		return "layout/main";
	}

	@GetMapping("layout/chart")
	public String chart() {
		return "layout/chart";
	}

	@PostMapping("/layout/incomeSelect")
	@ResponseBody
	public ArrayList<IncomeSelectDto> incomeSelect(String cyear) {

		ArrayList<IncomeSelectDto> selectDto = serv.incomeSelectYear(cyear);

		return selectDto;
	}

	@GetMapping("layout/publicData")
	public String publicData() {
		return "layout/publicData";
	}

	@PostMapping("/layout/searchData")
	@ResponseBody
	public String searchData(String txt) throws IOException {
		String result = "";
		String serviceKey ="ug6PU1xTJgPhLhYpjU%2BUP%2F49s5oHuVCoKFmACMSq0YBgjzPgbN01TCNa%2F4Vxm8hTj8YUJ%2BSE27aIt%2BI%2FmaIENw%3D%3D";
		if(txt.equals(""))
		{
			result = getList(serviceKey, txt);
		}
		else
		{
			result = searchList(serviceKey, txt, "1");
		}
		
		return result;
			
	}
	
	public String getList(String serviceKey, String txt) throws IOException	{

		System.out.println("txt : " + txt);

		JSONObject jobj = new JSONObject();

		
		
		String page = 1+"";
		StringBuilder urlBuilder = new StringBuilder(
				"https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1"); /* URL */

		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey);
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*목록 건수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*선거ID*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*정당명*/
        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); 
        
		 
		URL url = new URL(urlBuilder.toString());
		
//		URL url = new URL("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=ug6PU1xTJgPhLhYpjU%2BUP%2F49s5oHuVCoKFmACMSq0YBgjzPgbN01TCNa%2F4Vxm8hTj8YUJ%2BSE27aIt%2BI%2FmaIENw%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A&_type=json");
				
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		return sb.toString();
	}
	
	public String searchList(String serviceKey, String txt, String page) throws IOException
	{
		StringBuilder urlBuilder = new StringBuilder(
				"https://apis.data.go.kr/B551011/PhotoGalleryService1/gallerySearchList1"); /* URL */

		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey);
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*목록 건수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*선거ID*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*정당명*/
        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode(txt, "UTF-8"));
        
		 
		URL url = new URL(urlBuilder.toString());
		
//		URL url = new URL("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=ug6PU1xTJgPhLhYpjU%2BUP%2F49s5oHuVCoKFmACMSq0YBgjzPgbN01TCNa%2F4Vxm8hTj8YUJ%2BSE27aIt%2BI%2FmaIENw%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A&_type=json");
				
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		
		
		return sb.toString();
	}
	
	
	@GetMapping("/layout/screenData")
	public String screenData() {
		
		
		return "/layout/screenData";
	}
	
	
	@PostMapping("/layout/searchScreen")
	@ResponseBody
	public String searchScreen(String txt) throws IOException {

		String serviceKey = "7058445392fd0398bcb479690ffa9ee6";
		StringBuilder urlBuilder = new StringBuilder(
				"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"); /* URL */

		urlBuilder.append("?" + URLEncoder.encode("key","UTF-8") + "=" + serviceKey);
		
		if(txt.equals(""))
		{
			urlBuilder.append("&" + URLEncoder.encode("targetDt","UTF-8") + "=" + URLEncoder.encode("20230101", "UTF-8"));
		}
		else
		{
			urlBuilder.append("&" + URLEncoder.encode("targetDt","UTF-8") + "=" + URLEncoder.encode(txt, "UTF-8"));
		}
   
		 
		URL url = new URL(urlBuilder.toString());
		
//		URL url = new URL("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=ug6PU1xTJgPhLhYpjU%2BUP%2F49s5oHuVCoKFmACMSq0YBgjzPgbN01TCNa%2F4Vxm8hTj8YUJ%2BSE27aIt%2BI%2FmaIENw%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A&_type=json");
				
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		
		
		return sb.toString();
			
	}
	
	
	@GetMapping("/layout/bikeData")
	public String bikeData() {
		
		
		return "/layout/bikeData";
	}
	
	@PostMapping("/layout/searchBike")
	@ResponseBody
	public String searchBike(String txt) throws IOException {

		String serviceKey = "685656644d626165313230624654524c";
		String seoulURL = "http://openapi.seoul.go.kr:8088/"+serviceKey+"/json/bikeList/1/1000";
		StringBuilder urlBuilder = new StringBuilder(
				seoulURL); /* URL */

/*		urlBuilder.append("?" + URLEncoder.encode("KEY","UTF-8") + "=" + serviceKey);
		urlBuilder.append("?" + URLEncoder.encode("TYPE","UTF-8") + "=" + "json");
		urlBuilder.append("?" + URLEncoder.encode("SERVICE","UTF-8") + "=" + "bikeList");
		urlBuilder.append("?" + URLEncoder.encode("START_INDEX","UTF-8") + "=" + "1");
		urlBuilder.append("?" + URLEncoder.encode("END_INDEX","UTF-8") + "=" + "1000");*/
		

		URL url = new URL(urlBuilder.toString());
		
//		URL url = new URL("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=ug6PU1xTJgPhLhYpjU%2BUP%2F49s5oHuVCoKFmACMSq0YBgjzPgbN01TCNa%2F4Vxm8hTj8YUJ%2BSE27aIt%2BI%2FmaIENw%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A&_type=json");
				
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		
		
		return sb.toString();
			
	}
	
}
