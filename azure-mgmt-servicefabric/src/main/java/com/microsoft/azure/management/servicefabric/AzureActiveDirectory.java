/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.servicefabric;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The settings to enable AAD authentication on the cluster.
 */
public class AzureActiveDirectory {
    /**
     * Azure active directory tenant id.
     */
    @JsonProperty(value = "tenantId")
    private String tenantId;

    /**
     * Azure active directory cluster application id.
     */
    @JsonProperty(value = "clusterApplication")
    private String clusterApplication;

    /**
     * Azure active directory client application id.
     */
    @JsonProperty(value = "clientApplication")
    private String clientApplication;

    /**
     * Get the tenantId value.
     *
     * @return the tenantId value
     */
    public String tenantId() {
        return this.tenantId;
    }

    /**
     * Set the tenantId value.
     *
     * @param tenantId the tenantId value to set
     * @return the AzureActiveDirectory object itself.
     */
    public AzureActiveDirectory withTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    /**
     * Get the clusterApplication value.
     *
     * @return the clusterApplication value
     */
    public String clusterApplication() {
        return this.clusterApplication;
    }

    /**
     * Set the clusterApplication value.
     *
     * @param clusterApplication the clusterApplication value to set
     * @return the AzureActiveDirectory object itself.
     */
    public AzureActiveDirectory withClusterApplication(String clusterApplication) {
        this.clusterApplication = clusterApplication;
        return this;
    }

    /**
     * Get the clientApplication value.
     *
     * @return the clientApplication value
     */
    public String clientApplication() {
        return this.clientApplication;
    }

    /**
     * Set the clientApplication value.
     *
     * @param clientApplication the clientApplication value to set
     * @return the AzureActiveDirectory object itself.
     */
    public AzureActiveDirectory withClientApplication(String clientApplication) {
        this.clientApplication = clientApplication;
        return this;
    }

}