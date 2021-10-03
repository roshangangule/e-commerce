package com.ecommerce.config;

import org.hibernate.boot.Metadata;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		HttpMethod[] theUnSupportedMethod = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
		
		config.getExposureConfiguration()
			  .forDomainType(Product.class)
			  .withItemExposure((metData, httpMethods) -> httpMethods.disable(theUnSupportedMethod))
			  .withCollectionExposure((metData, httpMethods) -> httpMethods.disable(theUnSupportedMethod));
		
		config.getExposureConfiguration()
		  .forDomainType(ProductCategory.class)
		  .withItemExposure((metData, httpMethods) -> httpMethods.disable(theUnSupportedMethod))
		  .withCollectionExposure((metData, httpMethods) -> httpMethods.disable(theUnSupportedMethod));
	}

	
}
