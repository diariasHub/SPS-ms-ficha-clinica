package cl.rednorte.ms_ficha_clinica.model;

import org.hl7.fhir.r4.model.*;

public class ObservationMapper {

    public static ObservationModel fromFhir(Observation obs) {

        ObservationModel model = new ObservationModel();

        model.setId(obs.getId());

        if (obs.hasSubject()) {
            model.setPatientId(obs.getSubject().getReference());
        }

        if (obs.getCode().hasCoding()) {
            model.setCode(obs.getCode().getCodingFirstRep().getCode());
        }

        if (obs.getValue() instanceof Quantity q) {
            model.setValue(q.getValue().doubleValue());
            model.setUnit(q.getUnit());
        }

        if (obs.hasEffectiveDateTimeType()) {
            model.setEffectiveDate(obs.getEffectiveDateTimeType().getValue());
        }

        return model;
    }
}
