package com.tcpclient.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.tcpclient.config.deserializer.CustomDeserializer;
import com.tcpclient.config.mapper.XmlMapperConfig;
import com.tcpclient.model.entity.EventEntity;
import com.tcpclient.model.xml.Msg;
import com.tcpclient.model.xml.XmlCs;
import com.tcpclient.service.EventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.ip.tcp.TcpReceivingChannelAdapter;
import org.springframework.integration.ip.tcp.connection.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Configuration
@EnableIntegration
@RequiredArgsConstructor
public class TcpClientConfig {

    @Value(value = "${tcp.server.host}")
    private String host;

    @Value(value = "${tcp.server.port}")
    private Integer port;

    private final EventServiceImpl eventService;

    private String receivedMessage = "";

    @Bean
    public IntegrationFlow integrationFlow() {
        return IntegrationFlow
                .from(tcpReceivingChannelAdapter())
                .handle(message -> receivedMessage += new String((byte[]) message.getPayload()))
                .get();
    }

    @Bean
    public TcpReceivingChannelAdapter tcpReceivingChannelAdapter() {
        return Tcp.inboundAdapter(tcpNetClientConnectionFactory())
                .clientMode(true)
                .getObject();
    }

    @Bean
    public TcpNetClientConnectionFactory tcpNetClientConnectionFactory() {
        return Tcp.netClient(host, port)
                .soReceiveBufferSize(10 * 1024 * 1024)
                .deserializer(new CustomDeserializer())
                .getObject();
    }

    @EventListener(TcpConnectionCloseEvent.class)
    private void socketClosedEvent() throws JsonProcessingException {
        eventService.saveEvent(receivedMessage + "</xml_cs>");
        receivedMessage = "";
    }
}