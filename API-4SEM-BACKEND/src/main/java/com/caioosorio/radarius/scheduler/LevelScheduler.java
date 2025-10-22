package com.caioosorio.radarius.scheduler;

import com.caioosorio.radarius.entity.Criterion;
import com.caioosorio.radarius.entity.Region;
import com.caioosorio.radarius.repository.CriterionRepository;
import com.caioosorio.radarius.repository.RegionRepository;
import com.caioosorio.radarius.service.AlertLogService;
import com.caioosorio.radarius.service.CriterionService;
import com.caioosorio.radarius.service.RegionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class LevelScheduler {
    @Autowired
    private AlertLogService alertLogService;
    @Autowired
    private RegionRepository regionService;
    @Autowired
    private CriterionRepository criterionService;

    @Scheduled(fixedRate = 2 * (60 * 1000))
    public void checkLevels() {
        System.out.println("Checking levels...");
        Short previousLevel = (short) (new Random().nextInt(5) + 1);
        Short newLevel = (short) (new Random().nextInt(5) + 1);
        Region region = regionService.findById(1).orElse(null);
        Criterion criterion = criterionService.findById(1).orElse(null);

        if (!newLevel.equals(previousLevel)) {
//            alertLogService.create(newLevel, criterion, region);
        }
    }
}
