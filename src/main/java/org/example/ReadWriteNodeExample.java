/*
 * Copyright (c) 2019 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.example;

import java.util.concurrent.CompletableFuture;

import org.eclipse.milo.opcua.stack.core.types.builtin.*;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadWriteNodeExample implements ClientExample {

    public static void main(String[] args) throws Exception {
        ReadWriteNodeExample example = new ReadWriteNodeExample();

        new ClientExampleRunner(example, false).run();
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(OpcUaClient client, CompletableFuture<OpcUaClient> future) throws Exception {
        // synchronous connect
        client.connect().get();

        // synchronous read request via VariableNode
        UaVariableNode node = client.getAddressSpace().getVariableNode(
            new NodeId(2, "HelloWorld/ScalarTypes/Double")
        );

        logger.info("DataType={}", node.getDataType());

        // Read the current value
        DataValue value = node.readValue();
        logger.info("Value bf={} ", value);

        Variant variant = value.getValue();
        node.writeValue(new DataValue(new Variant(3.14d)));

        // Read the modified value back
        logger.info("Value af={} ", node.readValue());

        future.complete(client);
    }

}