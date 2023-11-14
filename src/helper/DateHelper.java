package helper;

import DTO.DateRangeDTO;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateHelper {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    public static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("MM/yyyy");
    public static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yyyy");
    public static final SimpleDateFormat SQL_ROW_MONTH_FORMATTER = new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat SQL_ROW_YEAR_FORMATTER = new SimpleDateFormat("yyyy");
    public static final DateTimeFormatter SQL_ROW_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final String SQL_QUERY_MONTH_FORMAT = "%Y-%m";
    public static final String SQL_QUERY_YEAR_FORMAT = "%Y";
    
    public static LocalDateTime convertDateObjToLDT(Date date) {
        if (date instanceof java.sql.Date) {
            return ((java.sql.Date) date).toLocalDate().atStartOfDay();
        } else {
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
    }
    
    public static Date convertLDTToDateObj(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public static String dateRangeToString(DateRangeDTO dateRange, DateTimeFormatter formatter) {
        return dateRange.getFromDate().format(formatter) + " - " + dateRange.getToDate().format(formatter);
    }
}
