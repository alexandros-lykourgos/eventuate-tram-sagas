package io.eventuate.tram.sagas;

import io.eventuate.javaclient.spring.jdbc.EventuateSchema;
import io.eventuate.tram.sagas.orchestration.AggregateInstanceSubscriptionsDAO;

public class AggregateInstanceSubscriptionsDAOEmptySchemaTest extends AggregateInstanceSubscriptionsDAOSchemaTest {

  @Override
  protected AggregateInstanceSubscriptionsDAO getAggregateInstanceSubscriptionsDAO() {
    return new AggregateInstanceSubscriptionsDAO(new EventuateSchema(EventuateSchema.EMPTY_SCHEMA));
  }

  @Override
  protected String getExpectedInsert() {
    return "INSERT INTO aggregate_instance_subscriptions(aggregate_id, event_type, saga_type, saga_id) values(?, ?, ?, ?)";
  }

  @Override
  protected String getExpectedSelect() {
    return "select saga_type, saga_id from aggregate_instance_subscriptions where aggregate_id = ? and event_type = ?";
  }

  @Override
  protected String getExpectedDelete() {
    return "DELETE FROM aggregate_instance_subscriptions WHERE saga_type = ? AND saga_id =?";
  }
}
