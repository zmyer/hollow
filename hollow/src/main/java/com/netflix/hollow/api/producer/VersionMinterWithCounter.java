/*
 *
 *  Copyright 2016 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.hollow.api.producer;

import com.netflix.hollow.api.producer.HollowProducer.VersionMinter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A {@link VersionMinter}, which combines a timestamp with a repeating 3-digit sequence number
 *
 * @author Tim Taylor {@literal<tim@toolbear.io>}
 */
public class VersionMinterWithCounter implements HollowProducer.VersionMinter {

    private static AtomicInteger versionCounter = new AtomicInteger();

    /**
     * Create a new state version.<p>
     *
     * State versions should be ascending -- later states have greater versions.<p>
     *
     * Here we use an easily readable timestamp format.
     *
     * @return a new state version
     */
    public long mint() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = dateFormat.format(new Date());

        String versionStr = formattedDate + String.format("%03d", versionCounter.incrementAndGet() % 1000);

        return Long.parseLong(versionStr);
    }

}
