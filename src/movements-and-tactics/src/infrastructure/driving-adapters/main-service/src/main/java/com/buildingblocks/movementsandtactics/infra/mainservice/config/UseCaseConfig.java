package com.buildingblocks.movementsandtactics.infra.mainservice.config;

import com.buildingblocks.movementsandtactics.application.changeShift.ChangeShiftUseCase;
import com.buildingblocks.movementsandtactics.application.createShifts.ManageShiftUseCase;
import com.buildingblocks.movementsandtactics.application.getShifts.GetAllShiftsUseCase;
import com.buildingblocks.movementsandtactics.infra.mongo.adapters.MongoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
  @Bean
  public ManageShiftUseCase ManageShiftUseCase(MongoAdapter adapter) {
    return new ManageShiftUseCase(adapter);
  }
  @Bean
  public ChangeShiftUseCase ChangeShiftUseCase(MongoAdapter adapter){
    return new ChangeShiftUseCase(adapter);
  }
  @Bean
  public GetAllShiftsUseCase getAllShiftsUseCase(MongoAdapter adapter) {
    return new GetAllShiftsUseCase(adapter);
  }
}
