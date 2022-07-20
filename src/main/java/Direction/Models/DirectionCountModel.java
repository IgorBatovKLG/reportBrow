package Direction.Models;


public class DirectionCountModel {
    int MseRecordsCount;
    int MissingMedExamsCount;
    int TfomsCount;

    public DirectionCountModel(int mseRecordsCount, int missingMedExamsCount, int tfomsCount) {
        MseRecordsCount = mseRecordsCount;
        MissingMedExamsCount = missingMedExamsCount;
        TfomsCount = tfomsCount;
    }

    public int getMseRecordsCount() {
        return MseRecordsCount;
    }

    public void setMseRecordsCount(int mseRecordsCount) {
        MseRecordsCount = mseRecordsCount;
    }

    public int getMissingMedExamsCount() {
        return MissingMedExamsCount;
    }

    public void setMissingMedExamsCount(int missingMedExamsCount) {
        MissingMedExamsCount = missingMedExamsCount;
    }

    public int getTfomsCount() {
        return TfomsCount;
    }

    public void setTfomsCount(int tfomsCount) {
        TfomsCount = tfomsCount;
    }
}
