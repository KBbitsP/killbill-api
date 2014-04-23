/*
 * Copyright 2014 Groupon, Inc
 *
 * Groupon licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.payment.api;

import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.plugin.api.PaymentInfoPlugin;
import org.killbill.billing.util.entity.Entity;

import java.math.BigDecimal;
import java.util.UUID;

public interface DirectPaymentTransaction extends Entity {

    /**
     *
     * @return the id of the direct payment.
     */
    UUID getDirectPaymentId();

    /**
     *
     * @return the type of transaction
     */
    TransactionType getTransactionType();

    /**
     *
     * @return the effective date of the payment
     */
    DateTime getEffectiveDate();

    /**
     * @return the captured amount
     */
    BigDecimal getAmount();

    /**
     * @return the currency associated with that payment
     */
    Currency getCurrency();

    /**
     * @return the error code from the gateway
     */
    String getGatewayErrorCode();

    /**
     * @return the error message from the gateway
     */
    String getGatewayErrorMsg();

    /**
     * @return the status for that attempt
     */
    PaymentStatus getPaymentStatus();

    /**
     * This will only be filled when the call requires the details from the plugin
     *
     * @return the additional info from the plugin
     */
    PaymentInfoPlugin getPaymentInfoPlugin();

}
