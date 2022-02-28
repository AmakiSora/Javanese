package java_.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Set;
import java.util.TimeZone;

/**
 * Date Time API
 *      java.util.Date是非线程安全的,所有的日期类都是可变的,这是Java日期类最大的问题之一
 *      Date Time API中的所有类均生成不可变实例,它们是线程安全的
 *      并且这些类不提供公共构造函数(没有办法new出来),
 *      需要采用工厂方法加以实例化
 */
public class Time_ {
    public void test() {
        //获取当前时间 now
        Instant now = Instant.now();
        System.out.println(now);
        //只有年月日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        //只有时分秒
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        //年月日T时分秒.纳秒
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //加上时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        //年
        Year year = Year.now();
        System.out.println(year);
        //月
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        //日
        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);
        System.out.println("---------------------------------");
        //of方法获取具体时间
        LocalDateTime twosday = LocalDateTime.of(2022, 2, 2, 2, 22, 22);
        System.out.println(twosday);
        //可以用localDate和localTime进行重载
        LocalDateTime someDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(someDateTime);
        System.out.println("---------------------------------");
        //获取所有的时区信息 getAvailableZoneIds
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
        //获取当前系统默认的时区信息 systemDefault
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        //添加时区信息 atZone
        ZonedDateTime shanghaiTwosday = twosday.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(shanghaiTwosday);
        //变更时区 withZoneSameInstant
        ZonedDateTime tokyoDay = shanghaiTwosday.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println(tokyoDay);
        System.out.println("---------------------------------");
        //月份枚举类 Mouth
        Month month = Month.of(1);
        System.out.println(month);
        System.out.println("---------------------------------");
        //星期枚举类 DayOfWeek
        DayOfWeek dayOfWeek = DayOfWeek.of(1);
        System.out.println(dayOfWeek);
        System.out.println("---------------------------------");
        //获取未来的时间点 plus
        System.out.println(twosday.plusYears(1));
        System.out.println(twosday.plusMonths(1));
        System.out.println(twosday.plusWeeks(1));
        System.out.println(twosday.plusDays(1));
        System.out.println(twosday.plusHours(1));
        System.out.println(twosday.plusMinutes(1));
        System.out.println(twosday.plusSeconds(1));
        System.out.println(twosday.plusNanos(1));
        //获取过去的时间点 minus
        System.out.println(twosday.minusYears(1));
        System.out.println(twosday.minusMonths(1));
        System.out.println(twosday.minusWeeks(1));
        System.out.println(twosday.minusDays(1));
        System.out.println(twosday.minusHours(1));
        System.out.println(twosday.minusMinutes(1));
        System.out.println(twosday.minusSeconds(1));
        System.out.println(twosday.minusNanos(1));
        System.out.println("---------------------------------");
        //一段时间 Period
        Period period = Period.of(1, 2, 3);//表示一年两个月三天
        System.out.println(twosday.plus(period));//加上这段时间
        System.out.println(twosday.minus(period));//减去这段时间
        System.out.println("---------------------------------");
        //一段时间的枚举类 ChronoUnit
        LocalDate t1 = LocalDate.now();
        LocalDate t2 = t1.plusDays(3);
        System.out.println(ChronoUnit.DAYS.between(t2, t1));//时间间隔
        System.out.println(twosday.plus(2, ChronoUnit.DAYS));//加两天
        System.out.println(twosday.minus(1, ChronoUnit.DECADES));//减10年
        System.out.println("---------------------------------");
        //直接修改某个时间中的值 with
        System.out.println(twosday.withYear(1));
        System.out.println(twosday.withMonth(1));
        System.out.println(twosday.withDayOfYear(1));
        System.out.println(twosday.withDayOfMonth(1));
        System.out.println(twosday.withHour(1));
        System.out.println(twosday.withMinute(1));
        System.out.println(twosday.withSecond(1));
        System.out.println(twosday.withNano(1));
        System.out.println("---------------------------------");
        //通过枚举类来修改时间中的值 ChronoField
        System.out.println(twosday.with(ChronoField.DAY_OF_MONTH, 11));//修改为一个月中的11号
        //调整时间的枚举类 TemporalAdjusters
        System.out.println(twosday.with(TemporalAdjusters.firstDayOfNextMonth()));//修改为下个月的第一天
        System.out.println("---------------------------------");
        //判断时间的前后
        System.out.println(twosday.isAfter(someDateTime));
        System.out.println(twosday.isBefore(someDateTime));
        System.out.println("---------------------------------");
        //java.util.Date转换为java.time.LocalDateTime
        java.util.Date date = new java.util.Date();
        ZonedDateTime zoneDate = date.toInstant().atZone(zoneId);
        System.out.println(zoneDate.toLocalDateTime());
        //java.sql.Date转换为java.time.LocalDate
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        System.out.println(sqlDate.toLocalDate());
        //java.sql.Timestamp转换为java.time.LocalDateTime
        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.toLocalDateTime());
        System.out.println("---------------------------------");
        //Calendar转换为ZonedDateTime
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();
        ZoneId toZoneId = timeZone.toZoneId();
        System.out.println(ZonedDateTime.ofInstant(calendar.toInstant(), toZoneId));
        //Calendar转换为LocalDateTime
        int cYear = calendar.get(Calendar.YEAR);
        int cMonth = calendar.get(Calendar.MONTH);//月份记得减一
        int cDay = calendar.get(Calendar.DAY_OF_MONTH);
        int cHour = calendar.get(Calendar.HOUR);
        int cMinute = calendar.get(Calendar.MINUTE);
        int cSecond = calendar.get(Calendar.SECOND);
        System.out.println(LocalDateTime.of(cYear, cMonth - 1, cDay, cHour, cMinute, cSecond));
        System.out.println("---------------------------------");
        //日期格式化 format
        System.out.println(twosday.format(DateTimeFormatter.ISO_DATE));
        System.out.println(twosday.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("---------------------------------");
        //指定解析格式 ofLocalizedDate
        System.out.println(twosday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));//全显示
        System.out.println(twosday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));//长显示
        System.out.println(twosday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));//缩略显示
        System.out.println(twosday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));//精简显示
        System.out.println("---------------------------------");
        //自定义格式器 ofPattern
        System.out.println(twosday.format(DateTimeFormatter.ofPattern("yyyy_MM_dd HH:mm:ss-SSS")));
        System.out.println("---------------------------------");
    }
}
