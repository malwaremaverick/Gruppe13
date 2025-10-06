package no.hiof.journeyplanner.controller;

import no.hiof.journeyplanner.model.JourneyPlan;
import no.hiof.journeyplanner.service.JourneyPlannerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/journeyplans")
public class JourneyController {

    private final JourneyPlannerService planner = new JourneyPlannerService();

    @GetMapping
    public JourneyPlan searchJourney(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String arriveBy
    ) {
        LocalDateTime parsed = LocalDateTime.parse(arriveBy);
        return planner.planJourney(from, to, parsed);
    }
}
