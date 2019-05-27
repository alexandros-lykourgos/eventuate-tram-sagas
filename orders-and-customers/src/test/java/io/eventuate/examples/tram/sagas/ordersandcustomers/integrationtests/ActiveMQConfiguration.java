package io.eventuate.examples.tram.sagas.ordersandcustomers.integrationtests;

import io.eventuate.jdbcactivemq.TramJdbcActiveMQConfiguration;
import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import(TramJdbcActiveMQConfiguration.class)
@Profile("ActiveMQ")
public class ActiveMQConfiguration {
}
