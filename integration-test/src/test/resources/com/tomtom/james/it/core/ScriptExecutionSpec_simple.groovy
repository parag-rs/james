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

package com.tomtom.james.it.core

import com.tomtom.james.common.api.publisher.Event
import com.tomtom.james.script.ErrorHandlerContext
import com.tomtom.james.script.SuccessHandlerContext

def onSuccess(SuccessHandlerContext context) {
    def eventMap = [
            result     : "success",
            className  : context.origin.declaringClass.name,
            methodName : context.origin.name,
            returnValue: context.returnValue,
    ]
    context.parameters.each {
        eventMap["arg(${it.name})"] = it.value
    }
    publishEvent(new Event(eventMap))
}

def onError(ErrorHandlerContext context) {
    def eventMap = [
            result    : "error",
            className : context.origin.declaringClass.name,
            methodName: context.origin.name,
    ]
    context.parameters.each {
        eventMap["arg(${it.name})"] = it.value
    }
    publishEvent(new Event(eventMap))
}
