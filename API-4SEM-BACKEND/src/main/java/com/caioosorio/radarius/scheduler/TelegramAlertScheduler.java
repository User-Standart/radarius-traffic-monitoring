package com.caioosorio.radarius.scheduler;

import com.caioosorio.radarius.entity.AlertLog;
import com.caioosorio.radarius.entity.Criterion;
import com.caioosorio.radarius.entity.Region;
import com.caioosorio.radarius.repository.CriterionRepository;
import com.caioosorio.radarius.repository.RegionRepository;
import com.caioosorio.radarius.service.AlertLogService;
import com.caioosorio.radarius.service.TelegramService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Slf4j
@Component
public class TelegramAlertScheduler {
    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private CriterionRepository criterionRepository;

    @Autowired
    private TelegramService telegramService;

    @Value("${telegram.chat.id}")
    private String chatId;

    private Map<String, Short> lastLevels = new HashMap<>();

    @Scheduled(fixedRate = 2 * (60 * 1000))
    public void sendLevelChangeAlerts() {
        log.info("Verificando níveis...");


        Short newLevel = (short) (new Random().nextInt(5) + 1);
        Region region = regionRepository.findAll().getFirst();
        Criterion criterion = criterionRepository.findAll().getFirst();

        String key = region.getId() + "-" + criterion.getId();

        Short previousLevel = lastLevels.get(key);

        if (previousLevel == null || !newLevel.equals(previousLevel)) {

            lastLevels.put(key, newLevel);

            AlertLog alertLog = alertLogService.create(newLevel, criterion, region);

            if (alertLog.getAlert() != null) {
                String message = String.format(
                        "🚨 *ALERTA DE MUDANÇA DE NÍVEL*\n\n" +
                                "📍 *Região:* %s\n" +
                                "📊 *Critério:* %s\n" +
                                "⚠️ *Nível Anterior:* %s\n" +
                                "🔔 *Novo Nível:* %d",
                        (region != null ? region.getName() : "N/A"),
                        (criterion != null ? criterion.getName() : "N/A"),
                        (previousLevel != null ? previousLevel : "N/A"),
                        newLevel
                );

                try {
                    telegramService.sendMessage(chatId, message);
                    log.info("Alerta enviado via Telegram para a região {} e critério {} - mudança de nível {} para {}",
                            region.getName(), criterion.getName(), previousLevel, newLevel);
                } catch (Exception e) {
                    log.error("Erro ao enviar alerta via Telegram", e);
                }
            }
        } else {
            log.info("Nenhuma mudança de nível detectada. Nível atual: {}", newLevel);
        }
    }
}
