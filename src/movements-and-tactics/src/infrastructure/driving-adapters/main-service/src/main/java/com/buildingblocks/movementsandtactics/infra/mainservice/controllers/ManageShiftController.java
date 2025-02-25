package com.buildingblocks.movementsandtactics.infra.mainservice.controllers;

import com.buildingblocks.movementsandtactics.application.createShifts.ManageShiftUseCase;
import com.buildingblocks.movementsandtactics.application.shared.movements.ManageShiftUseCaseRequest;
import com.buildingblocks.movementsandtactics.application.shared.movements.ManageShiftUseCaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/create-shift")
public class ManageShiftController {
  private final ManageShiftUseCase useCase;

  public ManageShiftController(ManageShiftUseCase useCase) {
    this.useCase = useCase;
  }
  @PostMapping
  public Mono<ManageShiftUseCaseResponse> execute(@RequestBody ManageShiftUseCaseRequest request){
    return useCase.execute(request);
  }
}
