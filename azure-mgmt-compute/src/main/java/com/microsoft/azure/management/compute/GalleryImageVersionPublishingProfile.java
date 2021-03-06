/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

/**
 * The publishing profile of a gallery Image Version.
 */
public class GalleryImageVersionPublishingProfile extends GalleryArtifactPublishingProfileBase {
    /**
     * The number of replicas of the Image Version to be created per region.
     * This property would take effect for a region when regionalReplicaCount
     * is not specified. This property is updatable.
     */
    @JsonProperty(value = "replicaCount")
    private Integer replicaCount;

    /**
     * If set to true, Virtual Machines deployed from the latest version of the
     * Image Definition won't use this Image Version.
     */
    @JsonProperty(value = "excludeFromLatest")
    private Boolean excludeFromLatest;

    /**
     * The timestamp for when the gallery Image Version is published.
     */
    @JsonProperty(value = "publishedDate", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime publishedDate;

    /**
     * The end of life date of the gallery Image Version. This property can be
     * used for decommissioning purposes. This property is updatable.
     */
    @JsonProperty(value = "endOfLifeDate")
    private DateTime endOfLifeDate;

    /**
     * Get the number of replicas of the Image Version to be created per region. This property would take effect for a region when regionalReplicaCount is not specified. This property is updatable.
     *
     * @return the replicaCount value
     */
    public Integer replicaCount() {
        return this.replicaCount;
    }

    /**
     * Set the number of replicas of the Image Version to be created per region. This property would take effect for a region when regionalReplicaCount is not specified. This property is updatable.
     *
     * @param replicaCount the replicaCount value to set
     * @return the GalleryImageVersionPublishingProfile object itself.
     */
    public GalleryImageVersionPublishingProfile withReplicaCount(Integer replicaCount) {
        this.replicaCount = replicaCount;
        return this;
    }

    /**
     * Get if set to true, Virtual Machines deployed from the latest version of the Image Definition won't use this Image Version.
     *
     * @return the excludeFromLatest value
     */
    public Boolean excludeFromLatest() {
        return this.excludeFromLatest;
    }

    /**
     * Set if set to true, Virtual Machines deployed from the latest version of the Image Definition won't use this Image Version.
     *
     * @param excludeFromLatest the excludeFromLatest value to set
     * @return the GalleryImageVersionPublishingProfile object itself.
     */
    public GalleryImageVersionPublishingProfile withExcludeFromLatest(Boolean excludeFromLatest) {
        this.excludeFromLatest = excludeFromLatest;
        return this;
    }

    /**
     * Get the timestamp for when the gallery Image Version is published.
     *
     * @return the publishedDate value
     */
    public DateTime publishedDate() {
        return this.publishedDate;
    }

    /**
     * Get the end of life date of the gallery Image Version. This property can be used for decommissioning purposes. This property is updatable.
     *
     * @return the endOfLifeDate value
     */
    public DateTime endOfLifeDate() {
        return this.endOfLifeDate;
    }

    /**
     * Set the end of life date of the gallery Image Version. This property can be used for decommissioning purposes. This property is updatable.
     *
     * @param endOfLifeDate the endOfLifeDate value to set
     * @return the GalleryImageVersionPublishingProfile object itself.
     */
    public GalleryImageVersionPublishingProfile withEndOfLifeDate(DateTime endOfLifeDate) {
        this.endOfLifeDate = endOfLifeDate;
        return this;
    }

}
