package com.caioosorio.radarius.scheduler;

import com.caioosorio.radarius.entity.Criterion;
import com.caioosorio.radarius.entity.Region;
import com.caioosorio.radarius.service.AlertLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LevelScheduler {
    @Autowired
    private AlertLogService alertLogService;

    @Scheduled(fixedRate = 2 * (60 * 1000))
    public void checkLevels() {
        System.out.println("Checking levels...");
        Short previousLevel = 1;
        Short newLevel = 2;
        Region region = Region.builder()
                .id(97)
                .name("Região Teste")
                .build();
        Criterion criterion = Criterion.builder()
                .id(1)
                .name("Critério Teste")
                .build();

        if (!newLevel.equals(previousLevel)) {
            alertLogService.create(newLevel, criterion, region);
        }
    }
}
