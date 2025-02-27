package com.buildingblocks.movementsandtactics.infra.mainservice.controllers;

import com.buildingblocks.movementsandtactics.application.getShifts.GetAllShiftsUseCase;
import com.buildingblocks.movementsandtactics.application.shared.movements.ManageShiftUseCaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/get-shifts")
public class GetAllShiftsController {
  private final GetAllShiftsUseCase useCase;

  public GetAllShiftsController(GetAllShiftsUseCase useCase) {
    this.useCase = useCase;
  }
  @GetMapping
  public Flux<ManageShiftUseCaseResponse> execute(){
    return useCase.execute();
  }
}
