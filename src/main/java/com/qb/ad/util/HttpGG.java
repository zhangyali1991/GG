package com.qb.ad.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
/**
 * http请求方法
 */
public class HttpGG {
//    public static final String Access_Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE1OTQ5NTM3MTYwMjEsImV4cCI6MTYyNjQ4OTcxNn0.EOpScsrZyk4Br1-LTqtnYEnESrTicFA0iK8BZ_pm4toiWtUpxxWJBjpqN8rZdlCt4K01rQSf8P2tEp8z2F2IwA";

    public static String doPost(String url,String requestData) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        org.apache.http.client.methods.HttpPost post = new org.apache.http.client.methods.HttpPost(url);
        post.setHeader("Content-Type", "application/json;charset=utf-8");

        StringEntity entity = new StringEntity(requestData, "UTF-8");
        System.out.println("请求地址： "+ url);
        System.out.println("post请求报文requestData::"+requestData);
        post.setEntity(entity);
        CloseableHttpResponse response = client.execute(post);

        String result = EntityUtils.toString(response.getEntity());
        System.out.println("post响应报文:" + result);
        response.close();
        return result;
    }

    public static String doPost2(String url,String requestData,String Access_Token) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        org.apache.http.client.methods.HttpPost post = new org.apache.http.client.methods.HttpPost(url);
        post.setHeader("Content-Type", "application/json;charset=utf-8");
        post.setHeader("Access-Token", Access_Token);

        StringEntity entity = new StringEntity(requestData, "UTF-8");
        System.out.println("请求地址： "+ url);
        System.out.println("post请求报文requestData::"+requestData);
        post.setEntity(entity);
        CloseableHttpResponse response = client.execute(post);

        String result = EntityUtils.toString(response.getEntity());
        System.out.println("post响应报文result::    "+result);
        response.close();
        return result;
    }

    public static void doGet(String url) throws IOException{
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet post = new HttpGet(url);
        post.setHeader("Content-Type", "application/json;charset=utf-8");
        post.setHeader("Content-Encrypt", "ECC");
        HttpResponse resp = httpClient.execute(post);
        String result = EntityUtils.toString(resp.getEntity(), "utf-8");
        System.out.println("get响应报文result:{}" + result);
    }

    public static String doGet02(String url,String json) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestBuilder requestBuilder = RequestBuilder.get(url);
        requestBuilder.addHeader("Content-type", "application/json");
        System.out.println("请求地址： "+ url);
        System.out.println("get请求报文:" + json);
        StringEntity jsonBody = new StringEntity(json, ContentType.APPLICATION_JSON);
        requestBuilder.setEntity(jsonBody);
        HttpUriRequest httpRequest = requestBuilder.build();
        CloseableHttpResponse resp = httpClient.execute(httpRequest);
        String result = EntityUtils.toString(resp.getEntity(), "utf-8");
        System.out.println("get响应报文:" + result);
        return result;
    }
    public static String doPut(String url,String requestData) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        org.apache.http.client.methods.HttpPut put = new org.apache.http.client.methods.HttpPut(url);
        put.setHeader("Content-Type", "application/json;charset=utf-8");
        put.setHeader("Content-Encrypt", "ECC");
        StringEntity entity = new StringEntity(requestData, "UTF-8");
        System.out.println("请求地址： "+ url);
        System.out.println("put请求报文requestData::"+requestData);
        put.setEntity(entity);
        CloseableHttpResponse response = client.execute(put);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println("put响应报文" + result);
        response.close();
        return result;
    }
    }

