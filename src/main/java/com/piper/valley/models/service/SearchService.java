package com.piper.valley.models.service;
import com.piper.valley.models.common.SearchResult;
import com.piper.valley.models.domain.Store;
import com.piper.valley.models.domain.StoreProduct;

import java.util.List;

public interface SearchService {
    SearchResult generalSearch(String queryString);
    SearchResult autoCompleteSearch(String queryString);
    List<StoreProduct> storeProductSearch(String queryString, Integer maxTimeLimit);
    List<Store> storeSearch(String queryString, Integer maxTimeLimit);
}
