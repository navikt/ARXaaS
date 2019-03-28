package no.oslomet.aaas.analyzer;

import no.oslomet.aaas.model.AnalyzeResult;
import no.oslomet.aaas.model.DistributionOfRisk;
import no.oslomet.aaas.model.Request;
import no.oslomet.aaas.utils.ARXPayloadAnalyser;
import no.oslomet.aaas.utils.DataFactory;
import org.deidentifier.arx.ARXPopulationModel;
import org.deidentifier.arx.Data;
import org.deidentifier.arx.DataHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Analyzer class using the ARX library to implement the analysation
 */
@Component
public class ARXAnalyzer implements Analyzer {

    private final DataFactory dataFactory;

    @Autowired
    public ARXAnalyzer(DataFactory dataFactory) {
        this.dataFactory = dataFactory;
    }

    @Override
    public AnalyzeResult analyze(Request payload) {
        Data data = dataFactory.create(payload);
        DataHandle dataToAnalyse = data.getHandle();
        ARXPopulationModel pModel= ARXPopulationModel.create(data.getHandle().getNumRows(), 0.01d);
        Map<String,String> analysisMetrics = ARXPayloadAnalyser.getPayloadAnalyzeData(dataToAnalyse,pModel);
        return new AnalyzeResult(analysisMetrics,distributionOfRisk(dataToAnalyse,pModel));
    }

    private DistributionOfRisk distributionOfRisk(DataHandle dataToAnalyse, ARXPopulationModel pModel){
        double[] recordsWithRisk = ARXPayloadAnalyser.getPayloadDistributionOfRecordsWithRisk(dataToAnalyse,pModel);
        double[] recordsWithMaximalRisk = ARXPayloadAnalyser.getPayloadDistributionOfRecordsWithMaximalRisk(dataToAnalyse,pModel);
        return DistributionOfRisk.createFromRiskAndMaxRisk(recordsWithRisk,recordsWithMaximalRisk);
    }

}
