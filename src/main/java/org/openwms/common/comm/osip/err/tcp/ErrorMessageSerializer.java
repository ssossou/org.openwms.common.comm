/*
 * Copyright 2018 Heiko Scherrer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openwms.common.comm.osip.err.tcp;

import org.openwms.common.comm.app.Driver;
import org.openwms.common.comm.osip.err.ErrorMessage;
import org.openwms.common.comm.tcp.OSIPSerializer;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * A ErrorMessageSerializer.
 *
 * @author <a href="mailto:hscherrer@interface21.io">Heiko Scherrer</a>
 */
@Component
public class ErrorMessageSerializer extends OSIPSerializer<ErrorMessage> {

    public ErrorMessageSerializer(Driver driver) {
        super(driver);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessageIdentifier() {
        return ErrorMessage.IDENTIFIER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String convert(ErrorMessage message) {
        return getMessageIdentifier() +
                message.getErrorCode() +
                new SimpleDateFormat(getDriver().getOsip().getDatePattern()).format(message.getCreated());
    }
}