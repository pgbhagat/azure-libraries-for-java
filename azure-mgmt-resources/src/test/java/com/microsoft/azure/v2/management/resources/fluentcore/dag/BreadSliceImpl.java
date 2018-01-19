/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.v2.management.resources.fluentcore.dag;

import com.microsoft.azure.v2.management.resources.fluentcore.model.Creatable;
import com.microsoft.azure.v2.management.resources.fluentcore.model.Executable;
import com.microsoft.azure.v2.management.resources.fluentcore.model.implementation.ExecutableImpl;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

/**
 * Implementation for IBreadSlice.
 */
public class BreadSliceImpl extends ExecutableImpl<IBreadSlice> implements IBreadSlice {
    private final String name;
    public BreadSliceImpl(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public Observable<IBreadSlice> executeWorkAsync() {
        System.out.println("Bread("+ this.name +")::executeWorkAsync() [Getting slice from store]");
        return Observable.just(this)
                .delay(250, TimeUnit.MILLISECONDS)
                .map(new Function<BreadSliceImpl, IBreadSlice>() {
                    @Override
                    public IBreadSlice apply(BreadSliceImpl breadSlice) {
                        return breadSlice;
                    }
                });
    }

    @Override
    public IBreadSlice withAnotherSliceFromStore(Executable<IBreadSlice> breadFetcher) {
        this.addDependency(breadFetcher);
        return this;
    }

    @Override
    public IBreadSlice withNewOrder(Creatable<IOrder> order) {
        this.addDependency(order);
        return this;
    }
}