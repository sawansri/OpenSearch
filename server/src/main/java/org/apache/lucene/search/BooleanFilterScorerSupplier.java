/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.apache.lucene.search;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class BooleanFilterScorerSupplier extends ScorerSupplier {
    List<ScorerSupplier> subs;

    public BooleanFilterScorerSupplier() {

    }

    @Override
    public Scorer get(long leadCost) throws IOException {
        return null;
    }

    @Override
    public long cost() {
        return 0;
    }

    public BulkScorer bulkScorer() {
        long filterLeadCost =
            subs.stream()
                .mapToLong(ScorerSupplier::cost)
                .min()
                .orElse(Long.MAX_VALUE);
        return null;
    }
}
