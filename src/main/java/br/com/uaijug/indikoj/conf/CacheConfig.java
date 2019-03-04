package br.com.uaijug.indikoj.conf;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@EnableCaching
@Configuration
public class CacheConfig {

	@Bean
	public CaffeineCache clientsCache() {
		return new CaffeineCache("companysInCache",
				Caffeine.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).maximumSize(100).build());
	}

	@Bean
	public CaffeineCache clientTypesCache() {
		return new CaffeineCache("companysTypesInCache",
				Caffeine.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).maximumSize(100).build());
	}

	@Bean
	public CaffeineCache candidatesCache() {
		return new CaffeineCache("candidatesInCache",
				Caffeine.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).maximumSize(100).build());
	}

	@Bean
	public CaffeineCache jobOpportunitysCache() {
		return new CaffeineCache("jobOpportunitysInCache",
				Caffeine.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).maximumSize(100).build());
	}
}
