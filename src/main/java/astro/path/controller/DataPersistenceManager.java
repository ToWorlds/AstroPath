package astro.path.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import astro.path.objects.Spacecraft;

public class DataPersistenceManager {

    private String filePath;

    public DataPersistenceManager(String filePath) {
        this.filePath = filePath;
    }

    public void saveFleet(List<Spacecraft> fleet) {
        StringBuilder json = new StringBuilder();
        json.append("[\n");

        for (int i = 0; i < fleet.size(); i++) {
            Spacecraft s = fleet.get(i);
            TelemetryData t = s.getTelemetry();

            json.append("  {\n");
            json.append("    \"id\": \"").append(s.getId()).append("\",\n");
            json.append("    \"type\": \"").append(s.getType()).append("\",\n");
            json.append("    \"status\": \"").append(s.getStatus()).append("\",\n");
            json.append("    \"fuelLevel\": ").append(t.getFuelLevel()).append(",\n");
            json.append("    \"temperature\": ").append(t.getTemperature()).append(",\n");
            json.append("    \"signalStrength\": ").append(t.getSignalStrength()).append("\n");
            json.append("  }");

            if (i < fleet.size() - 1) {
                json.append(",");
            }
            json.append("\n");
        }

        json.append("]\n");

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json.toString());
            System.out.println("Fleet data saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving fleet data: " + e.getMessage());
        }
    }

    public String loadFleet() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return content;
        } catch (IOException e) {
            System.out.println("Error loading fleet data: " + e.getMessage());
            return "";
        }
    }

    public String getFilePath() {
        return filePath;
    }
}