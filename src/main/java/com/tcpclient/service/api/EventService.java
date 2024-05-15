package com.tcpclient.service.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcpclient.model.entity.EventEntity;

public interface EventService {

    void saveEvent(String receivedMessage) throws JsonProcessingException;
}
