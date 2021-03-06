package com.piper.valley.models.service;

import com.piper.valley.models.domain.StoreProduct;
import com.piper.valley.models.enums.StoreStatus;
import com.piper.valley.models.repository.StoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StoreProductServiceImpl implements StoreProductService {

	@Autowired
	private StoreProductRepository storeProductRepository;

	@Override
	public Optional<StoreProduct> getProductById(Long id) {
		return storeProductRepository.findById(id);
	}

	public void incrementViews(StoreProduct storeProduct) {
		storeProduct.setStoreViews(storeProduct.getStoreViews()+1);
			storeProductRepository.save(storeProduct);
	}

	@Override
	public Collection<StoreProduct> getTop30() {
		return storeProductRepository.findAllTop30ByStore_StatusOrderByIdDesc(StoreStatus.ACCEPTED);
	}

	@Override
	public void remove(StoreProduct storeProduct) {
		storeProductRepository.delete(storeProduct);
	}
}
