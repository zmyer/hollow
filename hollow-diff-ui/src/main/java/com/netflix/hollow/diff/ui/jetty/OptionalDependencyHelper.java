/*
 *
 *  Copyright 2017 Netflix, Inc.
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
package com.netflix.hollow.diff.ui.jetty;

import com.netflix.hollow.ui.jetty.AbstractOptionalDependencyHelper;

final class OptionalDependencyHelper extends AbstractOptionalDependencyHelper {
    HollowDiffUIServer.UIServer.Factory uiServerFactory() {
        return (HollowDiffUIServer.UIServer.Factory)newFactory(
                "com.netflix.hollow.diff.ui.jetty.JettyBasedUIServer$Factory",
                "org.eclipse.jetty.server.Server",
                "please add jetty-server (org.eclipse.jetty:jetty-server) to your dependencies");
    }

    OptionalDependencyHelper() {}
}
