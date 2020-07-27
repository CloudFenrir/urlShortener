package com.nearsoft.java.urlshortener.Service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@Service
public class UrlService {

    private Map<String, String> storedUrl = new LinkedHashMap<String, String>();
    private final String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // This method receives the url and generates the ones that are not google or yahoo
    public String urlShortener(String longUrl){

        if(storedUrl.containsValue(longUrl)){
            for (Map.Entry<String, String> urls : storedUrl.entrySet()){
                String key = urls.getKey();
                String value = urls.getValue();
                if(value.equals(longUrl))
                    return key;
            }
        }else{
            String shortUrl = "";
            char [] charsUrl = longUrl.toCharArray();
            for (int i = 0; i < charsUrl.length; i++) {
                if(longUrl.matches(("(.*)google(.*)"))){
                    return generateShortUrl(5, longUrl);
                }else
                    if(longUrl.matches(("(.*)yahoo(.*)"))){
                        return generateShortUrl(7, longUrl);
                    }else
                        if(String.valueOf(charsUrl[i]).matches(("[^aeiou^«#$%&./,()=*0-9]")))
                            shortUrl += charsUrl[i];
            }
            storedUrl.put(shortUrl, longUrl);
            return shortUrl;
        }
        return null;
    }

    // This method generates the url for google and yahoo
    private String generateShortUrl(int n, String longUrl){
        final String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
        final String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        if(n == 5){
            for (int i = 0; i < n; i++) {
                int index = (int)(AlphaString.length()* Math.random());
                sb.append(AlphaNumericString.charAt(index));
            }
        }else
            if(n == 7){
                for (int i = 0; i < n; i++) {
                    int index = (int)(AlphaNumericString.length()* Math.random());
                    sb.append(AlphaNumericString.charAt(index));
                }
            }
            storedUrl.put(sb.toString(), longUrl);
            return sb.toString();
    }

    public String retrieveStoredUrl(String shortUrl){
        if(storedUrl.containsKey(shortUrl)){
            for (Map.Entry<String, String> urls : storedUrl.entrySet()) {
                String key = urls.getKey();
                String value = urls.getValue();
                if (key.equals(shortUrl))
                    return value;
            }
        }
        return null;
    }
}
