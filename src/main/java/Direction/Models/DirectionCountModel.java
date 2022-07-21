package Direction.Models;


public class DirectionCountModel {
    int MseRecordsCount;
    int MissingMedExamsCount;
    int TfomsCount;
    String Number;

    public DirectionCountModel(int mseRecordsCount, int missingMedExamsCount, int tfomsCount, String number) {
        MseRecordsCount = mseRecordsCount;
        MissingMedExamsCount = missingMedExamsCount;
        TfomsCount = tfomsCount;
        Number = number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DirectionCountModel{");
        sb.append("MseRecordsCount=").append(MseRecordsCount);
        sb.append(", MissingMedExamsCount=").append(MissingMedExamsCount);
        sb.append(", TfomsCount=").append(TfomsCount);
        sb.append(", Number='").append(Number).append('\'');
        sb.append('}');
        return sb.toString();
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

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
