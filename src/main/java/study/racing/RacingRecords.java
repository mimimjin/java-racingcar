package study.racing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingRecords {

    private LinkedList<RacingRecord> racingRecords;

    public RacingRecords(){
        racingRecords = new LinkedList<RacingRecord>();
    }
    public void addRecord(RacingRecord racingRecord) {
        racingRecords.add(racingRecord);
    }

    public LinkedList<RacingRecord> getRecordList() {
        return racingRecords;
    }


    public String getResultString() {
        List<String> result = new ArrayList<String>();

        String racingTotalResult = racingRecords.stream().map(racingRecord -> racingRecord.getResultString()).collect(Collectors.joining("\n\n"));

        return racingTotalResult;
    }
}
