package utils

import models.LogRecordModel

class FilesParserUtil {

    public static String logsDirectory = "src/main/resources"
    public static File outPutDirectory = new File("src/main/resources/OutPutFile")
    public static final EXTENSION = ".log"

    private static List<File> getFilesWithLogExtension() {
        File dir = new File(logsDirectory)
        if (dir == null) {
            print("Incorrect directory name")
            return
        }
        List<File> files = dir.listFiles(new FilenameFilter() {
            @Override
            boolean accept(File d, String name) {
                return name.endsWith(EXTENSION)
            }
        })
        return files;
    }

    public static ArrayList<LogRecordModel> getLogRecordsListFromDirectory() {
        List<File> filesList = getFilesWithLogExtension()
        List<LogRecordModel> logRecordsList = new ArrayList<>()
        if (filesList.isEmpty()) {
            print("There are no" + EXTENSION + "files  in directory " + logsDirectory)
            return;
        } else {
            filesList.forEach(file -> {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] entry = line.split(",")
                        LogRecordModel logRecord = new LogRecordModel(entry[0], entry[1], entry[2]);
                        logRecordsList.add(logRecord);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            })
            return logRecordsList;

        }
    }

    public static void outPutFilteredLogRecords(List<LogRecordModel> logRecordList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outPutDirectory))) {
            if (logRecordList.isEmpty()) {
                print("Log  records were not found")
                return
            }
            logRecordList.forEach(record -> {
                writer.write(record.toString())
                writer.newLine()
            })
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}