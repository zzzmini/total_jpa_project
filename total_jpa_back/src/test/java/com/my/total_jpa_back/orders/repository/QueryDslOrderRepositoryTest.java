package com.my.total_jpa_back.orders.repository;

import com.my.total_jpa_back.common.entity.OrderStatus;
import com.my.total_jpa_back.orders.dto.OrderSearchCondition;
import com.my.total_jpa_back.orders.entity.UserOrder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Slf4j
class QueryDslOrderRepositoryTest {
    @Autowired
    QueryDslOrderRepository queryDslOrderRepository;

    @Test
    @DisplayName("QueryDSL로 동적 검색하기")
    void dslSearchTest() {
        // 검색 조건 DTO 생성
        OrderSearchCondition condition = new OrderSearchCondition();
        condition.setStatus(OrderStatus.COMPLETE);
        condition.setMinPrice(390000);
        condition.setUserName("kim");

        List<UserOrder> result = queryDslOrderRepository.search(condition);
        for(UserOrder order : result){
            System.out.println(order);
        }
    }
}