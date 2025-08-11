import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> sensor = new HashMap<>();
        sensor.put("name", "SensorFromRestClient");

        HttpEntity<Map<String, String>> addSensorRequest = new HttpEntity<>(sensor, headers);
        String url = "http://localhost:8080/sensors/registration";
        restTemplate.postForObject(url, addSensorRequest, String.class);

        url = "http://localhost:8080/measurements/add";
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            Map<String, Object> measurement = new LinkedHashMap<>();

            measurement.put("value", -45 + Math.random() * (45 - (-45)));
            measurement.put("raining", random.nextBoolean());
            measurement.put("sensor", sensor);

            HttpEntity<Map<String, Object>> addMeasurementsRequest = new HttpEntity<>(measurement, headers);
            restTemplate.postForObject(url, addMeasurementsRequest, String.class);
        }

        url = "http://localhost:8080/measurements";
        String response = restTemplate.getForObject(url, String.class);

        List<Double> temperatures = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        Pattern pattern = Pattern.compile("-?\\d\\d?.\\d");
        Matcher matcher = pattern.matcher(Objects.requireNonNull(response));
        int counter = 1;
        while (matcher.find()) {
            temperatures.add(Double.parseDouble(matcher.group()));
            indexes.add(counter++);
        }

        XYChart chart = QuickChart.getChart("График температур", "", "Температура", "Sensor",
                indexes, temperatures);

        SwingWrapper<XYChart> wrapper = new SwingWrapper<>(chart);
        wrapper.displayChart();
    }
}
