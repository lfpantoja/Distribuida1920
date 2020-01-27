package com.distribuida.server.conf;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpExaUtils {

	public static <T> T invoke(String url, Class<T> cls) {

		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet get = new HttpGet(url);

		get.addHeader("Accept", MediaType.APPLICATION_JSON);

		T dto;
		try {
			dto = httpClient.execute(get, response -> {

				int status = response.getStatusLine().getStatusCode();

				if (status == 200) {

					return new ObjectMapper().readValue(response.getEntity().getContent(), cls);
				}

				return null;
			});
		} catch (IOException e) {
			e.printStackTrace();

			return null;
		}

		return dto;
	}
}
