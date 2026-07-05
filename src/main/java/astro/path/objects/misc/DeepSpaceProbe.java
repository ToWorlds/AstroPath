package astro.path.objects.misc;

import astro.path.controller.TelemetryData;
import astro.path.objects.Spacecraft;

public class DeepSpaceProbe extends Spacecraft {
    private String deepSpaceAntenna;
    private String dataCompressionProtocol;

    public DeepSpaceProbe(String name, String id, String status, TelemetryData telemetryData,
                          String deepSpaceAntenna, String dataCompressionProtocol) {
        super(name, id, "Deep Space Probe", status, telemetryData);
        this.deepSpaceAntenna = deepSpaceAntenna;
        this.dataCompressionProtocol = dataCompressionProtocol;
    }

    
    public void showSpecialFunction() {
        System.out.println(id + " uses antenna: " + deepSpaceAntenna);
        System.out.println("Compression protocol: " + dataCompressionProtocol);
    }
}
