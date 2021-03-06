/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Metric availability and retention.
 */
public class MetricAvailabilily {
    /**
     * Time grain.
     */
    @JsonProperty(value = "timeGrain")
    private String timeGrain;

    /**
     * Retention period for the current time grain.
     */
    @JsonProperty(value = "retention")
    private String retention;

    /**
     * Get time grain.
     *
     * @return the timeGrain value
     */
    public String timeGrain() {
        return this.timeGrain;
    }

    /**
     * Set time grain.
     *
     * @param timeGrain the timeGrain value to set
     * @return the MetricAvailabilily object itself.
     */
    public MetricAvailabilily withTimeGrain(String timeGrain) {
        this.timeGrain = timeGrain;
        return this;
    }

    /**
     * Get retention period for the current time grain.
     *
     * @return the retention value
     */
    public String retention() {
        return this.retention;
    }

    /**
     * Set retention period for the current time grain.
     *
     * @param retention the retention value to set
     * @return the MetricAvailabilily object itself.
     */
    public MetricAvailabilily withRetention(String retention) {
        this.retention = retention;
        return this;
    }

}
