package tv.gtsrl.risingsun.api.driver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Component
public class DriverGtsApiRestTemplate {

    private static final String GTS_PUBLIC_API_SERVICE = "https://www.gran-turismo.com/us/api/gt7sp/profile/";

    private static final Integer DRIVER_PROFILE_JOB = 1;

    @Autowired
    private RestTemplate restTemplate;

    public Driver getDriverGtsProfileData(Integer driverGtsId) throws IOException {
        HttpHeaders gtsProfileRequestHeader = new HttpHeaders();
        gtsProfileRequestHeader.put("Content-Type", Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED_VALUE));
        HttpEntity gtsProfileRequestEntity = new HttpEntity(this.getDriverProfileFormData(driverGtsId), gtsProfileRequestHeader);
        ResponseEntity<String> profileData = restTemplate.exchange(GTS_PUBLIC_API_SERVICE, HttpMethod.POST, gtsProfileRequestEntity, String.class);
        return gtsProfileJsonToDriver(profileData.getBody());
    }

    private static Map getDriverProfileFormData(Integer driverGTSId) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("job", DRIVER_PROFILE_JOB.toString());
        form.add("user_no", driverGTSId.toString());
        return form;
    }

    private static Driver gtsProfileJsonToDriver(String responseJson) throws IOException {
        JsonNode profile = new ObjectMapper().readTree(responseJson).path("profile");
        Driver driver = new Driver();
        driver.setId(profile.path("number").asLong());
        driver.setName(profile.path("id").asText());
        driver.setCountry(profile.path("country").asText());
        return driver;
    }
}