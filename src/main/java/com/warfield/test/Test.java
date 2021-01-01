package com.warfield.test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Properties : "+System.getProperties());
        System.out.println("Environment :"+System.getenv());
        Scanner in = new Scanner(new FileReader("/Users/kojayaku/Documents/Koushik/intelij/warfield/src/main/java/com/warfield/test/file_list"));

        while ((in.hasNext())){
            String next = in.next();
            if(next.contains(".java")){
                System.out.println(next.substring(next.lastIndexOf('/')+1));
            }
        }

        String xml = "<NodeList><Node><name>abc</name></Node></NodeList>";
        String depXML ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><DeploymentInfo " +
                "xmlns=\"http://www.cisco.com/DeploymentInfo\" xmlns:ns6=\"http://www.cisco.com/LicenseInfo\" " +
                "xmlns:ns5=\"http://www.cisco.com/NetworkAccessInfo\" xmlns:ns8=\"http://www.cisco" +
                ".com/PeakCountsInfo\" xmlns:ns7=\"http://www.cisco.com/CountersInfo\" xmlns:ns9=\"http://www.cisco" +
                ".com/PostureInfo\" xmlns:ns2=\"http://www.cisco.com/NADInfo\" xmlns:ns4=\"http://www.cisco" +
                ".com/ProfilerInfo\" xmlns:ns3=\"http://www.cisco" +
                ".com/MDMInfo\"><DeploymentID>256c4d0b-1c04-4ca7-a82b-4d61bd059bdb</DeploymentID><FIPSStatus>Disabled" +
                "</FIPSStatus><NodeList><Node><Name>kojayaku-41.guest.com</Name><NodeTypes>PAP,MNT," +
                "PDP</NodeTypes><ProfilerProbes>activedir,dhcp,nmap,radius," +
                "snmpquery</ProfilerProbes><SN>4GIJO6K98QH</SN><Status>STANDALONE</Status><telemetryEnabled>true" +
                "</telemetryEnabled><NodeServiceType>PROFILER," +
                "SESSION</NodeServiceType><Version>3.0.0.295</Version><PID>ISE-VM-K9</PID><VID>V01</VID" +
                "><PeakCpuUtilization>8.04</PeakCpuUtilization><PeakMemoryUtilization>55.81</PeakMemoryUtilization" +
                "><LastLoggedInAdminViaCLI>admin</LastLoggedInAdminViaCLI><LastLoggedInAdminViaCLITimestamp>2020-03" +
                "-25 21:48:07.56 +0:00</LastLoggedInAdminViaCLITimestamp><NumberOfCpuCores>4</NumberOfCpuCores" +
                "><VMDiskSpace>214.7 GB</VMDiskSpace><Uptime>2020-03-23 00:00:44 UTC</Uptime><VMMemoryReservation>0 " +
                "MB</VMMemoryReservation><VMCpuReservation>0 MHz</VMCpuReservation><VMMemoryLimit>3145727 " +
                "MB</VMMemoryLimit><VMCpuLimit>4294967295 " +
                "MHz</VMCpuLimit><PT>VM</PT><Profile>SMALL</Profile><Memory><fromDate>2020-04-01%2001:53:29</fromDate" +
                "><toDate>2020-04-02%2001:53:29</toDate><Total>15879724</Total><Free>602652</Free><Percent>3.7951038" +
                "</Percent></Memory><Disk><fromDate>2020-04-01%2001:53:31</fromDate><toDate>2020-04-02%2001:53:31" +
                "</toDate><FileSystem><Name>/dev/sda1</Name><Total>991512</Total><Used>116668</Used><Available>807260" +
                "</Available><Percent>13%</Percent><MountPoint>/boot</MountPoint></FileSystem><FileSystem><Name>tmpfs" +
                "</Name><Total>1587976</Total><Used>0</Used><Available>1587976</Available><Percent>0%</Percent" +
                "><MountPoint>/run/user/440</MountPoint></FileSystem><FileSystem><Name>/dev/sda3</Name><Total>95054" +
                "</Total><Used>1583</Used><Available>86303</Available><Percent>2%</Percent><MountPoint>/storedconfig" +
                "</MountPoint></FileSystem><FileSystem><Name>tmpfs</Name><Total>7939860</Total><Used>0</Used" +
                "><Available>7939860</Available><Percent>0%</Percent><MountPoint>/sys/fs/cgroup</MountPoint" +
                "></FileSystem><FileSystem><Name>tmpfs</Name><Total>7939860</Total><Used>1344</Used><Available" +
                ">7938516</Available><Percent>1%</Percent><MountPoint>/run</MountPoint></FileSystem><FileSystem><Name" +
                ">/dev/sda2</Name><Total>18717084</Total><Used>2423016</Used><Available>15320244</Available><Percent" +
                ">14%</Percent><MountPoint>/</MountPoint></FileSystem><FileSystem><Name>devtmpfs</Name><Total>7928332" +
                "</Total><Used>0</Used><Available>7928332</Available><Percent>0%</Percent><MountPoint>/dev" +
                "</MountPoint></FileSystem><FileSystem><Name>/dev/sda7</Name><Total>176250844</Total><Used>33397988" +
                "</Used><Available>133876680</Available><Percent>20%</Percent><MountPoint>/opt</MountPoint" +
                "></FileSystem><FileSystem><Name>tmpfs</Name><Total>1587976</Total><Used>0</Used><Available>1587976" +
                "</Available><Percent>0%</Percent><MountPoint>/run/user/0</MountPoint></FileSystem><FileSystem><Name" +
                ">tmpfs</Name><Total>1587976</Total><Used>0</Used><Available>1587976</Available><Percent>0%</Percent" +
                "><MountPoint>/run/user/322</MountPoint></FileSystem><FileSystem><Name>tmpfs</Name><Total>1587976" +
                "</Total><Used>0</Used><Available>1587976</Available><Percent>0%</Percent><MountPoint>/run/user/301" +
                "</MountPoint></FileSystem><FileSystem><Name>tmpfs</Name><Total>7939860</Total><Used>0</Used" +
                "><Available>7939860</Available><Percent>0%</Percent><MountPoint>/dev/shm</MountPoint></FileSystem" +
                "><FileSystem><Name>tmpfs</Name><Total>1587976</Total><Used>0</Used><Available>1587976</Available" +
                "><Percent>0%</Percent><MountPoint>/run/user/321</MountPoint></FileSystem><FileSystem><Name>tmpfs" +
                "</Name><Total>1587976</Total><Used>0</Used><Available>1587976</Available><Percent>0%</Percent" +
                "><MountPoint>/run/user/304</MountPoint></FileSystem><FileSystem><Name>/dev/sda6</Name><Total>1983056" +
                "</Total><Used>19652</Used><Available>1844620</Available><Percent>2%</Percent><MountPoint>/tmp" +
                "</MountPoint></FileSystem></Disk><LoadAvg><fromDate>2020-04-01%2001:53:31</fromDate><toDate>2020-04" +
                "-02%2001:53:31</toDate><LoadAvgOne> 2.23</LoadAvgOne><LoadAvgFive> " +
                "2.03</LoadAvgFive><LoadAvgFifteen> " +
                "1.06</LoadAvgFifteen></LoadAvg></Node><CountInfo><fromDate>2020-04-01%2001:53:27</fromDate><toDate" +
                ">2020-04-02%2001:53:27</toDate><CurrentPostureEndptCount>0</CurrentPostureEndptCount" +
                "><CurrentGuestUserCount>0</CurrentGuestUserCount><CurrentMDMEndPtCount>0</CurrentMDMEndPtCount" +
                "><CurrentPxGridClientCount>0</CurrentPxGridClientCount></CountInfo><NodeCount>1</NodeCount" +
                "><PAPNodeCount>1</PAPNodeCount><MnTNodeCount>1</MnTNodeCount><PDPNodeCount>1</PDPNodeCount" +
                "><PxGridNodeCount>0</PxGridNodeCount><PICNodeCount>0</PICNodeCount></NodeList></DeploymentInfo>";
        JSONObject depJSON = XML.toJSONObject(depXML);
        System.out.println(depJSON);
        System.out.println(convertNodeToArray(depJSON));
        Object obj = depJSON.getJSONObject("DeploymentInfo").getJSONObject("NodeList").get("Node");
/*        System.out.println(xml +" --> "+XML.toJSONObject(xml));
        System.out.println(xml2 +" ---> "+XML.toJSONObject(xml2));
        JSONObject finalObj = convertNodeToArray(XML.toJSONObject(xml));
        System.out.println(xml +" --> "+convertNodeToArray(XML.toJSONObject(xml)));
        System.out.println(xml2 +" ---> "+convertNodeToArray(XML.toJSONObject(xml2)));
        System.out.println(finalObj);*/
    }

    private static JSONObject convertNodeToArray(JSONObject jsonObject) {
        if(!(jsonObject.getJSONObject("DeploymentInfo").getJSONObject("NodeList").get("Node") instanceof JSONArray)){
            JSONObject nodeListJSON = (JSONObject) jsonObject.getJSONObject("DeploymentInfo").getJSONObject("NodeList").remove("Node");
            jsonObject.getJSONObject("DeploymentInfo").getJSONObject("NodeList").put("Node",new JSONArray().put(nodeListJSON));
        }
        return jsonObject;
    }
}
