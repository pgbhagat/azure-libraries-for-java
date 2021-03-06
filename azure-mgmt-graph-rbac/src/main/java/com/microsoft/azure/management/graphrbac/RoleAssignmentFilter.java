/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.graphrbac;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Role Assignments filter.
 */
public class RoleAssignmentFilter {
    /**
     * Returns role assignment of the specific principal.
     */
    @JsonProperty(value = "principalId")
    private String principalId;

    /**
     * The Delegation flag for the roleassignment.
     */
    @JsonProperty(value = "canDelegate")
    private Boolean canDelegate;

    /**
     * Get the principalId value.
     *
     * @return the principalId value
     */
    public String principalId() {
        return this.principalId;
    }

    /**
     * Set the principalId value.
     *
     * @param principalId the principalId value to set
     * @return the RoleAssignmentFilter object itself.
     */
    public RoleAssignmentFilter withPrincipalId(String principalId) {
        this.principalId = principalId;
        return this;
    }

    /**
     * Get the canDelegate value.
     *
     * @return the canDelegate value
     */
    public Boolean canDelegate() {
        return this.canDelegate;
    }

    /**
     * Set the canDelegate value.
     *
     * @param canDelegate the canDelegate value to set
     * @return the RoleAssignmentFilter object itself.
     */
    public RoleAssignmentFilter withCanDelegate(Boolean canDelegate) {
        this.canDelegate = canDelegate;
        return this;
    }

}
