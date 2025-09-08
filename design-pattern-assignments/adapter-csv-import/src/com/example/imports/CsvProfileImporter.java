package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter
{
    private final NaiveCsvReader reader;
    private final ProfileService service;

    public CsvProfileImporter(NaiveCsvReader reader, ProfileService service)
    {
        this.reader = Objects.requireNonNull(reader);
        this.service = Objects.requireNonNull(service);
    }

    @Override
    public int importFrom(Path csvFile)
    {
        Objects.requireNonNull(csvFile);
        List<String[]> rows = reader.read(csvFile);
        if (rows.isEmpty()) return 0;

        // We assume header exists and columns are in the following order: id,email,displayName
        int success = 0;
        for (int i = 1; i < rows.size(); i++)
        {
            String[] cols = rows.get(i);
            String id = cols.length > 0 && cols[0] != null ? cols[0].trim() : "";
            String email = cols.length > 1 && cols[1] != null ? cols[1].trim() : "";
            String displayName = cols.length > 2 && cols[2] != null ? cols[2].trim() : "";

            //Validation
            if (id.isBlank())
            {
                System.out.println("Skipping row " + (i + 1) + ": missing id");
                continue;
            }
            if (email.isBlank())
            {
                System.out.println("Skipping row " + (i + 1) + ": missing email for id " + id);
                continue;
            }
            if (!email.contains("@"))
            {
                System.out.println("Skipping row " + (i + 1) + ": bad email '" + email + "' for id " + id);
                continue;
            }

            try
            {
                service.createProfile(id, email, displayName);
                success++;
            } catch (RuntimeException e)
            {
                System.out.println("Skipping row " + (i + 1) + ": service error: " + e.getMessage());
            }
        }

        return success;
    }
}