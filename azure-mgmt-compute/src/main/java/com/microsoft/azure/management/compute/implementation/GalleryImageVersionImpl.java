/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.compute.implementation;

import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.compute.GalleryArtifactSource;
import com.microsoft.azure.management.compute.GalleryImageVersion;
import com.microsoft.azure.management.compute.GalleryImageVersionPublishingProfile;
import com.microsoft.azure.management.compute.GalleryImageVersionStorageProfile;
import com.microsoft.azure.management.compute.ManagedArtifact;
import com.microsoft.azure.management.compute.ReplicationStatus;
import com.microsoft.azure.management.compute.TargetRegion;
import com.microsoft.azure.management.compute.VirtualMachineCustomImage;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.resources.fluentcore.model.implementation.CreatableUpdatableImpl;
import org.joda.time.DateTime;
import rx.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The implementation for GalleryImageVersion and its create and update interfaces.
 */
@LangDefinition
class GalleryImageVersionImpl extends CreatableUpdatableImpl<GalleryImageVersion, GalleryImageVersionInner, GalleryImageVersionImpl>
        implements GalleryImageVersion, GalleryImageVersion.Definition, GalleryImageVersion.Update {
    private final ComputeManager manager;
    private String resourceGroupName;
    private String galleryName;
    private String galleryImageName;
    private String galleryImageVersionName;

    GalleryImageVersionImpl(String name, ComputeManager manager) {
        super(name, new GalleryImageVersionInner());
        this.manager = manager;
        // Set resource name
        this.galleryImageVersionName = name;
        //
    }

    GalleryImageVersionImpl(GalleryImageVersionInner inner, ComputeManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.galleryImageVersionName = inner.name();
        // resource ancestor names
        this.resourceGroupName = getValueFromIdByName(inner.id(), "resourceGroups");
        this.galleryName = getValueFromIdByName(inner.id(), "galleries");
        this.galleryImageName = getValueFromIdByName(inner.id(), "images");
        this.galleryImageVersionName = getValueFromIdByName(inner.id(), "versions");
        //
    }

    @Override
    public ComputeManager manager() {
        return this.manager;
    }

    @Override
    public Observable<GalleryImageVersion> createResourceAsync() {
        GalleryImageVersionsInner client = this.manager().inner().galleryImageVersions();
        return client.createOrUpdateAsync(this.resourceGroupName, this.galleryName, this.galleryImageName, this.galleryImageVersionName, this.inner())
                .map(innerToFluentMap(this));
    }

    @Override
    public Observable<GalleryImageVersion> updateResourceAsync() {
        GalleryImageVersionsInner client = this.manager().inner().galleryImageVersions();
        return client.createOrUpdateAsync(this.resourceGroupName, this.galleryName, this.galleryImageName, this.galleryImageVersionName, this.inner())
                .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<GalleryImageVersionInner> getInnerAsync() {
        GalleryImageVersionsInner client = this.manager().inner().galleryImageVersions();
        return client.getAsync(this.resourceGroupName, this.galleryName, this.galleryImageName, this.galleryImageVersionName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String location() {
        return this.inner().location();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public GalleryImageVersionPublishingProfile publishingProfile() {
        return this.inner().publishingProfile();
    }

    @Override
    public List<TargetRegion> availableRegions() {
        List<TargetRegion> regions = new ArrayList<TargetRegion>();
        if (this.inner().publishingProfile() != null && this.inner().publishingProfile().targetRegions() != null) {
            for (TargetRegion targetRegion : this.inner().publishingProfile().targetRegions()) {
                regions.add(new TargetRegion().withName(targetRegion.name()).withRegionalReplicaCount(targetRegion.regionalReplicaCount()));
            }
        }
        return Collections.unmodifiableList(regions);
    }

    @Override
    public DateTime endOfLifeDate() {
        if (this.inner().publishingProfile() != null) {
            return this.inner().publishingProfile().endOfLifeDate();
        } else {
            return null;
        }
    }

    @Override
    public Boolean isExcludedFromLatest() {
        if (this.inner().publishingProfile() != null) {
            return this.inner().publishingProfile().excludeFromLatest();
        } else {
            return false;
        }
    }

    @Override
    public ReplicationStatus replicationStatus() {
        return this.inner().replicationStatus();
    }

    @Override
    public GalleryImageVersionStorageProfile storageProfile() {
        return this.inner().storageProfile();
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().getTags();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public GalleryImageVersionImpl withExistingImage(String resourceGroupName, String galleryName, String galleryImageName) {
        this.resourceGroupName = resourceGroupName;
        this.galleryName = galleryName;
        this.galleryImageName = galleryImageName;
        return this;
    }

    @Override
    public GalleryImageVersionImpl withLocation(String location) {
        this.inner().withLocation(location);
        return this;
    }

    @Override
    public DefinitionStages.WithSource withLocation(Region location) {
        this.inner().withLocation(location.toString());
        return this;
    }

    @Override
    public GalleryImageVersionImpl withSourceCustomImage(String customImageId) {
        if (this.inner().publishingProfile() == null) {
            this.inner().withPublishingProfile(new GalleryImageVersionPublishingProfile());
        }
        if (this.inner().publishingProfile().source() == null) {
            this.inner().publishingProfile().withSource(new GalleryArtifactSource());
        }
        this.inner().publishingProfile().source().withManagedImage(new ManagedArtifact().withId(customImageId));
        return this;
    }

    @Override
    public GalleryImageVersionImpl withSourceCustomImage(VirtualMachineCustomImage customImage) {
        return this.withSourceCustomImage(customImage.id());
    }

    @Override
    public GalleryImageVersionImpl withRegionAvailability(Region region, int replicaCount) {
        if (this.inner().publishingProfile() == null) {
            this.inner().withPublishingProfile(new GalleryImageVersionPublishingProfile());
        }
        if (this.inner().publishingProfile().targetRegions() == null) {
            this.inner().publishingProfile().withTargetRegions(new ArrayList<TargetRegion>());
        }

        boolean found = false;
        String newRegionName = region.toString();
        String newRegionNameTrimmed = newRegionName.replaceAll("\\s", "");
        for (TargetRegion targetRegion : this.inner().publishingProfile().targetRegions()) {
            String regionStr = targetRegion.name();
            String regionStrTrimmed = regionStr.replaceAll("\\s", "");
            if (regionStrTrimmed.equalsIgnoreCase(newRegionNameTrimmed)) {
                targetRegion.withRegionalReplicaCount(replicaCount); // Update existing
                found = true;
                break;
            }
        }
        if (!found) {
            TargetRegion targetRegion = new TargetRegion()
                    .withName(newRegionName)
                    .withRegionalReplicaCount(replicaCount);
            this.inner().publishingProfile().targetRegions().add(targetRegion);
        }
        //
        // Gallery image version publishing profile regions list must contain the location of image version.
        //
        found = false;
        String locationTrimmed = this.location().replaceAll("\\s", "");
        for (TargetRegion targetRegion : this.inner().publishingProfile().targetRegions()) {
            String regionStr = targetRegion.name();
            String regionStrTrimmed = regionStr.replaceAll("\\s", "");
            if (regionStrTrimmed.equalsIgnoreCase(locationTrimmed)) {
                found = true;
                break;
            }
        }
        if (!found) {
            TargetRegion defaultTargetRegion = new TargetRegion()
                    .withName(this.location())
                    .withRegionalReplicaCount(null); // null means default where service default to 1 replica
            this.inner().publishingProfile().targetRegions().add(defaultTargetRegion);
        }
        //
        return this;
    }

    @Override
    public GalleryImageVersionImpl withRegionAvailability(List<TargetRegion> targetRegions) {
        if (this.inner().publishingProfile() == null) {
            this.inner().withPublishingProfile(new GalleryImageVersionPublishingProfile());
        }
        this.inner().publishingProfile().withTargetRegions(targetRegions);
        //
        // Gallery image version publishing profile regions list must contain the location of image version.
        //
        boolean found = false;
        String locationTrimmed = this.location().replaceAll("\\s", "");
        for (TargetRegion targetRegion : this.inner().publishingProfile().targetRegions()) {
            String regionStr = targetRegion.name();
            String regionStrTrimmed = regionStr.replaceAll("\\s", "");
            if (regionStrTrimmed.equalsIgnoreCase(locationTrimmed)) {
                found = true;
                break;
            }
        }
        if (!found) {
            TargetRegion defaultTargetRegion = new TargetRegion()
                    .withName(this.location())
                    .withRegionalReplicaCount(null); // null means default where service default to 1 replica
            this.inner().publishingProfile().targetRegions().add(defaultTargetRegion);
        }
        //
        return this;
    }

    @Override
    public Update withoutRegionAvailability(Region region) {
        if (this.inner().publishingProfile() != null && this.inner().publishingProfile().targetRegions() != null) {
            int foundIndex = -1;
            int i = 0;
            String regionNameToRemove = region.toString();
            String regionNameToRemoveTrimmed = regionNameToRemove.replaceAll("\\s", "");

            for (TargetRegion targetRegion : this.inner().publishingProfile().targetRegions()) {
                String regionStr = targetRegion.name();
                String regionStrTrimmed = regionStr.replaceAll("\\s", "");
                if (regionStrTrimmed.equalsIgnoreCase(regionNameToRemoveTrimmed)) {
                    foundIndex = i;
                    break;
                }
                i++;
            }
            if (foundIndex != -1) {
                this.inner().publishingProfile().targetRegions().remove(foundIndex);
            }
        }
        return this;
    }

    @Override
    public GalleryImageVersionImpl withEndOfLifeDate(DateTime endOfLifeDate) {
        if (this.inner().publishingProfile() == null) {
            this.inner().withPublishingProfile(new GalleryImageVersionPublishingProfile());
        }
        this.inner().publishingProfile().withEndOfLifeDate(endOfLifeDate);
        return this;
    }


    @Override
    public GalleryImageVersionImpl withExcludedFromLatest() {
        if (this.inner().publishingProfile() == null) {
            this.inner().withPublishingProfile(new GalleryImageVersionPublishingProfile());
        }
        this.inner().publishingProfile().withExcludeFromLatest(true);
        return this;
    }

    @Override
    public GalleryImageVersionImpl withoutExcludedFromLatest() {
        if (this.inner().publishingProfile() == null) {
            this.inner().withPublishingProfile(new GalleryImageVersionPublishingProfile());
        }
        this.inner().publishingProfile().withExcludeFromLatest(false);
        return this;
    }

    @Override
    public GalleryImageVersionImpl withTags(Map<String, String> tags) {
        this.inner().withTags(tags);
        return this;
    }

    private static String getValueFromIdByName(String id, String name) {
        if (id == null) {
            return null;
        }
        Iterable<String> iterable = Arrays.asList(id.split("/"));
        Iterator<String> itr = iterable.iterator();
        while (itr.hasNext()) {
            String part = itr.next();
            if (part != null && part.trim() != "") {
                if (part.equalsIgnoreCase(name)) {
                    if (itr.hasNext()) {
                        return itr.next();
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }
}