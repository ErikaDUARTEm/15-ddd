package com.buildingblocks.shared.domain.generic;

import java.time.Instant;
import java.util.UUID;

public abstract class DomainEvent {
  private final Instant when;
  private final String uuid;
  private final String name;
  private  String aggregateRootId;
  private String aggregateName;
  private Long version;

  protected DomainEvent(String name){
    this.when = Instant.now();
    this.uuid = UUID.randomUUID().toString();
    this.name = name;
    this.version = 1L;

  }
}
