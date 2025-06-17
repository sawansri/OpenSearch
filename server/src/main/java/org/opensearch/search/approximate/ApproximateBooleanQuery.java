/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.search.approximate;

import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.QueryVisitor;
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.sort.SortOrder;

import java.util.List;

public class ApproximateBooleanQuery extends ApproximateQuery {

    public BooleanQuery boolQuery = null;

    private int size;

    private SortOrder sortOrder;

    public ApproximateBooleanQuery(int minimumNumberShouldMatch, BooleanClause[] clauses) {
        this(minimumNumberShouldMatch, clauses, SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO, null);
    }

    protected ApproximateBooleanQuery(int minimumNumberShouldMatch, BooleanClause[] clauses, int size, SortOrder sortOrder) {
        this.size = size;
        this.sortOrder = sortOrder;
        this.boolQuery = new BooleanQuery.Builder().add(List.of(clauses)).build();
    }

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

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SortOrder getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
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
