package com.nearsoft.java.urlshortener.Controller;

import com.nearsoft.java.urlshortener.Model.UrlModel;
import com.nearsoft.java.urlshortener.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping("/url")
    public String convertToShortUrl(@RequestBody UrlModel url){
        return urlService.urlShortener(url.getUrl());
    }

    @GetMapping(value = "{shortUrl}")
    public ResponseEntity<String> getUrl(@PathVariable String shortUrl){
        String url = urlService.retrieveStoredUrl(shortUrl);
        if (url == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(url);
    }
}
