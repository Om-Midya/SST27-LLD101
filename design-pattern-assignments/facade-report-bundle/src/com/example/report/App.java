package com.example.report;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void main(String[] args)
    {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Archisman");
        data.put("score", 95);

        Path outDir = Paths.get(".");
        String baseName = "report";

        ReportBundleFacade facade = new ReportBundleFacade();
        Path zipPath = facade.export(data, outDir, baseName);
        System.out.println("Exported to: " + zipPath);
    }
}