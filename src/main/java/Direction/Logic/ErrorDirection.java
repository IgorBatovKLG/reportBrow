package Direction.Logic;

import Direction.Models.DirectionCountModel;

public class ErrorDirection {


    public int NotRecordAndMissingExams(DirectionCountModel directionCountModel){
        if (directionCountModel.getMissingMedExamsCount()==0&directionCountModel.getMissingMedExamsCount()==0){
            return 1;
        }
        if (directionCountModel.getMissingMedExamsCount()!=0&directionCountModel.getTfomsCount()==0){
            return 2;
        }
        return 0;
    }
}
