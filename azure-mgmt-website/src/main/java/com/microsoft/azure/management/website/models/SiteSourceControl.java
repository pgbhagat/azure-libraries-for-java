/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 0.15.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.website.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Describes the source control configuration for web app.
 */
@JsonFlatten
public class SiteSourceControl extends Resource {
    /**
     * Repository or source control url.
     */
    @JsonProperty(value = "properties.repoUrl")
    private String repoUrl;

    /**
     * Name of branch to use for deployment.
     */
    @JsonProperty(value = "properties.branch")
    private String branch;

    /**
     * Whether to manual or continuous integration.
     */
    @JsonProperty(value = "properties.isManualIntegration")
    private Boolean isManualIntegration;

    /**
     * Whether to manual or continuous integration.
     */
    @JsonProperty(value = "properties.deploymentRollbackEnabled")
    private Boolean deploymentRollbackEnabled;

    /**
     * Mercurial or Git repository type.
     */
    @JsonProperty(value = "properties.isMercurial")
    private Boolean isMercurial;

    /**
     * Get the repoUrl value.
     *
     * @return the repoUrl value
     */
    public String getRepoUrl() {
        return this.repoUrl;
    }

    /**
     * Set the repoUrl value.
     *
     * @param repoUrl the repoUrl value to set
     */
    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    /**
     * Get the branch value.
     *
     * @return the branch value
     */
    public String getBranch() {
        return this.branch;
    }

    /**
     * Set the branch value.
     *
     * @param branch the branch value to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * Get the isManualIntegration value.
     *
     * @return the isManualIntegration value
     */
    public Boolean getIsManualIntegration() {
        return this.isManualIntegration;
    }

    /**
     * Set the isManualIntegration value.
     *
     * @param isManualIntegration the isManualIntegration value to set
     */
    public void setIsManualIntegration(Boolean isManualIntegration) {
        this.isManualIntegration = isManualIntegration;
    }

    /**
     * Get the deploymentRollbackEnabled value.
     *
     * @return the deploymentRollbackEnabled value
     */
    public Boolean getDeploymentRollbackEnabled() {
        return this.deploymentRollbackEnabled;
    }

    /**
     * Set the deploymentRollbackEnabled value.
     *
     * @param deploymentRollbackEnabled the deploymentRollbackEnabled value to set
     */
    public void setDeploymentRollbackEnabled(Boolean deploymentRollbackEnabled) {
        this.deploymentRollbackEnabled = deploymentRollbackEnabled;
    }

    /**
     * Get the isMercurial value.
     *
     * @return the isMercurial value
     */
    public Boolean getIsMercurial() {
        return this.isMercurial;
    }

    /**
     * Set the isMercurial value.
     *
     * @param isMercurial the isMercurial value to set
     */
    public void setIsMercurial(Boolean isMercurial) {
        this.isMercurial = isMercurial;
    }

}