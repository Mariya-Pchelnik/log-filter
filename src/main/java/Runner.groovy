import models.LogRecordModel
import utils.DataFilterUtil
import utils.FilesParserUtil

class Runner {
    static void main(String[] args) {
        List<LogRecordModel> filteredList = DataFilterUtil.filterByTimePeriod("19:30:22", "19:35:22")
        FilesParserUtil.outPutFilteredLogRecords(filteredList)
    }
}
