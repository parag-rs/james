/*
 * Copyright 2017 TomTom International B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tomtom.james.script;

import com.google.common.base.MoreObjects;
import com.tomtom.james.common.api.script.RuntimeInformationPointParameter;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

public final class ErrorHandlerContext extends InformationPointHandlerContext {

    private final Throwable errorCause;

    public ErrorHandlerContext(String informationPointClassName,
                               String informationPointMethodName,
                               Method origin,
                               List<RuntimeInformationPointParameter> runtimeParameters,
                               Object runtimeInstance,
                               Thread currentThread,
                               Duration executionTime,
                               String[] callStack,
                               Throwable errorCause) {
        super(informationPointClassName, informationPointMethodName, origin, runtimeParameters, runtimeInstance,
                currentThread, executionTime, callStack);
        this.errorCause = errorCause;
    }

    @SuppressWarnings("unused")
    public Throwable getErrorCause() {
        return errorCause;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("informationPointClassName", informationPointClassName)
                .add("informationPointMethodName", informationPointMethodName)
                .add("origin", origin)
                .add("runtimeInstance", runtimeInstance)
                .add("runtimeParameters", runtimeParameters)
                .add("currentThread", currentThread)
                .add("executionTime", executionTime)
                .add("callStack", callStack)
                .add("errorCause", errorCause)
                .toString();
    }
}
