package Direction.Models;

public class DirectionErrorModel {
    String dayReg;
    String dayEnd;
    String dayRecord;
    String maxDayReg;
    String maxDayRecord;
    String docStatus;
    String number;

    public DirectionErrorModel(String dayReg, String dayEnd, String dayRecord, String maxDayReg, String maxDayRecord, String docStatus, String number) {
        this.dayReg = dayReg;
        this.dayEnd = dayEnd;
        this.dayRecord = dayRecord;
        this.maxDayReg = maxDayReg;
        this.maxDayRecord = maxDayRecord;
        this.docStatus = docStatus;
        this.number = number;
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
}
