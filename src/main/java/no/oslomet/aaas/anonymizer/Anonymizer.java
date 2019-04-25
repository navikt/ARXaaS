package no.oslomet.aaas.anonymizer;

import no.oslomet.aaas.model.anonymity.AnonymizeResult;
import no.oslomet.aaas.model.Request;


/**
 *  Public Interface to be forfilled by data anonymizer classes
 */
public interface Anonymizer {

    /**
     * Method to run anonymization on data in the payload with the provided parameters in the payload
     * @param payload {@link Request}  object containing the data to be anonymized and params to use in anonymization
     * @return an {@link AnonymizeResult} object containing the best case anonymization and statistics
     */
    AnonymizeResult anonymize(Request payload);
}
