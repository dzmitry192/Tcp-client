package com.tcpclient.config.deserializer;

import org.springframework.integration.ip.tcp.serializer.AbstractByteArraySerializer;

import java.io.*;
import java.net.SocketException;

public class CustomDeserializer extends AbstractByteArraySerializer {

    @Override
    public void serialize(byte[] bytes, OutputStream outputStream) throws IOException {
        outputStream.write(bytes);
    }

    @Override
    public byte[] deserialize(InputStream inputStream) throws IOException {
        try {
            return new byte[] {(byte) inputStream.read()};
        } catch (Exception e) {
            throw new SocketException(e.getMessage());
        }
    }
}
