package com.abc.backend.service;

import java.util.List;

import com.abc.backend.model.Query;

public interface QueryService {

    public List<Query> allQueries();
    public Query addQuery(Query query);

}
