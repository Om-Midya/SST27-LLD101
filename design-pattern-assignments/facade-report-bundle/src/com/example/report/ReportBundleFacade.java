package com.example.report;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade
{

    public Path export(Map<String, Object> data, Path outDir, String baseName)
    {
        Objects.requireNonNull(data, "data");
        Objects.requireNonNull(outDir, "outDir");
        Objects.requireNonNull(baseName, "baseName");

        JsonWriter writer = new JsonWriter();
        Path json = writer.write(data, outDir, baseName);

        Path zipPath = outDir.resolve(baseName + ".zip");
        Zipper zipper = new Zipper();
        zipper.zip(json, zipPath);

        AuditLog audit = new AuditLog();
        audit.log("Exported " + zipPath.toAbsolutePath());

        return zipPath;
    }
}