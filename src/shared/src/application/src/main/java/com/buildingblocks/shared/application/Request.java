package com.buildingblocks.shared.application;

public abstract class Request {
  private String aggregateId;

  protected Request(String aggregateId) {
    this.aggregateId = aggregateId;
  }

  public Request() {
  }

  public String getAggregateId() {
    return aggregateId;
  }

  public void setAggregateId(String aggregateId) {
    this.aggregateId = aggregateId;
  }
}
