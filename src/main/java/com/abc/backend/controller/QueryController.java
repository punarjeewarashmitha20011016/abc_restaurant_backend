package com.abc.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.backend.model.Query;
import com.abc.backend.service.QueryService;

@RestController
@RequestMapping("/api/query")
@CrossOrigin(origins = "*") 
public class QueryController {

    @Autowired
    private QueryService queryService;

    @GetMapping("/allQueries")
    public ResponseEntity<List<Query>> getAllQueries() {
        return new ResponseEntity<>(queryService.allQueries(), HttpStatus.OK);
    }

    @PostMapping("/addQuery")
    public ResponseEntity<Query> addQuery(@RequestBody Query query) {
        Query newQuery = queryService.addQuery(query);
        return new ResponseEntity<>(newQuery, HttpStatus.CREATED);
    }
}
