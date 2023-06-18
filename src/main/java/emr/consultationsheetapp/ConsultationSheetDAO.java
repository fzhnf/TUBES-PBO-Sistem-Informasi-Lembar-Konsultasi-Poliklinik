package emr.consultationsheetapp;

import java.util.Date;

public class ConsultationSheetDAO extends ConsultationSheetModel {

    public ConsultationSheetDAO(int consultationSheetId, Date createdAt, int patientId, int bloodPressuremmHg, int heartRateBeatPerMinute, int temperateCelcius, int feelingRate, String physicalExaminationScript, String diagnosisScript, String patientEducation) {
        super(consultationSheetId, createdAt, patientId, bloodPressuremmHg, heartRateBeatPerMinute, temperateCelcius, feelingRate, physicalExaminationScript, diagnosisScript, patientEducation);
    }
}
