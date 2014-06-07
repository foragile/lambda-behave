package com.insightfullogic.lambdabehave;

import com.insightfullogic.lambdabehave.impl.Specifier;
import com.insightfullogic.lambdabehave.impl.reports.Report;
import com.insightfullogic.lambdabehave.impl.reports.ReportStore;

/**
 * Callback interface to allow you to describe a suite of
 * behaviours about some concept.
 */
@FunctionalInterface
public interface Suite {

    /**
     * Describe a suite of behaviours.
     *
     * @param name the name of the concept you're specifying.
     * @param behaviours the suite of behaviours you're specifying.
     */
    public static void describe(String name, Suite behaviours) {
        Report report = ReportStore.getReport();
        Specifier specifier = new Specifier(name, report);
        Description description = new Description(specifier);
        behaviours.specifySuite(description);
        specifier.checkSpecifications();
    }

    public void specifySuite(Description description);

}