package org.opensearch.latencytester.transportservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.LocalNodeResponse;
import org.opensearch.common.io.stream.StreamInput;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.transport.TransportException;
import org.opensearch.transport.TransportResponseHandler;

import java.io.IOException;

public class LocalNodeResponseHandler implements TransportResponseHandler<LocalNodeResponse> {
    private static final Logger logger = LogManager.getLogger(LocalNodeResponseHandler.class);

    @Override
    public void handleResponse(LocalNodeResponse response) {
        logger.info("received {}", response);
    }

    @Override
    public void handleException(TransportException exp) {
        logger.info("LocalNodeRequest failed", exp);
    }

    @Override
    public String executor() {
        return ThreadPool.Names.GENERIC;
    }

    @Override
    public LocalNodeResponse read(StreamInput in) throws IOException {
        return new LocalNodeResponse(in);
    }
}