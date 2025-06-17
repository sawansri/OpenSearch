/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.search.approximate;

import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.QueryVisitor;
import org.opensearch.search.internal.SearchContext;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.index.LeafReader;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.PointValues;
import org.apache.lucene.search.ConstantScoreScorer;
import org.apache.lucene.search.ConstantScoreWeight;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PointRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.QueryVisitor;
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.Scorer;
import org.apache.lucene.search.ScorerSupplier;
import org.apache.lucene.search.Weight;
import org.apache.lucene.util.ArrayUtil;
import org.apache.lucene.util.DocIdSetBuilder;
import org.apache.lucene.util.IntsRef;
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.sort.FieldSortBuilder;
import org.opensearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;

public class ApproximateBooleanQuery extends ApproximateQuery{

    public final BooleanQuery boolQuery = null;

    private int size;

    @Override
    protected boolean canApproximate(SearchContext context) {
        if (context == null) {
            return false;
        }
        if (context.aggregations() != null) {
            return false;
        }
        return false;
    }

    @Override
    public String toString(String field) {
        return "";
    }

    @Override
    public void visit(QueryVisitor visitor) {

    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return boolQuery.hashCode();
    }
}
