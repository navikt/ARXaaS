package no.nav.arxaas.model.risk;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.deidentifier.arx.ARXPopulationModel;
import org.deidentifier.arx.DataHandle;
import org.deidentifier.arx.risk.RiskModelAttributes;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AttributeRisk {

    private List<QuasiIdentifierRisk> quasiIdentifierRiskList;

    public AttributeRisk() {}

    public AttributeRisk(List<QuasiIdentifierRisk> quasiIdentifierRiskList) {
        this.quasiIdentifierRiskList = quasiIdentifierRiskList;
    }


    public List<QuasiIdentifierRisk> getQuasiIdentifierRiskList(){
        return this.quasiIdentifierRiskList;
    }

    public void setQuasiIdentifierRiskList(List<QuasiIdentifierRisk> quasiIdentifierRiskList) {
        this.quasiIdentifierRiskList = quasiIdentifierRiskList;
    }

    public static AttributeRisk create(DataHandle dataToAnalyse, ARXPopulationModel pModel){
        RiskModelAttributes.QuasiIdentifierRisk[] data = dataToAnalyse.getRiskEstimator(pModel).getAttributeRisks().getAttributeRisks();
        List<QuasiIdentifierRisk> quasiIdentifierRiskList = new ArrayList();
        for (RiskModelAttributes.QuasiIdentifierRisk risk : data){
            quasiIdentifierRiskList.add(new QuasiIdentifierRisk(risk.getIdentifier(), risk.getDistinction(), risk.getSeparation()));
        }
        return new AttributeRisk(quasiIdentifierRiskList);
    }

    public static class QuasiIdentifierRisk {
        private final List<String> identifier;
        private final double distinction;
        private final double separation;

        public QuasiIdentifierRisk(List<String> identifier, double distinction, double separation) {
            this.identifier = identifier;
            this.distinction = distinction;
            this.separation = separation;
        }

        public List<String> getIdentifier() {
            return identifier;
        }

        public double getDistinction() {
            return distinction;
        }

        public double getSeparation() {
            return separation;
        }

        @Override
        public String toString() {
            return "quasiIdentifierRisk{" +
                    "indentifier='" + identifier + '\'' +
                    ", distinction=" + distinction +
                    ", seperation=" + separation +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            QuasiIdentifierRisk that = (QuasiIdentifierRisk) o;
            return this.hashCode() == that.hashCode();
        }

        @Override
        public int hashCode() {
            return Objects.hash(identifier, distinction, separation);
        }


    }
}