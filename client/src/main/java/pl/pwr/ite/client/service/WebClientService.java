package pl.pwr.ite.client.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

public class WebClientService {
    private static WebClientService INSTANCE;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final WebClient webClient;

    public WebClientService() {
        webClient = buildDefaultClient("http://localhost:8080");
    }

    public WebClient buildDefaultClient(String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public <P, R> R sendRequest(HttpMethod method, String uri, P payload, Class<P> payloadType, Class<R> responseType) {
        return webClient
                .method(method)
                .uri(uri)
                .body(Mono.just(payload), payloadType)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .acceptCharset(StandardCharsets.UTF_8)
                .retrieve().bodyToMono(responseType)
                .block();
    }

    public <T> T sendRequest(String uri, Class<T> responseType) {
        return webClient
                .method(HttpMethod.GET)
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .acceptCharset(StandardCharsets.UTF_8)
                .retrieve()
                .bodyToMono(responseType)
                .block();
    }

    public <P, R> R sendRequest(String uri, P payload, Class<P> payloadType, Class<R> responseType) {
        return webClient
                .method(HttpMethod.POST)
                .uri(uri)
                .body(Mono.just(payload), payloadType)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .acceptCharset(StandardCharsets.UTF_8)
                .retrieve()
                .bodyToMono(responseType)
                .block();
    }

    public static WebClientService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new WebClientService();
        }
        return INSTANCE;
    }
}
