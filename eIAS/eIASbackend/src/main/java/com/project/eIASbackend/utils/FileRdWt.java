//readFile: 读取文件内容。根据给定的文件路径 filePath，使用 Apache POI 库读取 Word 文档的内容，并将内容以字符串形式返回。
//writeFile: 写入文件内容。根据给定的文件路径 filePath 和内容 content，使用字符流的方式将内容写入文件。
//readTxt: 读取文本文件内容。根据给定的文件路径 path，使用字符流的方式读取文本文件的内容，并以 StringBuffer 形式返回。
package com.project.eIASbackend.utils;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;


/************************
 * eIASbackend
 * com.project.eIASbackend.utils
 * MHC
 * author : mhc
 * date:  2023/4/29 0:56
 * description : 
 ************************/
public class FileRdWt {

        // 读取文件内容
        public static String readFile(String filePath) throws IOException {
            String text = "";
            try {
                FileInputStream fis = new FileInputStream(filePath);
                XWPFDocument doc = new XWPFDocument(fis);
                XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
                text = extractor.getText();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return text;
        }

        // 写入文件内容
        public static void writeFile(String filePath, String content) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath,true), "UTF-8"));
        bw.write(content);
        bw.close();
    }

    public static StringBuffer readTxt(String path) throws IOException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        //缓存文本数据以便更快的读取
        BufferedReader br = new BufferedReader(fr);

        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        br.close();
        return sb;
    }
}

