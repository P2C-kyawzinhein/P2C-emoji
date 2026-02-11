package jp.ac.emoji.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Shusseki {
    public static void main(String[] args) {
        String csvUrl = "https://docs.google.com/spreadsheets/d/1MIKDioPPQd9_gBNEMmD_PLZUmtxW5jDEDwiyy7gEieI/export?format=csv";

        try {
            URL url = new URL(csvUrl);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String line;
            int row = 0;

            while ((line = br.readLine()) != null) {
                row++;
                if (row == 1) continue; // headerスキップ

                String[] data = line.replaceAll("\"", "").split(",", -1);
                if (data.length < 4) continue;

                int totalDays = 0;
                int presentDays = 0;

                //  出席と 欠席 カウントする
                for (int i = 3; i < data.length; i++) {
                    String status = data[i].replaceAll("\\s+", "").trim();

                    //　　空をカウントしない
                    if (status.isEmpty()) continue;

                    if (status.contains("出席") || status.contains("欠席")) {
                        totalDays++;
                        if (status.contains("出席")) {
                            presentDays++;
                        }
                    }
                }

                double rate = (totalDays == 0) ? 0 : (double) presentDays / totalDays * 100.0;
                System.out.printf("出席率: %.1f%%%n", rate);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
