package no.nav.arxaas.model.risk;

import java.util.Objects;

/**
 * Represents data arxaas risks associated with a dataset
 */
public class RiskProfile {

    private final ReIdentificationRisk reIdentificationRisk;

    private final DistributionOfRisk distributionOfRisk;

    private AttributeRisk attributeRisk;

    public RiskProfile(ReIdentificationRisk reIdentificationRisk, DistributionOfRisk distributionOfRisk, AttributeRisk quasiIdentifierRisk) {
        this.reIdentificationRisk = reIdentificationRisk;
        this.distributionOfRisk = distributionOfRisk;
        this.attributeRisk = quasiIdentifierRisk;
    }

    public ReIdentificationRisk getReIdentificationRisk() {
        return reIdentificationRisk;
    }


    public DistributionOfRisk getDistributionOfRisk() {
        return distributionOfRisk;
    }

    public AttributeRisk getAttributeRisk() { return attributeRisk; }

    @Override
    public String toString() {
        return "RiskProfile{" +
                "reIdentificationRisk=" + reIdentificationRisk +
                ", distributionOfRisk=" + distributionOfRisk +
                ", attributeRisk=" + attributeRisk +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiskProfile that = (RiskProfile) o;
        return this.hashCode() == that.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(reIdentificationRisk, distributionOfRisk, attributeRisk);
    }
}
