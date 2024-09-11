package com.abc.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.model.Query;
import com.abc.backend.repository.QueryRepository;
import com.abc.backend.service.QueryService;

@Service
public class QueryServiceImpl implements QueryService{

    @Autowired
    private QueryRepository queryRepository;

    public List<Query> allQueries() {
        return queryRepository.findAll();
    }

    public Query addQuery(Query query) {
        return queryRepository.save(query);
    }

}
