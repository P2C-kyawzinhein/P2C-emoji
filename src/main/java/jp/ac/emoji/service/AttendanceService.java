package jp.ac.emoji.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    public String getAttendanceRate(String studentNumber) throws Exception {

        String csvUrl =
          "https://docs.google.com/spreadsheets/d/1wPMZJtXie4ypVDtogySS-KCu538REazMAQFVzralAGY/export?format=csv&gid=0";

        System.out.println("LOGIN=" + studentNumber);

        URL url = new URL(csvUrl);
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {

            String line;
            boolean header = true;

            while ((line = br.readLine()) != null) {
                if (header) { header = false; continue; }

                String[] data = line.replace("\"", "").split(",", -1);
                if (data.length < 4) continue;

                String sheetNumber = data[2]
                        .replaceAll("[^A-Za-z0-9]", "")
                        .toUpperCase();

                String loginNumber = studentNumber
                        .replaceAll("[^A-Za-z0-9]", "")
                        .toUpperCase();

                System.out.println("SHEET=" + sheetNumber);

                if (sheetNumber.equals(loginNumber)) {
                    return data[3].replace("%", "").trim();
                }
            }
        }
        return "0";
    }
}
