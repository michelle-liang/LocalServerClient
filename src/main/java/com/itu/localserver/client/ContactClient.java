package com.itu.localserver.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;

import com.itu.util.Log4jUtil;

public class ContactClient {
//	static Logger logger = Log4jUtil.getLogger(ContactClient.class);
//
//	public static void main(String[] args) throws IOException {
//		// rest/person
//		String url0 = "http://localhost:8080/RESTfulItu/myserver/addressbook/";
//		String name = "gqq";
//		// putContacts(url0, name);
//		String url = url0 + name;
//		// getContacts(url);
//
//		// String url =
//		// "http://localhost:8080/RESTfulItu/myserver/addressbook/person";
//		// getPerson(url);
//
//		// get person lists
//		String pl_key = "persons";
//		getPersons(url0 + pl_key);
//	}
//
//	private static void getPersons(String url) throws IOException {
//		// TODO Auto-generated method stub
//		URL target = new URL(url);
//		HttpURLConnection conn = (HttpURLConnection) target.openConnection();
//		conn.setDoOutput(true);
//		conn.setDoInput(true);
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Content-Type", "application/x-protobuf");
//		conn.setRequestProperty("Accept", "application/x-protobuf");
//		conn.connect();
//		// check response code
//		int code = conn.getResponseCode();
//		boolean success = (code >= 200) && (code < 300);
//		// @SuppressWarnings("resource")
//		InputStream in = success ? conn.getInputStream() : conn
//				.getErrorStream();
//
//		int size = conn.getContentLength();
//
//		byte[] response = new byte[size];
//		int curr = 0, read = 0;
//
//		while (curr < size) {
//			read = in.read(response, curr, size - curr);
//			if (read <= 0)
//				break;
//			curr += read;
//		}
//
//		AddressBook ab = AddressBook.parseFrom(response);
//
//		for (Person p : ab.getPersonList()) {
//			logger.debug(String.format("id:%d, name:%s, mail:%s", p.getId(),
//					p.getName(), p.getEmail()));
//		}
//
//	}

//	public static void putContacts(String url, String name) throws IOException {
//		File file = new File(CreatePerson.FILE_PATH + name + ".per");
//		Person p = Person.parseFrom(new FileInputStream(file));
//		byte[] content = p.toByteArray();
//
//		URL target = new URL(url);
//		HttpURLConnection conn = (HttpURLConnection) target.openConnection();
//		conn.setDoOutput(true);
//		conn.setDoInput(true);
//		conn.setRequestMethod("PUT");
//		conn.setRequestProperty("Content-Type", "application/x-protobuf");
//		conn.setRequestProperty("Accept", "application/x-protobuf;q=0.5");
//
//		conn.setRequestProperty("Content-Length",
//				Integer.toString(content.length));
//		// set stream mode to decrease memory usage
//		conn.setFixedLengthStreamingMode(content.length);
//		OutputStream out = conn.getOutputStream();
//		out.write(content);
//		out.flush();
//		out.close();
//		conn.connect();
//		// check response code
//		int code = conn.getResponseCode();
//		boolean success = (code >= 200) && (code < 300);
//		logger.debug("code" + code);
//		System.out.println("put person:" + name + " "
//				+ (success ? "successful!" : "failed!"));
//	}
//
//	public static void getContacts(String url) throws IOException {
//		URL target = new URL(url);
//		HttpURLConnection conn = (HttpURLConnection) target.openConnection();
//		conn.setDoOutput(true);
//		conn.setDoInput(true);
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Content-Type", "application/x-protobuf");
//		conn.setRequestProperty("Accept", "application/x-protobuf");
//		conn.connect();
//		// check response code
//		int code = conn.getResponseCode();
//		boolean success = (code >= 200) && (code < 300);
//		// @SuppressWarnings("resource")
//		InputStream in = success ? conn.getInputStream() : conn
//				.getErrorStream();
//
//		int size = conn.getContentLength();
//
//		byte[] response = new byte[size];
//		int curr = 0, read = 0;
//
//		while (curr < size) {
//			read = in.read(response, curr, size - curr);
//			if (read <= 0)
//				break;
//			curr += read;
//		}
//
//		Person p = Person.parseFrom(response);
//		System.out.println("id:" + p.getId());
//		System.out.println("name:" + p.getName());
//		System.out.println("email:" + p.getEmail());
//		List<PhoneNumber> pl = p.getPhoneList();
//		for (PhoneNumber pn : pl) {
//			System.out.println("number:" + pn.getNumber() + " type:"
//					+ pn.getType().name());
//		}
//	}
//
//	public static void getPerson(String url) throws IOException {
//		URL target = new URL(url);
//		HttpURLConnection conn = (HttpURLConnection) target.openConnection();
//		conn.setDoOutput(true);
//		conn.setDoInput(true);
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Content-Type", "application/x-protobuf");
//		conn.setRequestProperty("Accept", "application/x-protobuf");
//		conn.connect();
//		// check response code
//		int code = conn.getResponseCode();
//		boolean success = (code >= 200) && (code < 300);
//		// @SuppressWarnings("resource")
//		InputStream in = success ? conn.getInputStream() : conn
//				.getErrorStream();
//
//		int size = conn.getContentLength();
//
//		byte[] response = new byte[size];
//		int curr = 0, read = 0;
//
//		while (curr < size) {
//			read = in.read(response, curr, size - curr);
//			if (read <= 0)
//				break;
//			curr += read;
//		}
//
//		Person p = Person.parseFrom(response);
//		System.out.println("id:" + p.getId());
//		System.out.println("name:" + p.getName());
//		System.out.println("email:" + p.getEmail());
//		List<PhoneNumber> pl = p.getPhoneList();
//		for (PhoneNumber pn : pl) {
//			System.out.println("number:" + pn.getNumber() + " type:"
//					+ pn.getType().name());
//		}
//	}
}
