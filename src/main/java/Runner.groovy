import models.LogRecordModel
import utils.DataFilterUtil
import utils.FilesParserUtil

class Runner {
    static void main(String[] args) {
        FilesParserUtil.outPutFilteredLogRecords(DataFilterUtil.filterLogRecords())
    }
}
