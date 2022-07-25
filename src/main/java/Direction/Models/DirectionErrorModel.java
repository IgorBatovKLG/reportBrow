package Direction.Models;

public class DirectionErrorModel {
    String dayStart;
    String dayReg;
    String dayEnd;
    String dayRecord;
    String maxDayReg;
    String maxDayRecord;
    String docStatus;
    String number;
    String href;

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayReg() {
        return dayReg;
    }

    public void setDayReg(String dayReg) {
        this.dayReg = dayReg;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getDayRecord() {
        return dayRecord;
    }

    public void setDayRecord(String dayRecord) {
        this.dayRecord = dayRecord;
    }

    public String getMaxDayReg() {
        return maxDayReg;
    }

    public void setMaxDayReg(String maxDayReg) {
        this.maxDayReg = maxDayReg;
    }

    public String getMaxDayRecord() {
        return maxDayRecord;
    }

    public void setMaxDayRecord(String maxDayRecord) {
        this.maxDayRecord = maxDayRecord;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public DirectionErrorModel(String dayStart, String dayReg, String dayEnd, String dayRecord, String maxDayReg, String maxDayRecord, String docStatus, String number, String href) {
        this.dayStart = dayStart;
        this.dayReg = dayReg;
        this.dayEnd = dayEnd;
        this.dayRecord = dayRecord;
        this.maxDayReg = maxDayReg;
        this.maxDayRecord = maxDayRecord;
        this.docStatus = docStatus;
        this.number = number;
        this.href = href;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DirectionErrorModel{");
        sb.append("dayStart='").append(dayStart).append('\'');
        sb.append(", dayReg='").append(dayReg).append('\'');
        sb.append(", dayEnd='").append(dayEnd).append('\'');
        sb.append(", dayRecord='").append(dayRecord).append('\'');
        sb.append(", maxDayReg='").append(maxDayReg).append('\'');
        sb.append(", maxDayRecord='").append(maxDayRecord).append('\'');
        sb.append(", docStatus='").append(docStatus).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append(", href='").append(href).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
