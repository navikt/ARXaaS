package no.oslomet.aaas.analyser;

import no.oslomet.aaas.model.AnalysisResult;
import no.oslomet.aaas.model.Request;

/**
 * Public contract to be forfilled by data anonymization analyse classes
 */
public interface Analyser {

    /**
     * Method to run analysation on the anonymization metrics of the data in the payload
     * with the provided parameters in the payload.
     * @param payload Request containing the data to be analysed and parameters for the analysation process
     * @return AnalysisResult object containing the metrics for the provided data
     */
    AnalysisResult analyse(Request payload);
}
