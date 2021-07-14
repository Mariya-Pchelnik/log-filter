package utils

import models.LogRecordModel

import java.time.LocalTime
import java.util.stream.Collectors

class DataFilterUtil {

    public static List<LogRecordModel> logRecordList = FilesParserUtil.getLogRecordsListFromDirectory()
    public static final String filterValue = properties.get("filterValue")

    private static Collection<LogRecordModel> filterByUser() {
        List<LogRecordModel> filteredList = logRecordList.stream()
                .filter(record -> record.getUser().equals(filterValue))
                .collect(Collectors.<LogRecordModel> toList());
        return filteredList
    }

    private static Collection<LogRecordModel> filterByTimePeriod() {
        String[] timePeriod = filterValue.split('-')
        List<LogRecordModel> filteredList = logRecordList.stream()
                .filter(record -> {
                    record.getTime().isAfter(LocalTime.from(LocalTime.parse(timePeriod[0])))
                            && record.getTime().isBefore(LocalTime.parse(timePeriod[1]))
                })
                .collect(Collectors.<LogRecordModel> toList());
        return filteredList;
    }

    public static Collection<LogRecordModel> filterLogRecords() {
        switch (properties.get("filterType")) {
            case "user":
                return filterByUser()
                break
            case "time":
                return filterByUser()
                break
            default:
                return Collections.emptyList()
        }
    }
}
