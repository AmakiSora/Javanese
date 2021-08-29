package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class RegularExpression {
    private String getContent(String uri){
        String content = "";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line).append("\n");
            }
            connection.disconnect();//表示在不久的将来不太可能向服务器发出其他请求
            content = result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
    private void getNum(){

    }
    private void getInfo(String regStr,String content){
        //创建模式对象(即正则表达式对象)
        Pattern pattern = Pattern.compile(regStr);
//        Pattern pattern = Pattern.compile(regStr,Pattern.CASE_INSENSITIVE);//Pattern.CASE_INSENSITIVE表示不区分大小写
        //创建匹配器,按照pattern匹配
        Matcher matcher = pattern.matcher(content);
        //开始匹配
        while (matcher.find()){
            /*
                不分组的情况下
                matcher.find()根据规则找到子字符串,将子字符串的索引记录到matcher对象的int[]group数组里
                group[0] = 子字符串起始位置,group[1] = 子字符串结束位置
                同时记录oldLast值,oldLast = 子字符串结束位置,下次执行find()时,从此处开始

                分组的情况下
                group[0] = 子字符串起始位置,group[1] = 子字符串结束位置
                group[2] = 第一组匹配到的字符串起始位置,group[3] = 第一组匹配到的字符串结束位置
                group[4] = 第二组匹配到的字符串起始位置,group[5] = 第二组匹配到的字符串结束位置
                group[6] = 第三组匹配到的字符串起始位置,group[7] = 第三组匹配到的字符串结束位置
                以此类推...
             */
            System.out.println(matcher.group(0));//取出子字符串
//            System.out.println(matcher.group(1));//取出第一组分组的字符串
//            System.out.println(matcher.group(2));//取出第二组分组的字符串
//            System.out.println(matcher.group("strName1"));//通过组名取出分组
            //matcher.group(0)根据group[0]和group[1]记录的位置,从content中截取字符串返回
        }
    }
    public void test(){
        String content = getContent("https://baike.baidu.com/item/正则表达式");
        getInfo("[a-zA-Z]+",content);
        getInfo("(\\d)(\\d)",content);//有()表示分组,一个()表示一组
//        getInfo("(?<strName1>\\d)(?<strName2>\\d)",content);//命名分组
        //非捕获分组,ABC(?:EE|GG|NM) 表示匹配ABCEE,ABCGG和ABCNM       以下非捕获分组不能用matcher.group()来获取分组
        //非捕获分组,ABC(?=66|77) 表示只匹配ABC66和ABC77
        //非捕获分组,ABC(?!66|77) 表示除了ABC66和ABC77,其他ABC开头的都匹配
        /*
            元字符
                转义字符\\
                    在使用正则表达式去检索某些特殊字符时,需要用到转义符\\
                    在java的正则表达式中,两个\\代表其他语言中的一个\
                    需要用到转义符号的字符有  .*+()$/\?[]^{}
                字符匹配符
                    [ ]  表示可接收的字符列表                     例如[efgh]表示e,f,g,h中任意一个字符
                    [^]  表示不可接收的字符列表                   例如[^cde]表示除了c,d,e以外的任意一个字符(包括数字和特殊符号)
                     -   表示连字符                             例如A-Z表示从A到Z任意单个大写字母
                     .   表示除\n以外的任何字符                   例如a..b表示以a开头,b结尾,中间包括任意两个字符,长度为4的字符串
                    \\d  表示单个数字字符,等价于[0-9]              例如\\d{3}(\\d)?表示包含3个或4个数字的字符串
                    \\D  表示单个非数字字符,等价于[^0-9]            例如\\D(\\d)*表示以单个非数字字符开头,后接任意个数的数字字符串
                    \\w  表示单个数字,字母字符,等价于[0-9a-zA-Z]     例如\\d{3}\\w{4}表示以3个数字字符开头的长度为7的字符串
                    \\W  表示单个非数字,字母字符,等价于[^0-9a-zA-Z]   例如\\W+\\d{2}表示以至少1个非数字字母字符开头,2个数字字符结尾的字符串
                    \\s  表示任意空白字符(空格,制表符等)
                    \\S  表示任意非空白字符
                选择匹配符
                     |   表示匹配|之前或之后的表达式               例如ab|cd表示匹配ab或cd
                限定符
                     *   表示指定字符重复0次或n次                 例如(abc)*表示仅包含任意个abc的字符串,等价于\w*,abcabcabc
                     +   表示指定字符重复1次或n次(至少一次)         例如m+(abc)*表示以至少1个m开头,后接任意个abc字符串,m,mabc
                     ?   表示指定字符重复0次或1次(最多一次)         例如m+abc?表示以至少1个m开头,后接ab或abc,mab,mabc,mmab
                    {n}  表示只能输入n个字符                      例如[abcd]{3}表示由abcd中任意字母组成的任意长度为3的字符串,adc,cba
                    {n,} 表示至少n个字符                         例如[abcd]{3,}表示abcd中任意字母长度不小于3的字符串,aaacdb
                    {n,m}表示指定至少n个但不多于m个字符匹配         例如[abcd]{3,5}表示abcd中任意字母长度不小于3且不大于5的字符串
                定位符
                     ^   表示起始字符                           例如^[0-9]+[a-z]*表示至少以一个数字开头,后接任意个小写字母的字符串,6ab
                     $   表示结束字符                           例如^[0-9]\\-[a-z]+$表示至少以一个数字开头后接-并以至少一个小写字母结尾的字符串,1-a
                    \\b  表示目标字符串的边界                     例如XYZ\\b表示XYZ后要有空格或者是字符串的结尾,233XYZ
                    \\B  表示目标字符串的非边界                    例如XYZ\\B表示XYZ后不能有空格或结尾,6XYZ9
        */
        /*
            正则表达式例子:
                (?!)abc         表示abc都不区分大小写
                a(?!)bc         表示bc不区分大小写
                a((?!)b)c       表示只有b不区分大小写
         */
    }
}
