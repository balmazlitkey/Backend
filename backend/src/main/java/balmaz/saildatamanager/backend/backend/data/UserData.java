package balmaz.saildatamanager.backend.backend.data;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "userdata")
public class UserData {
	@Id
	@Expose(serialize = false)
	private ObjectId id;

	@Indexed
	private String instrumentID;

	private String timestamp;
	private double speed;
	private int temp;
	private double lat;
	private double lon;
	private double windSpeed;
	private int windDirection;
	private int heading;
	private int batteryLevel;

	@PersistenceConstructor
	public UserData(String instrumentID, String timestamp, double speed, int temp, double lat, double lon, double windSpeed, int windDirection, int heading, int batteryLevel) {
		super();
		this.instrumentID = instrumentID;
		this.timestamp = timestamp;
		this.speed = speed;
		this.temp = temp;
		this.lat = lat;
		this.lon = lon;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.heading = heading;
		this.batteryLevel = batteryLevel;
	}

	public UserData() {
		//required empty constructor
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public int getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(int windDirection) {
		this.windDirection = windDirection;
	}

	public int getHeading() {
		return heading;
	}

	public void setHeading(int heading) {
		this.heading = heading;
	}

	public int getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	@Override
	public String toString() {
		return "UserData{" +
				"instrumentID='" + instrumentID + '\'' +
				", timestamp='" + timestamp + '\'' +
				", speed=" + speed +
				", temp=" + temp +
				", lat=" + lat +
				", lon=" + lon +
				", windSpeed=" + windSpeed +
				", windDirection=" + windDirection +
				", heading=" + heading +
				", batteryLevel=" + batteryLevel +
				'}';
	}
}