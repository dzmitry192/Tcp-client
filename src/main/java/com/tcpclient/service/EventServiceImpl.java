package com.tcpclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.tcpclient.config.mapper.XmlMapperConfig;
import com.tcpclient.model.xml.Msg;
import com.tcpclient.repository.EventRepository;
import com.tcpclient.service.api.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public void saveEvent(String receivedMessage) throws JsonProcessingException {
        log.info("Save message: {}", receivedMessage);
        JsonNode msgs = XmlMapperConfig.getXmlMapper().readTree(receivedMessage).path("packet").path("msg");
        Msg msg = XmlMapperConfig.getXmlMapper().treeToValue(msgs, Msg.class);
        eventRepository.save(Msg.toEventEntity(msg));
        log.info("Event was successfully saved");
    }
}
