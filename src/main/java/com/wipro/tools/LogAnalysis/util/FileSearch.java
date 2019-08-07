package com.wipro.tools.LogAnalysis.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileSearch {

    public static String readFile( String fileLoc, String lastToSearch, String firstToSearch, String keyword ) {
        File file = new File(fileLoc);
        StringBuffer log = new StringBuffer();
        try(RandomAccessFile in = new RandomAccessFile(file,"r");)  {

            long pos = file.length()-1;
            in.seek(pos);
            //System.out.println(readLineBackwards(in, 32));
            boolean textNotFound = true;

            while(textNotFound) {
                String line = readLineBackwards(in, pos);
                pos-=(line.length());
                System.out.println(line);
                //if(line != null && line.trim().contains("Exiting uVnfWorker")) {
                if(line != null && line.trim().contains(lastToSearch)) {
                    String uniqueId = line.split(" ")[3];
                    //if(!uniqueId.equals(keyword))
                      //  continue;
                    //System.out.println("Entering uVnfWorker");
                    textNotFound = false;
                    boolean secondTextNotFound = true;
                    while(secondTextNotFound) {

                        String line1 = readLineBackwards(in, pos);
                        pos-=(line1.length());
                        //System.out.println(line1);
                        if(line1 != null && line1.split(" ").length>3 && line1.split(" ")[3].equals(uniqueId))  {
                            //if( line1.contains("Entering uVnfWorker,") ) {
                            if( line1.contains(firstToSearch) ) {
                                secondTextNotFound = false;
                                System.out.println(line1);
                            }
                            log.insert(0, line1+"\n");//append(line1+"\n");
                        }
                    }
                }
            }
            System.out.println(log.toString());
            //System.out.println(pos);

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {

        }
        return log.toString();
    }


    private static String readLineBackwards(RandomAccessFile in, long pos) throws IOException {
        String line = null;

        boolean sameLine = true;
        //pos = (long) 25;

        //System.out.println(pos);
        StringBuffer a = new StringBuffer();

        byte[] b = new byte[1];
        String character = null;
        while (sameLine) {
            in.seek(pos);
            in.read(b);
            character = new String(b);
            //System.out.println(character);
            if(character.codePointAt(0) == 10 || pos == 0) {
                sameLine=false;
            }
            a.append(character);

            pos-=1;
        }
        line = a.reverse().toString();
        //System.out.println(line);
        return line;
    }

}
