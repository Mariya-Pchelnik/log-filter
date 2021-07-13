package utils

import models.LogRecordModel

import java.time.LocalTime
import java.util.stream.Collectors

class DataFilterUtil {

    public static List<LogRecordModel> logRecordList = FilesParserUtil.getLogRecordsListFromDirectory()

    public static Collection<LogRecordModel> filterByUser(String user) {
        List<LogRecordModel> filteredList = logRecordList.stream()
                .filter(record -> record.getUser().equals(user))
                .collect(Collectors.<LogRecordModel> toList());
        return filteredList
    }

    public static Collection<LogRecordModel> filterByTimePeriod(String startTime, String endTime) {
        List<LogRecordModel> filteredList = logRecordList.stream()
                .filter(record -> {
                    record.getTime().isAfter(LocalTime.from(LocalTime.parse(startTime)))
                            && record.getTime().isBefore(LocalTime.parse(endTime))
                })
                .collect(Collectors.<LogRecordModel> toList());
        return filteredList;
    }
}
