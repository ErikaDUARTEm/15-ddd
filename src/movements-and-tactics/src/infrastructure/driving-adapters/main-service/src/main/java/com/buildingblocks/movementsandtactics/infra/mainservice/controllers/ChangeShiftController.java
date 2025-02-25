package com.buildingblocks.movementsandtactics.infra.mainservice.controllers;

import com.buildingblocks.movementsandtactics.application.changeShift.ChangeShiftUseCase;
import com.buildingblocks.movementsandtactics.application.changeShift.ChangeShiftUseCaseRequest;
import com.buildingblocks.movementsandtactics.application.shared.movements.ChangeShiftUseCaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/change-shift")
public class ChangeShiftController {
  private final ChangeShiftUseCase useCase;

  public ChangeShiftController(ChangeShiftUseCase useCase){
    this.useCase = useCase;
  }
  @PostMapping
  public Mono<ChangeShiftUseCaseResponse> execute(@RequestBody ChangeShiftUseCaseRequest request){
    return useCase.execute(request);
  }
}
