package com.sparta.order.domain.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OrderQueryDslConfig {
  private final EntityManager entityManager;

  @Bean
  public JPAQueryFactory jpaQueryFactory() {
    return new JPAQueryFactory(entityManager);
  }
}
