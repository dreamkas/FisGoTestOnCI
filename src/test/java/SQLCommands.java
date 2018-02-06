/*
 * Created by v.bochechko on 30.01.2018.
 */
public class SQLCommands {
    private static final String attachCounters = "echo \"attach '/FisGo/countersDb.db' as counters; ";
    private static final String attachConfig = "echo \"attach '/FisGo/configDb.db' as config; ";
    private static final String attachReceipts = "echo \"attach '/FisGo/receiptsDb.db' as receipts; ";

    private static final String deleteCounters = attachCounters + "delete from counters.COUNTERS;\" | sqlite3 /FisGo/configDb.db\n";
    public String getDeleteCounts() {
        return deleteCounters;
    }

    private static final String stageCommand = attachConfig + "select STAGE from config.CONFIG;\" | sqlite3 /FisGo/configDb.db\n";
    public String getStageCommand() {
        return stageCommand;
    }

    private static final String openShiftCommand = attachConfig +
            "select OPEN_SHIFT_DATE from config.CONFIG; " + //get(0)
            "select SHIFT_TIMER from config.CONFIG;\" " +   //get(1)
            "| sqlite3 /FisGo/configDb.db\n";
    public String getOpenShiftCommand() {
        return openShiftCommand;
    }

    private static final String dateCommand = " date '+%d%m%y%H%M'\n";
    public String getDateCommand() {
        return dateCommand;
    }

    private static final String recieptCountCommand = attachReceipts + "select count (*) from receipts.RECEIPTS;\" | sqlite3 /FisGo/receiptsDb.db\n";
    public String getRecieptCountCommand() {
        return recieptCountCommand;
    }

    private static final String countersAdventValueCommand = attachCounters + "select * from counters.COUNTERS;\" | sqlite3 /FisGo/countersDb.db\n";
    public String getCountersAdventValueCommand() {
        return countersAdventValueCommand;
    }

    private static final String terminalModeCommand = attachConfig + "select TERMINAL_MODE from config.CONFIG;\" | sqlite3 /FisGo/configDb.db\n";
    public String getTerminalModeCommand() {
        return terminalModeCommand;
    }
}
