package com.example.springboorutil.zip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName: ZipUtility
 * @Description: 【Steps to Compress a File in Java 】
 * <p>
 * Here are the steps to compress a file using Java code:
 * <p>
 * 1. Open a ZipOutputStream that wraps an OutputStream like
 * FileOutputStream. The ZipOutputStream class implements an
 * output stream filter for writing in the ZIP file format.
 * <p>
 * 2. Put a ZipEntry object by calling the putNextEntry(ZipEntry)
 * method on the ZipOutputStream. The ZipEntry class represents an
 * entry of a compressed file in the ZIP file.
 * <p>
 * 3. Read all bytes from the original file by using the
 * Files.readAllBytes(Path) method.
 * <p>
 * 4. Write all bytes read to the output stream using the
 * write(byte[] bytes, int offset, int length) method.
 * <p>
 * 5. Close the ZipEntry.
 * <p>
 * 6. Close the ZipOutputStream.
 * <p>
 * You can also set the compression method and compression level
 * using the following ZipOutputStream’s methods:
 * <p>
 * A： setMethod(int method): there are 2 methods: DEFLATED (the
 * default) which compresses the data; and STORED which doesn’t
 * compress the data (archive only).
 * <p>
 * B: setLevel(int level): sets the compression level ranging from
 * 0 to 9 (the default).
 * @author: Mr.Yang
 * @date: 2017年9月7日 下午8:24:15
 */
public class ZipUtility {

    /**
     * @param filePath
     * @Title: compressSingleFile
     * @Description: compress a file in ZIP format
     * @return: void
     */
    public static void compressSingleFile(String filePath, String outPut) {
        try {
            File file = new File(filePath);
            String zipFileName = file.getName().concat(".zip");
            System.out.println("zipFileName:" + zipFileName);

            // if you want change the menu of output ,just fix here
            // FileOutputStream fos = new FileOutputStream(zipFileName);
            FileOutputStream fos = new FileOutputStream(outPut + File.separator + zipFileName);

            ZipOutputStream zos = new ZipOutputStream(fos);

            zos.putNextEntry(new ZipEntry(file.getName()));

            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
            zos.close();

        } catch (FileNotFoundException ex) {
            System.err.format("The file %s does not exist", filePath);
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        }
    }

    /**
     * @param filePaths
     * @Title: compressMultipleFiles
     * @Description: compresses multiple files into a single ZIP file.
     * <p>
     * The file paths are passed from the command line,
     * <p>
     * and the ZIP file name is name of the first file followed by
     * the .zip extension
     * @return: void
     */
    public static void compressMultipleFiles(String... filePaths) {
        try {
            File firstFile = new File(filePaths[0]);
            String zipFileName = firstFile.getName().concat(".zip");

            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (String aFile : filePaths) {
                zos.putNextEntry(new ZipEntry(new File(aFile).getName()));

                byte[] bytes = Files.readAllBytes(Paths.get(aFile));
                zos.write(bytes, 0, bytes.length);
                zos.closeEntry();
            }

            zos.close();

        } catch (FileNotFoundException ex) {
            System.err.println("A file does not exist: " + ex);
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        }
    }

    public static void main(String[] args) {
        ZipUtility.compressSingleFile("D:/JavaMaster.log", "H:");
        ZipUtility.compressMultipleFiles("D:/Temp.log", "D:/JavaMaster.log");
    }

}
