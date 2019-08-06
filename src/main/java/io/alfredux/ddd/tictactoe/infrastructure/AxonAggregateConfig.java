package io.alfredux.ddd.tictactoe.infrastructure;

import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonAggregateConfig {

    @Bean
    public JpaEventStorageEngine eventStorageEngine(EntityManagerProvider entityManagerProvider,
                                                    TransactionManager transactionManager) {
        return JpaEventStorageEngine.builder()
                .entityManagerProvider(entityManagerProvider)
                .transactionManager(transactionManager).build();
    }

}
