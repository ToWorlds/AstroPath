package astro.path.objects;

import java.util.ArrayList;
import java.util.List;

import astro.path.controller.DataPersistenceManager;

public class MissionCoordinator {

    private List<Spacecraft> managedFleet;
    private List<Mission> currentMissions;
    private DataPersistenceManager persistenceManager;

    public MissionCoordinator() {
        this.managedFleet = new ArrayList<>();
        this.currentMissions = new ArrayList<>();
        this.persistenceManager = new DataPersistenceManager("fleet.json");
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        managedFleet.add(spacecraft);
    }

    public void addMission(Mission mission) {
        currentMissions.add(mission);
    }

    public void monitorHealth() {
        for (Spacecraft s : managedFleet) {
            System.out.println(s.performSelfDiagnostic());
        }
    }

    public void executeManeuver(Spacecraft spacecraft, String maneuver) {
        spacecraft.setStatus("Executing maneuver: " + maneuver);
        System.out.println(spacecraft.getId() + " performs maneuver: " + maneuver);
    }

    public void persistData() {
        persistenceManager.saveFleet(managedFleet);
    }

    public List<Spacecraft> getManagedFleet() {
        return managedFleet;
    }

    public List<Mission> getCurrentMissions() {
        return currentMissions;
    }
}